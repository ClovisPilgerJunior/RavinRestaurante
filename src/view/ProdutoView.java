package view;

import javax.swing.*;

public class ProdutoView {
  public static void criarProdutoMenu (JMenuBar menuBar){
    JMenu produtoMenu = new JMenu("Produto");
    JMenuItem cadastrarProdutoItem = new JMenuItem("Cadastrar");
    JMenuItem alterarProdutoItem = new JMenuItem("Alterar");
    JMenuItem buscarProdutoItem = new JMenuItem("Buscar");
    JMenuItem listarProdutosItem = new JMenuItem("Listar");

    produtoMenu.add(cadastrarProdutoItem);
    produtoMenu.add(alterarProdutoItem);
    produtoMenu.add(buscarProdutoItem);
    produtoMenu.add(listarProdutosItem);

    menuBar.add(produtoMenu);
  }
}
