package main.programmers;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2021-01-11
 */
/*
 * 이분 탐색의 기준은 바위사이의 간격을 측정.
 * 바위 사이의 간격을 이분탐색으로 세팅하면서 지운 돌이 n개 보다 크면 right를 mid - 1,
 * n개 보다 작거나 같으면 left를 mid +1 시킨다.
 *
 * n개 보다 작거나 같은 경우는 문제의 요건에 충족하므로 그 중 최댓값을 구하면 된다.
 *
 * */
public class BinarySearchTree2 {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int left = 1, right = distance, mid = 0, start = 0;
        int cnt = 0; // 지운 바위 갯수

        while (left <= right) {
            mid = (left + right) / 2;

            // 가정한 돌사이의 최소 간격인 mid 보다 작은 간격이 있으면 틀렸기에 cnt 증가.
            for (int rock : rocks) {
                if (mid > rock - start) {
                    cnt++;
                } else {
                    start = rock;
                }
            }

            if (mid > distance - start) {
                cnt++;
            }

            if (cnt > n) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }

            cnt = 0;
            start = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        BinarySearchTree2 binarySearchTree2 = new BinarySearchTree2();
        int ans1 = binarySearchTree2.solution(25, new int[]{2, 14, 11, 21, 17}, 2);
        System.out.println("ans1 => " + ans1);
    }
}
