package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-03-13
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        double a = Math.sqrt(num);
        int b = (int) Math.sqrt(num);
        return a == b;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        boolean ans = validPerfectSquare.isPerfectSquare(16);
        System.out.println(ans);

        ans = validPerfectSquare.isPerfectSquare(14);
        System.out.println(ans);
    }
}
