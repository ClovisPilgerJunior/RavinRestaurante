package model;

import java.time.LocalDate;

public class ClienteModel extends PessoaModel{
  private String Alergia;
  private boolean vip;

  public ClienteModel(String nome, String telefone, LocalDate dataNascimento, String cpf, int cep, String cidade, String estado, String logradouro, String enderecoLocal, int numero, String complemento, String bairro, String email, String observacao, boolean ativo, String alergia, boolean vip) {
    super(nome, telefone, dataNascimento, cpf, cep, cidade, estado, logradouro, enderecoLocal, numero, complemento, bairro, email, observacao, ativo);
    Alergia = alergia;
    this.vip = vip;
  }

  public String getAlergia() {
    return Alergia;
  }

  public ClienteModel setAlergia(String alergia) {
    Alergia = alergia;
    return this;
  }

  public boolean isVip() {
    return vip;
  }

  public ClienteModel setVip(boolean vip) {
    this.vip = vip;
    return this;
  }
}
