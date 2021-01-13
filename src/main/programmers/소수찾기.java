package main.programmers;

/**
 * Created by geonyeong.kim on 2021-01-13
 */
public class 소수찾기 {

    public int solution(int n) {
        int answer = 0;
        boolean[] checked = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!checked[i])
                answer++;
            for (int j = i; j <= n; j += i) {
                if (!checked[j])
                    checked[j] = true;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        소수찾기 c = new 소수찾기();
        int ans1 = c.solution(10);
        System.out.println("ans1 => " + ans1);

        int ans2 = c.solution(5);
        System.out.println("ans2 => " + ans2);
    }
}
