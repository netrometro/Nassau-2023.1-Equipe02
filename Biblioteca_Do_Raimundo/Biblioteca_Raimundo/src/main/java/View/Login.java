package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        super("Login");

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Criação do painel principal
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);

        // Criação do campo de senha
        passwordField = new JPasswordField();
        passwordField.addActionListener(this);
        panel.add(passwordField);

        // Criação do botão de login
        loginButton = new JButton("Logar");
        loginButton.addActionListener(this);
        panel.add(loginButton);

        // Exibe a janela
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton || e.getSource() == passwordField) {
            // Verifica se a senha é válida (exemplo simples)
            String password = new String(passwordField.getPassword());
            if (password.equals("admin")) {
                // Senha correta, exibe mensagem de boas-vindas
                JOptionPane.showMessageDialog(this, "Bem-vindo!");
                // Fecha a janela
                dispose();
            } else {
                // Senha incorreta, exibe mensagem de erro
                JOptionPane.showMessageDialog(this, "Senha incorreta. Tente novamente.");
                // Limpa o campo de senha
                passwordField.setText("");
            }
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
