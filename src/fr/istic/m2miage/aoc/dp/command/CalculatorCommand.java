package fr.istic.m2miage.aoc.dp.command;

public class CalculatorCommand implements Command {
	private Calculator calc = null;
	private char operator;
	private int operand;

	public CalculatorCommand(Calculator calc, char operator, int operand) {
		this.calc = calc;
		this.operator = operator;
		this.operand = operand;
	}

	public void execute() {
		calc.calculate(operator, operand);
	}

	public void unexecute() {
		calc.calculate(undoOperand(operator), operand);
	}

	private char undoOperand(char operator) {
		char undoOperator = ' ';
		switch (operator) {
		case '+':
			undoOperator = '-';
			break;
		case '-':
			undoOperator = '+';
			break;
		}
		return undoOperator;
	}

}
