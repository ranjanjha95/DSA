package com.dsa.linkedlist.util;

public class ReverseLinkedList {

	//       10->20->30->40->50->null //head = 10
	// null<-10<-20<-30<-40<-50 //head = 50

	public Node reverse(Node head) {

		if (head == null)
			return null;

		Node curr = head, prev = null, next;

		while (curr != null) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}

		return prev;

	}

}
