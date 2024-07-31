package com.polovyi.ivan.tutorials;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentMethod {

    public static void main(String[] args) {
//        ignoreWhenKeyExist();
        //ignoreWhenKeyDoesntExistAndRemappingIsNull();
        //ignoreWhenKeyExistWithNullValueAndRemappingIsNull();
        updateValue();
       // addValue();
    }

    private static void ignoreWhenKeyExist() {
        System.out.println("IgnoreWhenKeyExist:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfAbsent(2,
                (key -> key + "&"));
        System.out.println("newValue = " + newValue);
        // newValue = null
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B}
    }

    private static void ignoreWhenKeyDoesntExistAndRemappingIsNull() {
        System.out.println("IgnoreWhenRemappingIsNull:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfAbsent(3,
                (key -> null));
        System.out.println("newValue = " + newValue);
        // newValue = null
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B}
    }

    private static void ignoreWhenKeyExistWithNullValueAndRemappingIsNull() {
        System.out.println("IgnoreWhenRemappingIsNull:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, null);
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfAbsent(2,
                (key -> null));
        System.out.println("newValue = " + newValue);
        // newValue = null
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B}
    }

    private static void updateValue() {
        System.out.println("UpdateValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, null);
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfAbsent(2,
                (key -> key + "&"));
        System.out.println("newValue = " + newValue);
        // newValue = 2&
        System.out.println("map after = " + map);
        // map after = {1=A, 2=2&}
    }

    private static void addValue() {
        System.out.println("AddValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfAbsent(3,
                (key -> key + "&"));
        System.out.println("newValue = " + newValue);
        // newValue = 3&
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B, 3=3&}
    }

}
