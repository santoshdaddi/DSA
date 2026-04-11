package com.santosh.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectAndRemoveCycleLinkedList {

	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data  = data;
			this.next = null;
		}
	}
	
	static Node detectCyle(Node head) {
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			Node cycle = slow;
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				System.out.println("cycle detected at = "+cycle.data);
				return slow;
			}
		}
		return null;
	}
	
	private static void removeCycle(Node head) {
		Node meetingPoint = detectCyle(head);
		
		if(meetingPoint == null) {
			System.out.println("There is no cycle exists");
			return;
		}
		System.out.println("meetingPoint is "+meetingPoint.data);
		Node ptr1= head;
		Node ptr2 = meetingPoint;
		
		while(ptr1 != ptr2) {
			ptr1= ptr1.next;
			ptr2= ptr2.next;
		}
		
		//cycle has found at ptr1
		Node cycleStart = ptr1;
		
		//find last node in cycle using temp Node
		Node temp = cycleStart;
		while(temp.next != cycleStart) {
			temp = temp.next;
		}
		
		//break the cycle
		temp.next = null;
		
	}
	
	private static void printNodes(Node head) {
		Node current = head;
		while(current != null) {
			System.out.print(" "+current.data);
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		
		//create cycle
		head.next.next.next.next.next = head.next.next; 
		
		removeCycle(head);
//		detectAndRemoveCycleUsingRecursion(head,null, new HashSet<>());
		printNodes(head);

	}
	
	private static boolean detectAndRemoveCycleUsingRecursion(Node current, Node previous, Set<Node> set) {
		
		if(current == null) {
			return false;
		}
		
		if(set.contains(current)) {
			previous.next = null;
			return true;
		}
		
		set.add(current);
		
		return detectAndRemoveCycleUsingRecursion(current.next, current, set);
	}

}
