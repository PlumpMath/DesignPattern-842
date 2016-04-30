package fr.istic.m2miage.aoc.dp.composite.example;

/**
 * In this class,there are many methods which are not applicable to developer
 * because it is a leaf node.
 */

public class Developer implements Employee {

	private String name;
	private double salary;

	public Developer(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public void add(Employee employee) {
		throw new RuntimeException("Improper use of Developer class");
	}

	public Employee getChild(int i) {
		throw new RuntimeException("Improper use of Developer class");
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void print() {
		System.out.println("-------------");
		System.out.println("Name =" + getName());
		System.out.println("Salary =" + getSalary());
		System.out.println("-------------");
	}

	public void remove(Employee employee) {
		throw new RuntimeException("Improper use of Developer class");
	}

}