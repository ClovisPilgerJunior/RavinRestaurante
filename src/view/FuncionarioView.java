package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    cadastrarFuncionarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para cadastrar funcionário
        //
      }
    });

    alterarFuncionarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para alterar funcionário
        JOptionPane.showMessageDialog(null, "Alterar Funcionário");
      }
    });

    buscarFuncionarioItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para buscar funcionário
        JOptionPane.showMessageDialog(null, "Buscar Funcionário");
      }
    });

    listarFuncionariosItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Lógica para listar funcionários
        JOptionPane.showMessageDialog(null, "Listar Funcionários");
      }
    });
  }
}
