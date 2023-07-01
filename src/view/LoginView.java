package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MenuMainView.exibirMenuPrincipal;
import static view.MenuMainView.usuarioController;

public class LoginView {
  public static void criarLoginMenu(){
    JFrame loginFrame = new JFrame("Tela de Login");
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    var panel = new JPanel(new GridLayout(3, 2));

    var usuarioLabel = new JLabel("Usuário:");
    var usuarioField = new JTextField(10);

    var senhaLabel = new JLabel("Senha:");
    var senhaField = new JPasswordField(10);

    var loginButton = new JButton("Login");

    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        var login = usuarioField.getText();
        var senha = String.valueOf(senhaField.getPassword());

        boolean autenticado = usuarioController.autenticarUsuario(login, senha);

        if (autenticado) {
          // Lógica para ação após a autenticação bem-sucedida
          JOptionPane.showMessageDialog(loginFrame, "Autenticação bem-sucedida!");
          loginFrame.dispose();
          exibirMenuPrincipal();
        } else {
          // Lógica para ação após a autenticação falhada
          JOptionPane.showMessageDialog(loginFrame, "Autenticação falhou!");
        }
      }
    });

    panel.add(usuarioLabel);
    panel.add(usuarioField);
    panel.add(senhaLabel);
    panel.add(senhaField);
    panel.add(new JLabel()); // Espaço vazio para alinhar o botão
    panel.add(loginButton);

    loginFrame.add(panel);
    loginFrame.pack();
    loginFrame.setLocationRelativeTo(null); // Centralizar a janela na tela
    loginFrame.setVisible(true);
  }
}
