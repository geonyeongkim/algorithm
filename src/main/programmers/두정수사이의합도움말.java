package main.programmers;

/**
 * Created by geonyeong.kim on 2020-12-29
 */
public class 두정수사이의합도움말 {

    public long solution(int a, int b) {
        long answer = 0;

        for(int i = Math.min(a, b) ; i <= Math.max(a,b); i++) {
            answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        두정수사이의합도움말 c = new 두정수사이의합도움말();
        long ans1 = c.solution(3, 5);
        System.out.println("ans1 -> " + ans1);
        long ans2 = c.solution(3, 3);
        System.out.println("ans2 -> " + ans2);
        long ans3 = c.solution(5, 3);
        System.out.println("ans3 -> " + ans3);
    }
}
