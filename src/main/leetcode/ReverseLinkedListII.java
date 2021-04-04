package main.leetcode;

import java.util.Stack;

public class ReverseLinkedListII {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode answer = head;
        Stack<ListNode> stack = new Stack<>();
        boolean flag = false;
        ListNode firstNode = null;
        int idx = 1;
        while(head != null) {

            // 마킹
            if(idx + 1 == left) {
                firstNode = head;
            }

            if(idx == left) {
                flag = true;
            }

            if(idx == right) {
                if(left == 1) answer = head;
                if(firstNode != null) firstNode.next = head;
                ListNode next = head.next;
                while(!stack.isEmpty()) {
                    head.next = stack.pop();
                    head = head.next;
                }

                head.next = next;
                break;
            }

            if(flag) {
                stack.push(head);
            }

            head = head.next;
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode ans = reverseLinkedListII.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
        System.out.println(ans);

        ans = reverseLinkedListII.reverseBetween(new ListNode(5), 1, 1);
        System.out.println(ans);

        ans = reverseLinkedListII.reverseBetween(new ListNode(3, new ListNode(5)), 1, 2);
        System.out.println(ans);
    }
}
