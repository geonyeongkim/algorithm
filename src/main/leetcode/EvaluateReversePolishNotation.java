package main.leetcode;

import java.util.Stack;

/**
 * Created by geonyeong.kim on 2021-03-02
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int right, left;
        for (String token : tokens) {
            switch (token) {
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(left / right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(left * right);
                    break;
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(left + right);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(left - right);
                    break;
                default:
                    stack.add(Integer.valueOf(token));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        int ans = evaluateReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println(ans);

        ans = evaluateReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(ans);

        ans = evaluateReversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(ans);
    }
}
