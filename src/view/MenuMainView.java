package view;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMainView {
      public static void exibirMenuPrincipal() {
            JFrame frame = new JFrame("Menu Principal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMenuBar menuBar = new JMenuBar();

            JMenu funcionarioMenu = new JMenu("Funcionário");
            JMenuItem cadastrarFuncionarioItem = new JMenuItem("Cadastrar");
            JMenuItem alterarFuncionarioItem = new JMenuItem("Alterar");
            JMenuItem buscarFuncionarioItem = new JMenuItem("Buscar");
            JMenuItem listarFuncionariosItem = new JMenuItem("Listar");

            funcionarioMenu.add(cadastrarFuncionarioItem);
            funcionarioMenu.add(alterarFuncionarioItem);
            funcionarioMenu.add(buscarFuncionarioItem);
            funcionarioMenu.add(listarFuncionariosItem);

            JMenu sairMenu = new JMenu("Sair");
            JMenuItem sairItem = new JMenuItem("Sair");

            sairMenu.add(sairItem);

            menuBar.add(funcionarioMenu);
            menuBar.add(sairMenu);



            frame.setJMenuBar(menuBar);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            sairItem.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                  }
            });

            cadastrarFuncionarioItem.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Lógica para cadastrar funcionário
                        JOptionPane.showMessageDialog(frame, "Cadastrar Funcionário");
                  }
            });

            alterarFuncionarioItem.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Lógica para alterar funcionário
                        JOptionPane.showMessageDialog(frame, "Alterar Funcionário");
                  }
            });

            buscarFuncionarioItem.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Lógica para buscar funcionário
                        JOptionPane.showMessageDialog(frame, "Buscar Funcionário");
                  }
            });

            listarFuncionariosItem.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Lógica para listar funcionários
                        JOptionPane.showMessageDialog(frame, "Listar Funcionários");
                  }
            });
      }
}



