package fr.istic.m2miage.aoc.dp.visitor.sample;

public class Editor {
	public static void main(String[] args){
		Document d = new Document();
		d.setText("Document");
		for(int i = 0 ; i < 10 ; i ++){
			Section s = new Section("Section "+ i+1);
			d.addSection(s);
		}
		
		PrettyPrinter pp = new PrettyPrinter();
		d.accept(pp);
		
		pp.print(d);
	}
}
