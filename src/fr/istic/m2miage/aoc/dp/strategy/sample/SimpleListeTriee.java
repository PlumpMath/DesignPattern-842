package fr.istic.m2miage.aoc.dp.strategy.sample;


public class SimpleListeTriee implements ListeTriee{
	private float[] contenu;
	public SimpleListeTriee(int n) {
		contenu = new float[n];
	}
	@Override
	public float getItem(int n) {
		return this.contenu[n];
	}

	@Override
	public void setItem(int n, float v) {
		this.contenu[n] = v;
	}

	@Override
	public void sort() {
		AlgoTrieur unAlgo;
		// Choix de l'algo
		if(contenu.length < 100){
			unAlgo = new BubbleSort();
		}else{
			unAlgo = new QuickSort();
		}
		unAlgo.configure(this);
		unAlgo.execute();
	}

}
