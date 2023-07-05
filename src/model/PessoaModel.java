package model;

import java.time.LocalDate;

public abstract class PessoaModel {

  private static int ultimoId = 0;
  private int id;
  private String nome;
  private String telefone;
  private LocalDate dataNascimento;
  private String cpf;
  private int cep;
  private String cidade;
  private String estado;
  private String logradouro;
  private String enderecoLocal;
  private int numero;
  private String complemento;
  private String bairro;
  private String email;
  private String observacao;
  private boolean ativo;


  public PessoaModel(String nome, String telefone, LocalDate dataNascimento, String cpf, int cep, String cidade, String estado, String logradouro, String enderecoLocal, int numero, String complemento, String bairro, String email, String observacao, boolean ativo) {
    this.id = ultimoId++;
    this.nome = nome;
    this.telefone = telefone;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
    this.logradouro = logradouro;
    this.enderecoLocal = enderecoLocal;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.email = email;
    this.observacao = observacao;
    this.ativo = ativo;
  }

  @Override
  public String toString() {
    return "PessoaModel{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", telefone='" + telefone + '\'' +
            ", dataNascimento=" + dataNascimento +
            ", cpf='" + cpf + '\'' +
            ", cep=" + cep +
            ", cidade='" + cidade + '\'' +
            ", estado='" + estado + '\'' +
            ", logradouro='" + logradouro + '\'' +
            ", enderecoLocal='" + enderecoLocal + '\'' +
            ", numero=" + numero +
            ", complemento='" + complemento + '\'' +
            ", bairro='" + bairro + '\'' +
            ", email='" + email + '\'' +
            ", observacao='" + observacao + '\'' +
            ", ativo=" + ativo +
            '}';
  }

  public static int getUltimoId() {
    return ultimoId;
  }

  public static void setUltimoId(int ultimoId) {
    PessoaModel.ultimoId = ultimoId;
  }

  public int getId() {
    return id;
  }

  public PessoaModel setId(int id) {
    this.id = id;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public PessoaModel setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public String getTelefone() {
    return telefone;
  }

  public PessoaModel setTelefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public PessoaModel setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
    return this;
  }

  public String getCpf() {
    return cpf;
  }

  public PessoaModel setCpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  public int getCep() {
    return cep;
  }

  public PessoaModel setCep(int cep) {
    this.cep = cep;
    return this;
  }

  public String getCidade() {
    return cidade;
  }

  public PessoaModel setCidade(String cidade) {
    this.cidade = cidade;
    return this;
  }

  public String getEstado() {
    return estado;
  }

  public PessoaModel setEstado(String estado) {
    this.estado = estado;
    return this;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public PessoaModel setLogradouro(String logradouro) {
    this.logradouro = logradouro;
    return this;
  }

  public String getEnderecoLocal() {
    return enderecoLocal;
  }

  public PessoaModel setEnderecoLocal(String enderecoLocal) {
    this.enderecoLocal = enderecoLocal;
    return this;
  }

  public int getNumero() {
    return numero;
  }

  public PessoaModel setNumero(int numero) {
    this.numero = numero;
    return this;
  }

  public String getComplemento() {
    return complemento;
  }

  public PessoaModel setComplemento(String complemento) {
    this.complemento = complemento;
    return this;
  }

  public String getBairro() {
    return bairro;
  }

  public PessoaModel setBairro(String bairro) {
    this.bairro = bairro;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public PessoaModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getObservacao() {
    return observacao;
  }

  public PessoaModel setObservacao(String observacao) {
    this.observacao = observacao;
    return this;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public PessoaModel setAtivo(boolean ativo) {
    this.ativo = ativo;
    return this;
  }
}
