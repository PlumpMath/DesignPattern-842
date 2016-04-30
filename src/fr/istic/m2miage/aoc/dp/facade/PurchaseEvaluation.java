package fr.istic.m2miage.aoc.dp.facade;

import fr.istic.m2miage.aoc.dp.model.Item;
/**
 * This is the facade class
*/
public class PurchaseEvaluation {
	
	private StockControl stockControl = new StockControl();
	private WholeSaler wholeSaler = new WholeSaler();
	private Bank bank = new Bank();

	public boolean shouldWePlaceOrder(Item item) {
		if (!stockControl.isBelowReorderpoint(item)) {
			return false;
		}
		if (!wholeSaler.hasSufficientStock(item)) {
			return false;
		}
		if (!bank.hasSufficientFunds()) {
			return false;
		}
		return true;
	}
}
