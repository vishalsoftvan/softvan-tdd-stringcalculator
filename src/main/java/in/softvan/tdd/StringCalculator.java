package in.softvan.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  public int Add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else {
      String[] numbersList = tokenize(numbers);
      List<String> strNumberList = Arrays.asList(numbersList);

      List<Integer> intNumberList = new ArrayList<>();

      List<Integer> negativeNumberList = new ArrayList<>();

      strNumberList.forEach(number -> {
        int parsedNumber = toInt(number);
        // exception for negative numbers
        if (parsedNumber < 0) {
          negativeNumberList.add(parsedNumber);
        }
        // number greater that 1000 should be ignored
        if (parsedNumber < 1000) {
          intNumberList.add(parsedNumber);
        }
      });

      if (!negativeNumberList.isEmpty()) {
        throw new RuntimeException("Negatives not allowed " + negativeNumberList.toString());
      }

      return intNumberList.stream().mapToInt(Integer::intValue).sum();
    }
  }

  private int toInt(String s) {
    return Integer.parseInt(s);
  }

  private String[] tokenize(String numbers) {
    if (numbers.startsWith("//")) {
      Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
      matcher.matches();
      String customDelimiter = matcher.group(1);
      String secondLineNumbers = matcher.group(2);
      return secondLineNumbers.split(customDelimiter);
    }
    return numbers.split(",|\n");
  }
}

