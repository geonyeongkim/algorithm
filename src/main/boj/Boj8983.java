package main.boj;

import java.util.*;

public class Boj8983 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
        * M = 사대 수
        * N = 동물 수
        * L = 거리
        * */
        int M = sc.nextInt(), N = sc.nextInt(), L = sc.nextInt();

        int[] gunPositions = new int[M];

        for(int i = 0; i < M; i++) {
            gunPositions[i] = sc.nextInt();
        }

        Arrays.sort(gunPositions);

        List<int[]> animals = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            animals.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        animals.sort(Comparator.comparingInt(o -> o[0]));

        int answer = 0;
        int cur = 0;

        for (int[] animal : animals) {

            // 사대의 최대 사정거리보다 동물이 멀리 있는경우는 탐색 X (정렬을 했기 때문에 가능)
            if (animal[0] > gunPositions[M - 1] + L) break;

            for (int i = cur; i < M; i++) {
                int distance = Math.abs(gunPositions[i] - animal[0]) + animal[1];
                if(distance <= L) {
                    answer++;
                    cur = i;
                    break;
                }

                // 사정거리에는 들지 않고 사대가 동물보다 x 축으로 더 멀리 있으면 더이상 그 다음 사대는 탐색 X
                if(animal[0] < gunPositions[i]) break;
            }
        }
        System.out.println(answer);
    }
}
