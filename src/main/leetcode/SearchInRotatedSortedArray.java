package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-03-04
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int answer = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) return i;
        }

        return answer;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int ans = searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(ans);

        ans = searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 3);
        System.out.println(ans);

        ans = searchInRotatedSortedArray.search(new int[]{1}, 0);
        System.out.println(ans);
    }
}
