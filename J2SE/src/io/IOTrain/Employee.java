package io.IOTrain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {

	int age;
	String name;

	Employee(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return (this.age + "\t" + this.name);
	}
}
