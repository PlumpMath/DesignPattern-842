package fr.istic.m2miage.aoc.dp.composite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import fr.istic.m2miage.aoc.dp.command.Calculator;
import fr.istic.m2miage.aoc.dp.command.CalculatorCommand;
import fr.istic.m2miage.aoc.dp.command.Command;
import fr.istic.m2miage.aoc.dp.dynamicProxy.LoggingHandler;

/**
 * This is the leaf staff employee object. staff do not have any subordinates.
 */
public class Staff extends Employee {
	public Staff(String name, double salary) {
		super(name, salary);
	}
	
	////////////////implementation of abstract methods //////////////////////////
	public boolean addEmployee(Employee... emp) {
		throw new RuntimeException("Improper use of Staff class");
	}

	public boolean removeEmployee(Employee emp) {
		throw new RuntimeException("Improper use of Staff class");
	}

	protected boolean hasSubordinates() {
		return false;
	}
	//////////////////////////////////////////////
	
	private Calculator calc = new Calculator();
	private List<Command> listCommands = new ArrayList<Command>(15);
	private int current = 0;

	public Staff(String name) {
		super(name);
	}

	// ...
	/**
	 * make use of command.
	 */
//	public void compute(char operator, int operand) {
//		Command command = new CalculatorCommand(calc, operator, operand);// Initialize the calculator
//		command.execute();
//		// add commands to the list so that undo operation can be performed
//		listCommands.add(command);
//		current++;
//	}
	
	public void compute(char operator, int operand) {
		compute(false, operator, operand);
	}
	
	public void compute(boolean withLogging, char operator, int operand) {
		Command c = new CalculatorCommand(calc, operator, operand);
		if(withLogging){
			//invoke the handler, which logs and invokes the target method on the Calculator
			InvocationHandler handler = new LoggingHandler(c);
			//create a proxy
			c = (Command) Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(), handler);
		}
		compute(c);
	}
	
	private void compute(Command command){
		command.execute();
		// add commands to the list so that undo operation can be performed
		listCommands.add(command);
		current++;
	}

	/**
	 * perform redo operations
	 */
	public void redo(int noOfLevels) {
		int noOfCommands = listCommands.size();
		for (int i = 0; i < noOfLevels; i++) {
			if (current < noOfCommands) {
				((Command) listCommands.get(current++)).execute();
			}
		}
	}

	/**
	 * perform undo operations
	 */
	public void undo(int noOfLevels) {
		for (int i = 0; i < noOfLevels; i++) {
			if (current > 0) {
				((Command) listCommands.get(--current)).unexecute();
			}
		}
	}
}
