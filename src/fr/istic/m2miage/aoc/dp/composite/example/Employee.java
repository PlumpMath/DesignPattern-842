package fr.istic.m2miage.aoc.dp.composite.example;

public interface Employee {
	public void add(Employee employee);

	public void remove(Employee employee);

	public Employee getChild(int i);

	public String getName();

	public double getSalary();

	public void print();
}
