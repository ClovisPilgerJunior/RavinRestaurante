package view;

import javax.swing.*;

public class CardapioView {
  public static void criarCardapioMenu(JMenuBar menuBar){

    JMenu cardapioMenu = new JMenu("Cardápio");
    JMenuItem cadastrarCardapioItem = new JMenuItem("Cadastrar");
    JMenuItem alterarCardapioItem = new JMenuItem("Alterar");
    JMenuItem buscarCardapioItem = new JMenuItem("Buscar");
    JMenuItem listarCardapiosItem = new JMenuItem("Listar");

    cardapioMenu.add(cadastrarCardapioItem);
    cardapioMenu.add(alterarCardapioItem);
    cardapioMenu.add(buscarCardapioItem);
    cardapioMenu.add(listarCardapiosItem);

    menuBar.add(cardapioMenu);

  }
}
