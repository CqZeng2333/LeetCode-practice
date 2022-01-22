/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 */
public class _24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Exchange the first two node
        ListNode p = head.next, pre = null;
        head.next = p.next;
        p.next = head;
        head = p;
        p = head.next.next;
        pre = head.next;

        // Exchange the rest adjacent nodes
        ListNode q;
        while (p != null && p.next != null) {
            q = p.next;
            p.next = q.next;
            q.next = p;
            pre.next = q;

            pre = p;
            p = p.next;
        }

        return head;
    }
}
