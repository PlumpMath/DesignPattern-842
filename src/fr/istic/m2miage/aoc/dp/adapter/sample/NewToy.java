package fr.istic.m2miage.aoc.dp.adapter.sample;
//신모델 장난감
public class NewToy implements NewToyInterface {
    private String myName = "";
 
    public NewToy(String myName) {
        this.myName = myName;
    }
 
    @Override
    public void use() {
    	System.out.println("we use " + myName);
    }
 
    // 신모델은 USB를 통해 충전 합니다.
    @Override
    public void onUSBCharge() {
        System.out.println(myName+" : on USB charge");
    }
     
    @Override
    public String getName() {
        return myName;
    }

}
