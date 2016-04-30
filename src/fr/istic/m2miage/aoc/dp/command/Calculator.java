package fr.istic.m2miage.aoc.dp.command;

public class Calculator {
	private int total = 0;

	/**
	 * calculates.
	 */
	public void calculate(char operator, int operand) {
		switch (operator) {
		case '+':
			total += operand;
			break;
		case '-':
			total -= operand;
			break;
		}
		System.out.println("Total = " + total);
	}
}
