package com.heejin.ex01_1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer02 {
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
  public Customer02(String name) {
    _name = name;
  }
  
  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }
  
  public String getName() {
    return _name;
  }
  
  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    Enumeration rentals = this._rentals.elements();
    // Enumeration은 Iterator에서 remove() 메서드만 없고 거의 동일한 역할을 하는 인터페이스이다.
    // Iterator가 나오기 이전 버전이므로 요즘은 가능한한 Iterator를 사용하고 있다.
    // Enumeration와 Iterator 는 둘다 인터페이스 이므로 new 연산자를 통해 생성하지 못한다.
    // 따라서 다른 클래스에서 제공하는 메서드를 통해서 인터페이스를 구현하는 클래스를 생성해야한다.
    // Iterator는 (컬렉션 객체).iterator();를 통해
    // Enumeration은 (컬렉션 객체).elements();를 통해 구현된다.
    // Enumeration에서 객체를 꺼내는 메서드는 nextElement()이다.
    // Enumeration에서 꺼낼 수 있는 객체가 있는지 확인하는 메서드는 hasMoreElements()이다.
    String result = "Rental Record for " + this.getName() + "\n";
    while (rentals.hasMoreElements()) {
      double thisAmount = 0;
      Rental each = (Rental)rentals.nextElement();
      
      // 각 영화에 대한 요금 결정
      thisAmount = amountFor(each);
      
      // 포인트 추가
      frequentRenterPoints++;
      // 최신을 이틀 이상 대여하는 경우 추가 포인트 제공
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
          (each.getDaysRented() > 1)) {
        frequentRenterPoints++;
      }
      
      // 이 대여에 대한 요금 계산 결과 표시
      result += "\t" + each.getMovie().getTitle() + "\t" +
      String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }
    
    // 풋터(footer) 추가
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) +
        "frequent renter points";
    return result;
    
  }
  
  private double amountFor(Rental aRental) {
    double result = 0;
    switch (aRental.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 2;
        if (aRental.getDaysRented() > 2) {
          result += (aRental.getDaysRented() - 2) * 1.5;
        }
        break;
      case Movie.NEW_RELEASE:
        result += aRental.getDaysRented() * 3;
        break;
      case Movie.CHILDREN:
        result += 1.5;
        if (aRental.getDaysRented() > 3) {
          result += (aRental.getDaysRented() - 3) * 1.5;
        }
        break;
    }
    return result;
  }
}
