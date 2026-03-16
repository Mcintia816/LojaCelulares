package LojaDeCelulares.gui;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import LojaDeCelulares.LojaDeCelular;

public class LojaGUI extends JFrame {

    private LojaDeCelular loja;

    public LojaGUI() {

        loja = new LojaDeCelular();

        setTitle("Sistema de Loja de Celulares");
        setSize(600, 600);
        setLocation(0, 0);

        setResizable(false);

        getContentPane().setBackground(Color.lightGray);
    }

    public static void main(String[] args) {

        LojaGUI janela = new LojaGUI();
        janela.setVisible(true);

        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        janela.addWindowListener(fechadorDeJanelaPrincipal);
    }
}
