package com.cab.invoice;

public class CabInvoiceService {

    private final CabInvoiceRepository cabRepository;

    public CabInvoiceService(CabInvoiceRepository cabRepository) {
        this.cabRepository = cabRepository;
    }

    public double calculateFare(double distance, double time, CabRideType type) {
        double total=distance*type.COST_PER_KILOMETER+time*type.COST_PER_TIME;
        return Math.max(total,type.MINIMUM_FARE);
    }

    public CabInvoiceSumary calculateFare(Ride[] ride) {
        double totalFare = 0.0;
        for(Ride rides : ride) {
            totalFare+=this.calculateFare(rides.distance,rides.time,rides.type);
        }
        return new CabInvoiceSumary(ride.length,totalFare);
    }

    public void addRides(String userId, Ride[] ride) {
        cabRepository.addRides(userId,ride);
    }

    public CabInvoiceSumary getInvoiceSummary(String userId) {
        return this.calculateFare(cabRepository.getRides(userId));
    }
}
