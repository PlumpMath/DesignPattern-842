package fr.istic.m2miage.aoc.dp.proxy;

public class PriceListUser implements Runnable {
	int itemId;
	double price;
	static int count = 0;
	
	public PriceListUser(int itemId) {
		this.itemId = itemId;
	}
	
	/**
	* runnable code where multi-threads are executed
	*/
	public void run() {
		String name = Thread.currentThread().getName();
		if (name.equals("accessor")) {
			//price = XYZPriceList.getInstance().getPrice(itemId); //using 3 rd party commponent
			price = XYZPriceListProxy.getInstance().getPrice(itemId);
		} else if (name.equals("mutator")) {
			//XYZPriceList.getInstance().setPrice(itemId, 15.00); //using 3 rd party commponent
			XYZPriceListProxy.getInstance().setPrice(itemId, 15.00);
		}
	}

}
