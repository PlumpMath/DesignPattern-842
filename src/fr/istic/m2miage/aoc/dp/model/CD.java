package fr.istic.m2miage.aoc.dp.model;

import fr.istic.m2miage.aoc.dp.visitor.ItemVisitor;

public class CD extends Goods {
	private boolean isTaxed = true;
	private boolean isImported = false;

	public CD(String description, int qty, double price) {
		super(description, qty, price);
	}

	public boolean isTaxed() {
		return isTaxed;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean b) {
		isImported = b;
	}

	@Override
	public void accept(ItemVisitor visitor) {
		visitor.visit(this);
	}

	//following methods gets called by the template method
	public void addToStock() {
		//database call logic to store the book in stock table.
		System.out.println("CD added to stock : " + this.getDescription());
	}
	public void applyBarcode() {
		//logic to print and apply the barcode to book.
		System.out.println("Bar code applied to CD : " + this.getDescription());
	}
	public void markRetailPrice() {
		//logic to read retail price from the book table and apply the retail price.
		System.out.println("Mark retail price for the CD : " + this.getDescription());
	}
}
