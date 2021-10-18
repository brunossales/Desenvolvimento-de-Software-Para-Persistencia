package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Serializa {
  List<Pessoa> objects = new ArrayList<Pessoa>();

  public Serializa() {
    objects.add(new Pessoa(1, "Bruno", "bruno@email", "88997"));
    objects.add(new Pessoa(2, "Rafa", "Rafa@email", "88856"));
    objects.add(new Pessoa(3, "Isaa", "Isaa@email", "8562"));
  }

  public void serializaApiJava() throws IOException {
    try {
      FileOutputStream out = new FileOutputStream(".\\resources\\naPropriaApi.txt");
      ObjectOutputStream o = new ObjectOutputStream(out);
      o.writeObject(objects.get(0));
      o.close();
    } catch (FileNotFoundException e) {
      System.out.println("Java na Api não deu certo" + e.toString());
    }
  }

  public void serialiazaJson() throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(new File(".\\resources\\personn.json"), objects.get(1));
  }
  public void serializarXml() throws IOException {
    XmlMapper xml = new XmlMapper();
    xml.writeValue(new File(".\\resources\\arquivoXml.xml"), objects.get(2));
    File file = new File(".\\resources\\arquivoXml.xml");
  }

}
