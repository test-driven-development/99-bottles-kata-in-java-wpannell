package com.ibm.cloud.garage.kata.bottles;

import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bottles {
  public BottleNumber makeBottleNumber(int number) {
    if(number == 0) return new Bottle0(number);
    if(number == 1) return new Bottle1(number);
    return new BottleNumber(number);
  }

  public String verse(int numberOfBottles) {
    BottleNumber bottleNumber = makeBottleNumber(numberOfBottles);
    BottleNumber predecessorBottleNumber = makeBottleNumber(bottleNumber.predecessor());
    
    return
        capitalize(bottleNumber.toString() + " of beer on the wall, ") +
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

  public class BottleNumber {
    private final int number;
    BottleNumber(int number) { this.number = number;}

    protected String action() {
      return "Take " + pronoun() + " down and pass it around";
    }

    protected String container() { return "bottles"; }

    private int predecessor() { return ((number % -100) + 99) % 100; }

    protected String pronoun() { return "one"; }

    protected String quantity() { return String.valueOf(number); }

    @Override
    public String toString() { return quantity() + " " + container(); }
  }

  public class Bottle0 extends BottleNumber {
    Bottle0(int number) { super(number); }

    @Override
    protected String quantity() { return "no more"; }

    @Override
    protected String action() { return "Go to the store and buy some more"; }
  }

  public class Bottle1 extends BottleNumber {
    Bottle1(int number) { super(number); }

    @Override
    protected String container() { return "bottle"; }

    @Override
    protected String pronoun() { return "it"; }
  }
}
