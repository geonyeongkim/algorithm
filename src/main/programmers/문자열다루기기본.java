package main.programmers;

public class 문자열다루기기본 {

    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6){
            for (int i = 0; i < s.length(); i++) {
                int ascii = (int) s.charAt(i);
                if(ascii < 48 || ascii > 57) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        문자열다루기기본 c = new 문자열다루기기본();
        boolean ans1 = c.solution("a234");
        System.out.println("ans1 -> " + ans1);
        boolean ans2 = c.solution("1234");
        System.out.println("ans2 -> " + ans2);
    }
}
