package main.hackerrank;

import java.util.*;

public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < d; i++) {
            map.put(expenditure[i], map.getOrDefault(expenditure[i], 0) + 1);
        }

        int answer = 0;

        for(int i = d; i < expenditure.length; i++) {
            if(d % 2 == 1) {
                // 홀수인 경우
                int idx = -1;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    idx += entry.getValue();
                    if(idx >= d/2) {
                        if((2 * entry.getKey()) <= expenditure[i]) answer++;
                        break;
                    }
                }
            } else {
                int idx1 = d/2, idx2 = (d/2 - 1);
                int sum = 0;
                int idx = 0;
                boolean flag = false;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    for(int j = 0; j < entry.getValue(); j++) {
                        if(idx == idx2) {
                            sum +=entry.getKey();
                        }
                        if(idx == idx1) {
                            sum +=entry.getKey();
                            flag = true;
                            break;
                        }
                        idx++;
                    }
                    if(flag) break;
                }

                double mid = (sum / (double) 2);
                if((2 * mid) <= expenditure[i]) answer++;
            }

            map.put(expenditure[i - d], map.get(expenditure[i - d]) - 1);
            map.put(expenditure[i], map.getOrDefault(expenditure[i], 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int ans = FraudulentActivityNotifications.activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5);
        System.out.println(ans);
        ans = FraudulentActivityNotifications.activityNotifications(new int[]{1, 2, 3, 4, 4}, 4);
        System.out.println(ans);
    }
}
