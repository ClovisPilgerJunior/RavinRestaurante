package model;

import java.time.LocalDate;

public class ClienteModel extends PessoaModel{
  private String Alergia;
  private boolean vip;

  public ClienteModel(){

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
