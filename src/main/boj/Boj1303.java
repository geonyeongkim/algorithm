package main.boj;

import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-01-21
 */
public class Boj1303 {

    static boolean[][] visit;
    static int[] dirX = {0, 1, -1, 0};
    static int[] dirY = {1, 0, 0, -1};
    static int x;
    static int y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();

        visit = new boolean[y][x];

        String[][] war = new String[y][x];
        sc.nextLine();
        for (int i = 0; i < y; i++) {
            war[i] = sc.nextLine().split("");
        }

        // W 측정
        String target = "W";
        int ansW = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visit[i][j] && target.equals(war[i][j])) {
                    int cnt = dfs(war, i, j, target, 1);
                    ansW += (cnt * cnt);
                }
            }
        }

        target = "B";
        int ansB = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visit[i][j] && target.equals(war[i][j])) {
                    int cnt = dfs(war, i, j, target, 1);
                    ansB += (cnt * cnt);
                }
            }

        }

        System.out.println(ansW + " " + ansB);
    }

    private static int dfs(String[][] war, int i, int j, String target, int cnt) {
        visit[i][j] = true;

        for (int q = 0; q < 4; q++) {
            int nextX = j + dirX[q];
            int nextY = i + dirY[q];

            if (nextX >= 0 && nextX < x && nextY >= 0 && nextY < y && !visit[nextY][nextX] && target.equals(war[nextY][nextX])) {
                cnt = dfs(war, nextY, nextX, target, cnt + 1);
            }
        }
        return cnt;
    }
}
