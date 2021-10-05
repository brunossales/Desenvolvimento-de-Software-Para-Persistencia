import java.io.*;
import java.util.Scanner;

public class formaModerna {
  public static void main(String[] args) throws IOException {
    InputStream is = new FileInputStream("arquivo.txt");
    Scanner leitura = new Scanner(is);
    // o Scanner ja faz a interpretação como UTF-8 e lê linha por linha
    while (leitura.hasNextLine()) {
      System.out.println(leitura.nextLine());
    }
    is.close();

  }
}
