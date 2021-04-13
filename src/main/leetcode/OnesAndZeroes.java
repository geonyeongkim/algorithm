package main.leetcode;

public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {

        /*
         * 0의 갯수, 1의 갯수 -> 최대 subset 길이
         * */
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int arr[] = extractOneAndZero(s);

            for (int zero = m; zero >= arr[0]; zero--) {
                for (int one = n; one >= arr[1]; one--) {
                    dp[zero][one] = Math.max(dp[zero][one], dp[zero - arr[0]][one - arr[1]] + 1);
                }
            }
        }


        return dp[m][n];
    }

    private int[] extractOneAndZero(String s) {
        int arr[] = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') arr[0]++;
            if (c == '1') arr[1]++;
        }
        return arr;
    }


    public static void main(String[] args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        int ans = onesAndZeroes.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 5);
        System.out.println(ans);
    }
}
