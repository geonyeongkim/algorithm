package main.programmers;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2020-12-20
 */
public class Sort2 {

    public String solution(int[] numbers) {

        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (result[0].equals("0")) {
            return "0";
        }

        String answer = "";
        for (String a : result) {
            answer += a;
        }
        return answer;
    }

    public static void main(String[] args) {
        Sort2 sort2 = new Sort2();
        String ans1 = sort2.solution(new int[]{6, 10, 2});
        System.out.println("ans1 = > " + ans1);

        String ans2 = sort2.solution(new int[]{3, 30, 34, 5, 9});
        System.out.println("ans2 = > " + ans2);

        String ans3 = sort2.solution(new int[]{40, 403});
        System.out.println("ans3 = > " + ans3);

        String ans4 = sort2.solution(new int[]{0,0,0,0,0,0});
        System.out.println("ans4 = > " + ans4);

        String ans5 = sort2.solution(new int[]{2,20,200});
        System.out.println("ans5 = > " + ans5);

    }
}
