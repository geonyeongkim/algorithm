package main.programmers;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by geonyeong.kim on 2020-12-23
 */
public class Greedy1 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        boolean[] arr = new boolean[n];
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();

        for (int i : reserve) {
            reserveSet.add(i);
        }

        for(int i : lost) {
            lostSet.add(i);
        }

        Set<Integer> intersection = new HashSet<>();

        for (Integer item : reserveSet) {
            if(lostSet.contains(item)) {
                intersection.add(item);
            }
        }

        reserveSet.removeAll(intersection);
        lostSet.removeAll(intersection);


        for (int i = 0; i < n; i++) {
            arr[i] = true;
        }

        for (int i : lostSet) {
            arr[i - 1] = false;
        }

        for (int i : reserveSet) {
            int idx = i -1;

            if(idx -1 >= 0 && arr[idx-1] == false) {
                arr[idx -1] = true;
            } else if(idx + 1 < arr.length && arr[idx + 1] == false) {
                arr[idx + 1] = true;
                continue;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Greedy1 greedy1 = new Greedy1();
//        int ans1 = greedy1.solution(5, new int[]{2, 4}, new int[]{1, 4});
//        System.out.println("ans1 -> " + ans1);
        int ans1 = greedy1.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        System.out.println("ans1 -> " + ans1);

        int ans2 = greedy1.solution(5, new int[]{2, 4}, new int[]{3});
        System.out.println("ans2 -> " + ans2);

        int ans3 = greedy1.solution(3, new int[]{3}, new int[]{1});
        System.out.println("ans3 -> " + ans3);
    }
}
