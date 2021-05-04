package main.leetcode;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int answer = 0;


        // '(' 를 만나면 가능한 parentheses 찾기
        // 그 후 길이 반환
        // tmp 변수를 사용하여 길이 누적하기
        // answer에는 Math.max로 tmp, answer 비교 후 큰거 넣기

        return answer;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int ans = longestValidParentheses.longestValidParentheses("(()");
        System.out.println(ans);

        ans = longestValidParentheses.longestValidParentheses(")()())");
        System.out.println(ans);

        ans = longestValidParentheses.longestValidParentheses("");
        System.out.println(ans);
    }
}
