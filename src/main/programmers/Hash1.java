package main.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by geonyeong.kim on 2020-12-14
 */
public class Hash1 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String user : participant) {
            map.put(user, map.getOrDefault(user, 0) + 1);
        }
        for (String user : completion) {
            map.put(user, map.get(user) - 1);
        }
        for (Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) answer = entry.getKey();
        }

        return answer;
    }

    public static void main(String[] args) {
        Hash1 hash1 = new Hash1();
        String ans1 = hash1.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println("ans1 -> " + ans1);

        String ans2 = hash1.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        System.out.println("ans2 -> " + ans2);

        String ans3 = hash1.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println("ans3 -> " + ans3);
    }
}
