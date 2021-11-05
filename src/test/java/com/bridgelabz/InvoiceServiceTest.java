package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    public static InvoiceGenerator invoiceGenerator = null;

    @BeforeAll
    static void beforeAll() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    void givenDistanceAndTime_ShouldReturnTheTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    void givenLessDistanceAndTime_ShouldReturnTheMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        double fare = invoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(30, fare, 0.0);
    }

    @Test
    void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        String userId = "CRN 1001";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    void givenUserIDAndRideList_WhenFareCalculatedForNormalRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1),
                new Ride(CabRide.NORMAL, 1.0, 5)
        };
        String userId = "CRN 1002";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    void givenUserIDAndRideList_WhenFareCalculatedForPremiumRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.PREMIUM, 3.0, 9),
                new Ride(CabRide.PREMIUM, 0.5, 5),
                new Ride(CabRide.PREMIUM, 5.0, 10)
        };
        String userId = "PRM 4001";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 178.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}
