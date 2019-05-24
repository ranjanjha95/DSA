/*
 * Given a ll with random pointers , clone this ll with random pointers

struct node{
  int data;
  struct node* next;
  struct node* random;
}
 * 
 * Given a LL, rearrange the odd position elements and even positions element
together with odd first and then even.

 I/P: 2 -> 3 -> 6 -> 1 -> 9
     |    |    |    |    |
     6    1    9    2    3


//clone every node (curr node) and put it in between curr node and next node

 * */

package dsa.linkedlist.single;

public class RandomListClone {

	public static void main(String[] args) {

		RandomListClone rCloneClsObj = new RandomListClone();

		Node head = null;
		head = rCloneClsObj.pushNext(head, 1);
		head = rCloneClsObj.pushNext(head, 2);
		head = rCloneClsObj.pushNext(head, 3);
		head = rCloneClsObj.pushNext(head, 4);
		head = rCloneClsObj.pushNext(head, 5);
		System.out.println("=======Input Linked List=======");
		rCloneClsObj.printNext(head);

		rCloneClsObj.pushRand(head, head.next.next);
		rCloneClsObj.pushRand(head.next.next, head.next);
		rCloneClsObj.pushRand(head.next.next.next, head);
		rCloneClsObj.pushRand(head.next.next.next.next, head.next.next.next);

		// rCloneClsObj.printRand(head);

		head = rCloneClsObj.insertClonedNode(head, head);// 1
		head = rCloneClsObj.insertClonedNode(head, head.next.next);// 2
		head = rCloneClsObj.insertClonedNode(head, head.next.next.next.next);// 3
		head = rCloneClsObj.insertClonedNode(head, head.next.next.next.next.next.next);// 4
		head = rCloneClsObj.insertClonedNode(head, head.next.next.next.next.next.next.next.next);// 5
		System.out.println("=======Modified head======");
		rCloneClsObj.printNext(head);

		rCloneClsObj.updateRandInClonedNode(head);
		System.out.println("=======Modified Rand======");
		rCloneClsObj.printRand(head);

		Node finalHead = rCloneClsObj.removeOriginalInClonedNode(head);
		System.out.println("=======Fnal head======");
		if (finalHead != null)
			rCloneClsObj.printRand(finalHead);

	}

	private Node removeOriginalInClonedNode(Node head) {

		if (head == null)
			return null;

		Node temp = head.next;

		while (temp != null && temp.next != null) {

			temp.next = temp.next.next;
			temp = temp.next;
		}

		temp = head.next;
		head.next = null;

		System.gc();

		return temp;

	}

	private void updateRandInClonedNode(Node head) {

		Node temp = head;
		while (temp != null && temp.next != null) {

			temp.next.rand = ((temp.rand == null) ? null : temp.rand.next);
			temp = temp.next.next;

		}

	}

	private Node insertClonedNode(Node head, Node node) {

		Node clonedNode = null;
		try {
			clonedNode = (Node) node.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		clonedNode.next = node.next;
		node.next = clonedNode;

		return head;
	}

	private Node pushNext(Node head, int data) {

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

	private void pushRand(Node start, Node end) {

		if (start == null)
			return;

		start.rand = end;
	}

	private void printNext(Node head) {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}

		System.out.println("null");

	}

	private void printRand(Node head) {

		Node temp = head;

		while (temp != null) {
			System.out.println(temp.data + " : next->" + (temp.next == null ? null : temp.next.data) + " : rand->"
					+ (temp.rand == null ? null : temp.rand.data));
			temp = temp.next;
		}

	}

	class Node implements Cloneable {

		int data;
		Node next;
		Node rand;

		Node(int data) {
			this.data = data;
			next = null;
			rand = null;
		}

		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

}
