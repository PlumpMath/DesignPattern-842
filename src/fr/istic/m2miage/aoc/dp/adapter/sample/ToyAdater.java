package fr.istic.m2miage.aoc.dp.adapter.sample;

public class ToyAdater implements NewToyInterface{
	
    OldToyInterface oldtype;
    // 구모델을 생성자를 통해 받음
    public ToyAdater(OldToyInterface oldtype) {
        this.oldtype = oldtype;
    }
     
    @Override
    public void use() {
        oldtype.use();
    }
 
    // 구모델 충전 타입을 USB로 전환 후 충전 함.
    @Override
    public void onUSBCharge() {
        System.out.println(oldtype.getName() + " --> change USB MODE !!");
        oldtype.onPlug();
    }
 
    @Override
    public String getName() {
        return oldtype.getName();
    }

}
