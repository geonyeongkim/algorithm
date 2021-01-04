package main.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-01-04
 */
public class DfsBfs2 {

    private void dfs(List<List<Integer>> connectList, boolean[] check, int depth) {
        // 연결된 컴퓨터들에서 순회한적 없으면 순회!
        // 순회 시 순회했다는 증거로 check 값 true로 변경
        for (int conn : connectList.get(depth)) {
            if (check[conn] == false) {
                check[conn] = true;
                dfs(connectList, check, conn);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 각 컴퓨터를 순회했는지에 대한 true/false
        boolean[] check = new boolean[n];

        List<List<Integer>> connectList = new ArrayList<>();

        // 연결 정보를 담는 이중 리스트
        for (int i = 0; i < computers.length; i++) {
            List<Integer> connect = new ArrayList<>();
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    connect.add(j);
                }
            }
            connectList.add(connect);
        }


        for (int i = 0; i < connectList.size(); i++) {
            // i 컴퓨터를 순회한적이 없다면 dfs를 통해 순회 시작.
            // 한번 순회할때마다 네트워크 갯수는 추가.
            if (check[i] == false) {
                // dfs 탐색 시작
                check[i] = true;
                answer++;
                dfs(connectList, check, i);
            }

            /*
            * 모든 컴퓨터를 돌았는지 체크
            * */
            boolean flag = true;
            for (boolean b : check) {
                if (!b) {
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        DfsBfs2 dfsBfs2 = new DfsBfs2();

        int ans1 = dfsBfs2.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println("ans1 -> " + ans1);

        int ans2 = dfsBfs2.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println("ans2 -> " + ans2);
    }
}
