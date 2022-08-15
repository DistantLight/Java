package chapter4_quick_sort.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int findMax(List<Integer> list){
        if(list.size() == 1)
            return list.get(0);

        int max = list.get(0);
        List<Integer> followingElements = new ArrayList();
        for (int i = 1; i < list.size(); i++) {
            followingElements.add(list.get(i));
        }

        int maxOfTheFollowing = findMax(followingElements);
        if (maxOfTheFollowing > max){
            max = maxOfTheFollowing;
        }

        return max;
    }

    public static void main(String[] args) {
        List <Integer> list;
        list = Arrays.asList(1,3,20,4,6,0);

        System.out.println(findMax(list));
    }
}