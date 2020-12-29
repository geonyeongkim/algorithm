package main.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by geonyeong.kim on 2020-12-29
 */
public class Greedy5 {

    public int solution(int n, int[][] costs) {
        int answer = 0;

        /*
         * 1. 비용순으로 정렬
         * 2. for-loop를 돌면서 다리가 놓아져 있는지 체크 : Map<섬 num, Set<이어진 섬 num>>
         *   2-1. 놓아져있으면 continue;
         *   2-2. 놓아져있지 않으면 추가;
         * 3. 모두 연결되었는지 체크: 체크시에는 set을 for-loop돌면서 건너지 않은 섬을 최우선적으로 탐색
         * 4. 모두 연결되었다면 break; 으로 빠져나옴.
         * */

        // 1.
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        // 2.
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // 초기화.
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }

        for(int[] cost : costs) {
            // check

            // 2-1.
            map.get(cost[0]).add(cost[1]);
            map.get(cost[1]).add(cost[0]);

            // 2-2.
            answer += cost[2];



        }

        return answer;
    }

    public static void main(String[] args) {
        Greedy5 greedy5 = new Greedy5();

        int ans1 = greedy5.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
        System.out.println("ans1 => " + ans1);

        int ans2 = greedy5.solution(4, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}});
        System.out.println("ans2 => " + ans2);

        int ans3 = greedy5.solution(6, new int[][]{{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}});
        System.out.println("ans3 => " + ans3);
    }
}