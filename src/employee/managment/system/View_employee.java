package employee.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_employee extends JFrame implements ActionListener {
    JTable table;
    Choice choiceemp;

    JButton searchbtn,printbtn,updatebtn,backbtn;
    View_employee(){
        getContentPane().setBackground(new Color(255,131,122) );
        JLabel search = new JLabel("Search by employee id ");
        search.setBounds(20,20,150,20);
        search.setFont(new Font("serif",Font.BOLD,12));
        add(search);
        choiceemp = new Choice();
        choiceemp.setBounds(180,20,150,20);
        add(choiceemp);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select*from employee");
            while (resultSet.next()){
                choiceemp.add(resultSet.getString("empid"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select*from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        printbtn = new JButton("Print");
        printbtn.setBounds(120,70,80,20);
        printbtn.addActionListener(this);
        add(printbtn);

        updatebtn = new JButton("Update");
        updatebtn.setBounds(220,70,80,20);
        updatebtn.addActionListener(this);
        add(updatebtn);

        backbtn = new JButton("Back");
        backbtn.setBounds(320,70,80,20);
        backbtn.addActionListener(this);
        add(backbtn);



        setSize(900,700);
        setLocation(300,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==searchbtn){
            String query = "select * from employee where empid ='"+ choiceemp.getSelectedItem()+"' ";
            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource()==printbtn) {
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
            
        }else if(e.getSource()==updatebtn){
            setVisible(false);
            new Update_employee(choiceemp.getSelectedItem());
        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new View_employee();
    }
}
