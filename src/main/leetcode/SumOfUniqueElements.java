package main.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by geonyeong.kim on 2021-02-13
 */
public class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if(map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToInt(Entry::getKey)
                .sum();
    }

    public static void main(String[] args) {
        SumOfUniqueElements sumOfUniqueElements = new SumOfUniqueElements();
        int ans = sumOfUniqueElements.sumOfUnique(new int[]{1, 2, 3, 2});
        System.out.println(ans);

        ans = sumOfUniqueElements.sumOfUnique(new int[]{1, 1, 1, 1, 1});
        System.out.println(ans);

        ans = sumOfUniqueElements.sumOfUnique(new int[]{1, 2, 3, 4, 5});
        System.out.println(ans);
    }
}
