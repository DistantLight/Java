package org.example;

import java.util.*;

public class ArrayHandler {
    public static ArrayList<String> getUniqueStrings(String[] strings) {
        var uniqueStrings = new HashSet<>(Arrays.asList(strings));
        return new ArrayList<>(uniqueStrings);
    }

    public static HashMap<String, Integer> getNumberOfUniqueStrings(String[] strings) {
        var hashMap = new HashMap<String, Integer>();
        for (String string: strings) {
            if (hashMap.containsKey(string)){
                hashMap.put(string, hashMap.get(string) + 1);
            } else {
                hashMap.put(string, 1);
            }
        }
        return hashMap;
    }

    public static void main(String[] args) {
        String[] words = {
                "car",
                "phone",
                "window",
                "car",
                "car",
                "window",
                "building",
                "phone",
                "road",
                "phone"
        };

        System.out.println(getUniqueStrings(words));
        System.out.println(getNumberOfUniqueStrings(words));
    }
}