import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SerializaCsv s = new SerializaCsv();
        SerializaXmlJson ser = new SerializaXmlJson();
        long start = System.currentTimeMillis();
        while (true) {
            try {
                String line = JOptionPane.showInputDialog(null, "Digite os seguintes Comandos:\n"
                        + "add - Para ser direcionado a tela de adicionar carros\n"
                        + "ser - Para serializar em arquivos XML e JSON, todos os objetos escritos no arquivo CSV\n"
                        + "exit - Se deseja encerrar a sessão", "Página Inicial", JOptionPane.INFORMATION_MESSAGE);
                if (line.equalsIgnoreCase("exit")) {
                    long elapsed = System.currentTimeMillis() - start;
                    JOptionPane.showMessageDialog(null, "Sessão Encerrada!\n"
                                                    + "Sua sessão demorou: " + elapsed/1000 + " segundos", "Exit",  JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                else if (line.equalsIgnoreCase("add")) {
                    while (true) {
                        String[] op = JOptionPane.showInputDialog(null, "Digite os valores do carro\n"
                                + "Chassi - int + Modelo - String + Marca - String + Ano - Int"
                                + "\nSair - Caso não queira adicionar mais carros", "Carro", JOptionPane.INFORMATION_MESSAGE).split(" ");
                        if (op[0].equalsIgnoreCase("sair"))
                            break;
                        else if (op.length > 1) {
                            try {
                                Carro carro = new Carro(Integer.parseInt(op[0]), op[1], op[2], Integer.parseInt(op[3]));
                                s.serializa(carro);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Tem certeza que digitou correto?", "Opção Inexistente", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Comando errado", "Opção Inexistente", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(line.equalsIgnoreCase("ser"))
                    ser.transforma();
                else
                    JOptionPane.showMessageDialog(null, "Opção Inexistente", "Digite algo novamente", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
