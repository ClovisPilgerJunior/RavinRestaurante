package model;

import enums.TipoUsuario;

import java.time.LocalDate;

public class ClienteModel extends UsuarioModel{
  private String Alergia;
  private boolean vip;

  public ClienteModel () {
  }

  public ClienteModel (int id, String login, String senha, TipoUsuario tipoUsuario, boolean ativo, String criadoPor, LocalDate criadoEm, String alteradoPor, LocalDate alteradoEm) {
    super(id, login, senha, tipoUsuario, ativo, criadoPor, criadoEm, alteradoPor, alteradoEm);
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
