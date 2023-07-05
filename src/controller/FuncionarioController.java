package controller;

import enums.Cargo;
import model.FuncionarioModel;
import repository.FuncionarioRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

  private FuncionarioRepo funcionarioRepo;

  public FuncionarioController() {
    funcionarioRepo = new FuncionarioRepo();
  }

  public void salvar(FuncionarioModel entidade) throws Exception {
    LocalDate dataNascimento = entidade.getDataNascimento();
    LocalDate dataAtual = LocalDate.now();
    LocalDate dataLimite = dataAtual.minusYears(18); // Subtrai 18 anos da data atual

    if (dataNascimento.isAfter(dataLimite)) {
      // O funcionário não tem 18 anos ou mais
      throw new Exception("O funcionário deve ter 18 anos ou mais.");
    }
    funcionarioRepo.salvar(entidade);
  }

  public void alterar(FuncionarioModel entidade) {
    // REGRAS DE NEGÓCIO
    funcionarioRepo.salvar(entidade);
  }

  public void excluir(int id) {
    FuncionarioModel funcionarioBuscado = funcionarioRepo.buscarPorId(id);

    if (funcionarioBuscado != null) {
      funcionarioRepo.excluir(funcionarioBuscado);
    }
  }

  public FuncionarioModel consultar(int id) {
    return funcionarioRepo.buscarPorId(id);
  }

  public List<FuncionarioModel> listarFuncionarios() {
    return funcionarioRepo.listarTodos();
  }

  public List<FuncionarioModel> listarGarconsDisponiveis() {
    List<FuncionarioModel> funcionarios = funcionarioRepo.listarTodos();
    List<FuncionarioModel> funcionarioDisponiveis = new ArrayList<>();

    for (FuncionarioModel funcionario : funcionarios) {
      if (funcionario.isDisponibilidade()
          && funcionario.getCargo().equals(Cargo.GARCOM)) {
        funcionarioDisponiveis.add(funcionario);
      }
    }

    return funcionarioDisponiveis;
  }

}
