package main.leetcode;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> dp = new HashMap<>();

        Map<String, List<String>> connect = new HashMap<>();
        connect.put(beginWord, new ArrayList<>());

        Map<String, Boolean> visit = new HashMap<>();


        for (int i = 0; i < wordList.size(); i++) {
            dp.put(wordList.get(i), Integer.MAX_VALUE);
            visit.put(wordList.get(i), false);
            if (check(beginWord, wordList.get(i))) {
                connect.get(beginWord).add(wordList.get(i));
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            connect.put(wordList.get(i), new ArrayList<>());
            for (int j = 0; j < wordList.size(); j++) {
                if (check(wordList.get(i), wordList.get(j))) {
                    connect.get(wordList.get(i)).add(wordList.get(j));
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visit.put(beginWord, true);
        dp.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();

            for (String node : connect.get(word)) {
                if (!visit.get(node)) {
                    visit.put(node, true);
                    dp.put(node, Math.min(dp.get(node), dp.get(word) + 1));
                    queue.add(node);
                }
            }
        }

        int answer = (dp.get(endWord) == null || dp.get(endWord) == Integer.MAX_VALUE) ? 0 : dp.get(endWord);

        return answer;
    }

    private boolean check(String str1, String str2) {
        int cnt = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        int ans = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ans);

        ans = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(ans);

        ans = wordLadder.ladderLength("hot", "dog", Arrays.asList("hot", "dog"));
        System.out.println(ans);
    }
}
