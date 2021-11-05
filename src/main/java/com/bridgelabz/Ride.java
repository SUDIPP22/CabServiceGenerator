package com.bridgelabz;

/**
 * Purpose : To generate multiple rides
 */
public class Ride {
    final double distance;
    final int time;
    final CabRide cabRide;

    public Ride(CabRide cabRide, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }
}
