package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-07
 */
public class WaterBottles {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while(true) {
            int a = numBottles/numExchange;
            int b = numBottles % numExchange;
            if(a == 0) break;

            result += a;
            numBottles = a + b;
        }

        return result;
    }


    public static void main(String[] args) {
        int res1 =  numWaterBottles(9, 3);
        System.out.println("res1 -> " + res1);
        int res2 =  numWaterBottles(15, 4);
        System.out.println("res2 -> " + res2);
    }
}
