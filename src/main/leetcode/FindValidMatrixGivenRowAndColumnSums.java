package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-09
 */
public class FindValidMatrixGivenRowAndColumnSums {

    /*
    * 문제풀이 참고함....
    * 모든 경우의 수로 n차열 배열을 만들어가며 체크하는 방법을 생각했으나, 그런경우 시간 복잡도가 엄청나게 증대하는게 느껴짐...
    *
    * 풀이는 아래와 같았다. ex) rowSum = [3, 8] , colSum = [4, 7]
    * 1. 각 rowSum 값과 colSum의 값들을 비교하며 min 값을 선택한다. -> 3, 4, 7 비교
    * 2. 단, min 값을 colSum에서 감소시킨다. 이유는 colSum도 맞춰야하니, 사용한 값을 감소 시킴.
    *
    * 3. 요약해서 min 값을 선택하여 감소시키는 작업은 우선순위로 rowSum을 맞추면서 사용한 값들을 감소시키는 작업이며, 남은 값을 마지막에 사용하여 colSum을 맞춰가는 작업.
    * */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        FindValidMatrixGivenRowAndColumnSums findValidMatrixGivenRowAndColumnSums = new FindValidMatrixGivenRowAndColumnSums();
        int[][] res1 = findValidMatrixGivenRowAndColumnSums.restoreMatrix(new int[]{3, 8}, new int[]{4, 7});
        printResult(res1);
        System.out.println();
        int[][] res2 = findValidMatrixGivenRowAndColumnSums.restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8});
        printResult(res2);
        System.out.println();
        int[][] res3 = findValidMatrixGivenRowAndColumnSums.restoreMatrix(new int[]{14, 9}, new int[]{6, 9, 8});
        printResult(res3);
        System.out.println();
        int[][] res4 = findValidMatrixGivenRowAndColumnSums.restoreMatrix(new int[]{1, 0}, new int[]{1});
        printResult(res4);
        System.out.println();
        int[][] res5 = findValidMatrixGivenRowAndColumnSums.restoreMatrix(new int[]{0}, new int[]{0});
        printResult(res5);
    }

    private static void printResult(int[][] res) {
        for(int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
                if (j != res[i].length-1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
