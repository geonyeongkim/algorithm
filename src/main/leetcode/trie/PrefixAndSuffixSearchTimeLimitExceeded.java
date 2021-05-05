package main.leetcode.trie;

import java.util.*;

public class PrefixAndSuffixSearchTimeLimitExceeded {

    // Time Limit Exceeded
    static class WordFilter {

        private static final int PREFIX_VAL = 1;
        private static final int SUFFIX_VAL = 2;

        private List<Map<Integer, Set<String>>> wordDict;

        public WordFilter(String[] words) {
            wordDict = new ArrayList<>();

            StringBuilder prefixSb = new StringBuilder();
            StringBuilder suffixSb = new StringBuilder();

            for (String word : words) {
                Map<Integer, Set<String>> map = new HashMap<>();
                map.put(PREFIX_VAL, new HashSet<>());
                map.put(SUFFIX_VAL, new HashSet<>());

                for (int i = 0; i < word.length(); i++) {
                    prefixSb.append(word.charAt(i));
                    suffixSb.insert(0, word.charAt(word.length() - 1 - i));
                    map.get(PREFIX_VAL).add(prefixSb.toString());
                    map.get(SUFFIX_VAL).add(suffixSb.toString());
                }
                wordDict.add(map);
                prefixSb.setLength(0);
                suffixSb.setLength(0);
            }
        }

        public int f(String prefix, String suffix) {
            for (int i = wordDict.size() - 1; i >= 0; i--) {
                if (wordDict.get(i).get(PREFIX_VAL).contains(prefix) && wordDict.get(i).get(SUFFIX_VAL).contains(suffix))
                    return i;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        int ans = wordFilter.f("a", "e");
        System.out.println(ans);

        wordFilter = new WordFilter(new String[]{"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"});
        ans = wordFilter.f("bccbacbcba","a");
        System.out.println(ans);
    }
}
