package fr.istic.m2miage.aoc.dp.strategy;

import fr.istic.m2miage.aoc.dp.adapter.CheckStrategyAdapter;

public class LongerThan15 extends CheckStrategyAdapter {
	public static final int LENGTH = 15; // constant

	public boolean check(String description) {
		if (description == null)
			return false;
		else
			return description.length() > LENGTH;
	}
}
