import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class SerializaXmlJson {
    List<Carro> carros;
    ObjectMapper om;
    String filename = "C:\\Users\\Bruno Sales\\Desktop\\Faculdade Bruno\\4° Semestre\\Desenvolvimento de Software para Persistência\\Desenvolvimento-de-Software-Para-Persistencia\\Trabalho 1\\src\\main\\resources\\objetos.csv";
    String filenameJson = "C:\\Users\\Bruno Sales\\Desktop\\Faculdade Bruno\\4° Semestre\\Desenvolvimento de Software para Persistência\\Desenvolvimento-de-Software-Para-Persistencia\\Trabalho 1\\src\\main\\resources\\obJson.json";
    String filenameXml = "C:\\Users\\Bruno Sales\\Desktop\\Faculdade Bruno\\4° Semestre\\Desenvolvimento de Software para Persistência\\Desenvolvimento-de-Software-Para-Persistencia\\Trabalho 1\\src\\main\\resources\\obXml.xml";

    XmlMapper xm;
    BufferedReader leitor;
    SerializaXmlJson() throws FileNotFoundException {
        this.carros = new ArrayList<Carro>();
        this.om = new ObjectMapper();
        this.xm = new XmlMapper();
        this.leitor = new BufferedReader(new FileReader(filename));
    }
    public void transforma(){
        try{
            String linha = "";
            this.carros.clear();
            while((linha = leitor.readLine()) != null) {
                String[] part = linha.split(",");
                this.carros.add(new Carro(Integer.parseInt(part[0]), part[1], part[2], Integer.parseInt(part[3])));
            }
            long start = System.currentTimeMillis();
            this.om.writeValue(new File(filenameJson), this.carros);
            xm.writeValue(new File(filenameXml), this.carros);
            long elapsed = System.currentTimeMillis() - start;
            JOptionPane.showMessageDialog(null, "Todos os objetos armazenados no arquivo CSV foram serializados\n"
                                                            + "Tempo para a serialização: " + elapsed + " ms", "Inserção Concluida",  JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void show() throws IOException {
        String linha = "";
        this.carros.clear();
        while((linha = leitor.readLine()) != null) {
            String[] part = linha.split(",");
            this.carros.add(new Carro(Integer.parseInt(part[0]), part[1], part[2], Integer.parseInt(part[3])));
        }
        StringBuffer bf = new StringBuffer();
        for (Carro c: this.carros) {
            bf.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, bf.toString(), "Carros",  JOptionPane.INFORMATION_MESSAGE);
    }


}
