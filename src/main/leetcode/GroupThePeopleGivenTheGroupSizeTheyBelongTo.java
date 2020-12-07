package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2020-12-07
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> storeMap = new HashMap<>();


        for(int i = 0 ; i < groupSizes.length; i++) {
            if(storeMap.get(groupSizes[i]) == null) {
                storeMap.put(groupSizes[i], new ArrayList<>());
            }
            storeMap.get(groupSizes[i]).add(i);
        }

        for(int key : storeMap.keySet()) {
            int a = storeMap.get(key).size() / key;

            for(int i = 0; i < a; i++) {
                List<Integer> tmpList = new ArrayList<>();
                for(int j = i * key; j < (i+1) * key; j++) {
                    tmpList.add(storeMap.get(key).get(j));
                }
                res.add(tmpList);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res1 = groupThePeople(new int[]{3,3,3,3,3,1,3});
        System.out.println("res1 -> " + res1);

        List<List<Integer>> res2 = groupThePeople(new int[]{2,1,3,3,3,2});
        System.out.println("res2 -> " + res2);
    }
}
