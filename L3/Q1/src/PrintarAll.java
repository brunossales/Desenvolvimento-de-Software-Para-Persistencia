import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PrintarAll {
  String arquivo;
  int aux = 1;

  PrintarAll(String arquivo) {
    this.arquivo = arquivo;
  }

  public void print() {
    try {
      Properties prop = new Properties();

      prop.load(new FileInputStream(".\\resources\\config.properties"));
      Scanner scannerText = new Scanner(new FileInputStream(".\\resources\\" + this.arquivo));

      int inicial = Integer.parseInt(prop.getProperty("linha_inicial"));
      int finall = Integer.parseInt(prop.getProperty("linha_final"));

      String line = scannerText.nextLine();

      while (scannerText.hasNextLine()) {
        if (aux >= inicial && aux < finall) {
          System.out.println(line);
        } else if (this.aux == finall) {
          System.out.println(line);
          break;
        }
        line = scannerText.nextLine();
        this.aux++;
      }
      scannerText.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
