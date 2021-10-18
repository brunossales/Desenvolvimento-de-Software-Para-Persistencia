package com;


public class App {
    public static void main(String[] args) throws Exception {
        Serializa s = new Serializa();
        DesSerializa des = new DesSerializa();
        s.serializaApiJava();
        s.serialiazaJson();
        s.serializarXml();
        des.desSerializa();
    }
}
