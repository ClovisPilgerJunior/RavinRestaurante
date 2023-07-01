package controller;

import enums.TipoUsuario;
import model.UsuarioModel;
import repository.UsuarioRepo;
import view.UsuarioView;

public class UsuarioController {
    private final UsuarioRepo usuarioRepo;

    public UsuarioController() {
        usuarioRepo = new UsuarioRepo();
        criarUsuarioAdministradorInicial();
    }

    public boolean autenticarUsuario(String login, String senha) {
        for (UsuarioModel usuario : usuarioRepo.listarTodos()) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return true; // Autenticação bem-sucedida
            }
        }
        return false; // Autenticação falhou
    }

    public void criarUsuario(UsuarioModel novoUsuario) {
        usuarioRepo.salvar(novoUsuario);
    }

    public void excluirUsuario(UsuarioModel usuario) {
        usuarioRepo.excluir(usuario);
    }

    public UsuarioModel obterUsuario(String username) {
        for (UsuarioModel usuario : usuarioRepo.listarTodos()) {
            if (usuario.getLogin().equals(username)) {
                return usuario;
            }
        }
        return null; // Usuário não encontrado
    }

    private void criarUsuarioAdministradorInicial() {
        // Verificar se o usuário administrador já existe
        for (UsuarioModel usuario : usuarioRepo.listarTodos()) {
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

        usuarioRepo.salvar(usuarioAdmin);
    }

    public boolean isUsuarioAdministrador() {
        UsuarioModel usuarioAdmin = obterUsuario("admin"); // Supondo que "admin" seja o nome de usuário do administrador
        if (usuarioAdmin != null && usuarioAdmin.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
            return true; // O usuário é um administrador
        }
        return false; // O usuário não é um administrador
    }
}



