package main.programmers;

/**
 * Created by geonyeong.kim on 2020-12-30
 */
public class DfsBfs1 {

    int ans = 0;

    public void subset(boolean[] arr, int cur, int max, int[] numbers, int target) {
        if(cur == max) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }

            if(sum == target) ans++;

            return;
        }
        arr[cur] = false;
        subset(arr, cur +1, max, numbers, target);
        arr[cur] = true;
        subset(arr, cur +1, max, numbers, target);
    }

    public int solution(int[] numbers, int target) {
        subset(new boolean[numbers.length], 0, numbers.length, numbers, target);
        return ans;
    }

    public static void main(String[] args) {
        DfsBfs1 dfsBfs1 = new DfsBfs1();
        dfsBfs1.solution(new int[]{1,1,1,1,1}, 3);

    }

}
