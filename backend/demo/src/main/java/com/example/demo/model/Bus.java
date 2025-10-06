package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String route;
    private String departure_time;
    private int total_seats;
    private int seats_left;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }

    public String getDeparture_time() { return departure_time; }
    public void setDeparture_time(String departure_time) { this.departure_time = departure_time; }

    public int getTotal_seats() { return total_seats; }
    public void setTotal_seats(int total_seats) { this.total_seats = total_seats; }

    public int getSeats_left() { return seats_left; }
    public void setSeats_left(int seats_left) { this.seats_left = seats_left; }
}
