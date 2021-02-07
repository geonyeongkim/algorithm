package main.leetcode;

import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Set<Character> open = Set.of('(', '{', '[');
        Set<Character> close = Set.of(')', '}', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(open.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if(close.contains(s.charAt(i))) {
                if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
                else if(!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') stack.pop();
                else if(!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();
        boolean ans = validParentheses.isValid("()");
        System.out.println(ans);

        ans = validParentheses.isValid("()[]{}");
        System.out.println(ans);

        ans = validParentheses.isValid("(]");
        System.out.println(ans);

        ans = validParentheses.isValid("([)]");
        System.out.println(ans);

        ans = validParentheses.isValid("{[]}");
        System.out.println(ans);

        ans = validParentheses.isValid("]");
        System.out.println(ans);

        ans = validParentheses.isValid("(])");
        System.out.println(ans);
    }
}
