/**
 * Code floyds cycle algorithm 
 * 
	1. detect the cycle
	2. size of cycle
	3. start of cycle
	4. remove the cycle
	
 * */

package dsa.linkedlist.single;

import java.util.HashSet;
import java.util.Set;

public class FloydCycleLinkedList {

	public static void main(String[] args) {

		Node head = null, q = null, head1;
		FloydCycleLinkedList floydCycleLL = new FloydCycleLinkedList();

		// Seed input data
		for (int i = 1; i < 10; i++)
			head = floydCycleLL.push(head, i);
		floydCycleLL.print(head);

		// Make a circular LL at node 5
		// floydCycleLL.linkLastNodeToKthNode(head, 5);
		floydCycleLL.print(head);

		// 1. detect the cycle
		boolean isCycle = floydCycleLL.detectLoop(head);
		System.out.println("Loop/Cycle exists in the Linked List: " + isCycle);

		// 2. size of cycle
		int sizeOfCycle = floydCycleLL.getSizeOfCycle(head);
		System.out.println("Size of Cycle is: " + sizeOfCycle);

		// 3. start of cycle
		Node loopHead = floydCycleLL.getLoopHead(head);
		System.out.println("Start node of the loop is: " + (loopHead == null ? null : loopHead.data));

		// 4. remove the cycle
		floydCycleLL.removeLoop(head);
		floydCycleLL.print(head);

	}

	private void removeLoop(Node head) {

		if (head == null)
			return;

		Node p = head, q = head;

		while (q != null && q.next != null) {

			p = p.next;
			q = q.next.next;

			if (p == q)
				break;

		}

		// If no loop exists
		if (p != q)
			return;

		// reset p to head
		p = head;

		Node prev = null;
		while (p != q) {
			p = p.next;
			prev = q;
			q = q.next;
		}

		// Set prev.next = null, inplace of pointing to start of the loop node.

		prev.next = null;

	}

	private Node getLoopHead(Node head) {

		if (head == null)
			return null;

		Node p = head, q = head;

		while (q != null && q.next != null) { // while(true): In case of not at loop-> will go to infinite loop

			p = p.next;
			q = q.next.next;

			if (p == q) {
				break;
			}
		}
		if (p != q)// Not a loop
			return null;

		// Point p at start and check for condition when they match.

		p = head;

		while (p != q) {
			p = p.next;
			q = q.next;
		}

		return p;
	}

	private int getSizeOfCycle(Node head) {

		if (head == null)
			return 0;

		Node p = head, q = head;

		while (q != null && q.next != null) { // while(true): In case of not at loop-> will go to infinite loop

			p = p.next;
			q = q.next.next;

			if (p == q) {
				break;
			}
		}

		if (p != q)
			return 0;

		// Find distance of p/q from head of node.

		Node temp = head;
		int dist = 0;
		while (temp != p) {
			temp = temp.next;
			dist++;
		}

		return dist;
	}

	private boolean detectLoop(Node head) {

		if (head == null)
			return false;

		Node p = head, q = head;

		boolean isLoop = false;

		while (q != null && q.next != null) { // while(true): In case of not at loop-> will go to infinite loop

			p = p.next;
			q = q.next.next;

			if (p == q) {
				isLoop = true;
				break;
			}
		}

		return isLoop;
	}

	private void linkLastNodeToKthNode(Node p, int k) {

		Node temp = p;
		while (k-- > 1) {
			temp = temp.next;
		}

		Node end = temp;
		while (end.next != null) {
			end = end.next;
		}

		end.next = temp;

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

		Set<Node> nodeSet = new HashSet<Node>();

		while (temp != null) {

			if (nodeSet.contains(temp))
				break;
			nodeSet.add(temp);
			System.out.print(temp.data + "->");
			temp = temp.next;
		}

		if (temp == null)
			System.out.println("null");
		else
			System.out.println(temp.data);

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
