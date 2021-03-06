package main.codility;

import java.util.Arrays;

public class PermCheck {

    public int solution(int[] A) {
        Arrays.sort(A);
        int tmp = 1;
        for (int i : A) {
            if(tmp++ != i) return 0;
        }
        
        return 1;
    }

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        int ans = permCheck.solution(new int[]{4, 1, 3, 2});
        System.out.println(ans);

        ans = permCheck.solution(new int[]{4, 1, 3});
        System.out.println(ans);
    }
}
