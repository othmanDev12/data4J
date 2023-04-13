package reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.data4j.data.Data;
import org.data4j.data.Record;
import org.data4j.reader.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CsvReaderTest {
  private CsvReader csvReader;

  @BeforeEach
  void setUp() {
    csvReader = new CsvReader();
  }

  @Test
  void should_read_csv_data() throws IOException {
    Data data = csvReader.readCsv("src/test/resources/reader/data.csv", ",");
    assertEquals(2, data.size());
    assertEquals(Record.of("firstName", "john", "lastName", "doe", "age", "40"), data.get(0));
    assertEquals(Record.of("firstName", "jane", "lastName", "doe", "age", ""), data.get(1));
  }
}
