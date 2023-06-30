package view;

import javax.swing.*;

public class MesaView {
  public static void criarMesaMenu(JMenuBar menuBar){

    JMenu mesaMenu = new JMenu("Mesa");
    JMenuItem cadastrarMesaItem = new JMenuItem("Cadastrar");
    JMenuItem alterarMesaItem = new JMenuItem("Alterar");
    JMenuItem buscarMesaItem = new JMenuItem("Buscar");
    JMenuItem listarMesasItem = new JMenuItem("Listar");

    mesaMenu.add(cadastrarMesaItem);
    mesaMenu.add(alterarMesaItem);
    mesaMenu.add(buscarMesaItem);
    mesaMenu.add(listarMesasItem);

    menuBar.add(mesaMenu);
  }
}
