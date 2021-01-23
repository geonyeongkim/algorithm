package main.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-01-23
 */
public class Boj1939 {

    static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<List<Bridge>> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            list.get(from).add(new Bridge(to, weight));
            list.get(to).add(new Bridge(from, weight));
        }

        visit = new boolean[n + 1];

        int from = sc.nextInt();
        int to = sc.nextInt();


        List<Integer> answerList = new ArrayList<>();
        dfs(list, from, to, answerList, Integer.MAX_VALUE);

        System.out.println(Collections.max(answerList));
    }

    private static void dfs(List<List<Bridge>> list, int from, int to, List<Integer> answerList, int weight) {
        visit[from] = true;
        for (Bridge bridge : list.get(from)) {
            if(bridge.num == to) {
                answerList.add(Math.min(weight, bridge.weight));
                break;
            }

            if(!visit[bridge.num]) {
                dfs(list, bridge.num, to, answerList, Math.min(weight, bridge.weight));
            }
        }
    }

    static class Bridge {
        int num;
        int weight;

        public Bridge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
