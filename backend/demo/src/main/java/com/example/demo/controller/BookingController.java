package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Bus;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.BusRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingRepository bookingRepo;
    private final BusRepository busRepo;
    private final UserRepository userRepo;

    public BookingController(BookingRepository bookingRepo, BusRepository busRepo, UserRepository userRepo) {
        this.bookingRepo = bookingRepo;
        this.busRepo = busRepo;
        this.userRepo = userRepo;
    }

    @PostMapping("/{userId}/{busId}")
    public String makeBooking(@PathVariable Long userId, @PathVariable Long busId) {
        User user = userRepo.findById(userId).orElse(null);
        Bus bus = busRepo.findById(busId).orElse(null);

        if (user == null || bus == null) return "❌ User or Bus not found!";
        if (bus.getSeats_left() <= 0) return "❌ No seats available!";

        bus.setSeats_left(bus.getSeats_left() - 1);
        busRepo.save(bus);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBus(bus);
        bookingRepo.save(booking);

        return "✅ Booking confirmed for " + user.getName() + " on " + bus.getRoute();
    }
}
