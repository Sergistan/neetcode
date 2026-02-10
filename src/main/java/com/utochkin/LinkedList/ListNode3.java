package com.utochkin.LinkedList;
// Linked List Cycle Detection
public class ListNode3 {
    private int val;
    private ListNode3 next;

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3() {
    }

    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode3{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        ListNode3 three = new ListNode3(4);
        ListNode3 two = new ListNode3(3, three);
        ListNode3 one = new ListNode3(2, two);
        ListNode3 head = new ListNode3(1, one);

        three.next = one;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode3 head) {

        if (head == null) {
            return false;
        }

        ListNode3 slow = head;
        ListNode3 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // на 1 шаг
            fast = fast.next.next;    // на 2 шага

            if (slow == fast) {        // встретились → есть цикл
                return true;
            }
        }
        return false;  // дошли до конца → цикла нет
    }


}
