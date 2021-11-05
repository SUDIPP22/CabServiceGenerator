package com.bridgelabz;

public enum CabRide {
    NORMAL(10.0, 1.0, 5.0), PREMIUM(15, 2, 20);
    private final double costPerKm;
    private final double costPerMin;
    private final double minimumFarePerRide;

    CabRide(double costPerKm, double costPerMin, double minimumFarePerRide) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minimumFarePerRide = minimumFarePerRide;
    }

    /**
     * Purpose : To calculate the minimum fare as per rides
     *
     * @param ride : takes multiple rides as parameter
     * @return the total fare or minimum fare as per expectations
     */
    public double calculateCostOfRide(Ride ride) {
        double totalFare = ride.distance * costPerKm + ride.time * costPerMin;
        return Math.max(totalFare, minimumFarePerRide);
    }
}
