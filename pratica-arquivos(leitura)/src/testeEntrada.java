import java.io.*;

public class testeEntrada {
  public static void main(String[] args) throws IOException {
    InputStream is = new FileInputStream("arquivo.txt");
    // esse input stream ler de byte em byte
    // só com o fileInputStream não está na padronização UTF-8 que aceita ç e
    // acentos
    // para colocar, basta...
    InputStreamReader isr = new InputStreamReader(is);
    // padrão é UTF-8
    // interpreta os bytes em um conjunto de caracteres
    char b = (char) isr.read();
    System.out.println(b);
    char c = (char) isr.read();
    System.out.println(c);
  }
}
