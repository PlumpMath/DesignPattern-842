package fr.istic.m2miage.aoc.dp.decorator.istic;

/**
 * Created by plouzeau on 2014-09-17.
 */
public class AdvancedCoffeeMachineImpl extends CoffeeMachineDecorator implements AdvancedCoffeeMachine {

    public AdvancedCoffeeMachineImpl(CoffeeMachine coffeeMachine) {
            super(coffeeMachine);
    }
    /**
     * Puts one piece of sugar in cup
     *
     * @param cup the sugar receptacle
     */
    @Override
    public void putOneSugarPieceInCup(Cup cup) {
    	cup.addSugarAmountInGrams(3.0);
    }
}
