package com.utochkin.LinkedList;
// Reverse Linked List
public class ListNode {

    private int val;
    private ListNode next;

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

    public static void main(String[] args) {
        ListNode three = new ListNode(4);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(1, one);
        System.out.println(head);
        // 1 → 2 → 3 → 4 → null

        System.out.println(reverseList(head));
        // 4 → 3 → 2 → 1 → null
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null; // previous → null
        ListNode current = head;  // current → 1 → 2 → 3 → 4 → null

        while (current != null) {
            ListNode nextElement = current.next;  // nextElement → 2 → 3 → 4 → null   ;nextElement → 3 → 4 → null
            current.next = previous;  // 1 → null                                     ;2 → 1 → null
            previous = current;  // previous → 1 → null                               ;previous 2 → 1 → null
            current = nextElement; // current → 2 → 3 → 4 → null                      ;current → 3 → 4 → null
        }
        return previous;
    }
}
