package com.cab.invoice;

public class CabInvoice {

    public static final double COST_PER_KILOMETER=10;
    public static final double COST_PER_TIME=1;
    public static final double MINIMUM_FARE=5;

    public double calculateFare(double distance, double time) {
        double total=distance*COST_PER_KILOMETER+time*COST_PER_TIME;
        return Math.max(total,MINIMUM_FARE);
    }

    public CabInvoiceSumary calculateFare(Ride[] ride) {
        double totalFare = 0.0;
        for(Ride rides : ride) {
            totalFare+=this.calculateFare(rides.distance,rides.time);
        }
        return new CabInvoiceSumary(ride.length,totalFare);
    }
}
