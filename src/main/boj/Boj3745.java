package main.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj3745 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int days = sc.nextInt();
            int[] stock = new int[days];
            for (int i = 0; i < days; i++) {
                stock[i] = sc.nextInt();
            }

            List<Integer> lis = new ArrayList<>();
            lis.add(stock[0]);

            for (int i = 1; i < days; i++) {
                if(lis.get(lis.size() -1) < stock[i]) {
                    lis.add(stock[i]);
                } else {
                    lis.set(binarySearch(lis, stock[i]), stock[i]);
                }
            }

            System.out.println(lis.size());
        }
    }

    private static int binarySearch(List<Integer> lis, int target) {
        int left = 0;
        int right = lis.size();

        while(left < right) {
            int mid = (left+ right) / 2;
            if(lis.get(mid) >= target)
                right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
