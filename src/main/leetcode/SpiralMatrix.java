package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-02-22
 */
public class SpiralMatrix {

    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};
    static List<Integer> answer;
    static boolean[][] visit;
    static int[][] matrixStatic;
    static int lengthX, lengthY;

    public List<Integer> spiralOrder(int[][] matrix) {
        answer = new ArrayList<>();
        lengthY = matrix.length;
        lengthX = matrix[0].length;
        visit = new boolean[lengthY][lengthX];
        matrixStatic = matrix;
        visit[0][0] = true;
        dfs(0, 0, 0);

        return answer;
    }

    private void dfs(int x, int y, int dirIdx) {
        answer.add(matrixStatic[y][x]);

        int nextX = x + dirX[dirIdx];
        int nextY = y + dirY[dirIdx];
        if(nextY >= 0 && nextY < lengthY && nextX >= 0 && nextX < lengthX && !visit[nextY][nextX]) {
            visit[nextY][nextX] = true;
            dfs(nextX, nextY, dirIdx);
        } else {
            if(dirIdx == 3) dirIdx = 0;
            else dirIdx++;
            nextX = x + dirX[dirIdx];
            nextY = y + dirY[dirIdx];
            if(nextY >= 0 && nextY < lengthY && nextX >= 0 && nextX < lengthX && !visit[nextY][nextX]) {
                visit[nextY][nextX] = true;
                dfs(nextX, nextY, dirIdx);
            }
        }
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> ans = spiralMatrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(ans);
        ans = spiralMatrix.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(ans);

        ans = spiralMatrix.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        System.out.println(ans);
    }
}
