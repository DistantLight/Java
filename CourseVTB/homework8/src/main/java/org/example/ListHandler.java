package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListHandler {

    public static List<String> findMostFrequentlyRepeatedStrings(List<String> strings, int stringsNumber){
        return strings.stream()
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue()))
                .limit(stringsNumber)
                .map(object -> object.getKey())
                .collect(Collectors.toList());
    }

}
