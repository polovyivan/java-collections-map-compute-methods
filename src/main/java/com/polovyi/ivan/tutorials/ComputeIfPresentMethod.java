package com.polovyi.ivan.tutorials;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfPresentMethod {

    public static void main(String[] args) {
//         ignoreWhenKeyDoesntExist();
//        ignoreWhenValueIsNull();
        //updateValue();
        removeValue();
    }

    private static void ignoreWhenKeyDoesntExist() {
        System.out.println("IgnoreWhenKeyDoesntExist:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfPresent(3,
                (key, value) -> key + "&" + value);
        System.out.println("newValue = " + newValue);
        // newValue = null
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B}
    }

    private static void ignoreWhenValueIsNull() {
        System.out.println("IgnoreWhenValueIsNull:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, null);
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfPresent(2,
                (key, value) -> key + "&" + value);
        System.out.println("newValue = " + newValue);
        // newValue = null
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B}
    }

    private static void updateValue() {
        System.out.println("UpdateValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfPresent(2,
                (key, value) -> key + "&" + value);
        System.out.println("newValue = " + newValue);
        // newValue = 2&B
        System.out.println("map after = " + map);
        // map after = {1=A, 2=2&B}
    }

    private static void removeValue() {
        System.out.println("RemoveValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String newValue = map.computeIfPresent(2,
                (key, value) -> null);
        System.out.println("newValue = " + newValue);
        // newValue = null
        System.out.println("map after = " + map);
        // map after = {1=A}
    }

}
