package model;

import java.time.LocalDate;

public class ClienteModel extends PessoaModel{
  private String Alergia;
  private boolean vip;

  public ClienteModel () {
  }

  public ClienteModel(String nome, String telefone, LocalDate dataNascimento, String cpf, EnderecoModel endereco, String email, String observacao, boolean ativo, String alergia, boolean vip) {
    super(nome, telefone, dataNascimento, cpf, endereco, email, observacao, ativo);
    Alergia = alergia;
    this.vip = vip;
  }

  public String getAlergia () {
    return Alergia;
  }

  public void setAlergia (String alergia) {
    Alergia = alergia;
  }

  public boolean isVip () {
    return vip;
  }

  public void setVip (boolean vip) {
    this.vip = vip;
  }
}
