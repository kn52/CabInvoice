package com.cab.invoice.test;

import com.cab.invoice.CabInvoiceService;
import com.cab.invoice.CabInvoiceSumary;
import com.cab.invoice.CanRideType;
import com.cab.invoice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoiceService cabInvoiceSummary;

    @Before
    public void setUp() throws Exception {
        cabInvoiceSummary =new CabInvoiceService();
    }

    @Test
    public void whengiven_DistanceAndTime_ShouldReturn_TotalFare() {
        double distance=2;
        int time =1;
        double totalFare= cabInvoiceSummary.calculateFare(distance,time);
        Assert.assertEquals(21,totalFare,0.0);
    }

    @Test
    public void whengiven_DistanceAndTime_ShouldReturn_MinimumFare() {
        double distance=0.1;
        int time =1;
        double totalFare= cabInvoiceSummary.calculateFare(distance,time);
        Assert.assertEquals(5,totalFare,0.0);
    }

    @Test
    public void whengiven_MultipleRides_ShouldReturn_Summary() {
        Ride[] ride={ new Ride(2.0,2, CanRideType.NORMAL),
                new Ride(3,1, CanRideType.NORMAL)
        };
        CabInvoiceSumary summary= cabInvoiceSummary.calculateFare(ride);
        CabInvoiceSumary exceptedSummary=new CabInvoiceSumary(2,53);
        Assert.assertEquals(exceptedSummary,summary);
    }

    @Test
    public void whengiven_UserAnd_Rides_ShouldReturn_InvoiceSummary() {
        String userId="abc@.com";
        Ride[] ride={ new Ride(2.0,2, CanRideType.NORMAL),
                new Ride(3,1, CanRideType.NORMAL)
        };
        cabInvoiceSummary.addRides(userId,ride);
        CabInvoiceSumary summary= cabInvoiceSummary.getInvoiceSummary(userId);
        CabInvoiceSumary exceptedSummary=new CabInvoiceSumary(2,53);
        Assert.assertEquals(exceptedSummary,summary);
    }

    @Test
    public void whengiven_UserAnd_RideswithPremium_ShouldReturn_InvoiceSummary() {
        String userId="abc@.com";
        Ride[] ride={ new Ride(2.0,2, CanRideType.PREMIUM),
                new Ride(3,1, CanRideType.PREMIUM)
        };
        cabInvoiceSummary.addRides(userId,ride);
        CabInvoiceSumary summary= cabInvoiceSummary.getInvoiceSummary(userId);
        CabInvoiceSumary exceptedSummary=new CabInvoiceSumary(2,53);
        Assert.assertEquals(exceptedSummary,summary);
    }
}
