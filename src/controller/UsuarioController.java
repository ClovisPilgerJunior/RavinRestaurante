package controller;

import enums.TipoUsuario;
import model.UsuarioModel;
import repository.UsuarioRepo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UsuarioController {

    private final UsuarioRepo usuarioRepo;

    public UsuarioController() {
        this.usuarioRepo = new UsuarioRepo();
    }

    public void salvarUsuario(UsuarioModel entidade) {
        usuarioRepo.salvar(entidade);
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

    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepo.listarTodos();
    }

    public boolean autenticarUsuario(String login, String senha) {
        UsuarioModel usuarioAutenticado = usuarioRepo.buscarPorCredenciais(login, senha);
        return usuarioAutenticado != null; // Retorna true se o usuário for autenticado com sucesso, false caso contrário
    }

    public boolean deslogarUsuario(int id){
        UsuarioModel usuarioDeslogado = usuarioRepo.buscarPorId(id);
        return true;
    }
    public void criarUsuarioAdministradorInicial() {

        // Criar o usuário administrador
        UsuarioModel usuarioAdmin = new UsuarioModel();
        usuarioAdmin.setLogin("admin");
        usuarioAdmin.setSenha("admin");
        usuarioAdmin.setAtivo(true);
        usuarioAdmin.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
        usuarioAdmin.setCriadoPor("Sistema");
        usuarioAdmin.setCriadoEm(LocalDate.now());

        usuarioRepo.salvar(usuarioAdmin);
    }

    public UsuarioModel buscarUsuarioPorId(int id) {
        return usuarioRepo.buscarPorId(id);
    }
}



