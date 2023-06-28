package view;

import javax.swing.*;

public class MenuMainView {
  public static void exibirMenuPrincipal() {
    JPanel panel = new JPanel();
    JButton funcionarioButton = new JButton("Funcionário");
    JButton clienteButton = new JButton("Cliente");
    JButton produtoButton = new JButton("Produto");
    JButton cardapioButton = new JButton("Cardápio");
    JButton mesaButton = new JButton("Mesa");
    JButton pedidoButton = new JButton("Pedido");
    JButton sairButton = new JButton("Sair");

    panel.add(funcionarioButton);
    panel.add(clienteButton);
    panel.add(produtoButton);
    panel.add(cardapioButton);
    panel.add(mesaButton);
    panel.add(pedidoButton);
    panel.add(sairButton);

    funcionarioButton.addActionListener(e -> exibirFuncionarioMenu());
    clienteButton.addActionListener(e -> exibirClienteMenu());
    produtoButton.addActionListener(e -> exibirProdutoMenu());
    cardapioButton.addActionListener(e -> exibirCardapioMenu());
    mesaButton.addActionListener(e -> exibirMesaMenu());
    pedidoButton.addActionListener(e -> exibirPedidoMenu());
    sairButton.addActionListener(e -> System.exit(0));

    JOptionPane.showMessageDialog(null, panel, "Menu Principal", JOptionPane.PLAIN_MESSAGE);
  }

  public static void exibirFuncionarioMenu() {
    JOptionPane.showMessageDialog(null, "Menu do Funcionário");
  }

  public static void exibirClienteMenu() {
    JOptionPane.showMessageDialog(null, "Menu do Cliente");
  }

  public static void exibirProdutoMenu() {
    JOptionPane.showMessageDialog(null, "Menu do Produto");
  }

  public static void exibirCardapioMenu() {
    JOptionPane.showMessageDialog(null, "Menu do Cardápio");
  }

  public static void exibirMesaMenu() {
    JOptionPane.showMessageDialog(null, "Menu da Mesa");
  }

  public static void exibirPedidoMenu() {
    JOptionPane.showMessageDialog(null, "Menu do Pedido");
  }
}
