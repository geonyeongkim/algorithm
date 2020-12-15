package main.programmers;

/**
 * Created by geonyeong.kim on 2020-12-15
 */
public class StackQueue1 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if(val > prices[j]) break;
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        StackQueue1 stackQueue1 = new StackQueue1();
        int[] res1 = stackQueue1.solution(new int[]{1, 2, 3, 2, 3});
        for (int i : res1) {
            System.out.print(i + ",");
        }
    }
}
