package view;

import javax.swing.*;

public class MenuMainView {
  public static void exibirMenuPrincipal() {
        JFrame frame = new JFrame("Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        // Aqui você pode adicionar as ações dos botões

        frame.setUndecorated(true);
        frame.add(panel);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
  }
}
