/* 
 * Name : Tirth Patel
 * Course : CSCI 1302
 * Description : Read a binary file and write the data to a file using binary IO
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

public class Lab11Prob01 {

	public static void main(String[] args) {

		File inputFile = new File("src/people.dat");
		File outputFile = new File("src/people-copy.dat");
		
		int age;
		String name = "";
		String address = "";
		int zipCode;
		double salary;

		try (
				DataInputStream input = new DataInputStream(
						new BufferedInputStream(
								new FileInputStream(inputFile)));
				DataOutputStream output = new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(outputFile)));

		) {
			while (true) {
				
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipCode = input.readInt();
				salary = input.readDouble();
				
				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zipCode);
				output.writeDouble(salary);
				
				System.out.print(age + " ");
				System.out.print(name + " ");
				System.out.print(address + " ");
				System.out.print(zipCode + " ");
				System.out.printf("%.2f%n", salary);
			
			}

		} catch (EOFException e) {
			
		} catch (Exception e) {
			System.out.println("Error.");
		}

	}

}
