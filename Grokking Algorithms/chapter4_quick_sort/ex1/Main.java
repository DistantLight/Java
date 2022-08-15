package chapter4_quick_sort.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int sumOfListElements(List<Integer> list){
        if (list.size() == 1){
            return list.get(0);
        }
        List<Integer> followingElements = new ArrayList();
        for (int i = 1; i < list.size(); i++) {
            followingElements.add(list.get(i));
        }

        return list.get(0) + sumOfListElements(followingElements);
    }

    public static void main(String[] args) {
        List <Integer> list;
        list = Arrays.asList(10,2,4,6);

        System.out.println(sumOfListElements(list));
    }
}
