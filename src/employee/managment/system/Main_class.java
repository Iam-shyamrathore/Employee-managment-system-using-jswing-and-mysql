package employee.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading = new JLabel("EMPLOYEE MANAGMENT SYSTEM");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        img.add(heading);

        JButton add = new JButton("Add employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        img.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Add_employee();
                setVisible(false);
            }
        });

        JButton view = new JButton("View employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        img.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_employee();
                setVisible(false);
            }
        });

        JButton rem= new JButton("Remove employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        img.add(rem);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Remove_employee();
                setVisible(false);

            }
        });

        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);


    }
    public static void main(String[] args) {
        new Main_class();
    }
}
