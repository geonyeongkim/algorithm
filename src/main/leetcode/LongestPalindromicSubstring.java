package main.leetcode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder("#");

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append('#');
        }

        int r = 0, p = 0;
        int[] dp = new int[sb.length()];
        int maxIdx = 0, maxVal = 0;

        for (int i = 0; i < sb.length(); i++) {
            dp[i] = r >= i ? Math.min(r - i, dp[p * 2 - i]) : 0;

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < sb.length()
                    && sb.charAt(i - dp[i] - 1) == sb.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > r) {
                r = i + dp[i];
                p = i;
            }

            if(dp[i] > maxVal) {
                maxIdx = i;
                maxVal = dp[i];
            }
        }

        return sb.substring(maxIdx - dp[maxIdx], maxIdx + dp[maxIdx]).replaceAll("#", "");
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String ans = longestPalindromicSubstring.longestPalindrome("babad");
        System.out.println(ans);

        ans = longestPalindromicSubstring.longestPalindrome("cbbd");
        System.out.println(ans);

        ans = longestPalindromicSubstring.longestPalindrome("a");
        System.out.println(ans);

        ans = longestPalindromicSubstring.longestPalindrome("ac");
        System.out.println(ans);
    }
}
