package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PricipalView {
      static final UsuarioController usuarioController = new UsuarioController();

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
            if (usuarioController.isUsuarioAdministrador()) {
                  UsuarioView.criarMenuUsuario(menuBar);
            }
            SairView.criarSairMenu(menuBar);

            frame.setJMenuBar(menuBar);

            // Adicionar a barra de status na parte inferior
            JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel usuarioLabel = new JLabel("Usuário: " + "admin");
            JLabel horaLabel = new JLabel("Hora: ");

            statusPanel.add(usuarioLabel);
            statusPanel.add(horaLabel);

            frame.add(statusPanel, BorderLayout.SOUTH);

            // Configurar o Timer para atualizar a hora a cada segundo
            javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Obter a hora atual
                        Date horaAtual = new Date();

                        // Formatá-la como uma string
                        SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");
                        String horaFormatada = formatadorHora.format(horaAtual);

                        // Atualizar o JLabel da hora
                        horaLabel.setText("Hora: " + horaFormatada);
                  }
            });
             // Iniciar imediatamente e atualizar a cada 1 segundo
            timer.start();

            frame.setSize(800, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
      }
}



