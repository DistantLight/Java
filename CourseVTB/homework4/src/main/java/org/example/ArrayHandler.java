package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayHandler {
    public static void swapTwoElements(Object[] array, int index1, int index2){
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static ArrayList<Object> arrayToArrayList(Object[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
