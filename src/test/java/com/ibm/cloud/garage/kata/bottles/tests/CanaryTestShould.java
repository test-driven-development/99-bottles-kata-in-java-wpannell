package com.ibm.cloud.garage.kata.bottles.tests;

import com.ibm.cloud.garage.kata.bottles.Canary;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CanaryTestShould {
  @Test
  public void showTheTestInfrastructureWorks() {
    assertThat((new Canary().doesTestInfrastructureWork))
        .isEqualTo(true);
  }
}
