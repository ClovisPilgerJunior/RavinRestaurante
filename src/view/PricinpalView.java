package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PricinpalView {

      private static JLabel usuarioLabel;

      public static void exibirMenuPrincipal() {
            UsuarioController usuarioController = new UsuarioController();
            JFrame frame = new JFrame("Menu Principal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMenuBar menuBar = new JMenuBar();

            FuncionarioView.criarMenuFuncionario(menuBar);
            ClienteView.criarMenuCliente(menuBar);
            ProdutoView.criarProdutoMenu(menuBar);
            CardapioView.criarCardapioMenu(menuBar);
            PedidoView.criarPedidoMenu(menuBar);
            UsuarioView.criarMenuUsuario(menuBar);
            SairView.criarSairMenu(menuBar);

            frame.setJMenuBar(menuBar);

            // Adicionar a barra de status na parte inferior
            JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            usuarioLabel = new JLabel("Usuário: ");
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

            frame.setSize(1200, 800);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
      }

      public static void atualizarUsuarioLabel(String nomeUsuario) {
            usuarioLabel.setText("Usuário: " + nomeUsuario);
      }
}



