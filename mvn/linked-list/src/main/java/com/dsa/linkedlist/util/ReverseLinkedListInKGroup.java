package com.dsa.linkedlist.util;

public class ReverseLinkedListInKGroup {

	public Node reverseInKGroup(Node head, int k) {

		if (head == null)
			return null;

		Node temp = head;
		int length = 0;
		while (temp != null) {
			temp = temp.next;
			length++;
		}

		if (length < k)
			return null;

		Node curr = head, prev = null, next;

		while (k-- > 0) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}

		head.next = curr;

		return prev;
	}

}
