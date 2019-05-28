package com.maktab.homework10_tamrin1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        System.out.println(sortArrayByStream(initArray()));
    }

    private static String[] initArray() {
        String[] strings = {"Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali", "sam",
                "Davood", "Reza", "Mohsen"};
        return strings;
    }

    private static Map<Integer, List<Map.Entry<Integer, List<String>>>> sortArrayByStream(String[] strings) {


        Map<Integer, List<Map.Entry<Integer, List<String>>>> collect =
                Arrays.stream(strings).sorted(Comparator.comparingInt(String::length))
                        .collect(Collectors.groupingBy(String::length))
                        .entrySet().stream().collect(Collectors.groupingBy(o -> o.getValue().size()));

        return collect;
    }

}
