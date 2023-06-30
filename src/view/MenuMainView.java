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

            FuncionarioView.criarMenuFuncionario(menuBar);
            ClienteView.criarMenuCliente(menuBar);
            ProdutoView.criarProdutoMenu(menuBar);
            CardapioView.criarCardapioMenu(menuBar);
            CardapioView.criarCardapioMenu(menuBar);
            PedidoView.criarPedidoMenu(menuBar);
            UsuarioView.criarMenuUsuario(menuBar);
            SairView.criarSairMenu(menuBar);

            frame.setJMenuBar(menuBar);
            frame.setSize(800, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

      }
}



