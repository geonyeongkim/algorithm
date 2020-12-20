package main.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2020-12-20
 */
public class Sort2 {

    public String solution(int[] numbers) {
        Integer[] arr = new Integer[numbers.length];
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            String strNum = String.valueOf(numbers[i]);
            while(strNum.length() < 5) {
                strNum += strNum;
            }
            int subInt = Integer.valueOf(strNum.substring(0, 5));
            arr[i] = subInt;
            map.put(subInt, String.valueOf(numbers[i]));
        }

        Arrays.sort(arr, (o1, o2) -> o2-o1);


        StringBuilder sb = new StringBuilder();
        for(int item : arr) {
            sb.append(map.get(item));
        }

        if(sb.charAt(0) == '0') return "0";

        return sb.toString();
    }

    public static void main(String[] args) {
        Sort2 sort2 = new Sort2();
        String ans1 = sort2.solution(new int[]{6, 10, 2});
        System.out.println("ans1 = > " + ans1);

        String ans2 = sort2.solution(new int[]{3, 30, 34, 5, 9});
        System.out.println("ans2 = > " + ans2);

        String ans3 = sort2.solution(new int[]{40, 403});
        System.out.println("ans3 = > " + ans3);

        String ans4 = sort2.solution(new int[]{0,0,0,0,0,0});
        System.out.println("ans4 = > " + ans4);

        String ans5 = sort2.solution(new int[]{2,20,200});
        System.out.println("ans5 = > " + ans5);


    }
}
