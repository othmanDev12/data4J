package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.data4j.util.ArrayUtils;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {
  @Test
  void should_get_index() {
    String[] arr = new String[] {"one", "two"};

    assertEquals(1, ArrayUtils.getIndex(arr, "two"));
    assertEquals(-1, ArrayUtils.getIndex(arr, "three"));
  }
}
