package main.programmers;

/**
 * Created by geonyeong.kim on 2020-12-21
 */
public class Sort3 {

    public int solution(int[] citations) {
        int answer = 0;

        int max = 0;
        for (int i : citations) {
            max = Math.max(max, i);
        }

        for (int i = max; i >= 0; i--) {
            int cnt = 0;
            for(int j = 0; j< citations.length; j++){
                if(citations[j] >= i) {
                    cnt++;
                }
            }
            if(cnt >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Sort3 sort3 = new Sort3();
        int ans1 = sort3.solution(new int[]{3, 0, 6, 1, 5});
        System.out.println("ans1 -> " + ans1);
    }
}
