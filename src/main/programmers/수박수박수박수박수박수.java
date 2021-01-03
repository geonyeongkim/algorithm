package main.programmers;

/**
 * Created by geonyeong.kim on 2021-01-03
 */
public class 수박수박수박수박수박수 {

    String[] text = {"수", "박"};

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;


        for (int i = 0; i < n; i++) {
            answer.append(text[idx++]);
            if(idx == 2) idx = 0;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        수박수박수박수박수박수 c = new 수박수박수박수박수박수();
        String ans1 = c.solution(3);
        System.out.println("ans1 -> " + ans1);
    }
}
