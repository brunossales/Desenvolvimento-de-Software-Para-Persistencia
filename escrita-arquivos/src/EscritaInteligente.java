import java.io.FileNotFoundException;
import java.io.PrintStream;

public class EscritaInteligente {
  public static void main(String[] args) throws FileNotFoundException {
    PrintStream out = new PrintStream("saida.txt");
    out.append(" java");
    // println ja bota o \n
    out.append(" java");
    out.close();
  }
}
