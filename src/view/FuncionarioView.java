package view;

import controller.UsuarioController;
import enums.Cargo;
import enums.Escolaridade;
import enums.EstadoCivil;
import enums.TipoUsuario;
import model.FuncionarioModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static utils.DataUtils.parseLocalDate;

import static java.util.stream.StreamOpFlag.createMask;

public class FuncionarioView {

  public static void criarMenuFuncionario(JMenuBar menuBar){
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

    });

    alterarFuncionarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para alterar funcionário
        JOptionPane.showMessageDialog(null, "Alterar Funcionário");
      }
    });

    buscarFuncionarioItem.addActionListener(e ->{
    });

    listarFuncionariosItem.addActionListener(e -> {

    });

    public static void cadastrarFuncionarioPanel() {

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

      // Campos específicos de funcionários
      var estadoCivilComboBox = new JComboBox<>(EstadoCivil.values());
      var escolaridadeComboBox = new JComboBox<>(Escolaridade.values());
      var dataNascimentoCampo = new JFormattedTextField(created"##/##/####"));
      var cargoCampo = new JTextField(10);
      var carteiraTrabalhoCampo = new JTextField(10);
      var dataAdmissaoCampo = new JFormattedTextField(createMask("##/##/####"));
      var dataDemissaoCampo = new JFormattedTextField(createMask("##/##/####"));
      var disponibilidadeCheckBox = new JCheckBox("Disponível");

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

      // Campos específicos de funcionários
      inputPanel.add(new JLabel("Estado Civil:"));
      inputPanel.add(estadoCivilComboBox);
      inputPanel.add(new JLabel("Escolaridade:"));
      inputPanel.add(escolaridadeComboBox);
      inputPanel.add(new JLabel("Data de Nascimento:"));
      inputPanel.add(dataNascimentoCampo);
      inputPanel.add(new JLabel("Cargo:"));
      inputPanel.add(cargoCampo);
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
        String login = loginCampo.getText();
        String senha = senhaCampo.getText();
        TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioComboBox.getSelectedItem();
        boolean ativo = ativoRadioButton.isSelected();

        // Valores específicos de funcionários
        EstadoCivil estadoCivil = (EstadoCivil) estadoCivilComboBox.getSelectedItem();
        Escolaridade escolaridade = (Escolaridade) escolaridadeComboBox.getSelectedItem();
        LocalDate dataNascimento = parseLocalDate(dataNascimentoCampo.getText(), "dd/MM/yyyy");
        Cargo cargo = new Cargo(cargoCampo.getText());
        String carteiraTrabalho = carteiraTrabalhoCampo.getText();
        LocalDate dataAdmissao = parseLocalDate(dataAdmissaoCampo.getText(), "dd/MM/yyyy");
        LocalDate dataDemissao = parseLocalDate(dataDemissaoCampo.getText(), "dd/MM/yyyy");
        boolean disponibilidade = disponibilidadeCheckBox.isSelected();

        if (loginCampo.getText().isBlank() && senhaCampo.getText().isBlank()) {
          JOptionPane.showMessageDialog(null, "Preencha os campos Usuário e Senha");
        } else {
          FuncionarioModel funcionarioModel = new FuncionarioModel(
              login, senha, tipoUsuario, ativo, true, "", LocalDate.now(), "", LocalDate.now(),
              estadoCivil, escolaridade, dataNascimento, cargo, carteiraTrabalho,
              dataAdmissao, dataDemissao, disponibilidade
          );

          try {
            FuncionarioController.salvarFuncionario(funcionarioModel);
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
        // listarFuncionarios();
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
  }
}
