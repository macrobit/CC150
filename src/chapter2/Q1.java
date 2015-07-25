/****************************************************************************************
 * 		Problem: Remove duplicates from an unsorted linked list
 *		Tags:	 linked list, duplicates, unsorted
 * 		Data Structure:  HashMap, linked list
 * 		
 * 		Author:  Yuhao Fei
 *****************************************************************************************/

package chapter2;

import java.util.HashMap;
import dataStructures.ListNode;

public class Q1 {
	public void rmDups(ListNode head) {
		if(head == null) return;
		
		HashMap<Object, Boolean> table = new HashMap<Object, Boolean>();
		ListNode pre = null; // pre is the previous node of head
		while(head != null) {
			if(table.containsKey(head.val)) { // it is a duplicate
				pre.next = head.next;
			} else { // not a duplicate
				table.put(head.val, true);
				pre = head;
			}
			head = head.next;
		}				
	}
	
	// a temporary buffer is not allowed
	public void rmDups2(ListNode head) {
		if(head == null) return;
		
	/****************************************************
	 * 	Because no buffer, for each node, we have to iterate
	 *  the rest of nodes to find the duplicates and delete 
	 *  them. There are two iteration.
	 ****************************************************/
		ListNode current = head;
		while(current != null) {
			ListNode pre = current, runner = current.next;
			while(runner != null) {
				if(runner.val == current.val) {
					pre.next = runner.next;
				} else {
					pre = runner;
				}
				runner = runner.next;
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(2);
		head.add(3);
		head.add(5);
		head.print();
		
		Q1 test = new Q1();
		test.rmDups(head);
		head.print();
		
	}
}
