package com.polovyi.ivan.tutorials;

import java.util.HashMap;
import java.util.Map;

public class ComputeMethod {

    public static void main(String[] args) {
        updateValue();
        addNewValue();
        removeEntryValueNotNull();
        removeEntryValueNull();
        ignoreValue();
    }

    private static void updateValue() {
        System.out.println("UpdateValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String returnedValue = map.compute(2,
                (key, value) -> key + "&" + value);
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = 2&B
        System.out.println("map after = " + map);
        // map after = {1=A, 2=2&B}
    }

    private static void addNewValue() {
        System.out.println("AddValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String returnedValue = map.compute(3,
                (key, value) -> key + "&" + value);
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = 3&null
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B, 3=3&null}
    }

    private static void removeEntryValueNotNull() {
        System.out.println("RemoveEntryValueNotNull:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String returnedValue = map.compute(2,
                (value, newValue) -> null);
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = null
        System.out.println("map after = " + map);
        // map after = {1=A}
    }

    private static void removeEntryValueNull() {
        System.out.println("RemoveEntryValueNotNull:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, null);
        System.out.println("map before = " + map);
        // map before = {1=A, 2=null}
        String returnedValue = map.compute(2,
                (value, newValue) -> null);
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = null
        System.out.println("map after = " + map);
        // map after = {1=A}
    }

    private static void ignoreValue() {
        System.out.println("IgnoreValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String returnedValue = map.compute(3,
                (value, newValue) -> null);
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = null
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B}
    }
}
