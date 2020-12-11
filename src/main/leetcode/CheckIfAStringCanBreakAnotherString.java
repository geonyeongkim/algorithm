package main.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by geonyeong.kim on 2020-12-11
 */
public class CheckIfAStringCanBreakAnotherString {

    public boolean checkIfCanBreak(String s1, String s2) {
        Integer[] a = new Integer[s1.length()];
        Integer[] b = new Integer[s1.length()];


        for(int i = 0 ;i < s1.length(); i++) {
            a[i] = s1.charAt(i) - 0;
            b[i] = s2.charAt(i) - 0;
        }

        Arrays.sort(a, Comparator.reverseOrder());
        Arrays.sort(b, Comparator.reverseOrder());

        for(int i = 0 ;i < b.length; i++) {
            if(b[i] < a[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfAStringCanBreakAnotherString checkIfAStringCanBreakAnotherString = new CheckIfAStringCanBreakAnotherString();
        boolean res1 = checkIfAStringCanBreakAnotherString.checkIfCanBreak("abc", "xya");
        System.out.println("res1 -> " + res1);

        boolean res2 = checkIfAStringCanBreakAnotherString.checkIfCanBreak("abe", "acd");
        System.out.println("res2 -> " + res2);

        boolean res3 = checkIfAStringCanBreakAnotherString.checkIfCanBreak("leetcodee", "interview");
        System.out.println("res3 -> " + res3);

    }
}
