package main.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-01-12
 */
public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        if(n == 0) {
            return new int[]{0};
        }

        List<Integer> answerList = new ArrayList<>();

        while (n != 0) {
            answerList.add((int) (n % 10));
            n /= 10;
        }

        System.out.println("answerList => " + answerList);
        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        자연수뒤집어배열로만들기 c = new 자연수뒤집어배열로만들기();
        int[] ans = c.solution(12345);
        for (int an : ans) {
            System.out.print(an + ", ");
        }
    }
}
