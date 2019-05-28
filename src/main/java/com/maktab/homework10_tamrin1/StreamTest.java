package com.maktab.homework10_tamrin1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {


    private static String[] initArray() {
        String[] strings = {"Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali",
                "Davood", "Reza", "Mohsen"};
        return strings;
    }

    private static Map<Integer, List<String>> sortArrayByStream(String[] strings) {
        Map<Integer, List<String>> map = Arrays.stream(strings).sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.groupingBy(String::length));
        return map;
    }

}
