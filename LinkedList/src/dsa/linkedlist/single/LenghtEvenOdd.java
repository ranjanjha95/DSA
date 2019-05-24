
/**
 * Given a link list find the weather list is of even length or odd length.

I/P: 1->2->3->4->5->6->7->8->9->10
o/p: even

I/P: 1->2->3->4->5->6->7->8->9->10->11
o/p: odd
 * 
 * */

package dsa.linkedlist.single;

public class LenghtEvenOdd {

	Node head;

	public static void main(String[] args) {

		LenghtEvenOdd lengthEvenOdd = new LenghtEvenOdd();

		for (int i = 12; i > 0; i--) {
			lengthEvenOdd.push(i);
		}

		lengthEvenOdd.print();

		lengthEvenOdd.printEvenOrOddLength();

	}

	private void printEvenOrOddLength() {

		Node slow_ptr = head, fast_ptr = head;

		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}

		while (fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}

		if (fast_ptr != null)
			System.out.println("Linked List length is Odd.");
		else
			System.out.println("Linked List length is Even.");

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
