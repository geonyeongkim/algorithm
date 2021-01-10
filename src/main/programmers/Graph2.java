package main.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 경기 결과의 승, 패에 대해서 각각 그래프를 만들어
* 각각 탐색하며 이김과 패를 2차원 배열에 채움.
*
* 마지막으로 2차원 배열을 순회하면서 승패가 모두 있는 선수는 순위를 알 수 있기에, answer에 1 더함.
* */
public class Graph2 {

    List<Set<Integer>> wins;
    List<Set<Integer>> loses;
    int[][] games;
    boolean[] visit;

    private void dfsWins(int start, int target) {
        if (wins.get(target).size() == 0) {
            return;
        }

        for (int win : wins.get(target)) {
            if(!visit[win]) {
                visit[win] = true;
                games[start][win] = 1;
                dfsWins(start, win);
            }

        }
    }

    private void dfsLose(int start, int target) {
        if (loses.get(target).size() == 0) {
            return;
        }

        for (int lose : loses.get(target)) {
            if(!visit[lose]) {
                visit[lose] = true;
                games[start][lose] = 2;
                dfsLose(start, lose);
            }
        }
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        wins = new ArrayList<>();
        loses = new ArrayList<>();
        visit = new boolean[n + 1];

        // 초기화
        for (int i = 0; i <= n; i++) {
            wins.add(new HashSet<>());
            loses.add(new HashSet<>());
        }

        // 0 = 모름, 1 = 승, 2 = 패
        games = new int[n + 1][n + 1];

        for (int[] result : results) {
            games[result[0]][result[1]] = 1;
            games[result[1]][result[0]] = 2;
            wins.get(result[0]).add(result[1]);
            loses.get(result[1]).add(result[0]);
        }
        for (int i = 1; i <= n; i++) {
            dfsWins(i, i);
            visit = new boolean[n + 1];
            dfsLose(i, i);
            visit = new boolean[n + 1];
        }

        for (int i = 1; i < games.length; i++) {
            int cnt = 0;
            for (int j = 1; j < games[i].length; j++) {
                if (games[i][j] != 0) cnt++;
            }
            if (n - 1 == cnt) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Graph2 graph2 = new Graph2();
        int ans1 = graph2.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
        System.out.println("ans1 => " + ans1);

        int ans2 = graph2.solution(8, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}});
        System.out.println("ans2 => " + ans2);
    }
}