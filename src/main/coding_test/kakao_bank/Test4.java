package main.coding_test.kakao_bank;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

    public int solution(int[] arr) {
        if (arr.length == 1 && arr[0] == 1) return 0;

        int answer = 0;

        List<Integer> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        for (int i : arr) {
            tmp.add(i);
        }

        while (tmp.size() != 1 || tmp.get(0) != 1) {
            int checkInt = tmp.get(0);
            int cnt = 1;
            for (int i = 1; i < tmp.size(); i++) {
                if(checkInt == tmp.get(i)) {
                    cnt++;
                } else {
                    list.add(cnt);
                    checkInt = tmp.get(i);
                    cnt = 1;
                }
            }
            list.add(cnt);

            answer++;

            tmp = list;
            list = new ArrayList<>();
        }
        return answer;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int ans = test4.solution(new int[]{1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3});
        System.out.println(ans);

        ans = test4.solution(new int[]{1, 2, 3});
        System.out.println(ans);

        ans = test4.solution(new int[]{2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 2});
        System.out.println(ans);

        ans = test4.solution(new int[]{2});
        System.out.println(ans);

        ans = test4.solution(new int[]{2, 2, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8});
        System.out.println(ans);

        ans = test4.solution(new int[]{1});
        System.out.println(ans);
    }
}
