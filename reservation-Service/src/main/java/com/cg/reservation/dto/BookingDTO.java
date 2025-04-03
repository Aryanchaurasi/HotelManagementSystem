package com.cg.reservation.dto;

import com.cg.reservation.model.Booking;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingDTO {
    private Long guestId;
    private Long roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;

    // Convert DTO to Entity
    public Booking toEntity() {
        Booking booking = new Booking();
        booking.setGuestId(this.guestId);
        booking.setRoomId(this.roomId);
        booking.setCheckIn(this.checkIn);
        booking.setCheckOut(this.checkOut);
        booking.setStatus("CONFIRMED");
        return booking;
    }
}