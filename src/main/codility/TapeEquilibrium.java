package main.codility;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int answer = Integer.MAX_VALUE;

        int[] sumArr = new int[A.length];

        int sum = 0;

        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            sumArr[i] = sum;
        }

        for(int i = 0; i < A.length; i++) {
            int left = sumArr[i];
            int right = sum - sumArr[i];
            answer = Math.min(answer, Math.abs(left - right));
        }

        return answer;
    }

    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int ans = tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3});
        System.out.println(ans);
    }
}
