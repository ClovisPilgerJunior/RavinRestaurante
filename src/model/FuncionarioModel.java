package model;

import enums.Cargo;
import enums.Escolaridade;
import enums.EstadoCivil;
import enums.TipoUsuario;

import java.time.LocalDate;

public class FuncionarioModel extends UsuarioModel{
  private EstadoCivil estadoCivil;
  private Escolaridade escolaridade;

  private LocalDate dataNascimeto;
  private Cargo cargo;
  private String nCarteiraTrabalho;
  private LocalDate dataAdmissao;
  private LocalDate dataDemissao;
  private boolean disponibilidade;

  public FuncionarioModel () {
  }

  public FuncionarioModel (String login, String senha, TipoUsuario tipoUsuario, boolean ativo, boolean logado, String criadoPor, LocalDate criadoEm, String alteradoPor, LocalDate alteradoEm, EstadoCivil estadoCivil, Escolaridade escolaridade, LocalDate dataNascimeto, Cargo cargo, String nCarteiraTrabalho, LocalDate dataAdmissao, LocalDate dataDemissao, boolean disponibildiade) {
    super(login, senha, tipoUsuario, ativo, logado, criadoPor, criadoEm, alteradoPor, alteradoEm);
    this.estadoCivil = estadoCivil;
    this.escolaridade = escolaridade;
    this.dataNascimeto = dataNascimeto;
    this.cargo = cargo;
    this.nCarteiraTrabalho = nCarteiraTrabalho;
    this.dataAdmissao = dataAdmissao;
    this.dataDemissao = dataDemissao;
    this.disponibilidade = disponibildiade;
  }

  public EstadoCivil getEstadoCivil () {
    return estadoCivil;
  }

  public void setEstadoCivil (EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public Escolaridade getEscolaridade () {
    return escolaridade;
  }

  public void setEscolaridade (Escolaridade escolaridade) {
    this.escolaridade = escolaridade;
  }

  public Cargo getCargo () {
    return cargo;
  }

  public void setCargo (Cargo cargo) {
    this.cargo = cargo;
  }

  public String getnCarteiraTrabalho () {
    return nCarteiraTrabalho;
  }

  public void setnCarteiraTrabalho (String nCarteiraTrabalho) {
    this.nCarteiraTrabalho = nCarteiraTrabalho;
  }

  public LocalDate getDataAdmissao () {
    return dataAdmissao;
  }

  public void setDataAdmissao (LocalDate dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public LocalDate getDataDemissao () {
    return dataDemissao;
  }

  public void setDataDemissao (LocalDate dataDemissao) {
    this.dataDemissao = dataDemissao;
  }

  public boolean isDisponibilidade() {
    return disponibilidade;
  }

  public void setDisponibilidade(boolean disponibilidade) {
    this.disponibilidade = disponibilidade;
  }

  public LocalDate getDataNascimeto() {
    return dataNascimeto;
  }

  public void setDataNascimeto(LocalDate dataNascimeto) {
    this.dataNascimeto = dataNascimeto;
  }
}
