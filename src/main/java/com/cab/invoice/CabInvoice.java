package com.cab.invoice;

public class CabInvoice {

    public static final double COST_PER_KILOMETER=10;
    public static final double COST_PER_TIME=1;
    public static final double MINIMUM_FARE=5;

    public double calculateFare(double distance, int time) {
        double total=distance*COST_PER_KILOMETER+time*COST_PER_TIME;
        return Math.max(total,MINIMUM_FARE);
    }
}
