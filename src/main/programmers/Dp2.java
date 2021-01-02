package main.programmers;

public class Dp2 {

    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(triangle[i+1][j] > triangle[i+1][j+1]) {
                    triangle[i][j] += triangle[i+1][j];
                } else {
                    triangle[i][j] += triangle[i+1][j+1];
                }
            }
        }
        return triangle[0][0];
    }

    public static void main(String[] args) {
        /*
         * [7]
         * [3, 8]
         * [8, 1, 0]
         * [2, 7, 4, 4]
         * [4, 5, 2, 6, 5]
         * */

        /*
         * [30]
         * [23, 21]
         * [20, 13, 10]
         * [7, 12, 10, 10]
         * [4, 5, 2, 6, 5]
         * */

        Dp2 dp2 = new Dp2();
        int ans1 = dp2.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println("ans1 => " + ans1);
    }
}
