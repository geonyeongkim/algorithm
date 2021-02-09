package main.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-02-09
 */
public class AbsolutePermutation {

    static int[] absolutePermutation(int n, int k) {
        boolean[] visit = new boolean[n + 1];
        List<Integer> answerList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int a = i - k;
            int b = i + k;

            if (a > 0 && a <= n && !visit[a]) {
                answerList.add(a);
                visit[a] = true;
            } else if (b > 0 && b <= n && !visit[b]) {
                answerList.add(b);
                visit[b] = true;
            } else {
                return new int[]{-1};
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ans = AbsolutePermutation.absolutePermutation(2, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        ans = AbsolutePermutation.absolutePermutation(3, 0);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        ans = AbsolutePermutation.absolutePermutation(3, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
