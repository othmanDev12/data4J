package data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.data4j.data.Data;
import org.data4j.data.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataTest {

  private Data data;

  @BeforeEach
  void setUp() {
    data = new Data();
  }

  @Test
  void should_return_added_data_and_size() {
    data.add(Record.of("name", "phoegasus"));
    data.add(Record.of("name", "othmanDev12"));

    assertEquals(Record.of("name", "phoegasus"), data.get(0));
    assertEquals(Record.of("name", "othmanDev12"), data.get(1));

    assertEquals(2, data.size());
  }
}
