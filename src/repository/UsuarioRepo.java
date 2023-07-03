package repository;

import model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo {

  private final List<UsuarioModel> usuarios;

  public UsuarioRepo() {
    usuarios = new ArrayList<>();
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
    UsuarioModel usuarioBuscado = null;
    for (UsuarioModel usuario : usuarios) {
      if (usuario.getId() == id)
        usuarioBuscado = usuario;
    }

    return usuarioBuscado;
  }

  public void deletarPeloId(UsuarioModel usuario) {
    usuarios.remove(usuario);
  }

  public int contar() {
    return usuarios.size();
  }

  public UsuarioModel buscarPorCredenciais(String login, String senha) {
    for (UsuarioModel usuario : usuarios) {
      if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
        return usuario; // Retorna o usuário encontrado com as credenciais correspondentes
      }
    }
    return null; // Retorna null se as credenciais não corresponderem a nenhum usuário
  }
}
