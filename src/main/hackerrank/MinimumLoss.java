package main.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2021-02-16
 */
public class MinimumLoss {

    static int minimumLoss(long[] price) {
        long answer = Integer.MAX_VALUE;

        Map<Long, Integer> map = new HashMap<>();
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < price.length; i++) {
            list.add(price[i]);
            map.put(price[i], i);
        }

        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            long val = list.get(i) - list.get(i - 1);
            if (answer > val && map.get(list.get(i)) < map.get(list.get(i - 1))) {
                answer = val;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        int ans = MinimumLoss.minimumLoss(new long[]{5, 10, 3});
        System.out.println(ans);

        ans = MinimumLoss.minimumLoss(new long[]{20, 7, 8, 2, 5});
        System.out.println(ans);
    }

}
