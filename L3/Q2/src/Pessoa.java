import java.io.Serializable;

public class Pessoa implements Serializable {
  private int id;
  private String nome;
  private String email;
  private String fone;

  // gets
  public String getEmail() {
    return email;
  }

  public String getFone() {
    return fone;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  // set's
  public void setEmail(String email) {
    this.email = email;
  }

  public void setFone(String fone) {
    this.fone = fone;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  // Constructors
  public Pessoa() {
  }

  public Pessoa(int id, String nome, String email, String fone) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.fone = fone;
  }

  // toString
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("ID: ").append(id).append(", Nome: ").append(nome).append(", Email: ").append(email).append(", Fone: ")
        .append(fone);
    return sb.toString();
  }
}
