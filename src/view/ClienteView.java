package view;

import javax.swing.*;

public class ClienteView {
  public static void criarMenuCliente(JMenuBar menuBar){

    JMenu clienteMenu = new JMenu("Cliente");
    JMenuItem cadastrarClienteItem = new JMenuItem("Cadastrar");
    JMenuItem alterarClienteItem = new JMenuItem("Alterar");
    JMenuItem buscarClienteItem = new JMenuItem("Buscar");
    JMenuItem listarClientesItem = new JMenuItem("Listar");

    clienteMenu.add(cadastrarClienteItem);
    clienteMenu.add(alterarClienteItem);
    clienteMenu.add(buscarClienteItem);
    clienteMenu.add(listarClientesItem);

    menuBar.add(clienteMenu);
  }
}
