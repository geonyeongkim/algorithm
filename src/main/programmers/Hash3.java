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

    /*
    * 내가 풀은 방식.
    * 각 layer(머리, 눈) 별로 갯수를 담고, 모든 부분집합(= 모든 경우의 수)을 구한 뒤 계산.
    * 답은 맞으나 테스트 케이스 중 하나가 시간초과 발생.
    * */
    public int mySsolution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        answer = 0;

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        cntList = new ArrayList<>(map.values());

        subset(new boolean[cntList.size()], 0, cntList.size());

        return answer - 1;
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for(int cnt : map.values()) {
            answer *= cnt + 1; // 각 layer 갯수 + 해당 layer를 선택하지 않는 경우 1
        }

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
