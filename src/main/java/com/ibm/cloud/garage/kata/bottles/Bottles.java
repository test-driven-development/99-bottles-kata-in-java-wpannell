package com.ibm.cloud.garage.kata.bottles;

import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bottles {
  public String verse(int numberOfBottles) {
    BottleNumber bottleNumber = new BottleNumber(numberOfBottles);
    BottleNumber predecessorBottleNumber = new BottleNumber(bottleNumber.predecessor());
    
    return
        capitalize(bottleNumber.toString()) + " of beer on the wall, " +
        bottleNumber.toString() + " of beer.\n" +
        bottleNumber.action() + ", " +
        predecessorBottleNumber.toString() + " of beer on the wall.\n";
  }

  public String verses(int start, int end) {
    return IntStream.rangeClosed(end, start)
    .map(countDownFromTo(start, end))
    .mapToObj(this::verse)
    .collect(Collectors.joining("\n"));
  }

  public String song() { return verses(99, 0); }

  private String capitalize(String word) {
    return word.toUpperCase().charAt(0) + word.substring(1);
  }

  private IntUnaryOperator countDownFromTo(int from, int to) {
    return j -> to - j + from;
  }

  private String action(int numberOfBottles) {
    return new BottleNumber(numberOfBottles).action();
  }

  private String container(int numberOfBottles) {
    return new BottleNumber(numberOfBottles).container();
  }

  private int predecessor(int numberOfBottles) {
    return new BottleNumber(numberOfBottles).predecessor();
  }

  private String pronoun(int numberOfBottles) {
    return new BottleNumber(numberOfBottles).pronoun();
  }

  private String quantity(int numberOfBottles) {
    return new BottleNumber(numberOfBottles).quantity();
  }

  public class BottleNumber {
    private final int number;

    public BottleNumber(int number) { this.number = number;}

    private String action() {
      if(number == 0) { return "Go to the store and buy some more"; }
      return "Take " + pronoun() + " down and pass it around";
    }

    private String container() {
      if(number == 1) { return "bottle"; }
      return "bottles";
    }

    private int predecessor() {
      return ((number % -100) + 99) % 100;
    }

    private String pronoun() {
      if(number == 1) { return "it"; }
      return "one";
    }

    private String quantity() {
      if(number == 0) { return "no more"; }
      return String.valueOf(number);
    }

    @Override
    public String toString() {
      return quantity() + " " + container();
    }
  }
}
