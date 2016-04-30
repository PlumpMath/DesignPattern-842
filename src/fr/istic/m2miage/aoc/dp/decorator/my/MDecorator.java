package fr.istic.m2miage.aoc.dp.decorator.my;

public class MDecorator implements CM {
	
	private CM genericM;
	
	public MDecorator(CM cm) {
		genericM = cm;
	}

	@Override
	public void addDomino(int amount) {
		genericM.addDomino(amount);
	}

	@Override
	public void makeCoffee() {
		genericM.makeCoffee();
	}
}
