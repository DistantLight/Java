package chapter4_quick_sort.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int numberOfElements(List<Integer> list){
        if(list.size() == 0)
            return 0;

        List<Integer> followingElements = new ArrayList();
        for (int i = 1; i < list.size(); i++) {
            followingElements.add(list.get(i));
        }

        return 1 + numberOfElements(followingElements);
    }

    public static void main(String[] args) {
        List <Integer> list;
        list = Arrays.asList(1,3,2,4,6);

        System.out.println(numberOfElements(list));
    }
}