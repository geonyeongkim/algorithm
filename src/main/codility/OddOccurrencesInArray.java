package main.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by geonyeong.kim on 2021-03-05
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        int answer = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }

        return answer;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int ans = oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println(ans);
    }
}
