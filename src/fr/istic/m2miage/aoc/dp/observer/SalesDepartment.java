package fr.istic.m2miage.aoc.dp.observer;

import fr.istic.m2miage.aoc.dp.model.Item;

public class SalesDepartment implements Department {
	public void update(Item item, int qty) {
		//logic to update department's stock goes here
		System.out.println("Sales has updated its stock for " + item.getDescription() +
		" with qty=" + qty);
	}

}
