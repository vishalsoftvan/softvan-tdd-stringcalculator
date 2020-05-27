package in.softvan.tdd.tests;

import in.softvan.tdd.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTests {

  private StringCalculator stringCalculator;

  @BeforeEach
  public void setUp() {
    this.stringCalculator = new StringCalculator();
  }

  @Test
  public void testZeroOnEmptyString() {
    Assertions.assertEquals(0, stringCalculator.Add(""));
  }

  @Test
  public void testShouldReturnNumberOnNumber() {
    Assertions.assertEquals(1, stringCalculator.Add("1"));
  }
}
