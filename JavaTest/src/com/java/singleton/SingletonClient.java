package com.java.singleton;

import java.io.FileOutputStream;
import java.io.IOException;

public class SingletonClient {

	public static void main(String[] args) throws IOException {

		Student student = Student.getObject("A10", 10);
		System.out.println(student);

		FileOutputStream fos = new FileOutputStream(
				"E:\\Material\\ws\\JavaTest\\src\\com\\java\\singleton\\student.xml");

		/*
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * oos.writeObject(student); oos.flush();
		 */

		java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos);
		xe1.writeObject(student);
		xe1.close();

	}

}
