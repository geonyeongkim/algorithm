package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-03-14
 */
public class DetectPatternOfLengthMRepeatedKOrMoreTimes {

    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;
        for(int i = 0; i < arr.length - m; i++) {
            if(arr[i] == arr[i + m]) count++;
            else count = 0;
            if((count + m)/m >= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectPatternOfLengthMRepeatedKOrMoreTimes detectPatternOfLengthMRepeatedKOrMoreTimes = new DetectPatternOfLengthMRepeatedKOrMoreTimes();
        boolean ans = detectPatternOfLengthMRepeatedKOrMoreTimes.containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3);
        System.out.println(ans);

        ans = detectPatternOfLengthMRepeatedKOrMoreTimes.containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2);
        System.out.println(ans);

        ans = detectPatternOfLengthMRepeatedKOrMoreTimes.containsPattern(new int[]{1, 2, 1, 2, 1, 3}, 2, 3);
        System.out.println(ans);

        ans = detectPatternOfLengthMRepeatedKOrMoreTimes.containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2);
        System.out.println(ans);

        ans = detectPatternOfLengthMRepeatedKOrMoreTimes.containsPattern(new int[]{2, 2, 2, 2}, 2, 3);
        System.out.println(ans);
    }
}
