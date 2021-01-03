package main.programmers;

public class Dp1 {

    /*
     * 모든 사칙연산 경우의 수를 계산하여 number와 맞는 경우 answer의 최솟값을 반환
     * 아래와 같이 수행 되어짐.
     * N + N + N + N + N + N + N + N
     * N + N + N + N + N + N + N - N
     * N + N + N + N + N + N + N / N
     * N + N + N + N + N + N + N * N
     *
     * NN + N + N
     * NN + N - N
     * NN + N / N
     * NN + N * N
     * */
    public int solution(int N, int number) {
        int answer = 9;
        answer = dfs(N, 0, number, 0, answer);
        if(answer > 8) return -1;
        return answer;
    }

    private int dfs(int N, int cal, int number, int cnt, int answer) {
        if (cnt > 8) return answer;

        if (cal == number) {
            answer = Math.min(cnt, answer);
            return answer;
        }

        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = (nn * 10) + N;
            answer = dfs(N, cal + nn, number, cnt + 1 + i, answer);
            answer = dfs(N, cal - nn, number, cnt + 1 + i, answer);
            answer = dfs(N, cal / nn, number, cnt + 1 + i, answer);
            answer = dfs(N, cal * nn, number, cnt + 1 + i, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Dp1 dp1 = new Dp1();
        int ans1 = dp1.solution(5, 12);
        System.out.println("ans1 => " + ans1);

        int ans2 = dp1.solution(2, 11);
        System.out.println("ans2 => " + ans2);
    }
}
