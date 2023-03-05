package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PhoneBook {
    private HashMap<String, HashSet<String>> hashMap;

    public PhoneBook(){
        hashMap = new HashMap<>();
    }

    public void addRecord(String lastName, String phoneNumber){
        if (hashMap.containsKey(lastName)){
            hashMap.get(lastName).add(phoneNumber);
        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            hashMap.put(lastName, phoneNumbers);
        }
    }

    public HashSet<String> getNumber(String lastName){
        return hashMap.get(lastName);
    }
}
