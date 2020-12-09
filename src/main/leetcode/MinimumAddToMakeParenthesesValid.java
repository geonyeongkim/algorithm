package main.leetcode;

import java.util.Stack;

/**
 * Created by geonyeong.kim on 2020-12-09
 */
public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == ')' && !stack.isEmpty() &&stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(S.charAt(i));
        }
        return stack.size();
    }

    public static void main(String[] args) {

        MinimumAddToMakeParenthesesValid minimumAddToMakeParenthesesValid = new MinimumAddToMakeParenthesesValid();
        int res1 = minimumAddToMakeParenthesesValid.minAddToMakeValid("(()");
        System.out.println("res1 -> " + res1);

        int res2 = minimumAddToMakeParenthesesValid.minAddToMakeValid("(((");
        System.out.println("res2 -> " + res2);

        int res3 = minimumAddToMakeParenthesesValid.minAddToMakeValid("()");
        System.out.println("res3 -> " + res3);

        int res4 = minimumAddToMakeParenthesesValid.minAddToMakeValid("()))((");
        System.out.println("res4 -> " + res4);
    }
}
