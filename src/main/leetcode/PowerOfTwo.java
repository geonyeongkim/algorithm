package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-12
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        while (n > 0) {
            if (n == 1 || n == 2)
                return true;
            else if (n % 2 == 1)
                return false;
            n /= 2;
        }
        return false;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        boolean ans = powerOfTwo.isPowerOfTwo(1);
        System.out.println(ans);

        ans = powerOfTwo.isPowerOfTwo(16);
        System.out.println(ans);

        ans = powerOfTwo.isPowerOfTwo(3);
        System.out.println(ans);

        ans = powerOfTwo.isPowerOfTwo(4);
        System.out.println(ans);

        ans = powerOfTwo.isPowerOfTwo(5);
        System.out.println(ans);
    }
}
