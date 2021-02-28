package main.leetcode;

public class AddTwoNumbers {

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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode head = answer;

        int carry = 0;

        while(l1 != null || l2 != null || carry > 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;

            answer.next = new ListNode(sum % 10);
            answer = answer.next;
            carry = sum / 10;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode ans = addTwoNumbers.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
        System.out.println(ans);

        ans = addTwoNumbers.addTwoNumbers(new ListNode(0), new ListNode(0));
        System.out.println(ans);

        ans = addTwoNumbers
                .addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        System.out.println(ans);

        ans = addTwoNumbers.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(9))), new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9)))));
        System.out.println(ans);

        ans = addTwoNumbers.addTwoNumbers(new ListNode(9),
                new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))))));
        System.out.println(ans);
    }
}
