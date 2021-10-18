package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DesSerializa {
    Pessoa p;

    public DesSerializa() {
    }

    void desSerializa() throws IOException, ClassNotFoundException {
        try {
            FileInputStream is = new FileInputStream(".\\resources\\naPropriaApi.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            p = (Pessoa) ois.readObject();
            ois.close();
            System.out.println("Arquivo desserializado: " + p.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e);
        }
    }
}

