/*
 * given two ll intersecting at a point . find the intersecting point.

I.P: 1->2->3->4->5->
                       6->7->8->9->10
        11->12->13->
o/p:6
 * */

package dsa.linkedlist.single;

public class LLIntersectionPoint {

	Node head;

	public static void main(String[] args) {

		LLIntersectionPoint llIntrSec = new LLIntersectionPoint();

		Node intersectHead = null;
		intersectHead = llIntrSec.push(intersectHead, 6);
		intersectHead = llIntrSec.push(intersectHead, 7);
		intersectHead = llIntrSec.push(intersectHead, 8);
		intersectHead = llIntrSec.push(intersectHead, 9);
		intersectHead = llIntrSec.push(intersectHead, 10);
		llIntrSec.print(intersectHead);

		Node topHead = null;
		topHead = llIntrSec.push(topHead, 1);
		topHead = llIntrSec.push(topHead, 2);
		topHead = llIntrSec.push(topHead, 3);
		topHead = llIntrSec.push(topHead, 4);
		topHead = llIntrSec.push(topHead, 5);
		Node temp = topHead;
		while (temp.next != null)
			temp = temp.next;
		temp.next = intersectHead;
		llIntrSec.print(topHead);

		Node bottomHead = null;
		bottomHead = llIntrSec.push(bottomHead, 11);
		bottomHead = llIntrSec.push(bottomHead, 12);
		bottomHead = llIntrSec.push(bottomHead, 13);
		temp = bottomHead;
		while (temp.next != null)
			temp = temp.next;
		temp.next = intersectHead;
		llIntrSec.print(bottomHead);

		Node intersectionNode = findIntersectionNode(topHead, bottomHead);

		System.out.println(intersectionNode.data);
	}

	private static Node findIntersectionNode(Node topHead, Node bottomHead) {

		int topListNodeCnt = 0, bottomListNodeCnt = 0;

		Node temp = topHead;
		while (temp != null) {
			topListNodeCnt++;
			temp = temp.next;
		}

		temp = bottomHead;
		while (temp != null) {
			bottomListNodeCnt++;
			temp = temp.next;
		}

		Node tmpTop = topHead, tmpBottom = bottomHead;

		if (bottomListNodeCnt >= topListNodeCnt) {
			int diff = bottomListNodeCnt - topListNodeCnt;

			temp = bottomHead;
			while (diff-- >= 0) {
				temp = temp.next;
			}

			tmpBottom = temp;

		} else {
			int diff = topListNodeCnt - bottomListNodeCnt;

			temp = topHead;
			while (diff-- > 0) {
				temp = temp.next;
			}

			tmpTop = temp;
		}

		while (tmpTop != tmpBottom) {
			tmpTop = tmpTop.next;
			tmpBottom = tmpBottom.next;
		}

		return tmpTop;
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
