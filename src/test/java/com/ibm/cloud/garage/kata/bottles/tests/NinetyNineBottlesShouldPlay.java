package com.ibm.cloud.garage.kata.bottles.tests;

import org.junit.Before;
import org.junit.Test;

import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class NinetyNineBottlesShouldPlay {
  private Bottles bottles = null;

  @Before
  public void setUp() {
    this.bottles = new Bottles();
  }

  @Test
  public void verse99() {
    String expected =
        "99 bottles of beer on the wall, " +
        "99 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "98 bottles of beer on the wall.\n";

    assertThat(bottles.verse(99)).isEqualTo(expected);
  }

  @Test
  public void verse03() {
    String expected =
        "3 bottles of beer on the wall, " +
        "3 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "2 bottles of beer on the wall.\n";

    assertThat(bottles.verse(3)).isEqualTo(expected);
  }

  @Test
  public void verse02() {
    String expected =
        "2 bottles of beer on the wall, " +
        "2 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "1 bottle of beer on the wall.\n";

    assertThat(bottles.verse(2)).isEqualTo(expected);
  }

  @Test
  public void verse01() {
    String expected =
        "1 bottle of beer on the wall, " +
        "1 bottle of beer.\n" +
        "Take it down and pass it around, " +
        "no more bottles of beer on the wall.\n";

    assertThat(bottles.verse(1)).isEqualTo(expected);
  }

  @Test
  public void verse00() {
    String expected =
        "No more bottles of beer on the wall, " +
        "no more bottles of beer.\n" +
        "Go to the store and buy some more, " +
        "99 bottles of beer on the wall.\n";

    assertThat(bottles.verse(0)).isEqualTo(expected);
  }

  @Test
  public void verses99to98() {
    String expected =
        "99 bottles of beer on the wall, " +
        "99 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "98 bottles of beer on the wall.\n" +
        "\n" +
        "98 bottles of beer on the wall, " +
        "98 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "97 bottles of beer on the wall.\n";

    assertThat(bottles.verses(99, 98)).isEqualTo(expected);
  }

  @Test
  public void verses02to00() {
    String expected =
        "2 bottles of beer on the wall, " +
        "2 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "1 bottle of beer on the wall.\n" +
        "\n" +
        "1 bottle of beer on the wall, " +
        "1 bottle of beer.\n" +
        "Take it down and pass it around, " +
        "no more bottles of beer on the wall.\n" +
        "\n" +
        "No more bottles of beer on the wall, " +
        "no more bottles of beer.\n" +
        "Go to the store and buy some more, " +
        "99 bottles of beer on the wall.\n";

    assertThat(bottles.verses(2, 0)).isEqualTo(expected);
  }

  private class Bottles {
    String verse(int numberOfBottles) {
      return
          capitalize(quantity(numberOfBottles)) + " " + container(numberOfBottles) + " of beer on the wall, " +
          quantity(numberOfBottles) + " " + container(numberOfBottles) + " of beer.\n" +
          action(numberOfBottles) + ", " +
          quantity(predecessor(numberOfBottles)) + " " + container(predecessor(numberOfBottles)) + " of beer on the wall.\n";
    }

    private int predecessor(int numberOfBottles) {
      return ((numberOfBottles % -100) + 99) % 100;
    }

    private String action(int numberOfBottles) {
      if(numberOfBottles == 0) return "Go to the store and buy some more";
      return "Take " + pronoun(numberOfBottles) + " down and pass it around";
    }

    private String capitalize(String word) {
      return word.toUpperCase().charAt(0) + word.substring(1);
    }

    private String quantity(int numberOfBottles) {
      if(numberOfBottles == 0) return "no more";
      return String.valueOf(numberOfBottles);
    }

    private String pronoun(int numberOfBottles) {
      if(numberOfBottles == 1) return "it";
      return "one";
    }

    private String container(int numberOfBottles) {
      if(numberOfBottles == 1) return "bottle";
      return "bottles";
    }

    String verses(int start, int end) {
      return IntStream.rangeClosed(end, start)
      .map(countDownFromTo(start, end))
      .mapToObj(this::verse)
      .collect(Collectors.joining("\n"));
    }

    String song() { return verses(99, 0); }

    private IntUnaryOperator countDownFromTo(int from, int to) {
      return j -> to - j + from;
    }
  }
}
