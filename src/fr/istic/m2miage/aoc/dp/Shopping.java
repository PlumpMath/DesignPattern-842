package fr.istic.m2miage.aoc.dp;

import java.util.Iterator;

import fr.istic.m2miage.aoc.dp.builder.ItemBuilder;
import fr.istic.m2miage.aoc.dp.builder.ShoppingBasketBuilder;
import fr.istic.m2miage.aoc.dp.composite.Employee;
import fr.istic.m2miage.aoc.dp.composite.Manager;
import fr.istic.m2miage.aoc.dp.composite.Staff;
import fr.istic.m2miage.aoc.dp.decorator.CountDecorator;
import fr.istic.m2miage.aoc.dp.facade.PurchaseEvaluation;
import fr.istic.m2miage.aoc.dp.iterator.ItemIterator;
import fr.istic.m2miage.aoc.dp.model.Book;
import fr.istic.m2miage.aoc.dp.model.CD;
import fr.istic.m2miage.aoc.dp.model.Item;
import fr.istic.m2miage.aoc.dp.model.ItemException;
import fr.istic.m2miage.aoc.dp.model.ItemType;
import fr.istic.m2miage.aoc.dp.observer.Department;
import fr.istic.m2miage.aoc.dp.observer.LogisticsDepartment;
import fr.istic.m2miage.aoc.dp.observer.SalesDepartment;
import fr.istic.m2miage.aoc.dp.observer.StockControl;
import fr.istic.m2miage.aoc.dp.observer.XYZStockControl;
import fr.istic.m2miage.aoc.dp.proxy.PriceListUser;
import fr.istic.m2miage.aoc.dp.strategy.CheckStrategy;
import fr.istic.m2miage.aoc.dp.strategy.LongerThan15;
import fr.istic.m2miage.aoc.dp.strategy.StartsWithCD;
import fr.istic.m2miage.aoc.dp.visitor.GoodsLabellingVisitor;
import fr.istic.m2miage.aoc.dp.visitor.ItemVisitor;

public class Shopping {
	/**
	 * Class with main(String[] args) method which initially gets loaded by the
	 * class loader. Subsequent classes are loaded as they are referenced in the
	 * program.
	 */
	public static void main(String[] args) throws ItemException {
		Shopping shopping = new Shopping();
		ItemBuilder builder = new ShoppingBasketBuilder();
		shopping.builderPattern(builder, "SINGLETON, FACTORY, BUILDER PATTERN");
		shopping.decoratorPattern(builder, "DECORATOR PATTERN");
		shopping.visitorPattern(builder, "VISITOR PATTERN");
		shopping.iteratorPattern(builder, "ITERATOR PATTERN");
		shopping.templateMethodPattern(builder, "TEMPLATE METHOD PATTERN");
		shopping.compositePattern(builder, "COMPOSITE PATTERN");
		shopping.facadePattern(builder, "FACADE PATTERN");
		shopping.observerPattern(builder, "OBSERVER PATTERN");
		shopping.commandPattern(builder, "COMMAND PATTERN");
		shopping.dynamicProcxyPattern(builder, "DYNAMIC PROXY PATTERN");
		shopping.proxyPattern(builder, "PROXY PATTERN");
	}
	
	private void dynamicProcxyPattern(ItemBuilder builder, String title) {
		printTitle(title);
		Staff stockControlStaff = new Staff("Vincent Chou");
		
		System.out.println("==============Without dynamic proxy=============");
		stockControlStaff.compute('+',10);//10
		System.out.println("===============With dynamic proxy================");
		stockControlStaff.compute(true,'+',10);//10
	}

	private void proxyPattern(ItemBuilder builder, String title) {
		printTitle(title);
		System.out.println("---------------Accessing the price list---------------------------");
		PriceListUser user1 = new PriceListUser(1);//accessing same itemId=1
		PriceListUser user2 = new PriceListUser(1);//accessing same itemId=1
		Thread t1 = new Thread(user1);
		Thread t2 = new Thread(user2);
		Thread t3 = new Thread(user1);
		t1.setName("accessor");//user 1 reads the price
		t2.setName("mutator");//user 2 modifies the price
		t3.setName("accessor");//user 1 reads the price
		t1.start(); // accessor user-1 reads before mutator user-2 modifies the price as 12.00
		t2.start(); // mutator user-2 sets the price to 15.00
		t3.start(); // while the user-2 is setting the price to 15.00 user-1 reads again and gets the
		// price as 12.00
		//user-2 gets the wrong price i.e gets 12.0 again instead of 15.00
	}

	private void commandPattern(ItemBuilder builder, String title) {
		printTitle(title);
		System.out.println("------------Calculator with redo & undo operations-----------------------");
		Staff stockControlStaff = new Staff("Vincent Chou");
		stockControlStaff.compute('+',10);//10
		stockControlStaff.compute('-',5);//5
		stockControlStaff.compute('+',10);//15
		stockControlStaff.compute('-',2);//13
		//lets try our undo operations
		System.out.println("---------------undo operation : 1 level---------------------------");
		stockControlStaff.undo(1);
		System.out.println("---------------undo operation : 2 levels---------------------------");
		stockControlStaff.undo(2);
		//lets try our redo operations
		System.out.println("---------------redo operation : 2 levels---------------------------");
		stockControlStaff.redo(2);
		System.out.println("---------------redo operation : 1 level---------------------------");
		stockControlStaff.redo(1);
	}

	private void observerPattern(ItemBuilder builder, String title) {
		printTitle(title);
		Department deptLogistics = new LogisticsDepartment(); // observer/subscriber
		Department salesLogistics = new SalesDepartment(); // observer/subscriber
		StockControl stockControl = new XYZStockControl();// observable/publisher subject
		// let's register subscribers with the publisher
		stockControl.addSubscribers(deptLogistics);
		stockControl.addSubscribers(salesLogistics);
		// let's update the stock value of the publisher
		ItemIterator itemIterator = builder.getItemIterator();
		Item item = null;
		for (item = itemIterator.firstItem(); !itemIterator.isDone(); item = itemIterator.nextItem()) {
			if (item instanceof CD) {
				stockControl.updateStock(item, 25);
			} else if (item instanceof Book) {
				stockControl.updateStock(item, 40);
			} else {
				stockControl.updateStock(item, 50);
			}
		}
	}

	private void facadePattern(ItemBuilder builder, String title) {
		printTitle(title);
		
		ItemIterator itemIterator = builder.getItemIterator();
		Item item = null;
		PurchaseEvaluation purchaseEval = new PurchaseEvaluation();
		for (item = itemIterator.firstItem(); !itemIterator.isDone(); item = itemIterator.nextItem()) {
			boolean shouldWePlaceOrder = purchaseEval.shouldWePlaceOrder(item);
			System.out.println("shouldWePlaceOrder of "+ item.getDescription() +" => " + shouldWePlaceOrder);
		}
	}

	private void compositePattern(ItemBuilder builder, String title) {
		printTitle(title);
		//Employee hierachy & getSalaries() recursively
		//Employee hierachy
		Employee generalManager = new Manager("John Smith", 100000.00);
		Employee salesManger = new Manager("Peter Rodgers", 80000.00);
		Employee logisticsManger = new Manager("Graham anthony", 90000.00);
		Employee staffSales1 = new Staff("Lisa john", 40000.00);
		Employee staffSales2 = new Staff("Pamela watson", 50000.00);
		salesManger.addEmployee(staffSales1, staffSales2);
		Employee logisticsTeamLead = new Manager("Cooma kumar", 70000.00);
		Employee staffLogistics1 = new Staff("Ben Sampson", 60000.00);
		Employee staffLogistics2 = new Staff("Vincent Chou", 20000.00);
		logisticsTeamLead.addEmployee(staffLogistics1, staffLogistics2);
		logisticsManger.addEmployee(logisticsTeamLead);
		generalManager.addEmployee(salesManger, logisticsManger);
		
		System.out.println(staffSales1.getName() + "-->" + staffSales1.getSalaries());
		System.out.println(staffSales2.getName() + "-->" + staffSales2.getSalaries());
		System.out.println("Logistics dept " + " --> " + logisticsManger.getSalaries());
		System.out.println("General Manager " + " --> " + generalManager.getSalaries());
	}

	private void templateMethodPattern(ItemBuilder builder, String title) {
		printTitle(title);
		Item item = null;
		ItemIterator itemIterator = builder.getItemIterator();
		for (item = itemIterator.firstItem(); !itemIterator.isDone(); item = itemIterator.nextItem()) {
			item.prepareItemForRetail();
			System.out.println("-----------------------------------");
		}
	}

	private void visitorPattern(ItemBuilder builder, String title) {
		printTitle(title);
		Iterator<Item> it = builder.getIterator();
		it = builder.getIterator();
		ItemVisitor visitor = new GoodsLabellingVisitor ();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			item.accept(visitor);
		}
	}

	private void decoratorPattern(ItemBuilder builder, String title)throws ItemException {
		printTitle(title);
		Iterator<Item> it = builder.getIterator();
		boolean bol = false;
		CheckStrategy strategy = null;
		it = builder.getIterator();
		//for starting with CD
		strategy = new StartsWithCD();
		strategy = new CountDecorator(strategy);
		printTitle("Description satarting with cd");
		while (it.hasNext()) {
			Item item = (Item) it.next();
			bol = strategy.check(item.getDescription());
			System.out.println(item.getDescription() + " --> " + bol);
		}
		//System.out.println("No of descriptions starts with CD -->" + ((CountDecorator) strategy).count());
		System.out.println("No of descriptions starts with CD -->" + strategy.count());
		it = builder.getIterator();
		
		//longer than 15 charecters
		strategy = new LongerThan15();
		strategy = new CountDecorator(strategy);
		printTitle("Description longer than 15 characters");
		while (it.hasNext()) {
			Item item = (Item) it.next();
			bol = strategy.check(item.getDescription());
			System.out.println(item.getDescription() + " --> " + bol);
		}
		//System.out.println("No of descriptions longer than 15 characters -->" + ((CountDecorator) strategy).count());
		System.out.println("No of descriptions longer than 15 characters -->" + strategy.count());
	}

	private void builderPattern(ItemBuilder builder, String title) throws ItemException{
		printTitle(title);
		// ------creational patterns: singleton, factory method and builder
		// design patterns------
		printTitle("Create a shopping basket with items");
		// Shopping basket using the builder pattern
		// build basket of items using a builder pattern
		builder.buildBasket(ItemType.BOOK, "Book - IT", 1, 12.00);
		builder.buildBasket(ItemType.CD, "CD - JAZZ", 1, 15.00);
		builder.buildBasket(ItemType.COSMETICS, "Cosmetics - Lipstick", 1, 1.0);
		// let’s print prices and taxes of this built basket
		double totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
		System.out.println("Sales Taxes: " + totalTax);
		System.out.println("Grand Total: " + builder.calculateTotal());
		printTitle("After adding an imported CD to the basket");
		// Say now customer decides to buy an additional imported CD
		builder.buildBasket(ItemType.CD_IMPORTED, "CD - JAZZ IMPORTED", 1, 15.00);
		// lets print prices and taxes of this built basket with imported CD added
		totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
		System.out.println("Sales Taxes: " + totalTax);
		System.out.println("Grand Total: " + builder.calculateTotal());
	}

	private void iteratorPattern(ItemBuilder builder, String title) throws ItemException {
		printTitle(title);
		//Iterator pattern example, inner implementations of ShopingBasketBuilder is protected.
		ItemIterator itemIterator = builder.getItemIterator();
		//say we want to traverse through every second item in the basket
		itemIterator.setStep(2);
		Item item = null;
		for (item = itemIterator.firstItem(); !itemIterator.isDone(); item = itemIterator.nextItem()) {
			System.out.println("nextItem:" + item.getDescription() + "==>" + item.getExtendedTaxPrice());
		}
		item = itemIterator.lastItem();
		System.out.println("lastItem: " + item.getDescription() + "==> " + item.getExtendedTaxPrice());
		
	}
	
	private void printTitle(String str){
		System.out.println("\n----- "+ str +" ----");
	}
}
