package com.santosh.linkedlist;

public class MergeSortedLinkedLists {
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	// Approach
//	1. The idea is to iteratively merge two sorted linked lists using a dummy node to simplify the process.
//	2. A current pointer tracks the last node of the merged list.
//	3. We compare the nodes from both lists and append the smaller node to the merged list.
//	4. Once one list is fully traversed, the remaining nodes from the other list are appended. 
//	5. The merged list is returned starting from the node after the dummy node. 
	
	// T(C) -> O(n+m)
	// S(C) -> O(1)
	private static Node mergeSortedLists(Node list1, Node list2) {

		Node dummy = new Node(-1);
		Node tail = dummy;
		
		while(list1 != null && list2 != null) {
			if(list1.data <= list2.data) {
				tail.next = list1;
				list1 = list1.next;
				
			}else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}
		
		if(list1 != null)
			tail.next = list1;
		
		if(list2 != null)
			tail.next = list2;
		
		return dummy.next;
	}
	
	private static void printNodes(Node head) {
		Node current = head;
		while(current != null) {
			System.out.print(" "+current.data);
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		Node list1 = new Node(1);
		list1.next = new Node(3);
		list1.next.next = new Node(5);
		
		Node list2 = new Node(2);
		list2.next = new Node(4);
		list2.next.next = new Node(6);
		
		Node sortedList = mergeSortedLists(list1, list2);
		System.out.println("Sorted list  is :");
		printNodes(sortedList);
	}

}
