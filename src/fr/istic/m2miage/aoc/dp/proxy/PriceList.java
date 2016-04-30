package fr.istic.m2miage.aoc.dp.proxy;

public interface PriceList {
	public double getPrice(int itemId) ;
	public void setPrice(int itemId,double newPrice) ;
}
