/**
 * Code for Sum of two LL

	I/P: 
	1->2->3->4->null
	1->2->3->4->5->6->null

	O/P:
	1->2->4->6->9->0->null
	
 * */

package dsa.linkedlist.single;

public class SumLinkedList {

	public static void main(String[] args) {

		Node p = null, q = null, head;
		SumLinkedList sumLinkedList = new SumLinkedList();

		// Seed input data
		for (int i = 1; i < 5; i++)
			p = sumLinkedList.push(p, i);
		sumLinkedList.print(p);
		for (int i = 1; i < 7; i++)
			q = sumLinkedList.push(q, i);
		sumLinkedList.print(q);

		p = sumLinkedList.reverse(p);
		// sumLinkedList.print(p);
		q = sumLinkedList.reverse(q);
		// sumLinkedList.print(q);

		head = sumLinkedList.addLinkList(p, q);
		// sumLinkedList.print(head);

		head = sumLinkedList.reverse(head);
		System.out.println("Result===");
		sumLinkedList.print(head);
	}

	private Node addLinkList(Node p, Node q) {

		if (p == null)
			return q;
		if (q == null)
			return p;

		int pLen = getLength(p);
		int qLen = getLength(q);
		int carry = 0;
		Node head = null;

		if (pLen > qLen) {
			while (qLen-- > 0) {
				head = push(head, (carry + p.data + q.data) % 10);
				carry = (carry + p.data + q.data) / 10;
				p = p.next;
				q = q.next;
				pLen--;
			}
			while (pLen-- > 0) {
				head = push(head, (carry + p.data) % 10);
				carry = (carry + p.data) / 10;
				p = p.next;
			}
		}
		if (qLen >= pLen) {
			while (pLen-- > 0) {
				head = push(head, (carry + p.data + q.data) % 10);
				carry = (p.data + q.data) / 10;
				p = p.next;
				q = q.next;
				qLen--;
			}
			while (qLen-- > 0) {
				head = push(head, (carry + q.data) % 10);
				carry = (carry + q.data) / 10;
				q = q.next;
			}
		}

		if (carry != 0)
			head = push(head, carry);

		return head;
	}

	private int getLength(Node node) {

		int len = 0;
		while (node != null) {
			node = node.next;
			len++;
		}
		return len;
	}

	private Node reverse(Node head) {

		if (head == null)
			return null;

		Node curr = head, prev = null, temp;

		while (curr != null) {

			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;

		}

		return prev;
	}

	private Node push(Node head, int data) {

		Node node = new Node(data);

		if (head == null)
			return node;

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

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
