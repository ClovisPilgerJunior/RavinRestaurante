import controller.FuncionarioController;
import controller.UsuarioController;
import view.LoginView;
import view.PricinpalView;
import view.UsuarioView;

public class RavinMain {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.criarUsuarioAdministradorInicial();

        FuncionarioController funcionarioController = new FuncionarioController();

        LoginView loginView = new LoginView(usuarioController);
        loginView.criarLoginMenu();
    }
}
