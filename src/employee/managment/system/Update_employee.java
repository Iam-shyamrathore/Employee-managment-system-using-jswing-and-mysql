package employee.managment.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_employee extends JFrame implements ActionListener {
    JTextField teducation,tfname,taddres,tphone,tdesignation,tsalary,temail;

    JLabel tempid;

    JButton add, back;

    String number;
    Update_employee(String number){

        this.number = number;

        getContentPane().setBackground(new Color(165,255,188) );
        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);
        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);



        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);
        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);
        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel addres = new JLabel("Address");
        addres.setBounds(50,250,150,30);
        addres.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(addres);
        taddres = new JTextField();
        taddres.setBounds(200,250,150,30);
        taddres.setBackground(new Color(177,252,197));
        add(taddres);

        JLabel pno = new JLabel("Phone");
        pno.setBounds(400,250,150,30);
        pno.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(pno);
        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);
        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel adr = new JLabel("Aadhaar");
        adr.setBounds(400,300,150,30);
        adr.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(adr);
        JLabel taadhar = new JLabel();
        taadhar.setBounds(600,300,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel edu = new JLabel("Highest education");
        edu.setBounds(50,350,150,30);
        edu.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(edu);
        teducation = new JTextField();
        teducation.setBounds(200,350,150,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);


        JLabel empid = new JLabel("Employee id");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);
        tempid = new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setForeground(Color.red);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(tempid);

        JLabel desi = new JLabel("Designation");
        desi.setBounds(400,350,150,30);
        desi.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(desi);
        tdesignation = new JTextField();
        tdesignation.setBounds(600,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        try{
            conn c = new conn();
            String query = "select * from employee where empid = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddres.setText(resultSet.getString("adress"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empid"));
                tdesignation.setText(resultSet.getString("designation"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }



        add = new JButton("UPDATE");
        add.setBounds(450,550,150,30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);



        setSize(900,700);
        setLocation(300,50);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddres.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                conn c = new conn();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',adress = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empid = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Details updated sucessfull");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
            new View_employee();
        }
    }

    public static void main(String[] args) {
        new Update_employee("");
    }
}
