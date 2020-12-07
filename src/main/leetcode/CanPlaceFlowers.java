package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-07
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length == 1 && flowerbed[0] == 0) return true;

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) continue;

            if(i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
                continue;
            }

            if(i == flowerbed.length -1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                n--;
                continue;
            }

            if(flowerbed[i] == 0 &&  i > 0 &&flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n > 0 ? false: true;
    }

    public static void main(String[] args) {
        boolean res1 = canPlaceFlowers(new int[]{1,0,0,0,1}, 1);
        System.out.println("res1 -> " + res1);
        boolean res2 = canPlaceFlowers(new int[]{1,0,0,0,1}, 2);
        System.out.println("res2 -> " + res2);
        boolean res3 = canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2);
        System.out.println("res3 -> " + res3);
    }
}
