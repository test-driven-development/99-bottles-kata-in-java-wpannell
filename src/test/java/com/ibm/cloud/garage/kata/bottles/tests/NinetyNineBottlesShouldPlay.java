package com.ibm.cloud.garage.kata.bottles.tests;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class NinetyNineBottlesShouldPlay {
  private Bottles bottles = null;

  @Before
  public void setUp() throws Exception {
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

  private class Bottles {
    String verse(int numberOfBottles) {
      if(numberOfBottles == 0)
        return
            ("No more") + " bottles of beer on the wall, " +
            ("no more") + " bottles of beer.\n" +
            "Go to the store and buy some more, " +
            (99) + " bottles of beer on the wall.\n";

      if(numberOfBottles == 1)
        return
            numberOfBottles + " bottle of beer on the wall, " +
            numberOfBottles + " bottle of beer.\n" +
            "Take it down and pass it around, " +
            ("no more") + " bottles of beer on the wall.\n";

      if(numberOfBottles == 2)
        return
            numberOfBottles + " bottles of beer on the wall, " +
            numberOfBottles + " bottles of beer.\n" +
            "Take one down and pass it around, " +
            (numberOfBottles - 1) + " bottle of beer on the wall.\n";

      return
          numberOfBottles + " bottles of beer on the wall, " +
          numberOfBottles + " bottles of beer.\n" +
          "Take one down and pass it around, " +
          (numberOfBottles - 1) + " bottles of beer on the wall.\n";
    }
  }
}
