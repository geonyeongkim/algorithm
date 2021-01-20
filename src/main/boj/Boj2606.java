package main.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-01-20
 */
public class Boj2606 {

    static boolean[] visit;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computers = sc.nextInt() + 1;
        int connectNum = sc.nextInt();

        visit = new boolean[computers];
        ans = 0;

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < computers; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < connectNum; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visit[1] = true;
        dfs(1, list);

        System.out.println(ans);
    }

    private static void dfs(int target, List<List<Integer>> list) {
        for (int computer : list.get(target)) {
            if (!visit[computer]) {
                visit[computer] = true;
                ans++;
                dfs(computer, list);
            }
        }
    }
}
