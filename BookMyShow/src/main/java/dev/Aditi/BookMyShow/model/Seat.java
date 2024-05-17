package dev.Aditi.BookMyShow.model;

import dev.Aditi.BookMyShow.model.constants.SeatStatus;
import dev.Aditi.BookMyShow.model.constants.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private int seat_row;
    private int seat_col;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    public  Seat()
    {

    }

    public Seat(String seatNumber, SeatType seatType, int seat_row, int seat_col, SeatStatus status) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seat_row = seat_row;
        this.seat_col = seat_col;
        this.status = status;
    }
}
