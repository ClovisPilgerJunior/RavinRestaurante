package controller;

import enums.TipoUsuario;
import model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private final List<UsuarioModel> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<>();
        criarUsuarioAdministradorInicial();
    }

    public boolean autenticarUsuario(String login, String senha) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return true; // Autenticação bem-sucedida
            }
        }
        return false; // Autenticação falhou
    }

    public void criarUsuario(UsuarioModel novoUsuario) {
        usuarios.add(novoUsuario);
    }

    public void excluirUsuario(UsuarioModel usuario) {
        usuarios.remove(usuario);
    }

    public UsuarioModel obterUsuario(String username) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getLogin().equals(username)) {
                return usuario;
            }
        }
        return null; // Usuário não encontrado
    }

    private void criarUsuarioAdministradorInicial() {
        // Verificar se o usuário administrador já existe
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
                return; // Usuário administrador já cadastrado
            }
        }

        // Criar o usuário administrador
        UsuarioModel usuarioAdmin = new UsuarioModel();
        usuarioAdmin.setId(1);
        usuarioAdmin.setLogin("admin");
        usuarioAdmin.setSenha("admin");
        usuarioAdmin.setAtivo(true);
        usuarioAdmin.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
        // Defina outros atributos do usuário administrador, se necessário

        usuarios.add(usuarioAdmin);
    }
}


