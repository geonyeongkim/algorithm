package main.programmers;

public class 게임_맵_최단거리 {

    private static final int[] dirX = {0, 0, 1, -1};
    private static final int[] dirY = {1, -1, 0, 0};
    private static boolean[][] visit;
    private static int answer;
    private static int[][] mapsCopy;

    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        answer = Integer.MAX_VALUE;
        mapsCopy = maps;
        dfs( 0, 0, 1);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int curY, int curX, int distance) {
        if(mapsCopy.length - 1 == curY && mapsCopy[0].length - 1 == curX) {
            answer = Math.min(distance, answer);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nextY = curY + dirY[i];
            int nextX = curX + dirX[i];

            if(nextY >= 0 && nextY < mapsCopy.length && nextX >= 0 && nextX < mapsCopy[0].length && mapsCopy[nextY][nextX] == 1 && !visit[nextY][nextX]) {
                visit[nextY][nextX] = true;
                dfs(nextY, nextX, distance + 1);
                visit[nextY][nextX] = false;
            }
        }
    }

    public static void main(String[] args) {
        게임_맵_최단거리 c = new 게임_맵_최단거리();
        int ans = c.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        System.out.println(ans);

        ans = c.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});
        System.out.println(ans);
    }
}
