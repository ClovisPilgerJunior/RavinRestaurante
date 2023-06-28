package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MenuMainView.exibirMenuPrincipal;

public class UsuarioView {
  private UsuarioController usuarioController;

  public UsuarioView(UsuarioController usuarioController) {
    this.usuarioController = usuarioController;
  }

  public void loginUsuarioPanel() {
    JFrame loginFrame = new JFrame("Tela de Login");
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(3, 2));

    JLabel usuarioLabel = new JLabel("Usuário:");
    JTextField usuarioField = new JTextField(10);

    JLabel senhaLabel = new JLabel("Senha:");
    JPasswordField senhaField = new JPasswordField(10);

    JButton loginButton = new JButton("Login");

    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String login = usuarioField.getText();
        char[] senhaChars = senhaField.getPassword();
        String senha = new String(senhaChars);

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
  public void cadastrarUsuarioPanel() {
    JTextField idCampo = new JTextField(10);
    JTextField loginCampo = new JTextField(10);
    JTextField senhaCampo = new JTextField(10);
    JTextField tipoUsuarioCampo = new JTextField(10);
    JTextField ativoCampo = new JTextField(10);

    JPanel inputPanel = new JPanel(new GridLayout(0, 2));
    inputPanel.add(new JLabel("ID:"));
    inputPanel.add(idCampo);
    inputPanel.add(new JLabel("Login:"));
    inputPanel.add(loginCampo);
    inputPanel.add(new JLabel("Senha:"));
    inputPanel.add(senhaCampo);
    inputPanel.add(new JLabel("Tipo de Usuário:"));
    inputPanel.add(tipoUsuarioCampo);
    inputPanel.add(new JLabel("Ativo:"));
    inputPanel.add(ativoCampo);

    int option = JOptionPane.showConfirmDialog(null, inputPanel, "Formulário de Usuário", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION) {
      String id = idCampo.getText();
      String login = loginCampo.getText();
      String senha = senhaCampo.getText();
      String tipoUsuario = tipoUsuarioCampo.getText();
      String ativo = ativoCampo.getText();
    }

  }
}
