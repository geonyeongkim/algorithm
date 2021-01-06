package main.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by geonyeong.kim on 2021-01-05
 */
public class DfsBfs4 {

    public String[] solution(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            if(map.get(ticket[0]) == null) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        for (List<String> value : map.values()) {
            Collections.sort(value);
        }

        String[] answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        int idx = 1;
        String target = "ICN";

        Set<String> set = new HashSet<>();
        for (Entry<String, List<String>> stringListEntry : map.entrySet()) {
            set.add(stringListEntry.getKey());
            for (String s : stringListEntry.getValue()) {
                set.add(s);
            }
        }
        set.remove("ICN");

        String beforeTarget = "";
        while(true) {
            if (map.get(target) == null || map.get(target).size() == 0) {
                if(!set.isEmpty()) {
                    map.get(beforeTarget).add(target);
                    set.add(target);
                    target = beforeTarget;
                    idx--;
                    continue;
                }
                break;
            }

            beforeTarget = target;
            String nextTarget = map.get(target).get(0);
            answer[idx++] = nextTarget;
            set.remove(nextTarget);
            map.get(target).remove(0);
            target = nextTarget;
        }

        return answer;
    }

    public static void main(String[] args) {
        DfsBfs4 dfsBfs4 = new DfsBfs4();
        String[] ans1 = dfsBfs4.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        for (String s : ans1) {
            System.out.print(s + ", ");
        }
        System.out.println();

        String[] ans2 = dfsBfs4.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
        for (String s : ans2) {
            System.out.print(s + ", ");
        }
        System.out.println();

        String[] ans3 = dfsBfs4.solution(new String[][]{{"ICN", "A"},{"ICN", "A"},{"ICN", "A"},{"A", "ICN"},{"A", "ICN"}});
        for (String s : ans3) {
            System.out.print(s + ", ");
        }
        System.out.println();

        String[] ans4 = dfsBfs4.solution(new String[][]{{"ICN", "A"},{"A", "C"},{"A", "D"},{"D", "B"},{"B", "A"}});
        for (String s : ans4) {
            System.out.print(s + ", ");
        }
        System.out.println();

        String[] ans5 = dfsBfs4.solution(new String[][]{{"ICN", "A"},{"ICN", "A"}, {"A", "ICN"}});
        for (String s : ans5) {
            System.out.print(s + ", ");
        }

        System.out.println();

        String[] ans6 = dfsBfs4.solution(new String[][]{{"ICN", "SFO"},{"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}});
        for (String s : ans6) {
            System.out.print(s + ", ");
        }
    }
}
