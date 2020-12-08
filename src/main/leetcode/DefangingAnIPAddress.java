package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-08
 */
public class DefangingAnIPAddress {

    public static String defangIPaddr(String address) {
        char[] charArrs = new char[address.length() + 6];

        int charIdx = 0;

        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                charArrs[charIdx++] = '[';
                charArrs[charIdx++] = address.charAt(i);
                charArrs[charIdx++] = ']';
            } else {
                charArrs[charIdx++] = address.charAt(i);
            }
        }

        return new String(charArrs);
    }

    public static void main(String[] args) {
        String res1 = defangIPaddr("1.1.1.1");
        System.out.println("res1 -> " + res1);
        String res2 = defangIPaddr("255.100.50.0");
        System.out.println("res2 -> " + res2);
    }
}
