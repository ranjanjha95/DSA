package com.java.singleton;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Student _instance = null;

	private Student() {
	}

	String name;
	int id;

	public static Student getObject(String name, int id) {

		if (_instance == null) {
			_instance = new Student();
			_instance.name = name;
			_instance.id = id;
		}
		return _instance;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}

}
