package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RotateImage {

    public void rotate2(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    // 내 풀이..ㅎ
    public void rotate(int[][] matrix) {
        int row = 0, col = matrix.length - 1;

        List<int[]> tmp = new ArrayList<>();
        int[] arr;
        while(row < col) {
            tmp.clear();
            arr = new int[matrix.length];
            for (int q = row; q < matrix.length - row; q++) {
                arr[q] = matrix[row][q];
            }
            tmp.add(arr);

            arr = new int[matrix.length];
            for (int q = row; q < matrix.length - row; q++) {
                arr[q] = matrix[q][col];
            }
            tmp.add(arr);

            arr = new int[matrix.length];
            for (int q = row; q < matrix.length - row; q++) {
                arr[q] = matrix[matrix.length - row - 1][q];
            }
            tmp.add(arr);

            arr = new int[matrix.length];
            for (int q = row; q < matrix.length - row; q++) {
                arr[q] = matrix[q][matrix.length - col - 1];
            }
            tmp.add(arr);

            for (int q = row; q < matrix.length - row; q++) {
                matrix[q][col] = tmp.get(0)[q];
            }

            for (int q = row; q < matrix.length - row; q++) {
                matrix[matrix.length - row - 1][q] = tmp.get(1)[matrix.length - q - 1];
            }

            for (int q = row; q < matrix.length - row; q++) {
                matrix[q][matrix.length - col - 1] = tmp.get(2)[q];
            }

            for (int q = row; q < matrix.length - row; q++) {
                matrix[row][q] = tmp.get(3)[matrix.length - q - 1];
            }
            row++;
            col--;
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});

        rotateImage.rotate(new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}});
    }
}
