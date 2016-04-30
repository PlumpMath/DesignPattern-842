package fr.istic.m2miage.aoc.dp.factory;

import fr.istic.m2miage.aoc.dp.model.Item;
import fr.istic.m2miage.aoc.dp.model.ItemException;
import fr.istic.m2miage.aoc.dp.model.ItemType;
/**
* ItemFactory is responsible for creating Item objects like CD, Book, and Cosmetics etc
*/
public interface ItemFactory {
	public Item getItem(ItemType itemType, String description, int qty, double price)
			throws ItemException;
}
