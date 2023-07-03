package view;

import controller.UsuarioController;
import enums.TipoUsuario;
import model.UsuarioModel;
import utils.NonEditableTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

public class UsuarioView {
  private static UsuarioController usuarioController;

  public UsuarioView(UsuarioController usuarioController) {
    UsuarioView.usuarioController = usuarioController;
  }

  public static void criarMenuUsuario (JMenuBar menuBar) {
    JMenu usuarioMenu = new JMenu("Usuário");
    JMenuItem trocarUsuarioItem = new JMenuItem("Trocar Usuário");
    JMenuItem cadastrarUsuarioItem = new JMenuItem("Cadastrar");
    JMenuItem alterarUsuarioItem = new JMenuItem("Alterar");
    JMenuItem listarUsuarioItem = new JMenuItem("Listar");

    usuarioMenu.add(trocarUsuarioItem);
    usuarioMenu.add(cadastrarUsuarioItem);
    usuarioMenu.add(alterarUsuarioItem);
    usuarioMenu.add(listarUsuarioItem);

    menuBar.add(usuarioMenu);

    trocarUsuarioItem.addActionListener(e -> {
      // Lógica para cadastrar usuário
      LoginView.criarLoginMenu();
    });

    cadastrarUsuarioItem.addActionListener(e -> {
      // Lógica para cadastrar usuário
      UsuarioView.cadastrarUsuarioPanel();
    });

    alterarUsuarioItem.addActionListener(e -> {
      // Lógica para alterar usuário
      alterarUsuarioPanel();
    });

    listarUsuarioItem.addActionListener(e -> {
      // Lógica para listar usuários
      listarUsuarios();
    });
  }

  public static void listarUsuarios() {
    List<UsuarioModel> usuarios = usuarioController.listarUsuarios();

    // Criar um array com os dados dos usuários para popular a tabela
    Object[][] data = new Object[usuarios.size()][10]; // Número de colunas é 10 (ID, Login, Senha, Tipo de Usuário)

    for (int i = 0; i < usuarios.size(); i++) {
      UsuarioModel usuario = usuarios.get(i);
      data[i][0] = usuario.getId();
      data[i][1] = usuario.getLogin();
      data[i][2] = usuario.getSenha();
      data[i][3] = usuario.getTipoUsuario();
      if (usuario.isAtivo()){
        data[i][4] = "Ativo";
      } else {
        data[i][4] = "Inativo";
      }
      if (usuario.isLogado()){
        data[i][5] = "Online";
      } else {
        data[i][5] = "Offline";
      }
      data[i][6] = usuario.getCriadoPor();
      data[i][7] = usuario.getCriadoEm();
      data[i][8] = usuario.getAlteradoPor();
      data[i][9] = usuario.getAlteradoEm();

    }

    // Criar um array com os nomes das colunas da tabela
    String[] columnNames = {
            "ID",
            "Login",
            "Senha",
            "Tipo de Usuário",
            "Status",
            "Status Login",
            "Criado Por",
            "Criado Em",
            "Alterado Por",
            "Alterado Em"
    };

    JFrame parentFrame = null;

    // Criar o modelo da tabela usando o NonEditableTableModel
    NonEditableTableModel tableModel = new NonEditableTableModel(data, columnNames);

    // Criar a tabela com os dados e os nomes das colunas
    JTable table = new JTable(tableModel) {
      // Sobrescrever o método isCellEditable para tornar todas as células não editáveis
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    // Definir o modo de redimensionamento automático das colunas
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    // Ajustar o tamanho das colunas com base no tamanho do conteúdo do cabeçalho
    for (int i = 0; i < table.getColumnCount(); i++) {
      TableColumn column = table.getColumnModel().getColumn(i);
      TableCellRenderer headerRenderer = column.getHeaderRenderer();
      if (headerRenderer == null) {
        headerRenderer = table.getTableHeader().getDefaultRenderer();
      }
      Object headerValue = column.getHeaderValue();
      Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, 0);
      int headerWidth = headerComp.getPreferredSize().width;
      int cellWidth = table.prepareRenderer(table.getCellRenderer(0, i), 0, i).getPreferredSize().width;
      int width = Math.max(headerWidth, cellWidth);
      column.setPreferredWidth(width);
    }


    // Centralizar o conteúdo das células
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    for (int i = 0; i < table.getColumnCount(); i++) {
      table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Criar uma barra de rolagem para a tabela
    JScrollPane scrollPane = new JScrollPane(table);

    // Criar um painel para exibir a tabela
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(scrollPane, BorderLayout.CENTER);

    // Criar uma janela para exibir o painel com a tabela
    JDialog dialog = new JDialog(parentFrame, "Lista de Usuários", true); // O terceiro parâmetro true define o diálogo como modal
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.getContentPane().add(panel);
    dialog.pack();
    dialog.setLocationRelativeTo(parentFrame); // Centralizar o diálogo em relação ao JFrame pai
    dialog.setResizable(false);
    dialog.setSize(700
            , 400);
    dialog.setVisible(true);
  }

  public static void cadastrarUsuarioPanel() {
    // Campos de texto
    var loginCampo = new JTextField(10);
    var senhaCampo = new JTextField(10);

    // ComboBox para o tipo de usuário
    var tipoUsuarioComboBox = new JComboBox<>(TipoUsuario.values());

    // Radio buttons para o status de ativo
    var ativoRadioButton = new JRadioButton("Ativo");
    ativoRadioButton.setSelected(true);
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

    UsuarioModel usuarioModel = new UsuarioModel();

    // Botões
    var salvarButton = new JButton("Salvar");
    var cancelarButton = new JButton("Cancelar");
    var listarButton = new JButton("Listar");

    salvarButton.addActionListener(e -> {

        // Ação ao pressionar o botão "Salvar"
        String login = loginCampo.getText();
        String senha = senhaCampo.getText();
        TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioComboBox.getSelectedItem();
        boolean ativo = ativoRadioButton.isSelected();
        if (loginCampo.getText().isBlank() && senhaCampo.getText().isBlank()){
          JOptionPane.showMessageDialog(null, "Preencha os campos Usuário e Senha");
        } else {
          usuarioModel.setLogin(login);
          usuarioModel.setSenha(senha);
          usuarioModel.setTipoUsuario(tipoUsuario);
          usuarioModel.setAtivo(ativo);

          try {
            usuarioController.salvarUsuario(usuarioModel);
            System.out.println(usuarioModel);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
          } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
          }

          // Fechar o diálogo
          JOptionPane.getRootFrame().dispose();
        }
        // Atribua os valores aos atributos do objeto UsuarioModel
    });

    cancelarButton.addActionListener(e -> {
        // Ação ao pressionar o botão "Cancelar"
        // Fechar o diálogo
        JOptionPane.getRootFrame().dispose();

    });

    listarButton.addActionListener(e -> {
        listarUsuarios();
    });

    inputPanel.add(new JLabel()); // Espaço vazio para alinhar o botão
    inputPanel.add(salvarButton);

    JPanel buttonPanel = new JPanel(new FlowLayout()); // Alinhamento padrão (FlowLayout.CENTER)
    buttonPanel.add(salvarButton);
    buttonPanel.add(listarButton);
    buttonPanel.add(cancelarButton);

    var mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(inputPanel, BorderLayout.CENTER);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    JOptionPane.showOptionDialog(null, mainPanel, "Cadastrar Usuário", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
  }

  public static void alterarUsuarioPanel() {
    // Campos de texto
    var loginCampoAlterar = new JTextField(10);
    var senhaCampoAlterar = new JTextField(10);

    // ComboBox para o tipo de usuário
    var tipoUsuarioComboBoxAlterar = new JComboBox<>(TipoUsuario.values());

    // Radio buttons para o status de ativo
    var ativoRadioButtonAlterar = new JRadioButton("Ativo");
    var inativoRadioButtonAlterar = new JRadioButton("Inativo");

    // Campo de texto para o ID
    var idCampo = new JTextField(10);

    // Botão "Buscar"
    var buscarButton = new JButton("Buscar");

    UsuarioModel usuarioModel = new UsuarioModel();

    // Ação ao pressionar o botão "Buscar"
    buscarButton.addActionListener(e -> {
      String idText = idCampo.getText();

      if (idText.isBlank()) {
        JOptionPane.showMessageDialog(null, "Digite o ID do usuário.");
      } else if (!idText.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "ID inválido. Digite um número inteiro válido.");
      } else {
        int id = Integer.parseInt(idText);

        UsuarioModel usuario = usuarioController.buscarUsuarioPorId(id);
        // Buscar o usuário pelo ID
        if (usuario != null) {
          // Preencher os campos com as informações do usuário
          loginCampoAlterar.setText(usuario.getLogin());
          senhaCampoAlterar.setText(usuario.getSenha());
          tipoUsuarioComboBoxAlterar.setSelectedItem(usuario.getTipoUsuario());
          ativoRadioButtonAlterar.setSelected(usuario.isAtivo());
          inativoRadioButtonAlterar.setSelected(!usuario.isAtivo());
        } else {
          JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
        }
      }
    });

    var inputPanel = new JPanel(new GridLayout(0, 2));
    inputPanel.add(new JLabel("ID:"));
    inputPanel.add(idCampo);
    inputPanel.add(new JLabel()); // Espaço vazio para alinhar com a próxima linha
    inputPanel.add(buscarButton);
    inputPanel.add(new JLabel("Login:"));
    inputPanel.add(loginCampoAlterar);
    inputPanel.add(new JLabel("Senha:"));
    inputPanel.add(senhaCampoAlterar);
    inputPanel.add(new JLabel("Tipo de Usuário:"));
    inputPanel.add(tipoUsuarioComboBoxAlterar);
    inputPanel.add(new JLabel("Status:"));
    inputPanel.add(ativoRadioButtonAlterar);
    inputPanel.add(new JLabel()); // Espaço vazio para alinhar os radio buttons
    inputPanel.add(inativoRadioButtonAlterar);


    // Botões
    var salvarButton = new JButton("Salvar");
    var cancelarButton = new JButton("Cancelar");
    var listarButton = new JButton("Listar");

    salvarButton.addActionListener(e -> {
      // Ação ao pressionar o botão "Salvar"
      String login = loginCampoAlterar.getText();
      String senha = senhaCampoAlterar.getText();
      TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioComboBoxAlterar.getSelectedItem();
      boolean ativo = ativoRadioButtonAlterar.isSelected();

      if (loginCampoAlterar.getText().isBlank() && senhaCampoAlterar.getText().isBlank()){
        JOptionPane.showMessageDialog(null, "Preencha os campos Usuário e Senha");
      } else {
        usuarioModel.setLogin(login);
        usuarioModel.setSenha(senha);
        usuarioModel.setTipoUsuario(tipoUsuario);
        usuarioModel.setAtivo(ativo);

        try {
          usuarioController.salvarUsuario(usuarioModel);
          System.out.println(usuarioModel);
          JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (Exception ex){
          JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        }

        // Fechar o diálogo
        JOptionPane.getRootFrame().dispose();
      }

    });

    cancelarButton.addActionListener(e -> {
      // Ação ao pressionar o botão "Cancelar"
      // Fechar o diálogo
      JOptionPane.getRootFrame().dispose();
    });

    listarButton.addActionListener(e -> {
      listarUsuarios();
    });

    inputPanel.add(new JLabel()); // Espaço vazio para alinhar o botão
    inputPanel.add(salvarButton);

    JPanel buttonPanel = new JPanel(new FlowLayout()); // Alinhamento padrão (FlowLayout.CENTER)
    buttonPanel.add(salvarButton);
    buttonPanel.add(listarButton);
    buttonPanel.add(cancelarButton);

    var mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(inputPanel, BorderLayout.CENTER);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    JOptionPane.showOptionDialog(null, mainPanel, "Alterar Usuário", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
  }
}
