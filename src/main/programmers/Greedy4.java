package main.programmers;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2020-12-28
 */
public class Greedy4 {

    /*
    * 가장 작은 무게 + 가장 큰 무게의 조합이 limit에 안걸리는 것이 가장 최소한의 움직임.
    * */
    public int solution(int[] people, int limit) {
        int answer = 1;

        Arrays.sort(people);

        int right = people.length -1, left = 0;

        while(true) {
            if(people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            if(left > right) break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Greedy4 greedy4 = new Greedy4();

        int ans1 = greedy4.solution(new int[]{70, 50, 80, 50}, 100);
        System.out.println("ans1 => " + ans1);

        int ans2 = greedy4.solution(new int[]{70, 80, 50}, 100);
        System.out.println("ans2 => " + ans2);

        int ans3 = greedy4.solution(new int[]{40, 40, 40}, 100);
        System.out.println("ans3 => " + ans3);
    }
}
