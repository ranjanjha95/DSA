package com.dsa.linkedlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dsa.linkedlist.util.LinkedListUtils;
import com.dsa.linkedlist.util.Node;
import com.dsa.linkedlist.util.ReverseLinkedList;
import com.dsa.linkedlist.util.ReverseLinkedListInKGroup;

@SpringBootApplication
public class LinkedListApplication {

	public static void main(String[] args) {

		SpringApplication.run(LinkedListApplication.class, args);

		LinkedListUtils linkedListUtils = new LinkedListUtils();
		Node head = linkedListUtils.initLinkedListWithDummy(5);

		/**********************/
		System.out.println("Before Reverse");
		linkedListUtils.printLinkedList(head);
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		Node reversedHead = reverseLinkedList.reverse(head);
		System.out.println("\nAfter Reverse");
		linkedListUtils.printLinkedList(reversedHead);
		/**********************/

		/**********************/
		/*
		 * System.out.println("Before reverse"); linkedListUtils.printLinkedList(head);
		 * ReverseLinkedListInKGroup reverseLinkedListInKGroup = new
		 * ReverseLinkedListInKGroup(); Node reversedHead =
		 * reverseLinkedListInKGroup.reverseInKGroup(head, 3);
		 * System.out.println("After reverse");
		 * linkedListUtils.printLinkedList(reversedHead);
		 */
		/**********************/
	}
}
