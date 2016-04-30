package fr.istic.m2miage.aoc.dp.decorator;

import fr.istic.m2miage.aoc.dp.adapter.CheckStrategyAdapter;
import fr.istic.m2miage.aoc.dp.strategy.CheckStrategy;

public class CountDecorator extends CheckStrategyAdapter {
	private CheckStrategy cs = null;
	private int count = 0;

	public CountDecorator(CheckStrategy cs) {
		this.cs = cs;
	}

	public boolean check(String description) {
		boolean isFound = cs.check(description);
		if (isFound)
			this.count++;
		return isFound;
	}

	public int count() {
		return this.count;
	}

	public void reset() {
		this.count = 0;
	}
}
