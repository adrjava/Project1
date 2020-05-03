package aplicatie.view;

import javax.swing.*;
import java.awt.*;

public  class StartPage extends JFrame {
    private JPanel buttonPannel, imagePannnel;

    private JButton loginButton, registerButton, exitButton, infoButton;
    private ImageIcon imageIcon;
    private JLabel imageLabel, languageLabel;
    private JRadioButton radioButton1, radioButton2;
    private ButtonGroup buttonGroup;

    public StartPage() {
        buttonPannel = new JPanel();
        imagePannnel = new JPanel();
        LayoutManager layoutManager = new FlowLayout();
        buttonPannel.setLayout(layoutManager);

        initButtons();
        initImage();
        actionMetode();

        add(buttonPannel, BorderLayout.NORTH);
        add(imagePannnel, BorderLayout.SOUTH);

        setTitle("Aplicatie De Gestiune");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void initImage(){
        Image image = new ImageIcon(".//src/main/java/aplicatie/login.jpg")
                .getImage().getScaledInstance(450,350,Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel = new JLabel(imageIcon);
        imagePannnel.add(imageLabel);

    }
    private void initButtons(){
        initLoginButton();
        initRegisterButton();
        initExitButton();
        initInfoButton();
    }
    private  void initLoginButton(){
        loginButton = new JButton("Login");
        buttonPannel.add(loginButton);
    }
    private  void initRegisterButton(){
        registerButton = new JButton("Register");
        buttonPannel.add(registerButton);
    }
    private void initExitButton(){
        exitButton = new JButton("Exit");
        buttonPannel.add(exitButton);
    }
    private void initInfoButton(){
        infoButton = new JButton("Info");
        buttonPannel.add(infoButton);
    }

    private void actionMetode() {
        loginButton.addActionListener(event -> {
            LoginPage loginPage = new LoginPage();
            dispose();
        });
        registerButton.addActionListener(event -> {
            RegistrationPage registrationPage = new RegistrationPage();
            dispose();
        });
        exitButton.addActionListener(event ->{
            dispose();
        });

        infoButton.addActionListener(event ->{
            Information info = new Information();
            dispose();
        });
    }

    public static void main(String[] args) {
        new StartPage();
    }
}

