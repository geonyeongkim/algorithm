package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2020-12-12
 */
public class ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list, Comparator.reverseOrder());

        int length = arr.length;
        int res = 0;

        for(int i : list) {
            length -= i;
            res++;
            if((arr.length / 2) >= length) break;
        }
        return res;
    }

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf reduceArraySizeToTheHalf = new ReduceArraySizeToTheHalf();
        int res1 = reduceArraySizeToTheHalf.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7});
        System.out.println("res1 -> " + res1);

        int res2 = reduceArraySizeToTheHalf.minSetSize(new int[]{7,7,7,7,7,7});
        System.out.println("res2 -> " + res2);

        int res3 = reduceArraySizeToTheHalf.minSetSize(new int[]{1,9});
        System.out.println("res3 -> " + res3);

        int res4 = reduceArraySizeToTheHalf.minSetSize(new int[]{1000,1000,3,7});
        System.out.println("res4 -> " + res4);

        int res5 = reduceArraySizeToTheHalf.minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println("res5 -> " + res5);


    }
}
