package aplicatie.view;

import aplicatie.controller.MainController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginPage extends JFrame {

    private JPanel panel;
    private JPanel panelButoane;

    private JButton loginButton;
    private JButton registerButton;
    private JButton forgothButton;
    private JButton beackButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;


    LoginPage(){
        super("LoginAutentification");
        setSize(400,125);
        setLocationRelativeTo(null);
        EmptyBorder borderLabel = new EmptyBorder(5,10,5,10);

        usernameLabel = new JLabel("User Name: ");
        usernameLabel.setBorder(borderLabel);
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBorder(borderLabel);

        passwordField = new JPasswordField();
        usernameField = new JTextField();

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        forgothButton = new JButton("ForgothPass");
        beackButton = new JButton("Back");

        actionMetod();

        panel = new JPanel(new GridLayout(2,2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        panelButoane = new JPanel(new FlowLayout());
        panelButoane.add(loginButton);
        panelButoane.add(registerButton);
        panelButoane.add(forgothButton);
        panelButoane.add(beackButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel,BorderLayout.CENTER);
        add(panelButoane,BorderLayout.SOUTH);
        setVisible(true);
    }

    private void actionMetod() {
        beackButton.addActionListener(event->{
            new StartPage().setVisible(true);
            dispose();
        });
        registerButton.addActionListener(event->{
            new RegistrationPage().setVisible(true);
            dispose();
        });
        loginButton.addActionListener(event->{
            MainController mainController = MainController.getInstance();
            if (mainController.verificaLogin(usernameField.getText(), new String(passwordField.getPassword()))){
                new DashboardPage(usernameField.getText()).setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Credentiale incorecte !!!");
                usernameField.setText("");
                passwordField.setText("");
                usernameField.requestFocus();
            }
        });

    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
