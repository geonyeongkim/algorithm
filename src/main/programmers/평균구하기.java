package main.programmers;

/**
 * Created by geonyeong.kim on 2021-01-09
 */
public class 평균구하기 {

    public double solution(int[] arr) {
        double answer = 0;
        long sum = 0;

        for (int i : arr) {
            sum += i;
        }

        answer = sum/(double)arr.length;
        return answer;
    }

    public static void main(String[] args) {
        평균구하기 c = new 평균구하기();
        double ans1 = c.solution(new int[]{1, 2, 3, 4});
        System.out.println("ans1 => " + ans1);

        double ans2 = c.solution(new int[]{5, 5});
        System.out.println("ans2 => " + ans2);
    }
}
