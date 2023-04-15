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
  
   // handle counter to work with foreach instead of for loop
  public static <T> Consumer<T> withCounter(BiConsumer<Integer, T> consumer) {
      AtomicInteger counter = new AtomicInteger(0);
      return item -> consumer.accept(counter.getAndIncrement(), item);
  }
  
}
