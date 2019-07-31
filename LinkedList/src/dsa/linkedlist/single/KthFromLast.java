/**
 * Given a single linklist, find the kth element from last

I/P: 1->2->3->4->5->6->7->8->9->10  k=3
o/p: 8
 * */

package dsa.linkedlist.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthFromLast {

	Node head;

	public static void main(String[] args) {

		KthFromLast kthFromLast = new KthFromLast();

		for (int i = 10; i > 0; i--) {
			kthFromLast.push(i);
		}

		kthFromLast.print();

		System.out.print("Enter value of k: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node kthNode = null;
		try {
			kthNode = kthFromLast.findFromLast(Integer.parseInt(br.readLine()));
		} catch (IOException e) {
			System.err.println("Enter valid integer: " + e.getMessage());
			return;
		}

		if (kthNode != null)
			System.out.println(kthNode.data);

	}

	private Node findFromLast(int k) {

		if (k < 0) {
			System.out.println("Invalid value of k.");
			return null;
		}

		Node temp = head;
		while (k-- >= 0) {
			if (temp == null) {
				System.out.println("Invalid value of k.");
				return null;
			}
			temp = temp.next;
		}

		Node start = head;

		while (temp != null) {
			temp = temp.next;
			start = start.next;
		}

		return start;
	}

	private void push(int data) {

		Node node = new Node(data);
		node.next = head;
		head = node;

	}

	private void print() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}

		System.out.println("null");

	}

	class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

}
