import controller.UsuarioController;
import view.UsuarioView;

import javax.swing.*;
import java.awt.*;

public class RavinMain {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();

        UsuarioView usuarioView = new UsuarioView(usuarioController);

        usuarioView.loginUsuarioPanel();
    }
}
