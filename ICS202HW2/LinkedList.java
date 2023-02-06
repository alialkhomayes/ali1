//Ali alkhimayes
//201733950
package ICS202HW2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;



public class LinkedList<T> {
	
	Node head;
	class Node {
		T data;
		Node next;

		Node(T d) {
			data = d;
			next = null;
			}
		}

	public void insert(T data) {
		Node new_node = new Node(data);
		new_node.next = null;
		if (head == null) {
			head = new_node;
			} else {
				Node last = head;
				while (last.next != null) {
					last = last.next;
					}
				last.next = new_node;
				}
	}

	public int insertBefore(T newElem, T existingElem) {
		Node current = head;
		if (head.data == existingElem) {
			Node n = new Node(newElem);
			n.next = head;
			head = n;
			return 1;
			}

		while (current.next != null) {
			if (current.next.data == existingElem) {
				Node n = new Node(newElem);
				n.next = current.next;
				current.next = n;
				return 1;
				}
			current = current.next;
			}
		return -1;
		}

	public int insertAfter(T newElem, T existingElem) throws IOException {
		Node current = head;
		while (current != null) {
			if (current.data == existingElem) {
				Node n = new Node(newElem);
				n.next = current.next;
				current.next = n;
				return 1;
				}
			current = current.next;
			}
		return -1;
		}
	public int deleteBefore(T existingElem) {
		Node current = head;
		if (head.next.data == existingElem) {
			head = head.next;
			return 1;
			}

		while (current.next != null) {
			if (current.next.next.data == existingElem) {
				Node n = current.next.next;
				current.next = n;
				return 1;
			}
			current = current.next;
			}
		return -1;
		}
	
	public void printList() {
		Node currNode = head;
		System.out.print("the list is : ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
			}
		}
	
	public void printToFile(FileWriter f ) {
		Node currNode = head;
		while (currNode != null) {
			try {
				f.write(currNode.data + " ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currNode = currNode.next;
			} 	
		
		try {
				f.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	



		
	
}

