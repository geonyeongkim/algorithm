package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() { }

        TreeNode(int val) { this.val = val; }

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

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        // linked list => array list로 변경
        List<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        int mid = list.size()/2;

        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left = createTreeNode(list.subList(0, mid));
        treeNode.right= createTreeNode(list.subList(mid + 1, list.size()));

        return treeNode;
    }

    private TreeNode createTreeNode(List<Integer> list) {
        if(list.size() == 0) {
            return null;
        }
        int mid = list.size()/2;
        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left = createTreeNode(list.subList(0, mid));
        treeNode.right= createTreeNode(list.subList(mid + 1, list.size()));
        return treeNode;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        TreeNode ans = convertSortedListToBinarySearchTree.sortedListToBST(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9))))));
        System.out.println(ans);

        ans = convertSortedListToBinarySearchTree.sortedListToBST(new ListNode());
        System.out.println(ans);

        ans = convertSortedListToBinarySearchTree.sortedListToBST(new ListNode(0));
        System.out.println(ans);

        ans = convertSortedListToBinarySearchTree.sortedListToBST(new ListNode(1, new ListNode(3)));
        System.out.println(ans);
    }
}
