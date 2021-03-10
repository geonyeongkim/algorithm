package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-03-10
 */
public class LeetCode_3Sum {

    // 1. 풀이법 -> 시간 효율성이 좋지 않음.
    // 이상하게 Arrays.asList() 를 사용하면 TLE 발생. 내부적으로 더 느리나봄
    public List<List<Integer>> threeSumWorst(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!answer.contains(list)) answer.add(list);
                    right--;
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return answer;
    }


    /*
    * 2.
    * 정렬을 통해 같은 값이 연달아 나오는 경우가 있음.
    * 때문에, sum == 0 인 경우 left, right를 각각 같은 값이라면 가능 마지막(right라면 가장 앞)으로 땡겨줌
    *
    * 장점1: 땡겨주기 때문에, 중복 체크 로직 제거 가능.
    * 장점2: 가장 처음 for 문의 경우에도 같은 시작값이라면 pass 가능
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    answer.add(list);
                    right--;
                    left++;

                    while(right > -1 && nums[right] == nums[right + 1]) {
                        right--;
                    }

                    while(left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        LeetCode_3Sum leetCode_3Sum = new LeetCode_3Sum();
        List<List<Integer>> ans = leetCode_3Sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ans);

        ans = leetCode_3Sum.threeSum(new int[]{});
        System.out.println(ans);

        ans = leetCode_3Sum.threeSum(new int[]{0});
        System.out.println(ans);

        ans = leetCode_3Sum.threeSum(new int[]{1, 2, -2, -1});
        System.out.println(ans);

        ans = leetCode_3Sum.threeSum(new int[]{1, -1, -1, 0});
        System.out.println(ans);

        ans = leetCode_3Sum.threeSum(new int[]{3, 0, -2, -1, 1, 2});
        System.out.println(ans);
    }
}
