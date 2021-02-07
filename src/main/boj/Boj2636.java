package main.boj;

import java.util.Scanner;

public class Boj2636 {

    private static final int[] dirY = {0 , 0, 1, -1};
    private static final int[] dirX = {1, -1, 0, 0};
    private static int cheeseTmp = 0;
    private static int y;
    private static int x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        y = sc.nextInt();
        x = sc.nextInt();

        int[][] grid = new int[y][x];
        boolean[][] visit;

        int cheese = 0;
        int time = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) cheese++;
            }
        }

        while (cheese > 0) {
            // (0, 0) 기준으로 dfs 시작.
            cheeseTmp = 0;
            visit = new boolean[y][x];
            dfs(grid, visit, 0, 0);

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (grid[i][j] == 2) {
                        grid[i][j] = 0;
                        cheese--;
                        cheeseTmp++;
                    }
                }
            }
            time++;
        }

        System.out.println(time);
        System.out.println(cheeseTmp);
    }

    private static void dfs(int[][] grid, boolean[][] visit, int curY, int curX) {
        visit[curY][curX] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = curY + dirY[i];
            int nextX = curX + dirX[i];
            if (nextY > -1 && nextY < y && nextX > -1 && nextX < x && !visit[nextY][nextX]) {
                if (grid[nextY][nextX] == 0) {
                    dfs(grid, visit, nextY, nextX);
                }
                if (grid[nextY][nextX] == 1) {
                    grid[nextY][nextX] = 2;
                }
            }
        }
    }
}
