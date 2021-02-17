package main.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by geonyeong.kim on 2021-02-17
 */
public class GenerateParentheses_BruteForce {

    private static List<String> answer;

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        dfs("(", n * 2);
        return answer;
    }

    private void dfs(String parentheses, int max) {
        if(parentheses.length() == max) {
            // check
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < max; i++) {
                if (parentheses.charAt(i) == '(') {
                    stack.add(parentheses.charAt(i));
                } else {
                    if(stack.isEmpty()) {
                        return;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) answer.add(parentheses);
            return;
        }

        dfs(parentheses + "(", max);
        dfs(parentheses + ")", max);
    }

    public static void main(String[] args) {
        GenerateParentheses_BruteForce generateParentheses = new GenerateParentheses_BruteForce();
        List<String> ans = generateParentheses.generateParenthesis(3);
        System.out.println(ans);

        ans = generateParentheses.generateParenthesis(1);
        System.out.println(ans);
    }
}