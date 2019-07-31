/*
 * Given a single LL, reverse the LL.

	I/P: 1->2->3->4->5
	O/P: 5->4->3->2->1
 * */

package dsa.linkedlist.single;

public class ReverseLinkedList {

	Node head;

	public static void main(String[] args) {

		ReverseLinkedList revLL = new ReverseLinkedList();

		Node head = null;
		head = revLL.push(head, 1);
		head = revLL.push(head, 2);
		head = revLL.push(head, 3);
		head = revLL.push(head, 4);
		head = revLL.push(head, 5);

		revLL.print(head);

		head = revLL.reverseLinkList(head);
		revLL.print(head);
	}

	private Node reverseLinkList(Node head) {

		Node curr = head, prev = null, next;

		while (curr != null) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}

		return prev;
	}

	private Node push(Node head, int data) {

		Node node = new Node(data);

		if (head == null) {
			head = node;
			return head;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;

		return head;
	}

	private void print(Node head) {

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
