package fr.istic.m2miage.aoc.dp.model;

import fr.istic.m2miage.aoc.dp.visitor.ItemVisitor;

public interface Item {
	public static final int TYPE_BOOK = 1;
	public static final int TYPE_CD = 2;
	public static final int TYPE_COSMETICS = 3;
	public static final int TYPE_CD_IMPORTED = 4;
	public double getExtendedTax();
	double getExtendedTaxPrice() throws ItemException;
	void setImported(boolean b);
	String getDescription();
	public void accept(ItemVisitor visitor);
	public void prepareItemForRetail();
}
