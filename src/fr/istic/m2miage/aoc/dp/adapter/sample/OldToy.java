package fr.istic.m2miage.aoc.dp.adapter.sample;
//구모델 장난감
public class OldToy implements OldToyInterface{
    private String myName = "";
     
    public OldToy(String myName) {
        this.myName = myName;
    }
     
    @Override
    public void use() {
        System.out.println("we use " + myName);
    }
 
    // 구모델은 플러그를 통해 충전 함.
    @Override
    public void onPlug() {
        System.out.println(myName+" : plug on");
    }
 
    @Override
    public String getName() {
        return myName;
    }

}
