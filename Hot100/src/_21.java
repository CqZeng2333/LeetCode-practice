/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class _21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode p, q, result;
        if (list1.val <= list2.val) {
            p = list1;
            q = list2;
            result = list1;
        } else {
            p = list2;
            q = list1;
            result = list2;
        }

        while (p.next != null && q != null) {
            if (p.val <= q.val && p.next.val > q.val) {
                ListNode temp = q;
                q = q.next;
                temp.next = p.next;
                p.next = temp;
            }
            p = p.next;
        }
        if (q != null) {
            p.next = q;
        }
        return result;
    }
}
