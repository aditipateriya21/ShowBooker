package dev.Aditi.BookMyShow.service;

import dev.Aditi.BookMyShow.model.*;
import dev.Aditi.BookMyShow.model.constants.AuditoriumFeature;
import dev.Aditi.BookMyShow.model.constants.SeatStatus;
import dev.Aditi.BookMyShow.model.constants.SeatType;
import dev.Aditi.BookMyShow.model.constants.ShowSeatStatus;
import dev.Aditi.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  ShowSeatRepository showSeatRepository;

    public boolean initialise()
    {
            City delhi = new City("Delhi");
            City Bangalore = new City("Bangalore");
            City London = new City("London");

            cityRepository.save(delhi);
            cityRepository.save(Bangalore);
            cityRepository.save(London);

            City savedDelhi = cityRepository.findCityByName("Delhi");
            Theatre pvr = new Theatre("PVRCinemas","Delhi,whitefield");
            Theatre inox = new Theatre("INOXCinemas","Shantineketan,Delhi");

            theatreRepository.save(pvr);
            theatreRepository.save(inox);

            Theatre savedpvr = theatreRepository.findTheatreByName("PVRCinemas");
            Theatre savedinox = theatreRepository.findTheatreByName("INOXCinemas");

            List<Theatre> delhiTheatres = new ArrayList<>();
            delhiTheatres.add(savedpvr);
            delhiTheatres.add(savedinox);
            savedDelhi.setTheatres(delhiTheatres);

            cityRepository.save(savedDelhi);
        for(int i=1;i<=5;i++)
        {
            Seat s = new Seat(i+" "+i,SeatType.GOLD,i,i,SeatStatus.AVAIALBLE);
            seatRepository.save(s);
        }

        List<Seat> savedSeats = seatRepository.findAll();

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapcity(5);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.IMAX,AuditoriumFeature.TWOD));
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);

//        savedpvr.setAuditoriums(List.of(auditoriumRepository.findAuditoriumByName("Audi01")));
//        theatreRepository.save(savedpvr);

        Auditorium savedAudi =auditoriumRepository.findAuditoriumByName("Audi01");
        Theatre savedTheatre = theatreRepository.findTheatreByName("PVRCinemas");
        List<Auditorium> audis = new ArrayList<>();
        audis.add(savedAudi);
        savedTheatre.setAuditoriums(audis);
        theatreRepository.save(savedTheatre);

        Movie movie = new Movie("Titanic","Best movie ever");
        movieRepository.save(movie);

        Show show = new Show();
        show.setStartTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findMovieByName("Titanic"));
        show.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));
        showRepository.save(show);

        for(int i=1;i<=5;i++)
        {
            ShowSeat s = new ShowSeat(1200,showRepository.findById(1).get(),seatRepository.findSeatBySeatNumber(i+" "+i), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);

        }




            return true;



    }

}
