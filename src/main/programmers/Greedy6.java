package main.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by geonyeong.kim on 2021-01-01
 */
public class Greedy6 {

    public int solution(int[][] routes) {
        int answer = 0;

        int camera = -30001;

        // 차가 고속도로에서 나간 지점을 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        // 차가 고속도로에 진입 시점보다 카메라가 뒤에 있으면 카메라를 나간시점에 하나 더 설치
        for (int[] route : routes) {
            if(camera < route[0]) {
                answer++;
                camera = route[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Greedy6 greedy6 = new Greedy6();
        int ans1 = greedy6.solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}});
        System.out.println("ans1 => " + ans1);
    }
}
