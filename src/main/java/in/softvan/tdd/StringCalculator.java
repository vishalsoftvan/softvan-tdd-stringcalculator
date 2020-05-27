package in.softvan.tdd;

public class StringCalculator {

  public int Add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains(",")) {
      String[] numbersList = numbers.split(",");
      return toInt(numbersList[0]) + toInt(numbersList[1]);
    } else {
      return toInt(numbers);
    }
  }

  private int toInt(String s) {
    return Integer.parseInt(s);
  }
}
