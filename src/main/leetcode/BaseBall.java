package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-01-20
 */
public class BaseBall {

    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();

        for (String op : ops) {

            try {
                int opNum = Integer.parseInt(op);
                list.add(opNum);
            } catch (NumberFormatException e) {
                if ("+".equals(op)) {
                    list.add(list.get(list.size() -1) + list.get(list.size() -2));
                } else if ("D".equals(op)) {
                    list.add(list.get(list.size() -1) * 2);
                } else {
                    list.remove(list.size()-1);
                }
            }

        }

        int answer = 0;
        for (Integer score : list) {
            answer += score;
        }
        return answer;
    }

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        int ans1 = baseBall.calPoints(new String[]{"5","2","C","D","+"});
        System.out.println("ans1 => " + ans1);

        int ans2 = baseBall.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        System.out.println("ans2 => " + ans2);

        int ans3 = baseBall.calPoints(new String[]{"1"});
        System.out.println("ans3 => " + ans3);

    }
}
