package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-03-12
 */
public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int minLength = Math.min(word1.length(), word2.length());
        String maxStr = minLength == word1.length()? word2 : word1;

        for(int i = 0; i < minLength; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        for(int i = minLength; i < maxStr.length(); i++) {
            sb.append(maxStr.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        String ans = mergeStringsAlternately.mergeAlternately("abc", "pqr");
        System.out.println(ans);

        ans = mergeStringsAlternately.mergeAlternately("ab", "pqrs");
        System.out.println(ans);

        ans = mergeStringsAlternately.mergeAlternately("abcd", "pq");
        System.out.println(ans);
    }
}
