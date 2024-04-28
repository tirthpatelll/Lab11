/* 
 * Name : Tirth Patel
 * Course : CSCI 1302
 * Description : Read data from a file and sort it and write to a file using binary IO
 * Last Modified : April 27 2024
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {

	public static void main(String[] args) {

		File inputFile = new File("src/people.dat");
		File outputFile = new File("src/people-salary-sorted.dat");
		
		int age;
		String name = "";
		String address = "";
		int zipCode;
		double salary;
		
		ArrayList<Person> people = new ArrayList<>();

		try (
				DataInputStream input = new DataInputStream(
						new BufferedInputStream(
								new FileInputStream(inputFile)));
				DataOutputStream output = new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(outputFile)));
		) {
			while (input.available() > 0) {
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipCode = input.readInt();
				salary = input.readDouble();
				Person temp = new Person(age, name, address, zipCode, salary);
				people.add(temp);
			}
			Collections.sort(people, Collections.reverseOrder());
			
			for (Person p : people) {
				output.writeUTF(p.toString());
			}
			

		} catch (EOFException e) {

		} catch (Exception e) {
			System.out.println("Error.");
		}
	}

}
