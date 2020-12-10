package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-10
 */
public class NumberOfStepsToReduceANumberToZero {

    public int numberOfSteps (int num) {
        int result = 0;
        if(num == 0) return result;

        while(true) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            result++;
            if(num == 0) break;
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfStepsToReduceANumberToZero numberOfStepsToReduceANumberToZero = new NumberOfStepsToReduceANumberToZero();
        int res1 = numberOfStepsToReduceANumberToZero.numberOfSteps(14);
        System.out.println("res1 -> " + res1);

        int res2 = numberOfStepsToReduceANumberToZero.numberOfSteps(8);
        System.out.println("res2 -> " + res2);
    }
}
