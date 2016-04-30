package fr.istic.m2miage.aoc.dp.model;

public class Tax {

	// stay away from hard coding values. Define constants or read from a
	// “.properties” file
	public static final double SALES_TAX = 0.10; // 10%
	public static final double IMPORT_TAX = 0.05; // 5%
	private double salesTax = 0.0;
	private double importTax = 0.0;

	public void calculate(boolean isTaxable, boolean isImported, double price) {
		if (isTaxable) {
			salesTax = price * SALES_TAX;
		}
		if (isImported) {
			importTax = price * IMPORT_TAX;
		}
	}

	public double getTotalUnitTax() {
		return this.salesTax + this.importTax;
	}

}
