package com.cab.invoice;

public class Ride {
    public double distance;
    public double time;

    public Ride(double distance, double time, CanRideType premium) {
        this.distance = distance;
        this.time = time;
    }
}
