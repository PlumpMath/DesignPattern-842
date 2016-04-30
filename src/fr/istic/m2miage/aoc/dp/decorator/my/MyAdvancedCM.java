package fr.istic.m2miage.aoc.dp.decorator.my;

public class MyAdvancedCM extends MDecorator implements AdvancedCM{
	private int creamAmount;
	public MyAdvancedCM(CM genericM) {
		super(genericM);
	}
	
	@Override
	public void addCream(int amountInGram) {
		this.creamAmount = amountInGram;
	}

	
	@Override
	public void makeCoffee() {
		System.out.println("\nMyNewMachine!!!");
		super.makeCoffee();
		System.out.println(creamAmount + " grams Cream is added for you");
	}
	
	
	
	
}
