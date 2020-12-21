package main.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by geonyeong.kim on 2020-12-21
 */
public class BruteForce2 {

    boolean[] check;
    String[] numberArr;
    Set<Integer> caseSet;

    private void search(int cur, int max, String caseStr) {
        if (cur == max) {
            caseSet.add(Integer.valueOf(caseStr));
            return;
        }

        for (int i = 0; i < numberArr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                search(cur + 1, max, caseStr + numberArr[i]);
                check[i] = false;
            }
        }

    }

    public int solution(String numbers) {
        int answer = 0;
        numberArr = numbers.split("");
        check = new boolean[numberArr.length];
        caseSet = new HashSet<>();

        for (int i = 0; i < numberArr.length; i++) {
            for (int j = 0; j < numberArr.length; j++) {
                if (!check[j]) {
                    check[j] = true;
                    search(1, i + 1, numberArr[j]);
                    check[j] = false;
                }
            }
        }

        for (int caseNum : caseSet) {
            int cnt = 0;
            for (int i = 1; i <= caseNum; i++) {
                if(caseNum % i == 0) cnt++;
            }
            if (cnt == 2) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        BruteForce2 bruteForce2 = new BruteForce2();
        int ans1 = bruteForce2.solution("17");
        System.out.println("ans1 -> " + ans1);

        int ans2 = bruteForce2.solution("011");
        System.out.println("ans2 -> " + ans2);
    }
}
