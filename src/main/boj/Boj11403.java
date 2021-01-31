package main.boj;

import java.util.*;

/**
 * Created by geonyeong.kim on 2021-01-27
 */
public class Boj11403 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();

        // 초기화
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // 입력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(1 == sc.nextInt()) {
                    list.get(i).add(j);
                }
            }
        }

        // bfs를 위한 큐
        Queue<Integer> queue = new LinkedList<>();

        // 방문여부 확인 배열
        boolean[] visit = new boolean[n];

        int[][] answer = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                for (int node: list.get(i)) {
                    queue.add(node);
                }
                while(!queue.isEmpty()) {
                    int target = queue.poll();
                    visit[target] = true;
                    if(target == j) {
                        answer[i][j] = 1;
                        break;
                    }

                    for (int node : list.get(target)) {
                        if(visit[node] == false) {
                            queue.add(node);
                        }
                    }
                }
                queue.clear();
                visit = new boolean[n];
            }
        }

        for (int[] ints : answer) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
