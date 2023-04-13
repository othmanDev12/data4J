package org.data4j.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
  private final List<Record> data;

  public Data() {
    data = new ArrayList<>();
  }

  public void add(Record record) {
    data.add(record);
  }

  public Record get(int index) {
    return data.get(index);
  }

  public int size() {
    return data.size();
  }
}
