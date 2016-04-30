package fr.istic.m2miage.aoc.dp.iterator;

import fr.istic.m2miage.aoc.dp.model.Item;

public interface ItemIterator {
	public Item nextItem();
	public Item previousItem();
	public Item currentItem();
	public Item firstItem();
	public Item lastItem();
	public boolean isDone();
	public void setStep(int step);
}
