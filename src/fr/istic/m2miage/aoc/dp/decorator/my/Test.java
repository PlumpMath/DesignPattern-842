package fr.istic.m2miage.aoc.dp.decorator.my;

public class Test {
	public static void main(String[] args){
		CM basicM = new BasicM();
		basicM.addDomino(1);
		basicM.makeCoffee();
		
		AdvancedCM newM = new MyAdvancedCM(basicM);
		newM.addCream(10);
		newM.makeCoffee();
		
	}
}
