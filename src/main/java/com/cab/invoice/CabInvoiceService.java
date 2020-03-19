package com.cab.invoice;

public class CabInvoiceService {

    public double COST_PER_KILOMETER=10;
    public double COST_PER_TIME=1;
    public double MINIMUM_FARE=5;
    private final CabInvoiceRepository cabRepository;

    public CabInvoiceService() {
        cabRepository = new CabInvoiceRepository();
    }

    public double calculateFare(double distance, double time, CabRideType type) {
        if(type.equals(CabRideType.NORMAL))
            this.setvalue(10,1,5);
        else
            this.setvalue(15,2,20);
        double total=distance*COST_PER_KILOMETER+time*COST_PER_TIME;
        return Math.max(total,MINIMUM_FARE);
    }

    private void setvalue(int kilometerFare, int timeFare, int minimum) {
        COST_PER_KILOMETER=kilometerFare;
        COST_PER_TIME=timeFare;
        MINIMUM_FARE=minimum;
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
