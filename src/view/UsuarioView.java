package view;

import controller.UsuarioController;
import enums.TipoUsuario;
import model.UsuarioModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MenuMainView.exibirMenuPrincipal;
import static view.MenuMainView.usuarioController;

public class UsuarioView {
  private UsuarioController usuarioController;

  public UsuarioView(UsuarioController controller) {
    this.usuarioController = controller;
  }

  public static void criarMenuUsuario (JMenuBar menuBar) {
    JMenu usuarioMenu = new JMenu("Usuário");
    JMenuItem trocarUsuarioItem = new JMenuItem("Trocar Usuário");
    JMenuItem cadastrarUsuarioItem = new JMenuItem("Cadastrar");
    JMenuItem alterarUsuarioItem = new JMenuItem("Alterar");
    JMenuItem buscarUsuarioItem = new JMenuItem("Buscar");
    JMenuItem listarUsuarioItem = new JMenuItem("Listar");

    usuarioMenu.add(trocarUsuarioItem);
    usuarioMenu.add(cadastrarUsuarioItem);
    usuarioMenu.add(alterarUsuarioItem);
    usuarioMenu.add(buscarUsuarioItem);
    usuarioMenu.add(listarUsuarioItem);

    menuBar.add(usuarioMenu);

    trocarUsuarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para cadastrar usuário

        LoginView.criarLoginMenu();

      }
    });

    cadastrarUsuarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para cadastrar usuário
        UsuarioView.cadastrarUsuarioPanel();
      }
    });

    alterarUsuarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para alterar usuário
        JOptionPane.showMessageDialog(null, "Alterar Usuário");
      }
    });

    buscarUsuarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para buscar usuário
        JOptionPane.showMessageDialog(null, "Buscar Usuário");
      }
    });

    listarUsuarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para listar usuários
        JOptionPane.showMessageDialog(null, "Listar Usuários");
      }
    });
  }

  public static UsuarioModel cadastrarUsuarioPanel() {
    UsuarioModel usuarioModel = new UsuarioModel();

    // Campos de texto
    var loginCampo = new JTextField(10);
    var senhaCampo = new JTextField(10);

    // ComboBox para o tipo de usuário
    var tipoUsuarioComboBox = new JComboBox<>(TipoUsuario.values());

    // Radio buttons para o status de ativo
    var ativoRadioButton = new JRadioButton("Ativo");
    var inativoRadioButton = new JRadioButton("Inativo");

    // Grupo de botões para garantir que apenas uma opção seja selecionada
    var statusButtonGroup = new ButtonGroup();
    statusButtonGroup.add(ativoRadioButton);
    statusButtonGroup.add(inativoRadioButton);

    var inputPanel = new JPanel(new GridLayout(0, 2));
    inputPanel.add(new JLabel("Login:"));
    inputPanel.add(loginCampo);
    inputPanel.add(new JLabel("Senha:"));
    inputPanel.add(senhaCampo);
    inputPanel.add(new JLabel("Tipo de Usuário:"));
    inputPanel.add(tipoUsuarioComboBox);
    inputPanel.add(new JLabel("Status:"));
    inputPanel.add(ativoRadioButton);
    inputPanel.add(new JLabel()); // Espaço vazio para alinhar os radio buttons
    inputPanel.add(inativoRadioButton);

    int option = JOptionPane.showConfirmDialog(null, inputPanel, "Formulário de Usuário",
        JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION) {
      String login = loginCampo.getText();
      String senha = senhaCampo.getText();
      TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioComboBox.getSelectedItem();
      boolean ativo = ativoRadioButton.isSelected();

      // Atribua os valores aos atributos do objeto UsuarioModel
      int contadorIds = 1;
      usuarioModel.setId(contadorIds);
      usuarioModel.setLogin(login);
      usuarioModel.setSenha(senha);
      usuarioModel.setTipoUsuario(tipoUsuario);
      usuarioModel.setAtivo(ativo);
    }

    return usuarioModel;
  }


}
