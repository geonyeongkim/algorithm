package main.coding_test.woowa_brothers;

public class Test2 {

    String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = 2;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                return Character.toString((char) ((int) 'a' + i));
            }
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String ans = test2.solution("hello");
        System.out.println(ans);

        ans = test2.solution("ccdd");
        System.out.println(ans);

        ans = test2.solution("bbaa");
        System.out.println(ans);

        ans = test2.solution("ccbbaa");
        System.out.println(ans);
    }
}
