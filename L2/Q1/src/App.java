import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            InputStream arquivoExistence = new FileInputStream(args[0]);
            OutputStream os = new FileOutputStream(args[1]);

            System.out.println("Quantidade por block de byte transferivel: ");
            int sizeBlock = scanner.nextInt();

            byte[] data = new byte[sizeBlock]; // bloco de byte criado

            long start = System.currentTimeMillis();
            int solver = arquivoExistence.read(data); // usand o bloco de byte
            while (solver != -1) {
                os.write(data);
                solver = arquivoExistence.read(data);
            }
            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Successful ✅\nTime: " + elapsed + " ms");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
