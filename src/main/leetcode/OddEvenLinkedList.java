package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-07
 */
public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        boolean flag = true;

        ListNode odd = new ListNode();
        ListNode oddStart = odd;
        ListNode even = new ListNode();
        ListNode evenStart = even;

        while(head != null) {
            if(flag) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            flag = !flag;
        }

        if(flag) {
            odd.next = null;
        } else {
            even.next = null;
        }

        odd.next = evenStart.next;
        return oddStart.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode res1 = oddEvenList(listNode1);
        System.out.println("res1 -> " + res1);

        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res2 = oddEvenList(listNode2);
        System.out.println("res2 -> " + res2);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

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
}
