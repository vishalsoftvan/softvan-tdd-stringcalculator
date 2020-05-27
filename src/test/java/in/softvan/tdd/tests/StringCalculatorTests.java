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

  @Test
  public void testShouldReturnSumOnMultipleNumbers() {
    Assertions.assertEquals(3, stringCalculator.Add("1,2"));
  }

  @Test
  public void testShouldReturnSumOnMultipleUnCountedNumbers() {
    Assertions.assertEquals(6, stringCalculator.Add("1,2,3"));
  }

  @Test
  public void testShouldAcceptNewLineAsDelimiter() {
    Assertions.assertEquals(6, stringCalculator.Add("1\n2,3"));
  }

  @Test
  public void testShouldAcceptCustomDelimiterAsSyntax() {
    Assertions.assertEquals(3, stringCalculator.Add("//;\n1;2"));
  }

  @Test
  public void testShouldRaiseExceptionOnNegative() {
    try {
      stringCalculator.Add("-1,2,3");
      Assertions.fail("Exception Expected");
    } catch (RuntimeException ex) {
      Assertions.assertEquals("Negatives not allowed [-1]", ex.getMessage());
    }
  }

  @Test
  void testShouldRaiseExceptionOnMultipleNegatives() {
    try {
      stringCalculator.Add("-1,-2,3");
      Assertions.fail("Exception Expected");
    } catch (RuntimeException ex) {
      Assertions.assertEquals("Negatives not allowed [-1, -2]", ex.getMessage());
    }
  }
}
