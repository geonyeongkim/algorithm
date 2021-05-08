package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountItemsMatchingARule {

    private static final Map<String, Integer> TYPE_MAP = new HashMap<>();
    static {
        TYPE_MAP.put("type", 0);
        TYPE_MAP.put("color", 1);
        TYPE_MAP.put("name", 2);
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;

        int idx = TYPE_MAP.get(ruleKey);

        for(List<String> item : items) {
            if(item.get(idx).equals(ruleValue)) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        CountItemsMatchingARule countItemsMatchingARule = new CountItemsMatchingARule();
        int ans = countItemsMatchingARule.countMatches(Arrays.asList(
                Arrays.asList("phone","blue","pixel"),
                Arrays.asList("computer","silver","lenovo"),
                Arrays.asList("phone","gold","iphone")
        ), "color", "silver");

        System.out.println(ans);

        ans = countItemsMatchingARule.countMatches(Arrays.asList(
                Arrays.asList("phone","blue","pixel"),
                Arrays.asList("computer","silver","phone"),
                Arrays.asList("phone","gold","iphone")
        ), "type", "phone");

        System.out.println(ans);
    }
}
