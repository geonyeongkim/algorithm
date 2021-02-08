package main.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by geonyeong.kim on 2021-02-08
 */
public class ClimbingTheLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> answer = new ArrayList<>();

        Collections.sort(ranked, Comparator.reverseOrder());
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int rank = 1;
        map.put(ranked.get(0), rank);

        for (int i = 1; i < ranked.size(); i++) {
            if(map.firstKey() > ranked.get(i)) {
                map.put(ranked.get(i), ++rank);
            }
        }
        map.put(0, ++rank);

        map.put((int) Math.pow(10, 9), 1);

        for (int playI : player) {
            answer.add(map.floorEntry(playI).getValue());
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> ans = ClimbingTheLeaderboard.climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120));
        System.out.println(ans);

        ans = ClimbingTheLeaderboard.climbingLeaderboard(Arrays.asList(100, 90, 90, 80, 75, 60), Arrays.asList(50, 65, 77, 90, 102));
        System.out.println(ans);
    }
}
