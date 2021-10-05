import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("nome do arquivo: ");
        String name = s.nextLine();
        System.out.println("Substring");
        String subsString = s.nextLine();
        InputStream file = new FileInputStream(name);
        Scanner leitura = new Scanner(file);

        while (leitura.hasNextLine()) {
            String line = leitura.nextLine(); // Sem essa variavel String para auxiliar, na ultima linha do txt, tava
                                              // dando erro
            if (line.contains(subsString))
                System.out.println(line);
        }
        file.close();
    }

}
