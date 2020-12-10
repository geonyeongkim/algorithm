package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-10
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    public int subtractProductAndSum(int n) {
        int sum = 0, multiple = 1;

        while(true) {
            int b = n % 10;
            n = n / 10;
            sum += b;
            multiple *= b;
            if(n == 0) break;
        }
        return multiple - sum;
    }

    public static void main(String[] args) {
        SubtractTheProductAndSumOfDigitsOfAnInteger subtractTheProductAndSumOfDigitsOfAnInteger = new SubtractTheProductAndSumOfDigitsOfAnInteger();
        int res1 = subtractTheProductAndSumOfDigitsOfAnInteger.subtractProductAndSum(234);
        System.out.println("res1 => " + res1);

        int res2 = subtractTheProductAndSumOfDigitsOfAnInteger.subtractProductAndSum(4421);
        System.out.println("res2 => " + res2);
    }
}
