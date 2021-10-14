import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PrintarAll {
  String properties;
  String inicial;
  String finall;
  int aux = 0;

  PrintarAll(String arquivo, String ini, String fini) {
    this.properties = arquivo;
    this.inicial = ini;
    this.finall = fini;
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
        if (this.inicial.equals(Key.toString())) {
          System.out.println("Key: " + Key + ", Value: " + Value);
          aux++;
        } else if (aux > 0) {
          System.out.println("Key: " + Key + ", Value: " + Value);
          if (this.finall.equals(Key.toString()))
            aux = 0;
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
