package main.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2020-12-25
 */
public class 같은숫자는싫어 {

    public int[] solution(int[] arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        int before = arr[0];
        list.add(before);
        for (int i : arr) {
            if(before != i) {
                list.add(i);
                before = i;
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);

        }

        return answer;
    }

    public static void main(String[] args) {
        같은숫자는싫어 c = new 같은숫자는싫어();
        int[] ans1 = c.solution(new int[]{1,1,3,3,0,1,1});
        for (int i : ans1) {
            System.out.print(i + ", ");
        }

        int[] ans2 = c.solution(new int[]{4,4,4,3,3});
        for (int i : ans2) {
            System.out.print(i + ", ");
        }
    }
}
