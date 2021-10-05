import java.io.*;

public class testeEntradaBuffered {
  public static void main(String[] args) throws IOException {
    InputStream is = new FileInputStream("arquivo.txt");
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    // sem o buffer vao ler byte a byte, com o buffer pega um cash, um pedaço
    // Ele vai armazenar as coisas, para utilizarmos
    // ele tem o metodo readLine que le até encontrar um caracteres de \n
    String c = br.readLine(); // Primeira linha

    // ainda é como uma cadeia de bytes, no proximo readLine vai ler a proxima linha
    while (c != null) {
      System.out.println(c);
      c = br.readLine();
    }
    br.close();

  }
}
