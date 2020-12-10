package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-10
 */
public class ShuffleString {

    public String restoreString(String s, int[] indices) {

        char[] chars = new char[indices.length];

        for (int i = 0; i < s.length(); i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ShuffleString shuffleString = new ShuffleString();
        String res1 = shuffleString.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3});
        System.out.println("res1 -> " + res1);
    }
}
