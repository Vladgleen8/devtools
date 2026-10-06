package ru.mentee.power;

public class LiveCodingDemo {

  public static void main(String[] args) {
    printFizzBuzz(15);
  }

  public static void printFizzBuzz(int num) {
    for (int i = 1; i <= num; i++) {
      if (num % 3 == 0 && num % 5 == 0) {
        System.out.println("FizzBuzz");
      } else if (num % 3 == 0) {
        System.out.println("Fizz");
      } else if (num % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }




}
