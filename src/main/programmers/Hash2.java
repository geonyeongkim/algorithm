package main.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by geonyeong.kim on 2020-12-14
 */
public class Hash2 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        for(int i = 0; i < phone_book.length - 1; i++) {
            int phone_length = phone_book[i].length();
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[i].equals(phone_book[j].substring(0, phone_length))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Hash2 hash2 = new Hash2();
        boolean ans1 = hash2.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println("ans1 -> " + ans1);

        boolean ans2 = hash2.solution(new String[]{"123", "456", "789"});
        System.out.println("ans2 -> " + ans2);

        boolean ans3 = hash2.solution(new String[]{"12", "123", "1235", "567", "88"});
        System.out.println("ans3 -> " + ans3);
    }
}
