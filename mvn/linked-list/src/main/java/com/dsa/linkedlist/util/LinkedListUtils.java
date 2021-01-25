package com.dsa.linkedlist.util;

public class LinkedListUtils {

	public void printLinkedList(Node node) {

		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}

	}

	private void printLL_1(Node node) {

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}

	}

	private void printLL_2(Node node) {

		if (node == null)
			return;

		System.out.println(node.data);
		printLL_2(node.next);

	}

	private Node createLinkedList_1() {

		Node node = null, head = new Node(10);
		for (int i = 2; i <= 10; i++) {
			node = new Node(i * 10);
			node.next = head;
			head = node;
		}
		return head;
	}

	private Node createLinkedList_2() {

		Node node = null, head = new Node(10), prev = head;
		for (int i = 2; i <= 10; i++) {
			node = new Node(i * 10);
			prev.next = node;
			prev = node;
		}
		return head;
	}

	public Node initLinkedListWithDummy(int size) {

		Node node = null, head = new Node(10), prev = head;
		for (int i = 2; i <= size; i++) {
			node = new Node(i * 10);
			prev.next = node;
			prev = node;
		}
		return head;
	}

}
