package main.boj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-02-01
 */
public class Boj4195 {
    
    private static int[] parent;
    private static int[] count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int relationCount = sc.nextInt();
            
            parent = new int[relationCount * 2];
            count = new int[relationCount * 2];

            for(int j = 0; j < relationCount * 2; j++) {
                parent[j] = j;
            }

            Arrays.fill(count, 1);

            Map<String, Integer> relation = new HashMap<>();

            int idx = 0;
            for(int j = 0; j < relationCount; j++) {
                String friend1 = sc.next();
                String friend2 = sc.next();
                
                if(relation.get(friend1) == null) {
                    relation.put(friend1, idx++);
                }
                if(relation.get(friend2) == null) {
                    relation.put(friend2, idx++);
                }
                System.out.println(union(relation.get(friend1), relation.get(friend2)));
            }
        }
    }

    private static int find(int friend) {
        if(friend == parent[friend]) {
            return friend;
        } else {
            return parent[friend] = find(parent[friend]);
        }
    }
    
    private static int union(int friend1, int friend2) {
        friend1 = find(friend1);
        friend2 = find(friend2);

        if(friend1 != friend2) {
            if(friend1 < friend2) {
                parent[friend2] = friend1;
                count[friend1] += count[friend2];
                return count[friend1];
            } else {
                parent[friend1] = friend2;
                count[friend2] += count[friend1];
                return count[friend2];
            }
        }
        return count[friend1];
    }
}
