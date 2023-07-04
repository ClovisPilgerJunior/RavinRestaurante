package model;

public class EnderecoModel {
  private int cep;
  private String cidade;
  private String estado;
  private String logradouro;
  private String endereco;
  private int numero;
  private String complemento;
  private String bairro;

  public EnderecoModel(int cep, String cidade, String estado, String logradouro, String endereco, int numero, String complemento, String bairro) {
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
    this.logradouro = logradouro;
    this.endereco = endereco;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
  }


  public int getCep() {
    return cep;
  }

  public void setCep(int cep) {
    this.cep = cep;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
}
