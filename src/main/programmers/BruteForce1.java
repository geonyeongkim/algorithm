package main.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by geonyeong.kim on 2020-12-21
 */
public class BruteForce1 {

    public int[] solution(int[] answers) {
        int[] oneRepeat = new int[]{1, 2, 3, 4, 5};
        int[] twoRepeat = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] threeRepeat = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] one = new int[10000], two = new int[10000], three = new int[10000];
        int oneIdx = 0, twoIdx = 0, threeIdx = 0, cnt = 0;

        while (cnt <= 9999) {
            one[cnt] = oneRepeat[oneIdx++];
            two[cnt] = twoRepeat[twoIdx++];
            three[cnt] = threeRepeat[threeIdx++];

            if (oneIdx >= oneRepeat.length) {
                oneIdx = 0;
            }
            if (twoIdx >= twoRepeat.length) {
                twoIdx = 0;
            }
            if (threeIdx >= threeRepeat.length) {
                threeIdx = 0;
            }
            cnt++;
        }

        int oneAns = 0, twoAns = 0, threeAns = 0;

        for (int i = 0; i < answers.length; i++) {
            if (one[i] == answers[i]) {
                oneAns++;
            }
            if (two[i] == answers[i]) {
                twoAns++;
            }
            if (three[i] == answers[i]) {
                threeAns++;
            }
        }

        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(oneAns, new ArrayList<>());
        map.put(twoAns, new ArrayList<>());
        map.put(threeAns, new ArrayList<>());
        map.get(oneAns).add(1);
        map.get(twoAns).add(2);
        map.get(threeAns).add(3);

        List<Integer> answerList = map.values().stream().limit(1).findFirst().get();

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        BruteForce1 bruteForce1 = new BruteForce1();
        int[] ans1 = bruteForce1.solution(new int[]{1, 2, 3, 4, 5});
        for (int i : ans1) {
            System.out.print(i+ ", ");

        }
        System.out.println();

        int[] ans2 = bruteForce1.solution(new int[]{1, 3, 2, 4, 2});
        for (int i : ans2) {
            System.out.print(i+ ", ");

        }

    }
}
