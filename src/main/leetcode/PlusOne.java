package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-01-07
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }
            if (i == 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
                return digits;
            }
            digits[i] = (digits[i] + 1) % 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] ans1 = plusOne.plusOne(new int[]{1, 2, 3});
        for (int i : ans1) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] ans2 = plusOne.plusOne(new int[]{4, 3, 2, 1});
        for (int i : ans2) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] ans3 = plusOne.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        for (int i : ans3) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] ans4 = plusOne.plusOne(new int[]{0, 0});
        for (int i : ans4) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int[] ans5 = plusOne.plusOne(new int[]{9, 9});
        for (int i : ans5) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
