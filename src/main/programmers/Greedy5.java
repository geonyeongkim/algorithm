package main.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by geonyeong.kim on 2020-12-29
 */
public class Greedy5 {

    /*
    * 해당 문제의 경우,
    * 1. 합집합을 통한 노드들간 연결이 되었는지 체크하는 방법!!
    * 2. 연결 비용으로 오름차순 정렬하여 최소비용으로 연결할 수 있는 방법!!
    *
    * 이 두가지를 사용해야함!!
    * */
    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 연결이 되었는지 확인하기 위한 최상위 부모 노드를 가리킬수 있는 배열 생성
        int[] parent = new int[n];
        for(int i  = 0; i < n; i++) {
            parent[i] = i;
        }

        // 오름차순 정렬
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        /*
        * 각 노드들이 연결되어 있지 않으면 연결 및 비용 +
        * 연결되어 있으면 Pass
        * */
        for(int[] cost : costs) {
            boolean check = check(parent, cost[0], cost[1]);
            if(check) continue;
            else {
                // parent 배열 수정 -> 주어진 from to 노드의 최상위 노드를 찾아 변경해줌!!!
                int from = getParent(parent, cost[0]);
                int to = getParent(parent, cost[1]);
                if(from < to) {
                    parent[to] = from;
                } else {
                    parent[from] = to;
                }
                // 비용 더해줌
                answer += cost[2];
            }
        }

        return answer;
    }

    private boolean check(int[] parent, int from, int to) {
        int fromParentNode = getParent(parent, from);
        int toParentNode = getParent(parent, to);

        return fromParentNode == toParentNode;
    }

    // 해당 메서드를 재귀하여 최상위 노드를 찾음!!!
    private int getParent(int[] parent, int node) {
        if(parent[node] == node) return node;
        else return getParent(parent, parent[node]);
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