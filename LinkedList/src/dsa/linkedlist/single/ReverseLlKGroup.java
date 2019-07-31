/*
 * Given a single LL, reverse the LL in group of size of k.
	I/P: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
   	k=3

	O/P: 3->2->1 -> 6->5->4 -> 9->8->7 -> 10
 * */

package dsa.linkedlist.single;

public class ReverseLlKGroup {

	Node head;

	public static void main(String[] args) {

		ReverseLlKGroup revLL = new ReverseLlKGroup();

		Node head = null;
		head = revLL.push(head, 1);
		head = revLL.push(head, 2);
		head = revLL.push(head, 3);
		head = revLL.push(head, 4);
		head = revLL.push(head, 5);
		head = revLL.push(head, 6);
		head = revLL.push(head, 7);
		head = revLL.push(head, 8);
		head = revLL.push(head, 9);
		head = revLL.push(head, 10);

		revLL.print(head);

		head = revLL.reverseLinkList(head, 1);

		if (head == null)
			System.out.println("Invalid length");
		else
			revLL.print(head);
	}

	private Node reverseLinkList(Node head, int k) {

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
