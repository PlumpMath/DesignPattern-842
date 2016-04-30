package fr.istic.m2miage.aoc.dp.observer;

import fr.istic.m2miage.aoc.dp.model.Item;
/**
* This is an observer (aka subscriber) interface. This gets notified through its update method.
*/
public interface Department {
	public void update(Item item, int qty);
}
