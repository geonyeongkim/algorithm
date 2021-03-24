package main.programmers;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {

    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = nums.length / 2;
        return Math.min(answer, map.size());
    }

    public static void main(String[] args) {
        폰켓몬 c = new 폰켓몬();
        int ans = c.solution(new int[]{3,1,2,3});
        System.out.println(ans);

        ans = c.solution(new int[]{3,3,3,2,2,4});
        System.out.println(ans);

        ans = c.solution(new int[]{3,3,3,2,2,2});
        System.out.println(ans);
    }
}
