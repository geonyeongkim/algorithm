package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-20
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        boolean answer = true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }

        // check
        int left = 0, right = sb.length() - 1;

        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                answer = false;
                break;
            }
            left++;
            right--;
        }

        return answer;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean ans = validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(ans);

        ans = validPalindrome.isPalindrome("race a car");
        System.out.println(ans);

        ans = validPalindrome.isPalindrome("0P");
        System.out.println(ans);
    }
}
