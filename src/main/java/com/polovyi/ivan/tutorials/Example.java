package com.polovyi.ivan.tutorials;

import java.util.Map;
import java.util.TreeMap;

public class Example {

    public static void main(String[] args) {

        Map<String, Integer> rewardPoints = new TreeMap<>();
        rewardPoints.put("Customer1", 100);
        rewardPoints.put("Customer2", 200);
        rewardPoints.put("Customer3", null); // customer left reward program
        System.out.println("initial reward points = " + rewardPoints);
        // {Customer1=100, Customer2=200, Customer3=null}

        // Add a new customer to a reward program
        Integer newCustomerValue = rewardPoints.computeIfAbsent("Customer4", (key) -> 25);
        System.out.println("newCustomerValue = " + newCustomerValue);
        // newCustomerValue = 25
        System.out.println("reward points after adding new customer = " + rewardPoints);
        // {Customer1=100, Customer2=200, Customer3=null, Customer4=25}

        // Customer1 got bonus because he got the largest number of points
        Integer rewardPointsWithBonus = rewardPoints
                .computeIfPresent("Customer2", (key, value) -> value * 2);
        System.out.println("rewardPointsWithBonus = " + rewardPointsWithBonus);
        // rewardPointsWithBonus = 400
        System.out.println("reward points after bonus= " + rewardPoints);
        // {Customer1=100, Customer2=400, Customer3=null, Customer4=25}

        // Remove customer from reward program, although he earned some points in the last month
        Integer inactiveCustomer = rewardPoints
                .compute("Customer3", (key, value) -> value != null ? value + 100 : null);
        System.out.println("inactiveCustomer = " + inactiveCustomer);
        // inactiveCustomer = null
        System.out.println("reward points after removing customer = " + rewardPoints);
        // {Customer1=100, Customer2=400, Customer4=0}
    }
}
