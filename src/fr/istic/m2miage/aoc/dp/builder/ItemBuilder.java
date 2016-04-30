package fr.istic.m2miage.aoc.dp.builder;

import java.util.Iterator;

import fr.istic.m2miage.aoc.dp.iterator.ItemIterator;
import fr.istic.m2miage.aoc.dp.model.Item;
import fr.istic.m2miage.aoc.dp.model.ItemException;
import fr.istic.m2miage.aoc.dp.model.ItemType;

public interface ItemBuilder {
	public void buildBasket(ItemType itemType, String description, int qty, double unit_price)
			throws ItemException;
			
	public double calculateTotalTax() throws ItemException;
	public double calculateTotal() throws ItemException;
	public void printExtendedTaxedPrice() throws ItemException;
	public Iterator<Item> getIterator();
	public ItemIterator getItemIterator();
}
