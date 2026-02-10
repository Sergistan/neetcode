package com.utochkin.LinkedList;

// Remove Node From End of Linked List
public class ListNode5 {
    private int val;
    private ListNode5 next;

    ListNode5(int val) {
        this.val = val;
    }

    ListNode5() {
    }

    ListNode5(int val, ListNode5 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode5{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        ListNode5 three = new ListNode5(4);
        ListNode5 two = new ListNode5(3, three);
        ListNode5 one = new ListNode5(2, two);
        ListNode5 head = new ListNode5(1, one);
        // 1 → 2 → 3 → 4 → null
        System.out.println(removeNthFromEnd(head, 2));
        // 1 → 2 → 4 → null
    }

    public static ListNode5 removeNthFromEnd(ListNode5 head, int n) {
        // Создаём фиктивный узел перед head для удобства обработки крайних случаев
        ListNode5 dummy = new ListNode5();
        dummy.next = head;

        ListNode5 fast = dummy;
        ListNode5 slow = dummy;

        // Шаг 1: сдвигаем fast на n+1 узлов (чтобы slow оказался перед удаляемым)
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
       }

        // Шаг 2: двигаем fast и slow вместе до конца списка
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Шаг 3: удаляем узел после slow
        slow.next = slow.next.next;  // пропускаем удаляемый узел

        // Возвращаем новую голову (может быть null, если удалили head)
        return dummy.next;
    }


}
