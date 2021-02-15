package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2021-02-15
 */
public class LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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

    private static Map<Integer, Integer> parent;
    private static List<Integer> pList;
    private static List<Integer> qList;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent = new HashMap<>();

        if(root.left != null) {
            dfs(root.left, root.val);
        }

        if(root.right != null) {
            dfs(root.right, root.val);
        }

        pList = new ArrayList<>();
        qList = new ArrayList<>();


        getParent(p.val, 1);
        getParent(q.val, 2);

        int answer = 0;

        for (int val : pList) {
            if(qList.contains(val)) {
                answer = val;
                break;
            }
        }

        return new TreeNode(answer);
    }

    private void getParent(int val, int flagNum) {
        if(flagNum == 1) {
            pList.add(val);
        } else {
            qList.add(val);
        }

        if(parent.get(val) == null) {
            return;
        }
        getParent(parent.get(val), flagNum);
    }

    private void dfs(TreeNode root, int parentVal) {
        parent.put(root.val, parentVal);
        if(root.left != null) {
            dfs(root.left, root.val);
        }

        if(root.right != null) {
            dfs(root.right, root.val);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode ans = lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8))), new TreeNode(5), new TreeNode(1));
        System.out.println(ans);

        ans = lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8))), new TreeNode(5), new TreeNode(4));
        System.out.println(ans);

        ans = lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(new TreeNode(1, new TreeNode(2), null), new TreeNode(1), new TreeNode(2));
        System.out.println(ans);
    }
}
