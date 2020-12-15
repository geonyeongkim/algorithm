package main.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2020-12-15
 */
public class Hash3 {

    List<Integer> cntList;
    int answer;

    public void subset(boolean[] arr, int cur, int max) {
        if(cur == max) {
            int multiple = 1;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i]) {
                    multiple *= cntList.get(i);
                }
            }
            answer += multiple;
            return;
        }
        arr[cur] = false;
        subset(arr, cur +1, max);
        arr[cur] = true;
        subset(arr, cur +1, max);
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        answer = 0;

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        cntList = new ArrayList<>(map.values());

        /*
        * 모든 부분집합 구한 뒤, 각 집합의 숫자를 곱한 값을 answer에 더함.
        * */
        subset(new boolean[cntList.size()], 0, cntList.size());

        return answer - 1;
    }

    public static void main(String[] args) {
        Hash3 hash3 = new Hash3();

        int res1 = hash3.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println("res1 -> " + res1);

        int res2 = hash3.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}});
        System.out.println("res2 -> " + res2);
    }
}
