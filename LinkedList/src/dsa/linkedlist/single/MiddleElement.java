/**
 * Given a single link list find the middle element in single traversal.

I/P: 1->2->3->4->5->6->7->8->9->10
o/p: 5;

I/P: 1->2->3->4->null
o/p: 2;
*/

package dsa.linkedlist.single;

public class MiddleElement {

	Node head;

	public static void main(String[] args) {

		MiddleElement midEle = new MiddleElement();
		
		//Seed Input
		midEle.add(new Node(1));
		midEle.add(new Node(2));
		midEle.add(new Node(3));
		midEle.add(new Node(4));
		midEle.add(new Node(5));
		midEle.add(new Node(6));
		midEle.add(new Node(7));
		midEle.add(new Node(8));
		midEle.add(new Node(9));

		midEle.print();

		Node middleElement = midEle.getMiddleNode(midEle.head);
		System.out.println(middleElement.getData());
		
		midEle.printMiddle();
	}
	
	/* Function to print middle of linked list */
    void printMiddle() 
    { 
        Node slow_ptr = head; 
        Node fast_ptr = head; 
        if (head != null) 
        { 
            while (fast_ptr != null && fast_ptr.next != null) 
            { 
                fast_ptr = fast_ptr.next.next; 
                slow_ptr = slow_ptr.next; 
            } 
            System.out.println("The middle element is [" + 
                                slow_ptr.data + "] \n"); 
        } 
    }

	private Node getMiddleNode(Node head) {

		Node slowPtr = head, fastPtr = head;

		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		
		return slowPtr;
	}

	private void add(Node node) {

		if (head == null) {
			head = node;
			return;
		}

		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(node);

	}

	private void print() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}

		System.out.println();

	}

}

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
