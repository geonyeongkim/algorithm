package main.boj;

import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-01-20
 */
public class Boj9205 {

    // bfs로 변경해서 다시 풀이할 것!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        String[] answer = new String[tc];

        for (int i = 0; i < tc; i++) {
            int marketCnt = sc.nextInt();
            sc.nextLine();
            /*
             * 다음 목적지까지 맥주 20개를 가지고 갈수 있는지.
             * */
            answer[i] = "happy";
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int remainBeer = 20;
            for (int j = 0; j < marketCnt + 1; j++) {
                if (answer[i].equals("sad")) {
                    continue;
                }
                int x2 = sc.nextInt(), y2 = sc.nextInt();

                int distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                remainBeer -= (distance / 50);

                if (remainBeer < 0) {
                    answer[i] = "sad";
                } else {
                    remainBeer = 20;
                }
                x1 = x2;
                y1 = y2;
            }
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }
}
