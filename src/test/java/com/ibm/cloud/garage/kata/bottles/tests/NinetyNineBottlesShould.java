package com.ibm.cloud.garage.kata.bottles.tests;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class NinetyNineBottlesShould {
  @Test
  public void performVerse99() throws Exception {
    String expected =
        "99 bottles of beer on the wall, " +
        "99 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "98 bottles of beer on the wall.\n";

    Bottles bottles = new Bottles();
    assertThat(bottles.verse(99)).isEqualTo(expected);
  }

  @Test
  public void performVerse03() throws Exception {
    String expected =
        "3 bottles of beer on the wall, " +
        "3 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "2 bottles of beer on the wall.\n";

    Bottles bottles = new Bottles();
    assertThat(bottles.verse(3)).isEqualTo(expected);
  }

  private class Bottles {
    String verse(int numberOfBottlesOnWall) {
      return
          numberOfBottlesOnWall + " bottles of beer on the wall, " +
          numberOfBottlesOnWall + " bottles of beer.\n" +
          "Take one down and pass it around, " +
          (numberOfBottlesOnWall - 1) + " bottles of beer on the wall.\n";
    }
  }
}
