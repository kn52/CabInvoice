package com.cab.invoice;

import java.util.Objects;

public class CabInvoiceSumary {
    public double averageFare;
    public double numberOfRides;
    public double totalFare;

    public CabInvoiceSumary(double numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = totalFare / numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CabInvoiceSumary that = (CabInvoiceSumary) o;
        return Double.compare(that.averageFare, averageFare) == 0 &&
                Double.compare(that.numberOfRides, numberOfRides) == 0 &&
                Double.compare(that.totalFare, totalFare) == 0;
    }
}
