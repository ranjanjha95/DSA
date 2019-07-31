/*
 * Given a LL, rearrange the odd position elements and even positions element
together with odd first and then even.

      1    2     3     4      5    6
I.P: 10 -> 11 -> 14 -> 21 -> 25 -> 27
o/p: 10 -> 14 -> 25 -> 11 -> 21 -> 27

Cases:
1) Empty linked list
2) only one node
3) only two nodes
4) odd number of nodes
5) even number of nodes
 * */

package dsa.linkedlist.single;

public class RearrangeEvenOddPos {

	Node head;

	public static void main(String[] args) {

		RearrangeEvenOddPos rEO = new RearrangeEvenOddPos();

		rEO.push(10);
		rEO.push(20);
		rEO.push(30);
		rEO.push(40);
		rEO.push(50);
		rEO.push(60);
		rEO.push(70);
		rEO.push(80);
		rEO.push(90);
		//rEO.push(100);

		rEO.print(rEO.head);

		// Node newHead = rEO.rearrangeEvenOddPosElements(rEO.head);
		Node newHead = rEO.rearrangeEvenOddWith2List(rEO.head);

		rEO.print(newHead);
	}

	private Node rearrangeEvenOddWith2List(Node head) {

		if (head == null)
			return null;

		Node odd_ptr = head, even_ptr = head.next;
		Node even_first = even_ptr;

		while (odd_ptr != null && even_ptr != null) {

			//Ending with even node
			//There is no further odd node
			if (even_ptr.next == null) {
				odd_ptr.next = even_first;
				break;
			}
			
			// connected odd
			odd_ptr.next = even_ptr.next;
			odd_ptr = odd_ptr.next;

			//Ending with odd node
			//There is no further even node
			if (odd_ptr.next == null) {
				even_ptr.next = null;
				odd_ptr.next = even_first;
				break;
			}
			
			// connected even
			even_ptr.next = odd_ptr.next;
			even_ptr = even_ptr.next;

		}

		return head;
	}

	private Node rearrangeEvenOddPosElements(Node head) {

		if (head == null)
			return null;

		Node temp = head;
		Node resultHead = null;

		while (temp != null && temp.next != null) {
			resultHead = push(resultHead, temp.data);
			temp = temp.next.next;
		}
		if (temp != null)
			resultHead = push(resultHead, temp.data);

		temp = head.next;
		while (temp != null && temp.next != null) {
			resultHead = push(resultHead, temp.data);
			temp = temp.next.next;
		}
		if (temp != null)
			resultHead = push(resultHead, temp.data);

		return resultHead;
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

	private void push(int data) {

		Node node = new Node(data);

		if (head == null) {
			head = node;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
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
