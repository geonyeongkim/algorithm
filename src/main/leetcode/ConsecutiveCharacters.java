package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-02
 */
public class ConsecutiveCharacters {

    /*
    * 처음엔 string 비교를 하였으나, char 비교로 변경
    * */
    public static int maxPower(String s) {

        int res = 1, cnt = 1;

        char before = s.charAt(0);

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != before) {
                before = s.charAt(i);
                res = Math.max(cnt, res);
                cnt = 0;
            }
            cnt++;
        }

        return Math.max(cnt, res);
    }

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
    }
}
