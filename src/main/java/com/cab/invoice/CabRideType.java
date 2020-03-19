package com.cab.invoice;

public enum CabRideType {
    NORMAL(10 , 1 , 5),
    PREMIUM(15, 2, 20);

    public double COST_PER_KILOMETER;
    public double COST_PER_TIME;
    public double MINIMUM_FARE;

    CabRideType(double COST_PER_KILOMETER, double COST_PER_TIME, double MINIMUM_FARE) {
        this.COST_PER_KILOMETER = COST_PER_KILOMETER;
        this.COST_PER_TIME = COST_PER_TIME;
        this.MINIMUM_FARE = MINIMUM_FARE;
    }
}
