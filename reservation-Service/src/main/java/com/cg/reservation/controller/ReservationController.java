package com.cg.reservation.controller;


import com.cg.reservation.dto.BookingDTO;
import com.cg.reservation.model.Booking;
import com.cg.reservation.model.Room;
import com.cg.reservation.repository.BookingRepository;
import com.cg.reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    // Create Booking
    @PostMapping
    public Booking createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingRepository.save(bookingDTO.toEntity());
    }
    //Get all the Booking that have performed
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get Available Rooms
    @GetMapping("/rooms/available")
    public List<Room> getAvailableRooms() {
        return roomRepository.findByIsAvailableTrue();
    }

    // Cancel Booking
    @PutMapping("/{id}/cancel")
    public Booking cancelBooking(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return ResponseEntity.ok("Deleted booking ID: " + id);
    }

}