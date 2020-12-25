package main.programmers;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by geonyeong.kim on 2020-12-25
 */
public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {
        int[] answer;

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                map.put(numbers[i] + numbers[j], numbers[i] + numbers[j]);
            }
        }

        answer = new int[map.size()];

        int idx = 0;
        for (Integer integer : map.keySet()) {
            answer[idx++] = integer;
        }
        return answer;
    }

    public static void main(String[] args) {
        두개뽑아서더하기 c = new 두개뽑아서더하기();
        int[] ans1 = c.solution(new int[]{2,1,3,4,1});
        for (int i : ans1) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] ans2 = c.solution(new int[]{5,0,2,7});
        for (int i : ans2) {
            System.out.print(i + ", ");
        }
    }
}
