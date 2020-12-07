package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2020-12-07
 */
public class PartitionLabels {

    /*
    * 문제 풀이 참고함.
    * 해당 문제는 각 char의 마지막 index를 저장한 후, for문을 돌면서 현재 index와 char 마지막 index가 같으면 partial 으로 판단.
    * */
    public static List<Integer> partitionLabels(String S) {
        // 알파벳은 총 26개.
        int[] last = new int[26];
        // 각 알파벳별로 last index를 저장 ( charAt(i) - 'a' ) 로 map 처럼 사용하는 부분 알아두면 유용하다고 판단.
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            // for-loop 의 index와 last index가 같은경우 partial로 판단
            // 이유는 for문을 돌면서 마주친 알파벳들의 가장 last이기 때문!!! -> Math.max 로 인해서 성립함.
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
}
