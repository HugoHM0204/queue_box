package view;

import fila.FilaCaixa;

import javax.swing.*;
import java.util.Optional;

public class MainWindow extends JFrame {
    private JPanel panel;
    private JButton proximoButton;
    private JButton retirarSenhaButton;
    private JLabel labelSenha;

    private FilaCaixa filaCaixa = new FilaCaixa();

    public MainWindow() {
        this.setContentPane(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.labelSenha.setText("Aguardando...");

        retirarSenhaButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "Tem prioridade?");

            if (result != JOptionPane.CANCEL_OPTION) {
                String senha = filaCaixa.adicionar(result == JOptionPane.YES_OPTION);

                JOptionPane.showMessageDialog(this, "Senha retirada: " + senha,
                        "Retirar senha",  JOptionPane.INFORMATION_MESSAGE);
            }
        });

        proximoButton.addActionListener(e -> {
            Optional<String> proximo = filaCaixa.chamarProximo();

            if (proximo.isPresent()) {
                labelSenha.setText(proximo.get());
            } else {
                JOptionPane.showMessageDialog(this,
                        "Não há ninguém a ser chamado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
