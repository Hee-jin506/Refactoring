package com.heejin.ex06.Extract_Method;

public class Before {
  void printOwing(double amount) {
    printBanner();
    
    System.out.println("name: " + _name);
    System.out.println("amount: " + amount);
  }
}
