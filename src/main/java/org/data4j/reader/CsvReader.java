package org.data4j.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.data4j.data.Data;
import org.data4j.data.Record;
import org.data4j.util.ArrayUtils;

public class CsvReader {
  public Data readCsv(String fileName, String separator) throws IOException {
    return readCsv(fileName, null, separator);
  }

  public Data readCsv(String fileName, String[] columns, String separator) throws IOException {
    Data data = new Data();
    String[] headers = null;
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(separator);
        if (headers == null) {
          headers = values;
        } else {
          if (columns == null) {
            columns = headers;
          }
          int[] columnIndices = getColumnIndices(headers, columns);
          Record record = new Record();
          for (int i : columnIndices) {
            record.put(headers[i], i < values.length ? values[i] : "");
          }
          data.add(record);
        }
      }
    }

    return data;
  }

  private int[] getColumnIndices(String[] headers, String[] columns) {
    int[] indices = new int[columns.length];
    for (int i = 0; i < columns.length; i++) {
      indices[i] = ArrayUtils.getIndex(headers, columns[i]);
    }
    return indices;
  }
}
