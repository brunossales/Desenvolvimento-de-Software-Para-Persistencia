import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        InputStream arquivo1 = new FileInputStream(args[0]);
        OutputStream os = new FileOutputStream(args[1]);
        long start = System.currentTimeMillis();
        int bytee = arquivo1.read(); // Primeira leitura
        while (bytee != -1) {
            try {
                os.write(bytee);
                bytee = arquivo1.read();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Successful ✅\nTime: " + elapsed);
    }
}
