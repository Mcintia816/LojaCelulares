package LojaDeCelulares.gui;

import LojaDeCelulares.LojaDeCelular;
import LojaDeCelulares.Celular;
import LojaDeCelulares.CelularInexistenteException;

import javax.swing.*;
import java.awt.*;

public class LojaGUIV3 extends JFrame {

    JLabel linha1, linha2;
    ImageIcon lojaImg = new ImageIcon("./imgs/loja.png"); // imagem representativa da loja
    ImageIcon addImg = new ImageIcon("./imgs/icons/add.png");
    ImageIcon searchImg = new ImageIcon("./imgs/icons/search.png");
    ImageIcon removeImg = new ImageIcon("./imgs/icons/remove.png");

    JButton botaoAdicionar, botaoPesquisar, botaoRemover;

    LojaDeCelular loja;

    public LojaGUIV3() {

        loja = new LojaDeCelular();

        setTitle("Sistema de Loja de Celulares");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);

        linha1 = new JLabel("Bem-vindo à Loja de Celulares", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        linha2 = new JLabel(lojaImg, JLabel.CENTER);

        botaoAdicionar = new JButton("Cadastrar", addImg);
        botaoAdicionar.addActionListener(e -> cadastrarCelular());

        botaoPesquisar = new JButton("Pesquisar", searchImg);
        botaoPesquisar.addActionListener(e -> pesquisarCelular());

        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.addActionListener(e -> removerCelular());

        getContentPane().setLayout(new GridLayout(3, 2));
        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(linha2);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);
    }


    private void cadastrarCelular() {
        try {
            String codigo = JOptionPane.showInputDialog("Código do celular:");
            String marca = JOptionPane.showInputDialog("Marca:");
            String modelo = JOptionPane.showInputDialog("Modelo:");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

            boolean sucesso = loja.cadastrarCelular(codigo, marca, modelo, preco, quantidade);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Celular cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Código já existe!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }


    private void pesquisarCelular() {
        try {
            String codigo = JOptionPane.showInputDialog("Código do celular:");
            Celular c = loja.pesquisaCelular(codigo);
            JOptionPane.showMessageDialog(this, "Celular encontrado:\n" +
                    "Marca: " + c.getMarca() + "\n" +
                    "Modelo: " + c.getModelo() + "\n" +
                    "Preço: " + c.getPreco() + "\n" +
                    "Quantidade: " + c.getQuantUnidades());
        } catch (CelularInexistenteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void removerCelular() {
        try {
            String codigo = JOptionPane.showInputDialog("Código do celular:");
            loja.removerCelular(codigo);
            JOptionPane.showMessageDialog(this, "Celular removido com sucesso!");
        } catch (CelularInexistenteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame janela = new LojaGUIV3();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//