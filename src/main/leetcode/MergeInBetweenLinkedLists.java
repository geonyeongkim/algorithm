package main.leetcode;

public class MergeInBetweenLinkedLists {

    /*
    * 이건 다른 사람의 풀이를 참고,
    * 사실, 맨 처음 이 방법을 생각했지만.... 문제에 listnode 의 값들이 정렬되있다는 말이 없어서..... 아예 버린 풀이인데....
    * 예를 들어, 0, 1, 2, 3, 5, 6 등등... 괜히 어렵게 생각을 했던 문제...
    * */
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = list1;

        for(int i = 0 ; i < a -1; i ++) {
            list1 = list1.next;
        }

        ListNode tmp1 = list1;

        for(int i = 0; i < b - a + 1; i++) {
            list1 = list1.next;
        }

        ListNode tmp2 = list1;
        ListNode tmp3 = list2;
        tmp1.next = tmp3;

        while(list2.next != null) list2 = list2.next;
        ListNode tmp4 = list2;
        tmp4.next = tmp2.next;
        return res;
    }

    /*
    * 내가 풀은 문제 해결법, 객체를 계속 생성하여 조건에 맞는 리스트 노드를 새로 만드는 풀이
    * 풀이가 간단한 장점이 있지만, 시간복잡도와 공간복잡도의 효능이 떨어짐.
    * */
    public static ListNode myMergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = new ListNode();
        ListNode curr = res;
        boolean flag = false;

        while(list1 != null) {

            if(list1.next != null && list1.next.val == a) {
                flag = true;
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                while(list2 != null) {
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                }
            }

            if(!flag) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
            }

            if(list1.next != null && list1.next.val == b) {
                list1 = list1.next;
                flag = false;
            }

            list1 = list1.next;
        }
        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.println("listNode1 -> " + listNode1);

        ListNode listNode2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002, new ListNode(1000003, new ListNode(1000004)))));
        System.out.println("listNode2 -> " + listNode2);



//        [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
        ListNode res = mergeInBetween(listNode1, 2, 5, listNode2);
        System.out.println("res -> " + res);

    }
}
