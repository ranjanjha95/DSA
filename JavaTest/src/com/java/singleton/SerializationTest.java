package com.java.singleton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SerializationTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		Employee emp = new Employee("A10", 10);
		
		FileOutputStream fos = new FileOutputStream(
				"E:\\Material\\ws\\JavaTest\\src\\com\\java\\singleton\\employee.xml");

		java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos);
		xe1.writeObject(emp);
		xe1.close();
		
	}
	
}
