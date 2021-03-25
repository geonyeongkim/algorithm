package main.coding_test.kakao_bank;

public class Test5 {

    enum Number {
        ZERO("0", 3),
        ONE("1", 2),
        TWO("2", 2),
        THREE("3", 4),
        FOUR("4", 3),
        FIVE("5", 3),
        SIX("6", 2),
        SEVEN("7", 4),
        EIGHT("8", 4),
        NINE("9", 3)
        ;

        private final String num;
        private final int len;

        Number(String num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    public String solution(String number) {
        StringBuilder answer = new StringBuilder();
        Number num = Number.ZERO;

        for (int i = 0; i < number.length(); i++) {
            switch (number.charAt(i)) {
                case 'z':
                    num = Number.ZERO;
                    break;
                case 'o':
                    num = Number.ONE;
                    break;
                case 't':
                    if (number.charAt(i + 1) == 'w') {
                        num = Number.TWO;
                    } else {
                        num = Number.THREE;
                    }
                    break;
                case 'f':
                    if (number.charAt(i + 1) == 'o') {
                        num = Number.FOUR;
                    } else {
                        num = Number.FIVE;
                    }
                    break;
                case 's':
                    if (number.charAt(i + 1) == 'i') {
                        num = Number.SIX;
                    } else {
                        num = Number.SEVEN;
                    }
                    break;
                case 'e':
                    num = Number.EIGHT;
                    break;
                case 'n':
                    num = Number.NINE;
                    break;
            }
            answer.append(num.num);
            i += num.len;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        String ans = test5.solution("onesevenfive");
        System.out.println(ans);

        ans = test5.solution("threetwo");
        System.out.println(ans);

        ans = test5.solution("fourthreenine");
        System.out.println(ans);

        ans = test5.solution("eight");
        System.out.println(ans);

        ans = test5.solution("fivetwoonetwo");
        System.out.println(ans);

        ans = test5.solution("zerosix");
        System.out.println(ans);
    }
}
