import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;

class EscritaTeclado {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner s = new Scanner(System.in);
    PrintStream ps = new PrintStream(new FileOutputStream("LendoTeclado.txt", true));
    ps.println(s.nextLine());
    // while (s.hasNext() || !s.equals("fim")) {
    // ps.println(s.next());
    // }
  }
}