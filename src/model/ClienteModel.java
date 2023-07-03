package model;

import enums.TipoUsuario;

import java.time.LocalDate;

public class ClienteModel extends UsuarioModel{
  private String Alergia;
  private boolean vip;

  public ClienteModel () {
  }

  public ClienteModel (String login, String senha, TipoUsuario tipoUsuario, boolean ativo, boolean logado, String criadoPor, LocalDate criadoEm, String alteradoPor, LocalDate alteradoEm) {
    super(login, senha, tipoUsuario, ativo, logado, criadoPor, criadoEm, alteradoPor, alteradoEm);
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
