package fr.istic.m2miage.aoc.dp.adapter.sample;

//프로그램 실행
public class StartApp {
 public static void main (String ar[]) {
     // 구 모델의 장난감
     OldToyInterface oldToy = new OldToy("OldToy");
     // 신 모델의 장난감
     NewToyInterface newToy = new NewToy("NewToy");
     
     // 구 모델의 장난감을 어댑터를 통해 신모델처럼 사용
     NewToyInterface adater = new ToyAdater(oldToy);
      
     oldToy.use();
     newToy.use();

     // 신모델 충전
     newToy.onUSBCharge();

     // 구모델을 신모델 충전으로 사용하기 위해
     // 어뎁터에 추가했으므로, 어뎁터의 충전을 호출 함
     adater.onUSBCharge();
 }
}