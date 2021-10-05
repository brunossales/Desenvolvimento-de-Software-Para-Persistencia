import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Primeiro arquivo: ");
        String primeiro = s.nextLine();
        System.out.println("Segundo arquivo: ");
        String segundo = s.nextLine();
        System.out.println("Terceiro, o que vai ser criado: ");
        String terceiro = s.nextLine();
        InputStream lendoT1 = new FileInputStream(primeiro);
        InputStream lendoT2 = new FileInputStream(segundo);
        Scanner texto1 = new Scanner(lendoT1);
        Scanner texto2 = new Scanner(lendoT2);
        PrintStream out = new PrintStream(terceiro);
        long start = System.currentTimeMillis();
        while (texto1.hasNextLine() || texto2.hasNextLine()) {
            if (texto1.hasNextLine())
                out.println(texto1.nextLine());
            else
                out.println(texto2.nextLine());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Tempo total em segundos: " + elapsed);
        Path path = Paths.get(
                "C:/Users/Bruno Sales/Desktop/Faculdade Bruno/4° Semestre/Desenvolvimento de Software para Persistência/L1/Q2/"
                        + terceiro);
        byte[] bytesFiles = Files.readAllBytes(path);
        System.out.println("Tamanho do arquivo criado: " + bytesFiles.length);
    }
}
