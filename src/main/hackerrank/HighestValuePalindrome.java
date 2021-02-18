package main.hackerrank;

public class HighestValuePalindrome {

    static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder answer = new StringBuilder(s);

        boolean[] mark = new boolean[n];

        // 팰린드롬으로 만들기
        int left = 0, right = n - 1;

        while (left <= right) {
            if (answer.charAt(left) != answer.charAt(right)) {
                if (answer.charAt(left) > answer.charAt(right)) {
                    mark[right] = true;
                    answer.setCharAt(right, answer.charAt(left));
                } else {
                    mark[left] = true;
                    answer.setCharAt(left, answer.charAt(right));
                }
                k--;
            }
            left++;
            right--;
        }

        if (k < 0) return "-1";
        // max 팰린드롬으로 만들기
        System.out.println(answer.toString());
        System.out.println(k);

        left = 0;
        right = n - 1;

        while (left <= right) {

            if (left == right && k > 0) {
                answer.setCharAt(left, '9');
            }

            if (answer.charAt(left) < '9') {
                if (!mark[left] && !mark[right] && k > 1) {
                    answer.setCharAt(left, '9');
                    answer.setCharAt(right, '9');
                    k -= 2;
                } else if ((mark[left] || mark[right]) && k > 0) {
                    // k가 1지만 다 9로 하는 이유는 3843 같은 경우 4를 8로 바꾸는데 k를 한번 소모했고,
                    // 최대는 3993이기 때문에 위에서 4 -> 8로 바꾼걸 9로 바꾼거처럼 하기 위함.
                    answer.setCharAt(left, '9');
                    answer.setCharAt(right, '9');
                    k --;
                }
            }
            left++;
            right--;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String ans = HighestValuePalindrome.highestValuePalindrome("3943", 4, 1);
        System.out.println(ans);

        ans = HighestValuePalindrome.highestValuePalindrome("092282", 6, 3);
        System.out.println(ans);

        ans = HighestValuePalindrome.highestValuePalindrome("0011", 4, 1);
        System.out.println(ans);

        ans = HighestValuePalindrome.highestValuePalindrome("12321", 5, 1);
        System.out.println(ans);
    }
}
