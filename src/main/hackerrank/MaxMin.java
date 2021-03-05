package main.hackerrank;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2021-03-05
 */
public class MaxMin {

    static int maxMin(int k, int[] arr) {

        Arrays.sort(arr);

        int minIdx = -1, min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - k + 1; i++) {
            if(arr[i + k - 1] - arr[i] < min) {
                minIdx = i;
                min = arr[i + k - 1] - arr[i];
            }
        }

        return arr[minIdx + k - 1] - arr[minIdx];
    }

    public static void main(String[] args) {
        int ans = maxMin(3, new int[]{10, 100, 300, 200, 1000, 20, 30});
        System.out.println(ans);

        ans = maxMin(4, new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200});
        System.out.println(ans);

        ans = maxMin(2, new int[]{1, 2, 1, 2, 1});
        System.out.println(ans);

        ans = maxMin(3, new int[]{100, 200, 300, 350, 400, 401, 402});
        System.out.println(ans);
    }
}
