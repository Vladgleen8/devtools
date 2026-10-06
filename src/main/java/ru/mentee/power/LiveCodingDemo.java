package ru.mentee.power;

public class LiveCodingDemo {

  public static void main(String[] args) {
    printFizzBuzz(15);
    sumEven(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    findMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
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

  public static int sumEven(int[] numbers) {
    int result = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] % 2 == 0) {
        result += numbers[i];
      }
    }
    return result;
  }

  public static int findMax(int[] numbers) {
    if (numbers.length == 0) {
      return Integer.MIN_VALUE;
    }
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }
    return max;
  }

}
