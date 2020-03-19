package com.cab.invoice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CabInvoiceRepository {
    public Map<String,ArrayList<Ride>> userData=null;

    public CabInvoiceRepository() {
        userData=new HashMap();
    }

    public void addRides(String userId, Ride[] ride) {
        ArrayList<Ride> rides=this.userData.get(userId);
        if(rides == null)
            userData.put(userId,new ArrayList(Arrays.asList(ride)));
    }

    public Ride[] getRides(String userId) {
        return userData.get(userId).toArray(new Ride[0]);
    }
}