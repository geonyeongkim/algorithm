package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-10
 */
public class ScoreAfterFlippingMatrix {

    /*
    * 1. row 에서 첫번째가 0이면 1로 바꾸도록 함 -> 그게 가장 커지는 방법
    * 2. 1번 수행 후 col 들을 비교하며 0 이 있는 row가 1보다 많으면 switch하도록 함.
    * */
    public int matrixScore(int[][] A) {
        int rowLength = A.length, colLength = A[0].length;

        for (int i = 0; i < rowLength; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < colLength; j++) {
                    A[i][j] = Math.abs(A[i][j] - 1);
                }
            }
        }

        for (int i = 0; i < colLength; i++) {
            int zeroCnt = 0, oneCnt = 0;
            for (int j = 0; j < rowLength; j++) {
                if (A[j][i] == 0) {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }

            if (oneCnt < zeroCnt) {
                for (int j = 0; j < rowLength; j++) {
                    A[j][i] = Math.abs(A[j][i] - 1);
                }
            }
        }

        print(A);

        int result = 0;

        for (int i = 0; i < rowLength; i++) {
            int pow = colLength - 1;
            for (int j = 0; j < colLength; j++) {
                if(A[i][j] == 1) result += Math.pow(2, pow);
                pow--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix scoreAfterFlippingMatrix = new ScoreAfterFlippingMatrix();
        final int res = scoreAfterFlippingMatrix.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
        System.out.println("res -> " + res);

        final int res1 = scoreAfterFlippingMatrix.matrixScore(new int[][]{{0, 1}, {1, 1}});
        System.out.println("res -> " + res1);
    }

    private void print(int[][] A) {
        int rowLength = A.length, colLength = A[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                System.out.print(A[i][j] + ", ");
            }
            System.out.println();
        }

    }
}
