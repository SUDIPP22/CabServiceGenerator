package com.bridgelabz;

/**
 * Purpose : To generate the enhanced invoice summary of journey
 */
public class InvoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private final double averageFair;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFair = this.totalFare / this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFair, averageFair) == 0;
    }
}
