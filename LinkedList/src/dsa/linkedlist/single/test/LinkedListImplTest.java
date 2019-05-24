package dsa.linkedlist.single.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import dsa.linkedlist.single.util.LinkedListImpl;
import dsa.linkedlist.single.util.Node;

class LinkedListImplTest {

	List<Integer> inputList = null;
	
	@Before
	void initializeInputList() {
		inputList = new ArrayList<Integer>();
		inputList.add(10);
		inputList.add(20);
		inputList.add(30);
		inputList.add(40);
		inputList.add(50);
	}
	
	@Test
	void addNodeAtBegning() {

		initializeInputList();
		
		Node<Integer> head = null;
           
		LinkedListImpl<Integer> linkedListImpl = new LinkedListImpl<Integer>();

		for(int i=0; i<inputList.size(); i++) {
			head = linkedListImpl.addNodeAtBegning(head, inputList.get(i));
		}
		
		List<Integer> outputList = linkedListImpl.printLinkedList(head);
		outputList.stream().forEach(System.out::println);
		
	}

}
