import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.*;

public class PrintarAll {
  String properties;

  PrintarAll(String arquivo) {
    this.properties = arquivo;

  }

  public void print() {
    try (InputStream input = getClass().getClassLoader().getResourceAsStream("resources/" + this.properties)) {
      Properties prop = new Properties();
      if (input == null) {
        System.out.println("Error " + this.properties);
        return;
      }
      prop.load(input);
      prop.forEach((Key, Value) -> {
        System.out.println("Key: " + Key + ", Value: " + Value);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
