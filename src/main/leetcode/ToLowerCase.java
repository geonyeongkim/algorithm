package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-01-28
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        ToLowerCase toLowerCase = new ToLowerCase();
        String ans1 = toLowerCase.toLowerCase("Hello");
        System.out.println("ans1 = " + ans1);

        String ans2 = toLowerCase.toLowerCase("here");
        System.out.println("ans2 = " + ans2);

        String ans3 = toLowerCase.toLowerCase("LOVELY");
        System.out.println("ans3 = " + ans3);
    }
}
