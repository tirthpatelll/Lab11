/* 
 * Name : Tirth Patel
 * Course : CSCI 1302
 * Description : Define a Person class.
 * Last Modified : April 27 2024
 */

import java.io.Serializable;

public class Person implements Comparable, Serializable {
	
	// data members
	private int age;
	private String name = "";
	private String address = "";
	private int zipCode;
	private double salary;
	
	public Person() {
		this(0, "", "", 0, 0);
	}
	
	public Person(int age, String name, String address, int zipCode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);;
		setZipCode(zipCode);
		setSalary(salary);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Object o) {
		if (this.salary > ((Person)o).salary) {
			return 1;
		} else if (this.salary < ((Person)o).salary) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %d $%,.2f", getAge(), getName(), getAddress(), getZipCode(), getSalary());
	}
	
}
