package fr.istic.m2miage.aoc.dp.decorator.my;

public class BasicM implements CM{
	private int dominoAmount = 0;
	@Override
	public void addDomino(int amount) {
		dominoAmount+=amount;
	}
	@Override
	public void makeCoffee() {
		System.out.println("Take your coffee with " + dominoAmount +" dominos");
	}
}
