package org.data4j.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Record {
  private final Map<String, String> data;

  public Record() {
    data = new HashMap<>();
  }

  public static Record of(String... items) {
    Record record = new Record();

    for (int i = 0; i + 1 < items.length; i += 2) {
      record.put(items[i], items[i + 1]);
    }

    return record;
  }

  public String get(String key) {
    return data.get(key);
  }

  public String getOrDefault(String key, String defaultValue) {
    return data.getOrDefault(key, defaultValue);
  }

  public void put(String key, String value) {
    data.put(key, value);
  }

  public boolean has(String key) {
    return data.containsKey(key);
  }

  public Set<String> keys() {
    return data.keySet();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (obj instanceof Record record) {
      for (String key : record.keys()) {
        if (!has(key) || !get(key).equals(record.get(key))) {
          return false;
        }
      }
      return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return "Record{" + "data=" + data + '}';
  }
}
