package com.heejin.ex01_1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer05 {
  private String _name;
  private Vector _rentals = new Vector();
  // Vector 는 ArrayList와 동일한 내부구조를 갖는다.
  // ArrayList와 마찬가지로 Vector 내부에 값이 추가되면자동으로 크기가 조절된다.
  // 객체들은 한자리씩 이동한다.
  // 한가지 다른점은 Vector은 동기화되어있고
  // ArrayList 가 비동기화되어있다는 사실이다.
  // Vector의 단점
  // 스레드가 한개일때도 동기화를 하므로 ArrayList보다 성능이 떨어진다.
  // ArrayList의 기본적인 기능은 동일하지만 자동 동기화가 아닌 동기화 옵션이 존재한다.
  public Customer05(String name) {
    _name = name;
  }
  
  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }
  
  public String getName() {
    return _name;
  }
  
  public String statement() {
    Enumeration rentals = this._rentals.elements();
    String result = "Rental Record for " + this.getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental)rentals.nextElement();
      
      // 이 대여에 대한 요금 계산 결과 표시
      result += "\t" + each.getMovie().getTitle() + "\t" +
      String.valueOf(each.getCharge()) + "\n";
      
    }
    
    // 풋터(footer) 추가
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result += "You earned " + String.valueOf(getTotalRenterPoints()) +
        "frequent renter points";
    return result;
    
  }
  
  private double getTotalCharge() {
    double result = 0;
    Enumeration rentals = this._rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }
  
  private double getTotalRenterPoints() {
    double result = 0;
    Enumeration rentals = this._rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }
}
