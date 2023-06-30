package view;

import javax.swing.*;

public class PedidoView {
  public static void criarPedidoMenu(JMenuBar menuBar){

    JMenu pedidoMenu = new JMenu("Pedido");
    JMenuItem cadastrarPedidoItem = new JMenuItem("Cadastrar");
    JMenuItem alterarPedidoItem = new JMenuItem("Alterar");
    JMenuItem buscarPedidoItem = new JMenuItem("Buscar");
    JMenuItem listarPedidosItem = new JMenuItem("Listar");

    pedidoMenu.add(cadastrarPedidoItem);
    pedidoMenu.add(alterarPedidoItem);
    pedidoMenu.add(buscarPedidoItem);
    pedidoMenu.add(listarPedidosItem);

    menuBar.add(pedidoMenu);
  }
}
