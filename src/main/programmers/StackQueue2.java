package main.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2020-12-15
 */
public class StackQueue2 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] remains = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int remain = (100 - progresses[i]) % speeds[i] != 0 ? ((100 - progresses[i]) / speeds[i]) + 1 : ((100 - progresses[i]) / speeds[i]);
            remains[i] = remain;
        }
        List<Integer> list = new ArrayList<>();
        int max = remains[0];
        int cnt = 1;
        for (int i = 1; i < remains.length; i++) {
            if(max < remains[i]) {
                max = remains[i];
                list.add(cnt);
                cnt = 0;
            }
            cnt++;
        }
        list.add(cnt);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        StackQueue2 stackQueue2 = new StackQueue2();

        int[] res1 = stackQueue2.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        for (int i : res1) System.out.println(i + ",");


        int[] res2 = stackQueue2.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        for (int i : res2) System.out.println(i + ",");
    }
}
