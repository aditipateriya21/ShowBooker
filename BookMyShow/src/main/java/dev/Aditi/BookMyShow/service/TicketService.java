package dev.Aditi.BookMyShow.service;

import dev.Aditi.BookMyShow.model.ShowSeat;
import dev.Aditi.BookMyShow.model.Ticket;
import dev.Aditi.BookMyShow.model.constants.ShowSeatStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ShowSeatService showSeatService;
    public String greet()
    {
        return "HELLOWORLD";
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
            for(int showseatId : showSeatIds)
            {
                ShowSeat seat = showSeatService.getShowSeat(showseatId);
                if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
                {
                    throw new Exception("Seat is not available anymore");
                }
            }

            for(int showSeatId :  showSeatIds)
            {
                ShowSeat seat = showSeatService.getShowSeat(showSeatId);
                seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                showSeatService.saveShowSeat(seat);
            }
            startPayment(showSeatIds);
            return new Ticket();
    }

    public boolean startPayment(List<Integer> showSeatIds)
    {
        return  true;
    }
}
