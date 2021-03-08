package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-03-08
 */
public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int answer = 0;

        int sum = 0;

        for (int i : gain) {
            sum += i;
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        FindTheHighestAltitude findTheHighestAltitude = new FindTheHighestAltitude();
        int ans = findTheHighestAltitude.largestAltitude(new int[]{-5,1,5,0,-7});
        System.out.println(ans);

        ans = findTheHighestAltitude.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2});
        System.out.println(ans);
    }
}
