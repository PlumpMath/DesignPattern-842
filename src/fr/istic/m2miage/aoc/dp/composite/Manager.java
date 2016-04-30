package fr.istic.m2miage.aoc.dp.composite;

import java.util.ArrayList;
import java.util.List;

/**
* This is the Employee composite class having subordinates.
*/
public class Manager extends Employee {
	List<Employee> subordinates = null;

	public Manager(String name, double salary) {
		super(name, salary);
	}

	//////////////// implementation of abstract methods //////////////////////////
	public boolean addEmployee(Employee ... emp) {
		if (subordinates == null) {
			subordinates = new ArrayList<Employee>(10);
		}
		for(Employee e : emp)
			subordinates.add(e);
		return true;
	}

	public boolean removeEmployee(Employee emp) {
		if (subordinates == null) {
			subordinates = new ArrayList<Employee>(10);
		}
		return subordinates.remove(emp);
	}
	
	public boolean hasSubordinates() {
		boolean hasSubOrdinates = false;
		if (subordinates != null && subordinates.size() > 0) {
			hasSubOrdinates = true;
		}
		return hasSubOrdinates;
	}
	//////////////////////////////////////////////
	/**
	 * Recursive method call to calculate the sum of salary of a manager and his
	 * subordinates, which means sum of salary of a manager on whom this method
	 * was invoked and any employees who themselves will have any subordinates
	 * and so on.
	 */
	public double getSalaries() {
		double sum = super.getSalaries(); // this one's salary
		if (this.hasSubordinates()) {
			for (int i = 0; i < subordinates.size(); i++) {
				sum += ((Employee) subordinates.get(i)).getSalaries();
			}
		}
		return sum;
	}



}
