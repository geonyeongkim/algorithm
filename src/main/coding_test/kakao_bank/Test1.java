package main.coding_test.kakao_bank;

import java.util.Stack;

public class Test1 {

    public long solution(String[] p) {
        Stack<Long> stack = new Stack<>();
        long right, left;

        for (int i = 0; i < p.length; i++) {
            switch (p[i]) {
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(right + left);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(right * left);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    stack.push(Long.valueOf(p[i]));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        long ans = test1.solution(new String[]{"12","2","5","+","*","9","3","/","-"});
        System.out.println(ans);

        ans = test1.solution(new String[]{"1","1","+","1","1","+","*"});
        System.out.println(ans);
    }
}
