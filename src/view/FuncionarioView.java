package view;

import controller.FuncionarioController;
import enums.Cargo;
import enums.Escolaridade;
import enums.EstadoCivil;
import model.FuncionarioModel;
import utils.NonEditableTableModel;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.time.LocalDate;

import static utils.DataUtils.parseLocalDate;

public class FuncionarioView {

  private static FuncionarioController funcionarioController;

  public FuncionarioView(FuncionarioController funcionarioController) {
    FuncionarioView.funcionarioController = funcionarioController;
  }

  public static void criarMenuFuncionario(JMenuBar menuBar) {
    JMenu funcionarioMenu = new JMenu("Funcionário");
    JMenuItem cadastrarFuncionarioItem = new JMenuItem("Cadastrar");
    JMenuItem alterarFuncionarioItem = new JMenuItem("Alterar");
    JMenuItem buscarFuncionarioItem = new JMenuItem("Buscar");
    JMenuItem listarFuncionariosItem = new JMenuItem("Listar");

    funcionarioMenu.add(cadastrarFuncionarioItem);
    funcionarioMenu.add(alterarFuncionarioItem);
    funcionarioMenu.add(buscarFuncionarioItem);
    funcionarioMenu.add(listarFuncionariosItem);

    menuBar.add(funcionarioMenu);

    cadastrarFuncionarioItem.addActionListener(e -> {
      cadastrarFuncionarioPanel();
    });

    alterarFuncionarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para alterar funcionário
        JOptionPane.showMessageDialog(null, "Alterar Funcionário");
      }
    });

    buscarFuncionarioItem.addActionListener(e -> {
    });

    listarFuncionariosItem.addActionListener(e -> {
      listarFuncionarios();
    });
  }

  public static void cadastrarFuncionarioPanel() {
    // Campos específicos de funcionários
    var nomeCampo = new JTextField(10);
    var telefoneCampo = new JTextField(10);
    var estadoCivilComboBox = new JComboBox<>(EstadoCivil.values());
    var escolaridadeComboBox = new JComboBox<>(Escolaridade.values());
    var dataNascimentoCampo = new JFormattedTextField();
    var cpfCampo = new JTextField(10);
    var cepCampo = new JTextField(10);
    var cidadeCampo = new JTextField(10);
    var estadoCampo = new JTextField(10);
    var logradouroCampo = new JTextField(10);
    var enderecoCampo = new JTextField(10);
    var numeroCampo = new JTextField(10);
    var complementoCampo = new JTextField(10);
    var bairroCampo = new JTextField(10);
    var emailCampo = new JTextField(10);
    var observacaoCampo = new JTextField(10);
    var ativoRadioButton = new JRadioButton("Ativo");
    ativoRadioButton.setSelected(true);
    var inativoRadioButton = new JRadioButton("Inativo");
    var cargoCampoComboBox = new JComboBox<>(Cargo.values());
    var carteiraTrabalhoCampo = new JTextField(10);
    var dataAdmissaoCampo = new JFormattedTextField();
    var dataDemissaoCampo = new JFormattedTextField();
    var disponibilidadeCheckBox = new JCheckBox("Disponível");

    // Grupo de botões para garantir que apenas uma opção seja selecionada
    var statusButtonGroup = new ButtonGroup();
    statusButtonGroup.add(ativoRadioButton);
    statusButtonGroup.add(inativoRadioButton);

    var inputPanel = new JPanel(new GridLayout(0, 2));
    inputPanel.add(new JLabel("Nome:"));
    inputPanel.add(nomeCampo);
    inputPanel.add(new JLabel("Telefone:"));
    inputPanel.add(telefoneCampo);
    inputPanel.add(new JLabel("Estado Civil:"));
    inputPanel.add(estadoCivilComboBox);
    inputPanel.add(new JLabel("Escolaridade:"));
    inputPanel.add(escolaridadeComboBox);
    inputPanel.add(new JLabel("Data de Nascimento:"));
    inputPanel.add(dataNascimentoCampo);
    inputPanel.add(new JLabel("CPF:"));
    inputPanel.add(cpfCampo);
    inputPanel.add(new JLabel("CEP:"));
    inputPanel.add(cepCampo);
    inputPanel.add(new JLabel("Cidade:"));
    inputPanel.add(cidadeCampo);
    inputPanel.add(new JLabel("Estado:"));
    inputPanel.add(estadoCampo);
    inputPanel.add(new JLabel("Logradouro:"));
    inputPanel.add(logradouroCampo);
    inputPanel.add(new JLabel("Endereço:"));
    inputPanel.add(enderecoCampo);
    inputPanel.add(new JLabel("Número:"));
    inputPanel.add(numeroCampo);
    inputPanel.add(new JLabel("Complemento:"));
    inputPanel.add(complementoCampo);
    inputPanel.add(new JLabel("Bairro:"));
    inputPanel.add(bairroCampo);
    inputPanel.add(new JLabel("E-mail:"));
    inputPanel.add(emailCampo);
    inputPanel.add(new JLabel("Observação:"));
    inputPanel.add(observacaoCampo);
    inputPanel.add(new JLabel("Status:"));
    inputPanel.add(ativoRadioButton);
    inputPanel.add(new JLabel()); // Espaço vazio para alinhar os radio buttons
    inputPanel.add(inativoRadioButton);
    inputPanel.add(new JLabel("Cargo:"));
    inputPanel.add(cargoCampoComboBox);
    inputPanel.add(new JLabel("Carteira de Trabalho:"));
    inputPanel.add(carteiraTrabalhoCampo);
    inputPanel.add(new JLabel("Data de Admissão:"));
    inputPanel.add(dataAdmissaoCampo);
    inputPanel.add(new JLabel("Data de Demissão:"));
    inputPanel.add(dataDemissaoCampo);
    inputPanel.add(new JLabel("Disponibilidade:"));
    inputPanel.add(disponibilidadeCheckBox);

    // Botões
    var salvarButton = new JButton("Salvar");
    var cancelarButton = new JButton("Cancelar");
    var listarButton = new JButton("Listar");

    salvarButton.addActionListener(e -> {
      // Ação ao pressionar o botão "Salvar"
      String nome = nomeCampo.getText();
      String telefone = telefoneCampo.getText();
      EstadoCivil estadoCivil = (EstadoCivil) estadoCivilComboBox.getSelectedItem();
      Escolaridade escolaridade = (Escolaridade) escolaridadeComboBox.getSelectedItem();
      LocalDate dataNascimento = parseLocalDate(dataNascimentoCampo.getText());
      String cpf = cpfCampo.getText();
      int cep = Integer.parseInt(cepCampo.getText());
      String cidade = cidadeCampo.getText();
      String estado = estadoCampo.getText();
      String logradouro = logradouroCampo.getText();
      String endereco = enderecoCampo.getText();
      int numero = Integer.parseInt(numeroCampo.getText());
      String complemento = complementoCampo.getText();
      String bairro = bairroCampo.getText();
      String email = emailCampo.getText();
      String observacao = observacaoCampo.getText();
      boolean ativo = ativoRadioButton.isSelected();
      Cargo cargo = (Cargo) cargoCampoComboBox.getSelectedItem();
      String carteiraTrabalho = carteiraTrabalhoCampo.getText();
      LocalDate dataAdmissao = parseLocalDate(dataAdmissaoCampo.getText());
      LocalDate dataDemissao = parseLocalDate(dataDemissaoCampo.getText());
      boolean disponibilidade = disponibilidadeCheckBox.isSelected();

      if (nome.isBlank() || cpf.isBlank()) {
        JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
      } else {
        FuncionarioModel funcionarioModel = new FuncionarioModel(nome, telefone, dataNascimento, cpf, cep, cidade, estado, logradouro, endereco, numero, complemento, bairro, email, observacao, ativo, estadoCivil, escolaridade, cargo, carteiraTrabalho, dataAdmissao, dataDemissao, disponibilidade);
        try {
          funcionarioController.salvar(funcionarioModel);
          System.out.println(funcionarioModel);
          JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
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
      listarFuncionarios();
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

    JOptionPane.showOptionDialog(null, mainPanel, "Cadastrar Funcionário", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
  }

  public static void listarFuncionarios() {
    List<FuncionarioModel> funcionarios = funcionarioController.listarFuncionarios();

    // Criar um array com os dados dos funcionários para popular a tabela
    Object[][] data = new Object[funcionarios.size()][4];

    for (int i = 0; i < funcionarios.size(); i++) {
      FuncionarioModel funcionario = funcionarios.get(i);
      data[i][0] = funcionario.getId();
      data[i][1] = funcionario.getNome();
      data[i][2] = funcionario.isAtivo();
      data[i][3] = funcionario.getCargo();
    }

    // Criar um array com os nomes das colunas da tabela
    String[] columnNames = {
            "Id",
            "Nome",
            "Ativo",
            "Cargo"
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
    JDialog dialog = new JDialog(parentFrame, "Lista de Funcionários", true); // O terceiro parâmetro true define o diálogo como modal
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.getContentPane().add(panel);
    dialog.pack();
    dialog.setLocationRelativeTo(parentFrame); // Centralizar o diálogo em relação ao JFrame pai
    dialog.setResizable(false);
    dialog.setSize(800, 600);
    dialog.setVisible(true);
  }


}
