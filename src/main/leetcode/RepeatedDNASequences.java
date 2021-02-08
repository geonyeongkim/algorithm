package main.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Created by geonyeong.kim on 2021-02-08
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i+10);
            if(map.get(sub) == null) {
                map.put(sub, 1);
            } else {
                map.put(sub, map.get(sub) + 1);
            }
        }

        return map.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        List<String> ans = repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(ans);

        ans = repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAAAA");
        System.out.println(ans);
    }
}
