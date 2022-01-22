/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null && n == 1) {
            return null;
        } else {
            // Count the length of the list
            int length = 0;
            ListNode p = head;
            while (p != null) {
                length++;
                p = p.next;
            }

            // Find the node to remove
            if (length == n) {
                return head.next;
            } else {
                p = head;
                int count = 1;
                while (p != null && count < length - n) {
                    p = p.next;
                    count++;
                }
                if (p != null && p.next != null) {
                    p.next = p.next.next;
                }
                return head;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
