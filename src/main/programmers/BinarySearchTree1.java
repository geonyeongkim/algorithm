package main.programmers;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2021-01-06
 */
public class BinarySearchTree1 {

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0, end = n * (long)times[times.length - 1];

        while (start <= end) {

            long mid = (start + end) / 2;
            // mid 시간동안 전체 심사대에서 심사할 수 있는 총 인원 수
            long cnt = 0;

            for (int i = 0; i < times.length; i++) {
                cnt += mid / (long)times[i];
            }

            // n명을 처리해야하지만, cnt가 n보다 작으므로 start 시간을 늘리도록 해야함
            // start = mid + 1 로 이분 탐색이 되도록 해야함
            if(n > cnt) {
               start = mid + 1;
            } else {
                // 처리는 주어진 n 이상이 되었지만 최소 시간을 찾아야하기 떄문에 end를 mid-1로 하여 시간 찾음.
                end = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BinarySearchTree1 binarySearchTree1 = new BinarySearchTree1();
        long ans1 = binarySearchTree1.solution(6, new int[]{7, 10});
        System.out.println("ans1 => " + ans1);
    }
}
