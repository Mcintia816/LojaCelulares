package LojaDeCelulares.gui;

import javax.swing.*;

public class LojaGUIV3_Com_Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame janela = new LojaGUIV3ComMenu(); // nossa GUI com menu
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
