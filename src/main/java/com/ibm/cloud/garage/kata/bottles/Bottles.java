package com.ibm.cloud.garage.kata.bottles;

import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bottles {
  public String verse(int numberOfBottles) {
    return
        capitalize(quantity(numberOfBottles)) + " " + container(numberOfBottles) + " of beer on the wall, " +
        quantity(numberOfBottles) + " " + container(numberOfBottles) + " of beer.\n" +
        action(numberOfBottles) + ", " +
        quantity(predecessor(numberOfBottles)) + " " + container(predecessor(numberOfBottles)) + " of beer on the wall.\n";
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
    if(numberOfBottles == 0) return "Go to the store and buy some more";
    return "Take " + pronoun(numberOfBottles) + " down and pass it around";
  }

  private String container(int numberOfBottles) {
    if(numberOfBottles == 1) return "bottle";
    return "bottles";
  }

  private int predecessor(int numberOfBottles) {
    return ((numberOfBottles % -100) + 99) % 100;
  }

  private String pronoun(int numberOfBottles) {
    if(numberOfBottles == 1) return "it";
    return "one";
  }

  private String quantity(int numberOfBottles) {
    if(numberOfBottles == 0) return "no more";
    return String.valueOf(numberOfBottles);
  }

  public class BottleNumber {
    public BottleNumber() { }

    private String action(int numberOfBottles) {
      if(numberOfBottles == 0) { return "Go to the store and buy some more"; }
      return "Take " + pronoun(numberOfBottles) + " down and pass it around";
    }

    private String container(int numberOfBottles) {
      if(numberOfBottles == 1) { return "bottle"; }
      return "bottles";
    }

    private int predecessor(int numberOfBottles) {
      return ((numberOfBottles % -100) + 99) % 100;
    }

    private String pronoun(int numberOfBottles) {
      if(numberOfBottles == 1) { return "it"; }
      return "one";
    }

    private String quantity(int numberOfBottles) {
      if(numberOfBottles == 0) { return "no more"; }
      return String.valueOf(numberOfBottles);
    }
  }
}
