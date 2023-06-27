package view;

import javax.swing.*;
import java.awt.*;

public class UsuarioView {
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
