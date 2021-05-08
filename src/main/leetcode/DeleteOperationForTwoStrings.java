package main.leetcode;

public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {

        int leftIdx = 0, rightIdx = 0, maxLen = 0;

        // left shift
        while(leftIdx < word1.length() && rightIdx < word2.length()) {

            if(word1.charAt(leftIdx) == word2.charAt(rightIdx)) {
                maxLen = Math.max(maxLen, searchSameLength(word1, leftIdx, word2, rightIdx));
            }
            leftIdx++;
        }

        leftIdx = 0;
        rightIdx = 0;

        // right shift
        while(leftIdx < word1.length() && rightIdx < word2.length()) {

            if(word1.charAt(leftIdx) == word2.charAt(rightIdx)) {
                maxLen = Math.max(maxLen, searchSameLength(word1, leftIdx, word2, rightIdx));
            }
            rightIdx++;
        }

        return (word1.length() - maxLen) + (word2.length() - maxLen);
    }

    private int searchSameLength(String leftWord, int leftIdx, String rightWord, int rightIdx) {
        int len = 0;

        while(leftIdx < leftWord.length() && rightIdx < rightWord.length()) {
            if(leftWord.charAt(leftIdx++) == rightWord.charAt(rightIdx++)) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
        int ans = deleteOperationForTwoStrings.minDistance("sea", "eat");
        System.out.println(ans);

        ans = deleteOperationForTwoStrings.minDistance("leetcode", "etco");
        System.out.println(ans);
    }
}
