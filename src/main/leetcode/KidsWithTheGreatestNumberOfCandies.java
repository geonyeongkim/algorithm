package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2020-12-04
 */
public class KidsWithTheGreatestNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = 0;
        for(int i : candies) max = Math.max(max, i);
        for(int i : candies) res.add(i + extraCandies >= max);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));
    }
}
