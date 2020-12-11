package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Created by geonyeong.kim on 2020-12-11
 */
public class QueueReconstructionByHeight {

    /*
    * 1. 앞에 있는 사람 수로 오름차순 정렬
    * 2. 앞에 있는 사람이 동일한 경우 오름차순 정렬
    * 3. LinkedList를 통해 자신이 위치할 수 있는 마지막 index를 찾아 insert 작업 -> linkedlist로 insert 작업 최소화 (하지만 마지막 index를 찾기 위해 list를 계속 반복해야하는 시간 복잡도 증가..)
    * */
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for(int[] i : people) {
            if(map.get(i[1]) == null) map.put(i[1], new ArrayList<>());
            map.get(i[1]).add(i[0]);
        }

        for(List<Integer> value: map.values()) {
            Collections.sort(value);
        }

        for(Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for(int value : entry.getValue()) {
                if(list.isEmpty()) {
                    list.add(new int[]{value, entry.getKey()});
                } else {
                    int cnt  = 0, idx = 0;
                    for(int i = 0 ; i < list.size(); i++) {
                        if(list.get(i)[0] >= value) cnt++;

                        if(cnt == entry.getKey()) {
                            idx = i;
                        }
                    }
                    list.add(idx + 1, new int[]{value, entry.getKey()});
                }
            }

        }
        return list.toArray(value -> new int[0][]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        int[][] res1 = queueReconstructionByHeight.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        printArr(res1);
        System.out.println();
        int[][] res2 = queueReconstructionByHeight.reconstructQueue(new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}});
        printArr(res2);
    }

    private static void printArr(int[][] res) {
        for (int[] re : res) {
            System.out.println("a -> " + re[0] + " b -> " + re[1]);
        }
    }
}
