package main.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= X; i++) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if(set.contains(A[i])) set.remove(A[i]);
            if(set.isEmpty()) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        int ans = frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        System.out.println(ans);
    }
}
