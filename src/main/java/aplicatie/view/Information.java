package aplicatie.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Information extends JFrame {

    private JPanel appInformation;

    private JButton beack;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;

    public Information() {
        setTitle("Info Page");
        setSize(400, 400);
        setLocationRelativeTo(null);//pozitioneaza fereastra pe centru
        setVisible(true);//facem fereastra vizibile

        beack = new JButton("beack");
        text1 = new JLabel("                  Welcome    to gestion  aplication   !!!         ");
        text2 = new JLabel(" This is an employee ");
        text3 = new JLabel("management application. ");

        appInformation = new JPanel();
        appInformation.add(text1);
        appInformation.add(text2);
        appInformation.add(text3);

        beack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartPage();
                dispose();
            }
        });

        add(beack, BorderLayout.NORTH);
        add(appInformation, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}
