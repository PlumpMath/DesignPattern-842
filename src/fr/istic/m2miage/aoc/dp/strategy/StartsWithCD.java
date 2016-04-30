package fr.istic.m2miage.aoc.dp.strategy;

import fr.istic.m2miage.aoc.dp.adapter.CheckStrategyAdapter;

public class StartsWithCD extends CheckStrategyAdapter {
	public static final String STARTS_WITH = "cd";

	public boolean check(String description) {
		String s = description.toLowerCase();
		if (description == null || description.length() == 0)
			return false;
		else
			return s.startsWith(STARTS_WITH);
	}
}
