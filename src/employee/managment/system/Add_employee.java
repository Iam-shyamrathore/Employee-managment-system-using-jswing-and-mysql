package employee.managment.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Add_employee extends JFrame implements ActionListener {

    Random ran = new Random();

    int number = ran.nextInt(999999);
    JTextField tname,tfname,taddres,tphone,taadhar,tsalary,temail;

    JLabel tempid;
    JDateChooser tdob;

    JComboBox Boxeducation,Boxdesi;

    JButton add, back;
    Add_employee(){

        getContentPane().setBackground(new Color(165,255,188) );
        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);
        tname = new JTextField();
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

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
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
        taadhar = new JTextField();
        taadhar.setBounds(600,300,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel edu = new JLabel("Highest education");
        edu.setBounds(50,350,150,30);
        edu.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(edu);
        String items[]={"BBA","B.tech","BCA","BA","Bsc","B.com","MBA","MCA","MA","Mtec","MSc","PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(200,350,150,30);
        add(Boxeducation);

        JLabel empid = new JLabel("Employee id");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);
        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setForeground(Color.red);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(tempid);

        JLabel desi = new JLabel("Designation");
        desi.setBounds(400,350,150,30);
        desi.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(desi);
        String post[]={"ceo","worker","manager","accountant","assistant manager","PR manager","sweeper","tea boy","Peon"};
        Boxdesi = new JComboBox(post);
        Boxdesi.setBackground(new Color(177,252,197));
        Boxdesi.setBounds(600,350,150,30);
        add(Boxdesi);

        add = new JButton("ADD");
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
        if(e.getSource()== add){
            String name = tname.getText();
            String fname = tfname.getText();
            String addres = taddres.getText();
            String adr= taadhar.getText();
            String pno = tphone.getText();
            String email = temail.getText();
            String salary = tsalary.getText();
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String education = (String) Boxeducation.getSelectedItem();
            String post = (String) Boxdesi.getSelectedItem();
            String empid = tempid.getText();

            try {
                conn c = new conn();

                String query = "insert into employee values ('" + name + "','" + fname + "','" + dob +"','" + salary +"','" + addres + "','" + pno + "','" + email +"','"+ education +"','"+ post +"','" + adr +"','" + empid +"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added sucessfully");
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
        new Add_employee();
    }
}
