package com.heejin.ex01_2;

public class App {
  public static void main(String[] args) {
    Customer c1 = new Customer("희진");
    c1.addRental(new Rental(new Movie("바람과 함께 사라지다", Movie.CHILDREN), 1));
    c1.addRental(new Rental(new Movie("벤자민 버튼의 시간은 거꾸로 간다", Movie.CHILDREN),4));
    System.out.println(c1.statement());
    System.out.println("-------------");
    
    Customer c2 = new Customer("희주");
    c2.addRental(new Rental(new Movie("버즈 오프 프레이", Movie.REGULAR), 1));
    c2.addRental(new Rental(new Movie("어스", Movie.REGULAR),5));
    System.out.println(c2.statement());
    System.out.println("-------------");
    
    Customer c3 = new Customer("호준");
    c3.addRental(new Rental(new Movie("미세스 다웃파이어", Movie.NEW_RELEASE), 2));
    c3.addRental(new Rental(new Movie("마틸다", Movie.NEW_RELEASE), 6));
    System.out.println(c3.statement());
    System.out.println("-------------");
    
  }

}
