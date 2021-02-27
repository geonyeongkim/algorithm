package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-27
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            if((n & 1) > 0) ans++;
            n >>= 1;
        }
        return ans;
    }
}
