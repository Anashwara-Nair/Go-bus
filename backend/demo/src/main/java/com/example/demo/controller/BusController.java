package com.example.demo.controller;

import com.example.demo.model.Bus;
import com.example.demo.repository.BusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses")
@CrossOrigin(origins = "*")
public class BusController {

    private final BusRepository busRepository;

    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @PostMapping("/book/{id}")
    public String bookSeat(@PathVariable Long id) {
        Bus bus = busRepository.findById(id).orElse(null);
        if (bus != null && bus.getSeats_left() > 0) {
            bus.setSeats_left(bus.getSeats_left() - 1);
            busRepository.save(bus);
            return "Seat booked successfully!";
        }
        return "No seats available!";
    }
}
