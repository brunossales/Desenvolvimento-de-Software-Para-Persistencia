import java.io.Serializable;

public class Carro implements Serializable {
    private int chassi;
    private String modelo;
    private String marca;
    private int ano;

    //Constructor
    public Carro(int cha, String mo, String ma, int ano){
        this.chassi = cha;
        this.modelo = mo;
        this.marca = ma;
        this.ano = ano;
    }

    //Gets
    public int getChassi() {return chassi;}
    public String getMarca() {return marca;}
    public int getAno() {return ano;}
    public String getModelo() {return modelo;}

    //sets
    public void setAno(int ano) {this.ano = ano;}
    public void setChassi(int chassi) {this.chassi = chassi;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setModelo(String modelo) {this.modelo = modelo;}

    //ToString
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Chassi: ").append(chassi).append(", Modelo: ").append(modelo).append(", Marca: ")
                .append(marca).append(", Ano: ").append(ano);
        return sb.toString();
    }

}
