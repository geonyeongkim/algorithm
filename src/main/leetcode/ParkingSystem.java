package main.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2020-12-10
 */
public class ParkingSystem {

    private Map<Integer, Integer> map;

    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<>();
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }

    public boolean addCar(int carType) {
        if(map.get(carType) > 0) {
            map.put(carType, map.get(carType) - 1);
            return true;
        } else {
            return false;
        }
    }
}
