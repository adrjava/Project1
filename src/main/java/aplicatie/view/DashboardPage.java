package aplicatie.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;

public class DashboardPage extends JFrame {
    private String userName;
    private JPanel   imagePannnel, buttonPannel,buttonPannelNorth, buttonPannelCenter, buttonPannelSouth;
    private ImageIcon imageIcon;
    private JLabel imageLabel, userLabel, dataLabel;
    private JButton resetButton, beackButton, exitButton, userButton;

    public DashboardPage(String userName){
        this.userName = userName;

        initButtons();
        initImage();
        actionMetode();

        add(imagePannnel, BorderLayout.WEST);

        setTitle("Gestionare Angajati");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initButtons(){
        buttonPannel = new JPanel(new BorderLayout());
        initButtonNorth();
        initButtonSouth();
        add(buttonPannel, BorderLayout.EAST);
    }
    private void initButtonSouth(){
        buttonPannelSouth = new JPanel(new FlowLayout());
        initResetButton();
        initBeackButton();
        initExitButton();
        initUserButton();
        buttonPannelSouth.setBounds(600,700, 20,300);
        buttonPannel.add(buttonPannelSouth, BorderLayout.SOUTH);
    }
    private void initResetButton() {
        resetButton = new JButton("Reset");
        buttonPannelSouth.add(resetButton);
        resetButton.addActionListener(event -> {
            //usernameField.setText("");
            // passwordField.setText("");
            // emailField.setText("");
            // buttonGroup.clearSelection();
            // comboBox.setSelectedIndex(0);
            showMessage("Fields Reset!", JOptionPane.INFORMATION_MESSAGE);
        });
    }
    private void initBeackButton(){
        beackButton = new JButton("Beack");
        buttonPannelSouth.add(beackButton);
    }
    private void initExitButton(){
        exitButton = new JButton("Exit");
        buttonPannelSouth.add(exitButton);
    }
    private void initUserButton(){
        userButton = new JButton("User");
        buttonPannelSouth.add(userButton);
    }

    private void initButtonNorth(){
        LocalDate localDate = LocalDate.now();
        userLabel = new JLabel("user : "+userName);
        dataLabel = new JLabel(String.valueOf(localDate));
        EmptyBorder borderLabel = new EmptyBorder(0,10,0,10);
        userLabel.setBorder(borderLabel);
        dataLabel.setBorder(borderLabel);
        buttonPannelNorth = new JPanel(new FlowLayout());
        buttonPannelNorth.add(userLabel);
        buttonPannelNorth.add(dataLabel);
        // buttonPannelNorth.setBounds(1000,2,50,4);
        buttonPannel.add(buttonPannelNorth, BorderLayout.NORTH);
    }
    private void initImage(){
        imagePannnel = new JPanel();
        Image image = new ImageIcon(".//src/main/java/aplicatie/departamente.jpg")
                .getImage().getScaledInstance(680,550,Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel = new JLabel(imageIcon);
        imagePannnel.add(imageLabel);
    }
    private  void actionMetode(){
        exitButton.addActionListener(event ->{
            dispose();
        });
        beackButton.addActionListener(event->{
            new StartPage().setVisible(true);
            dispose();
        });
    }
    public static void showMessage(String msg, int messageType) {
        JOptionPane.showMessageDialog(null, msg, "Bilete GUI", messageType);
    }

    public static void main(String[] args) {
        new DashboardPage("adrian");
    }
}
