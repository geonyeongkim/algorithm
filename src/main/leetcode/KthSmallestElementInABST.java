package main.leetcode;

public class KthSmallestElementInABST {

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

    int cnt;
    int answer;

    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        answer = 0;
        dfs(root, k);
        return answer;
    }

    private void dfs(TreeNode root, int k) {
        if(cnt == k) return;
        if(root == null) return;

        if(root.left != null) {
            dfs(root.left, k);
        }
        cnt++;
        if(cnt == k) {
            answer = root.val;
            return;
        }
        if(root.right != null) {
            dfs(root.right, k);
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInABST k = new KthSmallestElementInABST();
        int ans = k.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1);
        System.out.println(ans);

        ans = k.kthSmallest(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)), 3);
        System.out.println(ans);
    }
}
