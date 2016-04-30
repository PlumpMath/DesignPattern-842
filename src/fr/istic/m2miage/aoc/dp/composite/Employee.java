package fr.istic.m2miage.aoc.dp.composite;
/**
* Base employee class
*/
public abstract class Employee {
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public double getSalaries() {
		return salary;
	}
	
	public abstract boolean addEmployee(Employee ... emp);
	public abstract boolean removeEmployee(Employee emp);
	protected abstract boolean hasSubordinates();
}
