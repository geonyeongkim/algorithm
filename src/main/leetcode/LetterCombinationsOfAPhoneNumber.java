package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2021-02-10
 */
public class LetterCombinationsOfAPhoneNumber {

    static Map<String, List<String>> map = new HashMap<>(){{
        put("2", Arrays.asList("a", "b", "c"));
        put("3", Arrays.asList("d", "e", "f"));
        put("4", Arrays.asList("g", "h", "i"));
        put("5", Arrays.asList("j", "k", "l"));
        put("6", Arrays.asList("m", "n", "o"));
        put("7", Arrays.asList("p", "q", "r", "s"));
        put("8", Arrays.asList("t", "u", "v"));
        put("9", Arrays.asList("w", "x", "y", "z"));

    }};
    static List<String> answer;
    static int size;
    static String[] arr;

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();

        answer = new ArrayList<>();
        arr = digits.split("");
        size = arr.length;
        for (String s : map.get(arr[0])) {
            dfs(1, s);
        }
        return answer;
    }

    private void dfs(int next, String s) {
        if (s.length() == size) {
            answer.add(s);
            return;
        }

        for (String s1 : map.get(arr[next])) {
            dfs(next + 1, s + s1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> ans = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        System.out.println(ans);

        ans = letterCombinationsOfAPhoneNumber.letterCombinations("");
        System.out.println(ans);
//
        ans = letterCombinationsOfAPhoneNumber.letterCombinations("2");
        System.out.println(ans);
    }
}
