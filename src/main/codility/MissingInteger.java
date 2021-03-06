package main.codility;

import java.util.Arrays;

public class MissingInteger {

    public int solution(int[] A) {
        Arrays.sort(A);
        int answer = 1;

        for (int i : A) {
            if(answer == i) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        int ans = missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(ans);

        ans = missingInteger.solution(new int[]{1, 2, 3});
        System.out.println(ans);

        ans = missingInteger.solution(new int[]{-1, -3});
        System.out.println(ans);
    }
}
