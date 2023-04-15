package org.data4j.util;

public class ArrayUtils {

  public static int getIndex(String[] array, String value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(value)) {
        return i;
      }
    }
    return -1;
  }
}
