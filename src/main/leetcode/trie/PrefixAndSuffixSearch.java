package main.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/*
* trie 문제.
* suffix 로 가능한 문자부터 trie node를 생성해 나간다. => 핵심
*
* word 중 동일하게 문제의 prefix, suffix 조건이 맞는경우 뒤에 주어진 생성 인자 index를 반환해야하기 때문에 weight 값을 가지도록 함.
*
* prefix와 suffix의 구분이 필요하므로 중간에 # 을 둠
* */
public class PrefixAndSuffixSearch {

    public static class WordFilter {

        private Trie trie;

        public WordFilter(String[] words) {
            trie = new Trie();

            for(int weight = 0; weight < words.length; weight++) {
                String word = words[weight] + "#";

                for(int i = 0; i < word.length(); i++) {
                    Trie cur = trie;
                    cur.weight = weight;

                    for(int j = i; j < (word.length() * 2) - 1; j++) {
                        char c = word.charAt(j % word.length());

                        if(cur.childrens.get(c) == null) {
                            cur.childrens.put(c, new Trie());
                        }
                        cur = cur.childrens.get(c);
                        cur.weight = weight;
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {

            Trie cur = trie;
            for(char c : (suffix + "#" + prefix).toCharArray()) {
                if(cur.childrens.get(c) == null) return -1;
                else cur = cur.childrens.get(c);
            }

            return cur.weight;
        }

        private class Trie {
            private int weight;
            private Map<Character, Trie> childrens;

            public Trie() {
                this.childrens = new HashMap<>();
            }

            @Override
            public String toString() {
                return "Trie{" +
                        "weight=" + weight +
                        ", childrens=" + childrens +
                        '}';
            }
        }
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"bccbacbcba"});
        int ans = wordFilter.f("bccbacbcba", "a");
        System.out.println(ans);
    }
}