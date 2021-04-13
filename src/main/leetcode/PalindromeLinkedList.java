package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0, right = list.size() - 1;

        while(left < right) {
            if(list.get(left) != list.get(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean ans = palindromeLinkedList.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
        System.out.println(ans);
        ans = palindromeLinkedList.isPalindrome(new ListNode(1, new ListNode(2)));
        System.out.println(ans);
    }
}
