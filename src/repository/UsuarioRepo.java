package repository;

import model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo {

  private final List<UsuarioModel> usuarios;

  public UsuarioRepo() {
    usuarios = new ArrayList<UsuarioModel>();
  }

  public void salvar(UsuarioModel entidade) {
    UsuarioModel usuario = buscarPorId(entidade.getId());

    if(usuario == null) {
      usuarios.add(entidade);
    } else {
      usuario = entidade;
    }

  }

  public List<UsuarioModel> listarTodos() {
    return usuarios;
  }

  public void excluir(UsuarioModel entidade) {
    usuarios.remove(entidade);
  }

  public UsuarioModel buscarPorId(int id) {
    UsuarioModel funcionarioBuscado = null;
    for (UsuarioModel funcionario : usuarios) {
      if (funcionario.getId() == id)
        funcionarioBuscado = funcionario;
    }

    return funcionarioBuscado;
  }

  public void deletarPeloId(UsuarioModel funcionario) {
    usuarios.remove(funcionario);
  }

  public int contar() {
    return usuarios.size();
  }

  public UsuarioModel buscarPorNome(String nome) {
    return null;
  }

}
