package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-11
 */
public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        int res = 0;
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt++;
            } else if(s.charAt(i) == ')') {
                res = Math.max(res, cnt);
                cnt--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses maximumNestingDepthOfTheParentheses = new MaximumNestingDepthOfTheParentheses();

        int res1 = maximumNestingDepthOfTheParentheses.maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println("res1 -> " + res1);

        int res2 = maximumNestingDepthOfTheParentheses.maxDepth("(1)+((2))+(((3)))");
        System.out.println("res2 -> " + res2);

        int res3 = maximumNestingDepthOfTheParentheses.maxDepth("1+(2*3)/(2-1)");
        System.out.println("res3 -> " + res3);

        int res4 = maximumNestingDepthOfTheParentheses.maxDepth("1");
        System.out.println("res4 -> " + res4);
    }
}
