package dev.Aditi.BookMyShow.service;

import dev.Aditi.BookMyShow.model.ShowSeat;
import dev.Aditi.BookMyShow.repository.ShowSeatRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId)
    {
        return showSeatRepository.findById(showSeatId).get();
    }

    public  ShowSeat saveShowSeat(ShowSeat showSeat)
    {
         return   showSeatRepository.save(showSeat);
    }

}
