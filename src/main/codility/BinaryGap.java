package main.codility;

/**
 * Created by geonyeong.kim on 2021-03-05
 */
public class BinaryGap {

    public int solution(int N) {
        int answer = 0;
        String binary = Integer.toBinaryString(N);

        int tmp = 0;

        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                answer = Math.max(tmp, answer);
                tmp = 0;
            } else {
                tmp++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BinaryGap iterationsLesson = new BinaryGap();
        int ans = iterationsLesson.solution(1041);
        System.out.println(ans);

        ans = iterationsLesson.solution(15);
        System.out.println(ans);

        ans = iterationsLesson.solution(32);
        System.out.println(ans);
    }
}
