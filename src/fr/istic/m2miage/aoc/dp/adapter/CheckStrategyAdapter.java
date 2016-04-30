package fr.istic.m2miage.aoc.dp.adapter;

import fr.istic.m2miage.aoc.dp.strategy.CheckStrategy;

/**
 * This is an adapter class which provides default implementations to be
 * extended not to be used and facilitates its subclasses to be adapted to each
 * other. Throws an unchecked exception to indicate improper use.
 */
public class CheckStrategyAdapter implements CheckStrategy {
	public boolean check(String word) {
		throw new RuntimeException(
				"Improper use of CheckStrategyAdapter class method check(String word)" );
	}

	public int count() {
		throw new RuntimeException(
				"Improper use of CheckStrategyAdapter class method count()");
	}

	public void reset() {
		throw new RuntimeException(
				"Improper use of CheckStrategyAdapter class method reset()");
	}

}
