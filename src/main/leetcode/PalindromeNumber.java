package main.leetcode;

public class PalindromeNumber {

    // 내가 푼 풀이
    public static boolean isPalindrome(int x) {
        String[] arr = String.valueOf(x).split("");
        int size = arr.length;

        for (int i = 0; i< size / 2; i++) {
            if(!arr[i].equals(arr[size-1-i])) return false;
        }
        return true;
    }

    // 10 씩 나누면서 reverse number 를 구함.
    public static boolean isPalindrome2(int x) {
        // 일단 음수 혹은 0이 아닌 10진수면 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverseNumber = 0;
        while(x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            // 자릿수를 뒤에서부터 제거.
            x = x/10;
        }

        return x == reverseNumber || x == reverseNumber/10;
    }

    public static void main(String[] args) {
        System.out.println(String.format("res -> %s", isPalindrome2(121)));
        System.out.println(String.format("res -> %s", isPalindrome2(-121)));
        System.out.println(String.format("res -> %s", isPalindrome2(10)));
        System.out.println(String.format("res -> %s", isPalindrome2(0)));
    }
}
