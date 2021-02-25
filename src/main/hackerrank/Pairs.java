package main.hackerrank;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2021-02-25
 */
public class Pairs {

    static int pairs(int k, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            for(int j = idx + 1; j < arr.length; j++) {
                if(k == Math.abs(arr[i] - arr[j])) {
                    answer++;
                    idx = j;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int ans = Pairs.pairs(1, new int[]{1, 2, 3, 4});
        System.out.println(ans);

        ans = Pairs.pairs(2, new int[]{1, 5, 3, 4, 2});
        System.out.println(ans);
    }
}
