import controller.FuncionarioController;
import controller.UsuarioController;
import view.FuncionarioView;
import view.LoginView;
import view.PricinpalView;
import view.UsuarioView;

public class RavinMain {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.criarUsuarioAdministradorInicial();

        UsuarioView usuarioView = new UsuarioView(usuarioController);
        FuncionarioView funcionarioView = new FuncionarioView(new FuncionarioController());

        LoginView loginView = new LoginView(usuarioController);
        loginView.criarLoginMenu();
    }
}
