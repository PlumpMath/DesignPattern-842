package fr.istic.m2miage.aoc.dp.decorator.istic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMachineTest {
	private AdvancedCoffeeMachine advancedCoffeeMachine;
    private CoffeeMachine sampleCoffeeMachine;
    private Cup sampleCup;

    @Before
    public void setUp() throws Exception {

        sampleCoffeeMachine = new BasicCoffeeMachine();
        advancedCoffeeMachine = new AdvancedCoffeeMachineImpl(sampleCoffeeMachine);
    }

    @Test
    public void testProvideCup() throws Exception {
        sampleCup = sampleCoffeeMachine.provideCup();
        Assert.assertEquals(10.0, sampleCup.getCapacityInCm3(),10.0e-5);
        Assert.assertEquals(0.0, sampleCup.getSugarAmountInGrams(),10.0e-5);
    }

@Test
public void testPourCoffee() throws Exception {
	sampleCup = sampleCoffeeMachine.provideCup();
	advancedCoffeeMachine = new AdvancedCoffeeMachineImpl(sampleCoffeeMachine);
	advancedCoffeeMachine.putOneSugarPieceInCup(sampleCup);// 3 grams sugar added
	Assert.assertEquals(10.0, sampleCup.getCapacityInCm3(),10.0e-5);
	Assert.assertEquals(3.0, sampleCup.getSugarAmountInGrams(),10.0e-5);
}
}