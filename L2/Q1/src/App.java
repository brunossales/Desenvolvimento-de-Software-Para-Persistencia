import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Quantidade por block de byte transferivel: ");
            int sizeBlock = scanner.nextInt();

            InputStream arquivoExistence = new BufferedInputStream(new FileInputStream(args[0]), sizeBlock);
            OutputStream newFile = new BufferedOutputStream(new FileOutputStream(args[1]), sizeBlock);
            // já estou definindo o tamanho especificado do meu buffered

            byte[] data = new byte[sizeBlock]; // Agora pegando o bloco de byte
            long start = System.currentTimeMillis();
            int solver = arquivoExistence.read(data);
            while (solver != -1) {// usand o bloco de byte
                newFile.write(data);
                solver = arquivoExistence.read(data);
            }
            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Successful ✅\nTime: " + elapsed + " ms");
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
