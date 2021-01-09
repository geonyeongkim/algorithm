package main.programmers;

/**
 * Created by geonyeong.kim on 2021-01-09
 */
public class 문자열을정수로바꾸기 {

    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0) == '-') {
            answer = Integer.valueOf(s.substring(1));
            answer *= -1;
        } else {
            answer = Integer.valueOf(s);
        }

        return answer;
    }

    public static void main(String[] args) {
        문자열을정수로바꾸기 c = new 문자열을정수로바꾸기();
        int ans1 = c.solution("1234");
        System.out.println("ans1 => " + ans1);

        int ans2 = c.solution("-1234");
        System.out.println("ans2 => " + ans2);
    }
}
