package com.bridgelabz;

/**
 * Purpose : To simulate Cab Service
 *
 * @author SUDIP PANJA
 * @version 11.0.11
 * @since 2021-11-04
 */
public class InvoiceGenerator {
    // Constants
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5.0;

    /**
     * Purpose : To calculate the minimum fare of a journey
     *
     * @param distance : takes distance as a first parameter
     * @param time     : takes time as a second parameter
     * @return the total fare or minimum fare as per expectations
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        else
            return totalFare;
    }
}
