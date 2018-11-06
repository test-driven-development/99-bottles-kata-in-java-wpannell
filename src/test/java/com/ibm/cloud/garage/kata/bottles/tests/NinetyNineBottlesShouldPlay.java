package com.ibm.cloud.garage.kata.bottles.tests;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class NinetyNineBottlesShouldPlay {
  @Test
  public void verse99() {
    String expected =
        "99 bottles of beer on the wall, " +
        "99 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "98 bottles of beer on the wall.\n";

    Bottles bottles = new Bottles();
    assertThat(bottles.verse(99)).isEqualTo(expected);
  }

  @Test
  public void verse03() {
    String expected =
        "3 bottles of beer on the wall, " +
        "3 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "2 bottles of beer on the wall.\n";

    Bottles bottles = new Bottles();
    assertThat(bottles.verse(3)).isEqualTo(expected);
  }

  @Test
  public void verse02() {
    String expected =
        "2 bottles of beer on the wall, " +
        "2 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "1 bottle of beer on the wall.\n";

    Bottles bottles = new Bottles();
    assertThat(bottles.verse(2)).isEqualTo(expected);
  }

  private class Bottles {
    String verse(int numberOfBottles) {
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
