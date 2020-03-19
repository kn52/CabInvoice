package com.cab.invoice;

public class Ride {
    public CabRideType type;
    public double distance;
    public double time;

    public Ride(double distance, double time, CabRideType type) {
        this.distance = distance;
        this.time = time;
        this.type=type;
    }
}
