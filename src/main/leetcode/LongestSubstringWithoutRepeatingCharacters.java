package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by geonyeong.kim on 2021-02-24
 */
public class LongestSubstringWithoutRepeatingCharacters {


    // 내가 푼 풀이, brute force는 아니기에 통과는 했지만, 좀 더 좋게 시간복잡도가 나오는 방법 있음.
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        List<Integer> list = new ArrayList<>();

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if(i != 0) {
                set.remove(s.charAt(i-1));
                for(int j = i + set.size(); j < s.length(); j++) {
                    if(set.contains(s.charAt(j))) {
                        break;
                    } else {
                        set.add(s.charAt(j));
                    }
                }
            } else {
                for(int j = i; j < s.length(); j++) {
                    if(set.contains(s.charAt(j))) {
                        break;
                    } else {
                        set.add(s.charAt(j));
                    }
                }
            }
            list.add(i, set.size());
        }

        return Collections.max(list);
    }

    public int lengthOfLongestSubstringOptimize(String s) {
        int i = 0, j = 0, ans = 0;
        Set<Character> set = new HashSet<>();

        while(i < s.length() && j < s.length()) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                ans = Math.max(ans, i++ - j +1);
            } else {
                set.remove(s.charAt(j++));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int ans = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);

        ans = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb");
        System.out.println(ans);

        ans = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);

        ans = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("");
        System.out.println(ans);
    }
}
