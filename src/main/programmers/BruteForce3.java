package main.programmers;

/**
 * Created by geonyeong.kim on 2020-12-21
 */
public class BruteForce3 {

    public int[] solution(int brown, int yellow) {
        int x = yellow, y = 1;

        while(true) {
            int cal = (x * 2) + (y * 2) + 4;
            if(cal == brown) {
                break;
            }

            while(true) {
                y += 1;
                x = yellow / y;
                if(x * y == yellow) break;
            }
        }

        return new int[]{x+2, y+2};
    }

    public static void main(String[] args) {

        BruteForce3 bruteForce3 = new BruteForce3();
        int[] ans1 = bruteForce3.solution(10, 2);
        System.out.println("x = " + ans1[0] + " y = "+ ans1[1]);

        int[] ans2 = bruteForce3.solution(8, 1);
        System.out.println("x = " + ans2[0] + " y = "+ ans2[1]);

        int[] ans3 = bruteForce3.solution(24, 24);
        System.out.println("x = " + ans3[0] + " y = "+ ans3[1]);

    }
}
