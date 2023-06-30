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

            JMenu clienteMenu = new JMenu("Cliente");
            JMenuItem cadastrarClienteItem = new JMenuItem("Cadastrar");
            JMenuItem alterarClienteItem = new JMenuItem("Alterar");
            JMenuItem buscarClienteItem = new JMenuItem("Buscar");
            JMenuItem listarClientesItem = new JMenuItem("Listar");

            clienteMenu.add(cadastrarClienteItem);
            clienteMenu.add(alterarClienteItem);
            clienteMenu.add(buscarClienteItem);
            clienteMenu.add(listarClientesItem);

            JMenu produtoMenu = new JMenu("Produto");
            JMenuItem cadastrarProdutoItem = new JMenuItem("Cadastrar");
            JMenuItem alterarProdutoItem = new JMenuItem("Alterar");
            JMenuItem buscarProdutoItem = new JMenuItem("Buscar");
            JMenuItem listarProdutosItem = new JMenuItem("Listar");

            produtoMenu.add(cadastrarProdutoItem);
            produtoMenu.add(alterarProdutoItem);
            produtoMenu.add(buscarProdutoItem);
            produtoMenu.add(listarProdutosItem);

            JMenu cardapioMenu = new JMenu("Cardápio");
            JMenuItem cadastrarCardapioItem = new JMenuItem("Cadastrar");
            JMenuItem alterarCardapioItem = new JMenuItem("Alterar");
            JMenuItem buscarCardapioItem = new JMenuItem("Buscar");
            JMenuItem listarCardapiosItem = new JMenuItem("Listar");

            cardapioMenu.add(cadastrarCardapioItem);
            cardapioMenu.add(alterarCardapioItem);
            cardapioMenu.add(buscarCardapioItem);
            cardapioMenu.add(listarCardapiosItem);

            JMenu mesaMenu = new JMenu("Mesa");
            JMenuItem cadastrarMesaItem = new JMenuItem("Cadastrar");
            JMenuItem alterarMesaItem = new JMenuItem("Alterar");
            JMenuItem buscarMesaItem = new JMenuItem("Buscar");
            JMenuItem listarMesasItem = new JMenuItem("Listar");

            mesaMenu.add(cadastrarMesaItem);
            mesaMenu.add(alterarMesaItem);
            mesaMenu.add(buscarMesaItem);
            mesaMenu.add(listarMesasItem);

            JMenu pedidoMenu = new JMenu("Pedido");
            JMenuItem cadastrarPedidoItem = new JMenuItem("Cadastrar");
            JMenuItem alterarPedidoItem = new JMenuItem("Alterar");
            JMenuItem buscarPedidoItem = new JMenuItem("Buscar");
            JMenuItem listarPedidosItem = new JMenuItem("Listar");

            pedidoMenu.add(cadastrarPedidoItem);
            pedidoMenu.add(alterarPedidoItem);
            pedidoMenu.add(buscarPedidoItem);
            pedidoMenu.add(listarPedidosItem);


            JMenu sairMenu = new JMenu("Sair");
            JMenuItem sairItem = new JMenuItem("Sair");

            sairMenu.add(sairItem);


            FuncionarioView.criarMenuFuncionario(menuBar);
            menuBar.add(produtoMenu);
            menuBar.add(cardapioMenu);
            menuBar.add(mesaMenu);
            menuBar.add(pedidoMenu);
            UsuarioView.criarMenuUsuario(menuBar);
            menuBar.add(sairMenu);

            frame.setJMenuBar(menuBar);
            frame.setSize(800, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            sairItem.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                  }
            });


      }
}



