package main.leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length -1;

        while(left < right) {
            answer = Math.max(answer, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int ans = containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(ans);

        ans = containerWithMostWater.maxArea(new int[]{1, 1});
        System.out.println(ans);

        ans = containerWithMostWater.maxArea(new int[]{4, 3, 2, 1, 4});
        System.out.println(ans);

        ans = containerWithMostWater.maxArea(new int[]{1, 2, 1});
        System.out.println(ans);
    }
}
