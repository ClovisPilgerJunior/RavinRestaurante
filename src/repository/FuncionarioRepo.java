package repository;

import model.FuncionarioModel;
import model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepo {
  private final List<FuncionarioModel> funcionarios;

  public FuncionarioRepo() {
    funcionarios = new ArrayList<>();
  }
  public void salvar(FuncionarioModel entidade) {
    FuncionarioModel funcionario = buscarPorId(entidade.getId());

    if(funcionario == null) {
      funcionarios.add(entidade);
    } else {
      funcionario = entidade;
    }
  }

  public void excluir(FuncionarioModel entidade) {
    funcionarios.remove(entidade);
  }

  public FuncionarioModel buscarPorId(int id) {
    FuncionarioModel funcionarioBuscado = null;
    for (FuncionarioModel usuario : funcionarios) {
      if (usuario.getId() == id)
        funcionarioBuscado = usuario;
    }

    return funcionarioBuscado;
  }
  public List<FuncionarioModel> listarTodos() { return funcionarios; }

  public void deletarPeloId(FuncionarioModel usuario) {
    funcionarios.remove(usuario);
  }

  public int contar() {
    return funcionarios.size();
  }

  public FuncionarioModel buscarPorNome(String nome) {
    return null;
  }

}
