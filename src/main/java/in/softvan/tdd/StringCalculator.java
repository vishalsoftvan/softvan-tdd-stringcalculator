package in.softvan.tdd;

public class StringCalculator {

  public int Add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else {
      return Integer.parseInt(numbers);
    }
  }
}
