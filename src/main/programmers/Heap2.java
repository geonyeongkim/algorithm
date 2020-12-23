package main.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by geonyeong.kim on 2020-12-22
 */
public class Heap2 {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (Comparator.comparingInt(o -> (o[0] + o[1]))));
        int answer = 0;



        return answer;
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{0, 3}, {1, 9}, {2, 6}};
    }

}
