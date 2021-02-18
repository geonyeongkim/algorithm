package main.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by geonyeong.kim on 2021-02-18
 */
public class BinaryTreeZigzagLevelOrderTraversal {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() { }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static List<List<Integer>> answer;
    static Stack<TreeNode> stack;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        answer = new ArrayList<>();
        stack = new Stack<>();

        stack.add(root);
        int level = 0;

        while(!stack.isEmpty()) {
            int n = stack.size();
            List<TreeNode> list = new ArrayList<>();
            while(n-- != 0) {
                TreeNode node = stack.pop();
                if(node != null) list.add(node);
            }
            if(list.size() == 0) break;
            if(answer.size() == level ) {
                answer.add(new ArrayList<>());
            }

            for (TreeNode node : list) {

                answer.get(level).add(node.val);

                if(level % 2 == 1) {
                    stack.add(node.right);
                    stack.add(node.left);
                } else {
                    stack.add(node.left);
                    stack.add(node.right);
                }
            }

            level++;
        }

        return answer;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> ans = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        System.out.println(ans);
    }
}
