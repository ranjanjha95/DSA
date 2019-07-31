package dsa.linkedlist.single.util;

import java.util.ArrayList;
import java.util.List;

public class LinkedListImpl<T> {

	public Node<T> addNodeAtBegning(Node<T> head, T data) {

		Node<T> tempNode = new Node<T>(data, null);

		if (head != null) {
			tempNode.setNext(head);
		}

		head = tempNode;

		return head;

	}

	public Node<T> addNodeAtEnd(Node<T> head, T data) {

		Node<T> tempNode = new Node<T>(data, null);

		if (head != null) {
			tempNode.setNext(head);
		}

		head = tempNode;

		return head;

	}
	
	public List<T> printLinkedList(Node<T> head) {

		List<T> list = new ArrayList<T>();
		Node<T> currentNode = head;

		while (currentNode != null) {
			list.add(currentNode.getData());
			currentNode = currentNode.getNext();
		}

		return list;

	}

}
