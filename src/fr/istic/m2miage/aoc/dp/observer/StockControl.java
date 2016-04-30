package fr.istic.m2miage.aoc.dp.observer;

import fr.istic.m2miage.aoc.dp.model.Item;

/**
* Subject (publisher) class: when stock is updated, notifies all the
* subscribers.
*/
public interface StockControl {
	public void notify(Item item, int qty);
	public void updateStock(Item item, int qty) ;
	public boolean addSubscribers(Department dept);
	public boolean removeSubscribers(Department dept);
}
