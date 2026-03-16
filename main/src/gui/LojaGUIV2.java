package LojaDeCelulares.gui;

import javax.swing.*;
import java.awt.*;

public class LojaGUIV2 extends JFrame {

    JLabel linha1, linha2;
    ImageIcon celularImg = new ImageIcon("./imgs/celular.png"); // imagem representativa da loja

    public LojaGUIV2() {
        setTitle("Sistema de Loja de Celulares");
        setSize(400, 400); // tamanho da janela
        setLocation(0, 0); // posição na tela
        setResizable(true);
        getContentPane().setBackground(Color.white);

        linha1 = new JLabel("Bem-vindo à Loja de Celulares", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        linha2 = new JLabel(celularImg, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
    }

    public static void main(String[] args) {
        JFrame janela = new LojaGUIV2();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//