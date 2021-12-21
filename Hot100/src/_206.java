/**
 * 反转链表
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:07:26
 */
public class _206 {
	private class ListNode {
		int value;
		ListNode next;
		
		ListNode(int v) {
			this.value = v;
			next = null;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public ListNode getNext() {
			return next;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	
	ListNode head;
	int length;
	
	_206(int[] values) {
		if (values != null && values.length != 0) {
			head = new ListNode(values[0]);
			ListNode p = head;
			for (int i = 1; i < values.length; i++) {
				p.next = new ListNode(values[i]);
				p = p.next;
			}
			length = values.length;
		}
	}
	
	public void revertLinkList() {
		if (head == null) return;
		
		ListNode pre, next;
		pre = null;
		
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		head = pre;
	}
	
	public void printLinkList() {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.value + " ");
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		_206 ll = new _206(new int[] {3, 1, 2, 3});
		ll.revertLinkList();
		ll.printLinkList();

	}
}
