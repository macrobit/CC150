package dataStructures;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
	
	public void add(int value){
		ListNode end = new ListNode(value);
		ListNode head = this;
		while(head.next != null) head = head.next;
		head.next = end;
	}
	public void print() {
		ListNode head = this;
		while(head != null){
			System.out.print("" + head.val + "->");
			head = head.next;
		}
		System.out.print("null\n");
	}
}
