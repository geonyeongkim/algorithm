package main.codility;

/**
 * Created by geonyeong.kim on 2021-03-05
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        while (K-- > 0) {
            int last = A[A.length - 1];
            for (int i = A.length - 2; i >= 0; i--) {
                A[i + 1] = A[i];
            }
            A[0] = last;
        }
        return A;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] ans = cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3);
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = cyclicRotation.solution(new int[]{0, 0, 0}, 1);
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = cyclicRotation.solution(new int[]{1, 2, 3, 4}, 4);
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }
}
