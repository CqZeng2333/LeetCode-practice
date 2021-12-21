/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 两数相加
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:01:11
 */
public class _2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode _1 = null, _2 = null, _3 = null;
        int val1, val2, val3;
        boolean addOne = false;

        _1 = l1;
        _2 = l2;
        while (_1 != null && _2 != null) {
            val1 = _1.val;
            val2 = _2.val;

            val3 = val1 + val2;
            if (addOne) val3 += 1; // be carried a bit
            addOne = false;
            if (val3 >= 10) { // to carry a bit
                addOne = true;
                val3 -= 10;
            }

            if (l3 == null) { // first number in list
                l3 = new ListNode(val3, null);
                _3 = l3;
            }
            else {
                _3.next = new ListNode(val3, null);
                _3 = _3.next;
            }
            _1 = _1.next;
            _2 = _2.next;
        }

        while (_1 != null) { // list 1 longer than list 2
            val3 = addOne ? _1.val + 1 : _1.val;
            addOne = false;
            if (val3 >= 10) { // to carry a bit
                addOne = true;
                val3 -= 10;
            }

            if (l3 == null) { // first number in list
                l3 = new ListNode(val3, null);
                _3 = l3;
            }
            else {
                _3.next = new ListNode(val3, null);
                _3 = _3.next;
            }
            _1 = _1.next;
        }

        while (_2 != null) { // list 2 longer than list 1
            val3 = addOne ? _2.val + 1 : _2.val;
            addOne = false;
            if (val3 >= 10) { // to carry a bit
                addOne = true;
                val3 -= 10;
            }

            if (l3 == null) { // first number in list
                l3 = new ListNode(val3, null);
                _3 = l3;
            }
            else {
                _3.next = new ListNode(val3, null);
                _3 = _3.next;
            }
            _2 = _2.next;
        }

        // the last carry bit
        if (addOne) {
            _3.next = new ListNode(1, null);
        }

        return l3;
    }
    
    class ListNode {
    	int val;
    	ListNode next;
    	ListNode() {}
    	ListNode(int val) { this.val = val; }
    	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}