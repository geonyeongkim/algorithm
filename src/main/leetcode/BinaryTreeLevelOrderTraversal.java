package main.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2021-02-04
 */
public class BinaryTreeLevelOrderTraversal {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        Map<Integer , List<Integer>> map = new LinkedHashMap<>();
        dfs(map, 0, root);

        for (int i = 0; i < map.entrySet().size(); i++) {
            answer.add(new ArrayList<>());
            answer.get(i).addAll(map.get(i));
        }
        return answer;
    }

    private void dfs(Map<Integer , List<Integer>> map, int depth, TreeNode root) {
        if (root != null) {
            if(map.get(depth) == null) {
                map.put(depth, new ArrayList<>());
            }
            map.get(depth).add(root.val);

            dfs(map, depth + 1, root.left);
            dfs(map, depth + 1, root.right);
        }
    }


    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> ans = binaryTreeLevelOrderTraversal.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        System.out.println("ans = " + ans);

    }
}
