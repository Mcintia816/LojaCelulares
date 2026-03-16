package LojaDeCelulares.gui;

import LojaDeCelulares.LojaDeCelular;
import LojaDeCelulares.Celular;
import LojaDeCelulares.CelularInexistenteException;

import javax.swing.*;
import java.awt.*;

public class LojaGUIV3ComMenu extends JFrame {

    JLabel linha1, linha2;
    ImageIcon lojaImg = new ImageIcon("./imgs/loja.png"); // imagem da loja
    LojaDeCelular loja = new LojaDeCelular();
    JMenuBar barraDeMenu = new JMenuBar();

    public LojaGUIV3ComMenu() {

        setTitle("Sistema de Loja de Celulares");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);

        linha1 = new JLabel("Bem-vindo à Loja de Celulares", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        linha2 = new JLabel(lojaImg, JLabel.CENTER);

        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel()); // espaço vazio

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarCelular = new JMenuItem("Cadastrar celular");
        menuCadastrar.add(menuCadastrarCelular);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarCelular = new JMenuItem("Pesquisar celular");
        menuPesquisar.add(menuPesquisarCelular);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverCelular = new JMenuItem("Remover celular");
        menuRemover.add(menuRemoverCelular);

        menuCadastrarCelular.addActionListener(ae -> cadastrarCelular());
        menuPesquisarCelular.addActionListener(ae -> pesquisarCelular());
        menuRemoverCelular.addActionListener(ae -> removerCelular());

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);

        setJMenuBar(barraDeMenu);
    }

    private void cadastrarCelular() {
        try {
            String codigo = JOptionPane.showInputDialog(this, "Código do celular:");
            String marca = JOptionPane.showInputDialog(this, "Marca:");
            String modelo = JOptionPane.showInputDialog(this, "Modelo:");
            double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço:"));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade:"));

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
            String codigo = JOptionPane.showInputDialog(this, "Código do celular:");
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
            String codigo = JOptionPane.showInputDialog(this, "Código do celular:");
            loja.removerCelular(codigo);
            JOptionPane.showMessageDialog(this, "Celular removido com sucesso!");
        } catch (CelularInexistenteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame janela = new LojaGUIV3ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//