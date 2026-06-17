package com.santosh.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromLinkedList {

	public static void main(String[] args) {
//		Input: 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21 
//		Output: 12 -> 11 -> 21 -> 41 -> 43 
		
		Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(10);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(20);

        System.out.println("Original List:");
        printNodes(head);
        removeDuplicates(head);
        System.out.println("After Removing Duplicates:");
        printNodes(head);
	}
	
	// use HashSet to add node value
	// before adding check if exists. if exists then adjust pointers
	// use 2 pointers current and previous
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	static Node removeDuplicates(Node head) {
		
		if(head == null) {
			return null;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		Node current = head;
		Node previous = null;
		
		while(current != null) {
			if(set.contains(current.data)) {
				// duplicate found skip the current node
				previous.next = current.next;
			}else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		
		return head;
	}
	
	public static void printNodes(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

}
