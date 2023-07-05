package model;

import enums.Cargo;
import enums.Escolaridade;
import enums.EstadoCivil;

import java.time.LocalDate;

public class FuncionarioModel extends PessoaModel{

  private EstadoCivil estadoCivil;
  private Escolaridade escolaridade;
  private Cargo cargo;
  private String nCarteiraTrabalho;
  private LocalDate dataAdmissao;
  private LocalDate dataDemissao;
  private boolean disponibilidade;

  public FuncionarioModel(){
  }

  public FuncionarioModel(int id, String nome, String telefone, LocalDate dataNascimento, String cpf, int cep, String cidade, String estado, String logradouro, String enderecoLocal, int numero, String complemento, String bairro, String email, String observacao, boolean ativo, String criadoPor, LocalDate criadoEm, String alteradoPor, LocalDate alteradoEm, EstadoCivil estadoCivil, Escolaridade escolaridade, Cargo cargo, String nCarteiraTrabalho, LocalDate dataAdmissao, LocalDate dataDemissao, boolean disponibilidade) {
    super(id, nome, telefone, dataNascimento, cpf, cep, cidade, estado, logradouro, enderecoLocal, numero, complemento, bairro, email, observacao, ativo, criadoPor, criadoEm, alteradoPor, alteradoEm);
    this.estadoCivil = estadoCivil;
    this.escolaridade = escolaridade;
    this.cargo = cargo;
    this.nCarteiraTrabalho = nCarteiraTrabalho;
    this.dataAdmissao = dataAdmissao;
    this.dataDemissao = dataDemissao;
    this.disponibilidade = disponibilidade;
  }

  @Override
  public String toString() {
    return "FuncionarioModel{" +
            "estadoCivil=" + estadoCivil +
            ", escolaridade=" + escolaridade +
            ", cargo=" + cargo +
            ", nCarteiraTrabalho='" + nCarteiraTrabalho + '\'' +
            ", dataAdmissao=" + dataAdmissao +
            ", dataDemissao=" + dataDemissao +
            ", disponibilidade=" + disponibilidade +
            "} " + super.toString();
  }

  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public Escolaridade getEscolaridade() {
    return escolaridade;
  }

  public void setEscolaridade(Escolaridade escolaridade) {
    this.escolaridade = escolaridade;
  }

  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }

  public String getnCarteiraTrabalho() {
    return nCarteiraTrabalho;
  }

  public void setnCarteiraTrabalho(String nCarteiraTrabalho) {
    this.nCarteiraTrabalho = nCarteiraTrabalho;
  }

  public LocalDate getDataAdmissao() {
    return dataAdmissao;
  }

  public void setDataAdmissao(LocalDate dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public LocalDate getDataDemissao() {
    return dataDemissao;
  }

  public void setDataDemissao(LocalDate dataDemissao) {
    this.dataDemissao = dataDemissao;
  }

  public boolean isDisponibilidade() {
    return disponibilidade;
  }

  public void setDisponibilidade(boolean disponibilidade) {
    this.disponibilidade = disponibilidade;
  }
}

