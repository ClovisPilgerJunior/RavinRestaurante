package model;

import java.time.LocalDate;

public abstract class PessoaModel extends EnderecoModel {

  private static int ultimoId = 0;
  private int id;
  private String nome;
  private String telefone;
  private LocalDate dataNascimento;
  private String cpf;
  private String endereco;
  private String email;
  private String observacao;
  private boolean ativo;


  public PessoaModel(int cep, String cidade, String estado, String logradouro, String endereco, int numero, String complemento, String bairro, int id, String nome, String telefone, LocalDate dataNascimento, String cpf, String endereco1, String email, String observacao, boolean ativo) {
    super(cep, cidade, estado, logradouro, endereco, numero, complemento, bairro);
    this.id = ultimoId++;
    this.nome = nome;
    this.telefone = telefone;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
    this.endereco = endereco1;
    this.email = email;
    this.observacao = observacao;
    this.ativo = ativo;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }
}
