package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-11
 */
public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;

        for (int i = 0; i <= points.length - 2; i++) {
            res += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints minimumTimeVisitingAllPoints = new MinimumTimeVisitingAllPoints();

        int res1 = minimumTimeVisitingAllPoints.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}});
        System.out.println("res1 => " + res1);

        int res2 = minimumTimeVisitingAllPoints.minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}});
        System.out.println("res2 => " + res2);
    }
}
