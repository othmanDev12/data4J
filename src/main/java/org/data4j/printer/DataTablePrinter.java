package org.data4j.printer;

import java.util.List;
import java.util.Map;
import org.data4j.util.ArrayUtils;

public class DataTablePrinter {
  private static void printData(List<Map<String, String>> data, String[] headers) {
    // Calculate the maximum length of each column
    int[] columnLengths = new int[headers.length];
    for (String header : headers) {
      columnLengths[ArrayUtils.getIndex(headers, header)] = header.length();
    }
    for (Map<String, String> record : data) {
      for (String key : record.keySet()) {
        int index = ArrayUtils.getIndex(headers, key);
        int length = record.get(key).length();
        if (length > columnLengths[index]) {
          columnLengths[index] = length;
        }
      }
    }

    // Print the table header
    for (int i = 0; i < headers.length; i++) {
      System.out.printf("| %-" + columnLengths[i] + "s ", headers[i]);
    }
    System.out.println("|");

    // Print the table separator
    for (int i = 0; i < headers.length; i++) {
      System.out.print("+");
      for (int j = 0; j < columnLengths[i] + 2; j++) {
        System.out.print("-");
      }
    }
    System.out.println("+");

    // Print the table rows
    for (Map<String, String> record : data) {
      for (int i = 0; i < headers.length; i++) {
        String value = record.get(headers[i]);
        System.out.printf("| %-" + columnLengths[i] + "s ", value);
      }
      System.out.println("|");
    }
  }
}
