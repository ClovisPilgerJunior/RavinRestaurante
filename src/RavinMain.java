import controller.UsuarioController;
import view.LoginView;
import view.UsuarioView;

public class RavinMain {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();

        UsuarioView usuarioView = new UsuarioView(usuarioController);

        LoginView.criarLoginMenu();
    }
}
