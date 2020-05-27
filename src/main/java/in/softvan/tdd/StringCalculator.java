package in.softvan.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

  public int Add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains(",")) {
      String[] numbersList = numbers.split(",|\n");
      List<String> strNumberList = Arrays.asList(numbersList);
      List<Integer> intNumberList = new ArrayList<>();
      strNumberList.forEach(number -> intNumberList.add(toInt(number)));
      return intNumberList.stream().mapToInt(Integer::intValue).sum();
    } else {
      return toInt(numbers);
    }
  }

  private int toInt(String s) {
    return Integer.parseInt(s);
  }
}
