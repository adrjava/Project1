package aplicatie.view;

import aplicatie.controller.MainController;
import aplicatie.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static aplicatie.view.DashboardPage.showMessage;

public class RegistrationPage extends JFrame {

    private JPanel panel,panelButon,imagePannnel;

    private JLabel usernameLabel, passwordLabel, emailLabel, imageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JButton registerButton, resetButton, beackButton;
    private EmptyBorder border;
    private ImageIcon imageIcon;
    public MainController mainController = null;

    public RegistrationPage() {
        setTitle("Register");
        setSize(450, 490);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(3, 2));
        panel.setSize(450,100);
        imagePannnel = new JPanel();
        panelButon = new JPanel(new FlowLayout());
        border = new EmptyBorder(0, 10, 0, 0);

        initUsername();
        initPassword();
        initEmail();
        initRegisterButton();
        initResetButton();
        initBeackButton();
        initImage();

        add(panel, BorderLayout.NORTH);
        add(panelButon,BorderLayout.CENTER);
        add(imagePannnel, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void initImage(){
        Image image = new ImageIcon(".//src/main/java/aplicatie/departamente2.jpg")
                .getImage().getScaledInstance(450,350,Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel = new JLabel(imageIcon);
        imagePannnel.add(imageLabel);

    }
    private void initUsername() {
        usernameLabel = new JLabel("Username");
        usernameLabel.setBorder(border);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);
    }
    private void initPassword() {
        passwordLabel = new JLabel("Enter Password");
        passwordLabel.setBorder(border);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);
    }
    private  void initEmail(){
        emailLabel = new JLabel("Enter Email");
        emailLabel.setBorder(border);
        panel.add(emailLabel);

        emailField = new JTextField();
        panel.add(emailField);
    }


    private void initRegisterButton() {
        mainController = MainController.getInstance();
        registerButton = new JButton("Register");
        panelButon.add(registerButton);
        registerButton.addActionListener(e -> {
            if (valid()) {
                User user = new User(
                        usernameField.getText(),
                        new String(passwordField.getPassword()),
                        emailField.getText());
                if(mainController.registerUser(user)) {
                    LoginPage loginPage = new LoginPage();
                    loginPage.setVisible(true);
                    showMessage("Registration Successful!", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }else{
                    showMessage("Registration NOT Successful!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    private void initResetButton() {
        resetButton = new JButton("Reset");
        panelButon.add(resetButton);
        resetButton.addActionListener(event -> {
            usernameField.setText("");
            passwordField.setText("");
            emailField.setText("");
            showMessage("Fields Reset!", JOptionPane.INFORMATION_MESSAGE);
        });
    }
    private void initBeackButton(){
        beackButton = new JButton("Beack");
        panelButon.add(beackButton);
        beackButton.addActionListener(event->{
            new StartPage().setVisible(true);
            dispose();
        });
    }
    private boolean valid() {
        if (usernameField.getText().equals("")) {
            showMessage("Please enter Username", JOptionPane.ERROR_MESSAGE);
            usernameField.requestFocus();
            return false;
        } else if (String.valueOf(passwordField.getPassword()).equals("")) {
            showMessage("Please enter Password", JOptionPane.ERROR_MESSAGE);
            passwordField.requestFocus();
            return false;
        }
        return true;
    }

    public static void showMessage(String msg, int messageType) {
        JOptionPane.showMessageDialog(null, msg, "Bilete GUI", messageType);
    }

    public static void main(String[] args) {
        new RegistrationPage();
    }

}
