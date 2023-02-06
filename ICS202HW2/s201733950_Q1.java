//Ali alkhimayes
//201733950
package ICS202HW2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class s201733950_Q1{
	public static void main(String[] args) throws Exception {

		if (args.length < 2) {
            System.out.print("there is no input or outbout file in command line\n");
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];
        Scanner sc = new Scanner(new File(inputFile));
        FileWriter out = new FileWriter(new File(outputFile));
        String n = sc.nextLine();
        
		LinkedList<Integer> list = new LinkedList();
		
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter Integers List: ");
		String[] numbers = n.split(" ");
		for (String number : numbers) {
			try {
				list.insert(Integer.parseInt(number));
			} catch (Exception e) {
				System.out.println("Number format exception");
			}
		}
		//System.out.print("insert number of lines: ");
		int lines = sc.nextInt();
		//sc.nextLine();
		for (int i = 0; i < lines+1; i++) {
			String line = sc.nextLine();
			int newElem;
			int existingElem;
			String operation = line.split(" ")[0];
			switch (operation) {
			case "ia":
				newElem = Integer.parseInt(line.split(" ")[1]);
				existingElem = Integer.parseInt(line.split(" ")[2]);
				int done1 = list.insertAfter(newElem, existingElem);
				if (done1 ==1 )
				list.printToFile(out);
				else {
					out.write("-1\n");
					}
				break;
			case "ib":
				newElem = Integer.parseInt(line.split(" ")[1]);
				existingElem = Integer.parseInt(line.split(" ")[2]);
				int done2 = list.insertBefore(newElem, existingElem);
				if (done2 ==1 )
					list.printToFile(out);
					else {
						out.write("-1\n");
						}
				break;
			case "db":
				existingElem = Integer.parseInt(line.split(" ")[1]);
				int done3 = list.deleteBefore(existingElem);
				if (done3 ==1 )
					list.printToFile(out);
					else {
						out.write("-1\n");
						}
				break;
				
			}				

		} 
		
		out.close();
	}
}

