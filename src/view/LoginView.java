package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.*;

import static view.PricinpalView.atualizarUsuarioLabel;
import static view.PricinpalView.exibirMenuPrincipal;

public class LoginView {

  private static UsuarioController usuarioController;

  public LoginView(UsuarioController usuarioController){
    LoginView.usuarioController = usuarioController;
  }
  public static void criarLoginMenu(){
    JFrame loginFrame = new JFrame("Tela de Login");
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    var panel = new JPanel(new GridLayout(3, 2));

    var usuarioLabel = new JLabel("Usuário:");
    var usuarioField = new JTextField(10);

    var senhaLabel = new JLabel("Senha:");
    var senhaField = new JPasswordField(10);

    var loginButton = new JButton("Login");
    loginButton.addActionListener(e -> {

      String login = usuarioField.getText();
      String senha = String.valueOf(senhaField.getPassword());

      boolean autenticar = usuarioController.autenticarUsuario(login, senha);

      if (autenticar) {
        // Lógica para ação após a autenticação bem-sucedida
        JOptionPane.showMessageDialog(loginFrame, "Autenticação bem-sucedida!");
        loginFrame.dispose();
        exibirMenuPrincipal();
        atualizarUsuarioLabel(login);
      } else {
        // Lógica para ação após a autenticação falhada
        JOptionPane.showMessageDialog(loginFrame, "Autenticação falhou!");
      }
    });

    panel.add(usuarioLabel);
    panel.add(usuarioField);
    panel.add(senhaLabel);
    panel.add(senhaField);
    panel.add(new JLabel()); // Espaço vazio para alinhar o botão
    panel.add(loginButton);

    JDialog dialog = new JDialog(loginFrame, "Tela de Login", true);
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.add(panel);
    dialog.pack();
    dialog.setLocationRelativeTo(null); // Centralizar a janela na tela
    dialog.setVisible(true);
  }
}
