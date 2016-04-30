package fr.istic.m2miage.aoc.dp.strategy.sample;

public class BubbleSort implements AlgoTrieur{
	private ListeTriee l;

	@Override
	public void configure(ListeTriee l) {
		this.l = l;
	}

	@Override
	public void execute() {
		System.out.println("Simulation de tri BubbleSort");
	}
}
