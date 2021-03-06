package main.codility;

import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {
        Arrays.sort(A);
        for(int i = 1; i < A.length; i++) {
            if(A[i-1] + 1 != A[i]) {
                return A[i-1] + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        int ans = permMissingElem.solution(new int[]{2,3,1,5});
        System.out.println(ans);
    }
}
