package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.data4j.data.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecordTest {

  private Record record;

  @BeforeEach
  void setUp() {
    record = new Record();
  }

  @Test
  void should_put_and_get_value() {
    record.put("name", "phoegasus");

    assertEquals("phoegasus", record.get("name"));
  }

  @Test
  void should_get_keys() {
    record.put("name", "othmanDev12");
    record.put("project", "data4j");

    assertEquals(Set.of("name", "project"), record.keys());
  }

  @Test
  void should_get_default_value() {
    assertEquals("default", record.getOrDefault("unknown", "default"));
  }

  @Test
  void should_return_whether_record_has_key() {
    record.put("name", "phoegasus");

    assertTrue(record.has("name"));
    assertFalse(record.has("unknown"));
  }

  @Test
  void should_return_whether_records_are_equal() {
    assertEquals(Record.of("name", "phoegasus"), Record.of("name", "phoegasus"));
    assertNotEquals(Record.of("name", "phoegasus"), Record.of("name", "othmanDev12"));
    assertNotEquals(Record.of("name", "othmanDev12"), new Object());
  }
}
