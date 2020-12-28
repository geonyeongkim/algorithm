package main.programmers;

import java.util.Stack;

/**
 * Created by geonyeong.kim on 2020-12-28
 */
public class Greedy3 {

    // 완전 탐색으로는 시간초과 발생...
    private int subset(int end, int cur, boolean[] flag, String number, int answerLength, int max) {
        if (end <= cur) {
            return max;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                sb.append(number.charAt(i));
            }
        }
        if (sb.length() == answerLength) {
            max = Math.max(max, Integer.valueOf(sb.toString()));
            return max;
        }

        flag[cur] = false;
        max = subset(end, cur + 1, flag, number, answerLength, max);
        flag[cur] = true;
        max = subset(end, cur + 1, flag, number, answerLength, max);
        return max;
    }

    public String solution(String number, int k) {
        char[] input = number.toCharArray();

        // 스택, 작은 수 일수록 위에 존재한다.
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while (!temp.empty() && k > 0 && temp.peek() < input[i]) {
                k--;
                temp.pop();
            }
            temp.push(input[i]);
        }
        StringBuilder sb = new StringBuilder();

        // k개를 삭제하지 못 한 경우 뒤에서 부터 제거.
        while (!temp.empty()) {
            if (k != 0) {
                // 그냥 삭제
                temp.pop();
                k--;
            } else {
                // 삭제하면서 builder 에 추가.
                sb.append(temp.pop());
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Greedy3 greedy3 = new Greedy3();
        String ans1 = greedy3.solution("1924", 2);
        System.out.println("ans1 => " + ans1);

        String ans2 = greedy3.solution("1231234", 3);
        System.out.println("ans2 => " + ans2);

        String ans3 = greedy3.solution("4177252841", 4);
        System.out.println("ans3 => " + ans3);
    }
}
