package main.hackerrank;

/**
 * Created by geonyeong.kim on 2021-03-04
 */
public class SamAndSubstrings {

    private static final int MOD = 1000000007;

    static int substrings(String n) {
        int len = n.length();
        long answer = 0;
        long f = 1;
        for(int i = len - 1; i >= 0; i--) {
            answer = (answer + (n.charAt(i) - '0') * f * (i + 1)) % MOD;
            f = (f * 10 + 1) % MOD;
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        int ans = SamAndSubstrings.substrings("16");
        System.out.println(ans);

        ans = SamAndSubstrings.substrings("123");
        System.out.println(ans);

        ans = SamAndSubstrings.substrings("972698438521");
        System.out.println(ans);
    }
}
