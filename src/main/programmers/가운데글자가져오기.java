package main.programmers;

/**
 * Created by geonyeong.kim on 2020-12-27
 */
public class 가운데글자가져오기 {

    public String solution(String s) {
        String answer;

        if(s.length() % 2 == 0) {
            int mid = s.length() / 2;
            answer = s.substring(mid - 1, mid + 1);
        } else {
            int mid = s.length() / 2;
            answer = s.substring(mid, mid + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        가운데글자가져오기 c = new 가운데글자가져오기();
        String ans1 = c.solution("abcde");
        System.out.println("ans1 -> " + ans1);

        String ans2 = c.solution("qwer");
        System.out.println("ans2 -> " + ans2);
    }
}
