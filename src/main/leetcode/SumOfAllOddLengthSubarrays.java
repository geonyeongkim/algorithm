package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-11
 */
public class SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int odd = arr.length;
        if (odd % 2 == 0) odd--;
        int res = 0;

        while (odd > 0) {
            for (int i = 0; i <= arr.length - odd; i++) {
                for (int j = i; j < odd + i; j++) {
                    res += arr[j];
                }
            }
            odd -= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays sumOfAllOddLengthSubarrays = new SumOfAllOddLengthSubarrays();

        int res1 = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3});
        System.out.println("res1 -> " + res1);

        int res2 = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(new int[]{1, 2});
        System.out.println("res2 -> " + res2);

        int res3 = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(new int[]{10, 11, 12});
        System.out.println("res3 -> " + res3);
    }
}
