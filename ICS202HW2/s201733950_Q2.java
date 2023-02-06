package ICS202HW2;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import ICS202HW2.LinkedList2.Node;

public class s201733950_Q2 {
	public static void main(String args[]) throws Exception {
        if (args.length < 2) {
            System.out.print("there is no input or outbout file in command line\n");
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];
        Scanner s = new Scanner(new File(inputFile));
        FileWriter out = new FileWriter(new File(outputFile));
        int n = s.nextInt();
        s.nextLine();
        Node list = null;
        Node head = null, href = null, tail = null;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            if (list == null) {
                list = new Node(num);
                head = list;
                href = head;
                tail = list;
                prev = num;
            } else {
                Node newNode = new Node(num);
                if (num % 2 == 0 && prev % 2 == 0) {
                    if (href.data % 2 != 0) {
                        newNode.next = href.next;
                        href.next = newNode;
                    } else { 
                        newNode.next = href;
                        href = newNode;
                        head = href;
                    }
                } else { 
                    tail.next = newNode;
                    href = tail;
                    tail = tail.next;
                }
                prev = num;
            }
        }
        Node curr = head;
        while (curr != null) {
            out.write(curr.data + " ");
            curr = curr.next;
        }
        System.out.println("check the output file "+outputFile);
        
        out.close();
    }
	


}
