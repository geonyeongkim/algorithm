package main.leetcode;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2021-03-05
 */
public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {
        int answer = 0;

        int[] cnt = new int[k];
        Arrays.fill(cnt, 0);

        Arrays.sort(c);
        int cntIdx = 0;

        for (int i = c.length - 1; i >= 0; i--) {
            answer += (c[i] * ++cnt[cntIdx++]);
            if(cntIdx == k) cntIdx = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        int ans = getMinimumCost(3, new int[]{2, 5, 6});
        System.out.println(ans);
        ans = getMinimumCost(2, new int[]{2, 5, 6});
        System.out.println(ans);
        ans = getMinimumCost(3, new int[]{1, 3, 5, 7, 9});
        System.out.println(ans);

        ans = getMinimumCost(3, new int[]{390225,426456,688267,800389,990107,439248,240638,15991,874479,568754,729927,980985,132244,488186,5037,721765,251885,28458,23710,281490,30935,897665,768945,337228,533277,959855,927447,941485,24242,684459,312855,716170,512600,608266,779912,950103,211756,665028,642996,262173,789020,932421,390745,433434,350262,463568,668809,305781,815771,550800});
        System.out.println(ans);
    }
}
