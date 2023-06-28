package model;

import enums.TipoUsuario;

import java.time.LocalDate;

public class PessoaModel extends UsuarioModel {
  private String nome;
  private String telefone;
  private LocalDate dataNascimento;
  private String cpf;
  private EnderecoModel endereco;
  private String email;
  private String observacao;

  public PessoaModel () {
  }

  public PessoaModel (int id, String login, String senha, TipoUsuario tipoUsuario, boolean ativo, String criadoPor, LocalDate criadoEm, String alteradoPor, LocalDate alteradoEm) {
    super(id, login, senha, tipoUsuario, ativo, criadoPor, criadoEm, alteradoPor, alteradoEm);
  }

  public String getNome () {
    return nome;
  }

  public void setNome (String nome) {
    this.nome = nome;
  }

  public String getTelefone () {
    return telefone;
  }

  public void setTelefone (String telefone) {
    this.telefone = telefone;
  }

  public LocalDate getDataNascimento () {
    return dataNascimento;
  }

  public void setDataNascimento (LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getCpf () {
    return cpf;
  }

  public void setCpf (String cpf) {
    this.cpf = cpf;
  }

  public EnderecoModel getEndereco () {
    return endereco;
  }

  public void setEndereco (EnderecoModel endereco) {
    this.endereco = endereco;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getObservacao () {
    return observacao;
  }

  public void setObservacao (String observacao) {
    this.observacao = observacao;
  }
}
