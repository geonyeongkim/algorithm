package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-13
 */
public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            res += mat[i][i];
            if(i != mat.length - 1 - i) {
                res += mat[i][mat.length - 1 - i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MatrixDiagonalSum matrixDiagonalSum = new MatrixDiagonalSum();
        int res1 = matrixDiagonalSum.diagonalSum(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        System.out.println("res1 -> " + res1);

        int res2 = matrixDiagonalSum.diagonalSum(new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}});
        System.out.println("res2 -> " + res2);
    }
}
