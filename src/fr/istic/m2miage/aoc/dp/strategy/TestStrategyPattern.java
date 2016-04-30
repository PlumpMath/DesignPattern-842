package fr.istic.m2miage.aoc.dp.strategy;

import org.junit.Assert;
import org.junit.Test;

public class TestStrategyPattern {
	
	@Test
	public void testCheckStrategy(){
		CheckStrategy longerThan15 = new LongerThan15();
		Assert.assertFalse(longerThan15.check("Jiyoung Park"));
		Assert.assertTrue(longerThan15.check("Jiyoung Parkdddd"));
		
		CheckStrategy startsWithCD = new StartsWithCD();
		Assert.assertFalse(startsWithCD.check("Jiyoung Park"));
		Assert.assertTrue(startsWithCD.check("cdJiyoung Park"));
	}

}
