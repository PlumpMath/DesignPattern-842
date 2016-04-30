package fr.istic.m2miage.aoc.dp.strategy;

public interface CheckStrategy {
	public boolean check(String word);
	public int count();
	public void reset();
}
