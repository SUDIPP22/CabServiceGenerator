package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Purpose : To generate enhanced invoice summary based on userID
 */
public class RideRepository {
    Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    /**
     * Purpose : Getting the ride summary based on given userId
     *
     * @param userId : takes userId as first parameter
     * @param rides  : takes multiple rides as second parameter
     */
    public void addRides(String userId, Ride[] rides) {
        this.userRides.computeIfAbsent(userId, rideList -> new ArrayList<>(Arrays.asList(rides)));
    }

    /**
     * Purpose : To get the ride details based on userId
     *
     * @param userId : takes user id as parameter
     * @return the list of rides based on userId
     */
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
