package fr.istic.m2miage.aoc.dp.model;
/**
* abstract parent class, which promotes code reuse for all the subclasses
* like Book , CD , and Cosmetics . implements interface Item to
* promote design principle code to interface not to an implementation.
*/
public abstract class Goods implements Item {
	// define attributes
	private String description;
	private int qty;
	private double price;
	private Tax tax = new Tax();

	public Goods(String description, int qty, double price) {
		this.description = description;
		this.qty = qty;
		this.price = price;
	}

	protected abstract boolean isTaxed();

	protected abstract boolean isImported();

	public double getExtendedTax() {
		tax.calculate(isTaxed(), isImported(), price);
		return this.tax.getTotalUnitTax() * qty;
	}

	public double getExtendedTaxPrice() throws ItemException {
		if (tax == null) {
			throw new ItemException("Tax should be calculated first:");
		}
		return qty * (this.tax.getTotalUnitTax() + price);
	}

	// getters and setters go here for attributes like description etc
	public String getDescription() {
		return description;
	}

	public String toString() {
		return qty + " " + description + " : ";
	}
	
	/**
	* The template method
	*/
	public void prepareItemForRetail() {
		addToStock();
		applyBarcode();
		markRetailPrice();
	}
	
	public abstract void addToStock();
	public abstract void applyBarcode();
	public abstract void markRetailPrice();
}
