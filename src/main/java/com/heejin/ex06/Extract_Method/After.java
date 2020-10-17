package com.heejin.ex06.Extract_Method;

public class After {
  void printOwing(double amount) {
    printBanner();
    printDetails(amount);
  }
  
  void printDetails(double amount) {
    System.out.println("name: " + _name);
    System.out.println("amount: " + amount);
  }
}
