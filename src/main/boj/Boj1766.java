package main.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-01-23
 */
public class Boj1766 {

    /*
    * 위상정렬 문제
    * 위상정렬이란 그래프(DAG) 에서 각 노드의 가중치에 따라 정렬을 하는것을 의미
    *
    * 문제에 따라 다르겠지만 가중치가 가장 낮은순이라면
    * 가장 낮은 노드를 queue에 담아 이어져 있는 노드들의 가중치를 줄이며 가중치가 특정 값이 된 경우 연결된 노드를 queue에 다시 담음 ( 이 문제의 경우는 0이 되면 담음 )
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        int[] weights = new int[n+1];

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            list.get(node1).add(node2);
            weights[node2]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int i = 1; i <= n; i++) {
            if(weights[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer i : list.get(node)) {
                weights[i]--;

                if(weights[i] == 0) {
                    queue.add(i);
                }
            }
            System.out.print(node + " ");
        }
    }
}
