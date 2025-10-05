package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bus;
import com.example.demo.repository.BusRepository;

@RestController
@RequestMapping("/buses")
public class BusController {
    private final BusRepository busRepo;

    public BusController(BusRepository busRepo) {
        this.busRepo = busRepo;
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return busRepo.save(bus);
    }

    @GetMapping
    public List<Bus> getAll() {
        return busRepo.findAll();
    }
}
