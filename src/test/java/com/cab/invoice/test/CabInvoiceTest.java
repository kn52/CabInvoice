package com.cab.invoice.test;

import com.cab.invoice.CabInvoiceService;
import com.cab.invoice.CabInvoiceSumary;
import com.cab.invoice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoiceService cabInvoice;

    @Before
    public void setUp() throws Exception {
        cabInvoice=new CabInvoiceService();
    }

    @Test
    public void whengiven_DistanceAndTime_ShouldReturn_TotalFare() {
        double distance=2;
        int time =1;
        double totalFare=cabInvoice.calculateFare(distance,time);
        Assert.assertEquals(21,totalFare,0.0);
    }

    @Test
    public void whengiven_DistanceAndTime_ShouldReturn_MinimumFare() {
        double distance=0.1;
        int time =1;
        double totalFare=cabInvoice.calculateFare(distance,time);
        Assert.assertEquals(5,totalFare,0.0);
    }

    @Test
    public void whengivenMultipleRides_SHouldReturn_Summary() {
        Ride[] ride={ new Ride(2.0,2),
                new Ride(3,1)
        };
        CabInvoiceSumary summary=cabInvoice.calculateFare(ride);
        CabInvoiceSumary exceptedSummary=new CabInvoiceSumary(2,53);
        Assert.assertEquals(exceptedSummary,summary);
    }
}
