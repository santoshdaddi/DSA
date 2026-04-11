package com.santosh.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfLinkedList {

	// Approach
//	1. Create temp node and HashMap of (Node,Integer).
//	2. Iterate over first list till the last and add node to map. node as key and value as 1
//	3. reassign temp node to list2 and iterate till the last. while iterating check if node is present in map or not.
//	4. if node is present then that is intersection point. return node where intersection is found.
	
	// T(C) -> O(m+n)
	// S(C) -> O(m)
	private static Node intersectioOfLists(Node head1, Node head2) {
		
		if(head1 == null || head2 == null) {
			return null;
		}
		
		Node temp = head1;
		Map<Node, Integer> map = new HashMap<>();
		
		//iterate over list1
		while(temp != null) {
			map.put(temp, 1);
			temp = temp.next;
		}
		
		//iterate over list2
		temp= head2;
		while(temp != null) {
			if(map.containsKey(temp)) {
				return temp;
			}
			
			temp = temp.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		
		Node head2 = new Node(4);
		head2.next = new Node(5);
		head2.next.next = new Node(6);
		head2.next.next.next = head1.next.next;
		
		Node result = intersectioOfLists(head1, head2);
		if(result != null) {
			System.out.println("intersection point is = "+result.data);
		}else {
			System.out.println("No intersection of lists... ");
		}
	}
	
}

class Node{
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
}
