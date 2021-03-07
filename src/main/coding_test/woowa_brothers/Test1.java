package main.coding_test.woowa_brothers;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    private static final Map<Character, Integer> CARD_HIERACHY = new HashMap(){{
        put('A', 13);
        put('K', 12);
        put('Q', 11);
        put('J', 10);
        put('T', 9);
        put('9', 8);
        put('8', 7);
        put('7', 6);
        put('6', 5);
        put('5', 4);
        put('4', 3);
        put('3', 2);
        put('2', 1);
    }};

    public int solution(String A, String B) {
        int answer = 0;
        for(int i = 0; i < A.length(); i++) {
            if(CARD_HIERACHY.get(A.charAt(i)) > CARD_HIERACHY.get(B.charAt(i))) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int ans = test1.solution("A586QK", "JJ653K");
        System.out.println(ans);
    }
}
