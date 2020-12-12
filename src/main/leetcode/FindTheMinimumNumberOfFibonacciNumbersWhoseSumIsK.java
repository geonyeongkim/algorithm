package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2020-12-12
 */
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {

    public int findMinFibonacciNumbers(int k) {
        int res = 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        int idx = 1;

        while (true) {
            list.add(list.get(idx) + list.get(idx - 1));

            if(list.get(++idx) >= k) {
                break;
            }
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            if(k - list.get(i) < 0) continue;
            k -= list.get(i);
            res++;
            if(k == 0) break;
        }
        return res;
    }

    public static void main(String[] args) {
        FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK findTheMinimumNumberOfFibonacciNumbersWhoseSumIsK = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK();
        int res1 = findTheMinimumNumberOfFibonacciNumbersWhoseSumIsK.findMinFibonacciNumbers(7);
        System.out.println("res1 -> " + res1);

        int res2 = findTheMinimumNumberOfFibonacciNumbersWhoseSumIsK.findMinFibonacciNumbers(10);
        System.out.println("res2 -> " + res2);

        int res3 = findTheMinimumNumberOfFibonacciNumbersWhoseSumIsK.findMinFibonacciNumbers(19);
        System.out.println("res3 -> " + res3);
    }
}
