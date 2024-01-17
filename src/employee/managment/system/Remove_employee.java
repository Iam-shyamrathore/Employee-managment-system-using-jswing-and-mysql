package employee.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove_employee extends JFrame implements ActionListener {

    Choice choiceempid;

    JButton delte,back;
    Remove_employee(){
        JLabel label = new JLabel("Employee Id");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceempid = new Choice();
        choiceempid.setBounds(200,50,150,30);
        add(choiceempid);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceempid.add(resultSet.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelname);

        JLabel textname = new JLabel();
        textname.setBounds(200,100,100,30);
        add(textname);

        JLabel labelpno = new JLabel("Phone");
        labelpno.setBounds(50,150,100,30);
        labelpno.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelpno);

        JLabel textpno = new JLabel();
        textpno.setBounds(200,150,100,30);
        add(textpno);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelemail);

        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,100,30);
        add(textemail);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empid = '"+ choiceempid.getSelectedItem() +"'");
            while (resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textpno.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        choiceempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empid = '"+ choiceempid.getSelectedItem() +"'");
                    while (resultSet.next()){
                        textname.setText(resultSet.getString("name"));
                        textpno.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));


                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delte = new JButton("Delete");
        delte.setBounds(80,300,100,30);
        delte.setBackground(Color.black);
        delte.setForeground(Color.white);
        delte.addActionListener(this);
        add(delte);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i12 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i12);
        JLabel imga = new JLabel(i31);
        imga.setBounds(0,0,1120,630);
        add(imga);



        setSize(1000,400);
        setLayout(null);
        setLocation(300,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delte){
            try{
                conn c = new conn();
                String query = "delete from employee where empid = '"+choiceempid.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee delted sucessfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Remove_employee();
    }
}
