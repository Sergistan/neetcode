package com.utochkin.LinkedList;
// Reorder Linked List
public class ListNode4 {

    private int val;
    private ListNode4 next;

    ListNode4(int val) {
        this.val = val;
    }

    ListNode4() {
    }

    ListNode4(int val, ListNode4 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode4{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        ListNode4 three = new ListNode4(8);
        ListNode4 two = new ListNode4(6, three);
        ListNode4 one = new ListNode4(4, two);
        ListNode4 head = new ListNode4(2, one);
        System.out.println(head);
        // 2 → 4 → 6 → 8 → null
        reorderList(head);
        System.out.println(head);
        // 2 → 8 → 4 → 6 → null
    }

    public static void reorderList(ListNode4 head) {
        if (head == null || head.next == null) {
            return;
        }

        // Шаг 1: Найти середину и разделить список
        ListNode4 slow = head;
        ListNode4 fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode4 secondHalf = slow.next;  // начало второй половины
        slow.next = null;               // разрезаем список

        // Шаг 2: Перевернуть вторую половину
        ListNode4 reverseSecondHalf = reverseList(secondHalf);

        // Шаг 3: Слить две половины
        merge(head, reverseSecondHalf);
    }

    public static ListNode4 reverseList (ListNode4 head) {

        ListNode4 prev = null;
        ListNode4 current = head;

        while (current != null) {
            ListNode4 next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void merge (ListNode4 first, ListNode4 second) {

        while (second != null) {
            // Сохраняем следующие узлы
            ListNode4 temp1 = first.next;
            ListNode4 temp2 = second.next;

            // Вставляем узел из второй половины между узлами первой
            first.next = second;
            second.next = temp1;

            // Перемещаем указатели
            first = temp1;
            second = temp2;
        }
    }
}