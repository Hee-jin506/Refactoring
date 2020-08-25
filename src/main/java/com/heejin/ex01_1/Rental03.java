package com.heejin.ex01_1;

public class Rental03 {
  private Movie _movie;
  private int _daysRented;
  
  public Rental03(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }
  
  public int getDaysRented() {
    return _daysRented;
  }
  
  public Movie getMovie() {
    return _movie;
  }
  
  double getCharge() {
    double result = 0;
    switch (this.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 2;
        if (this.getDaysRented() > 2) {
          result += (this.getDaysRented() - 2) * 1.5;
        }
        break;
      case Movie.NEW_RELEASE:
        result += this.getDaysRented() * 3;
        break;
      case Movie.CHILDREN:
        result += 1.5;
        if (this.getDaysRented() > 3) {
          result += (this.getDaysRented() - 3) * 1.5;
        }
        break;
    }
    return result;
  }
}
