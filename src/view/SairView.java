package view;


import javax.swing.*;
import javax.tools.JavaFileManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SairView {
   public static void criarSairMenu(JMenuBar menuBar){
     JMenu sairMenu = new JMenu("Sair");
     JMenuItem sairItem = new JMenuItem("Sair");

     sairMenu.add(sairItem);

     menuBar.add(sairMenu);

     sairItem.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
         int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação de Saída", JOptionPane.YES_NO_OPTION);
         if (opcao == JOptionPane.YES_OPTION) {
           System.exit(0);  // Encerra a execução do programa
         }
       }
     });
   }
}
