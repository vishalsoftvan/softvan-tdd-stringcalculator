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
      Matcher matcher = Pattern.compile("//(.+)\n(.+)").matcher(numbers);
      matcher.matches();
      String customDelimiter = matcher.group(1);
      if (customDelimiter.length() - 1 > 0) {
        customDelimiter = customDelimiter.substring(1, customDelimiter.length() - 1);
      }
      String secondLineNumbers = matcher.group(2);
      return secondLineNumbers.split(getDelimiterValue(customDelimiter));
    }
    return numbers.split(",|\n");
  }

  private String getDelimiterValue(String delimiter) {
    Character[] operators = new Character[] { '-', '+', '/', '*', 'x', '^', 'X' };
    StringBuilder newDelimiter = new StringBuilder();
    for (int i = 0; i < delimiter.length(); i++) {
      boolean isTrue = false;
      for (Character operator : Arrays.asList(operators)) {
        if (delimiter.charAt(i) == operator) {
          isTrue = true;
        }
      }
      if (isTrue) {
        newDelimiter.append("\\").append(delimiter.charAt(i));
      } else {
        newDelimiter.append(delimiter.charAt(i));
      }
    }
    return newDelimiter.toString();
  }
}

