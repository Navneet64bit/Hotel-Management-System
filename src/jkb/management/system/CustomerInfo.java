
package jkb.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(14, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(136, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(256, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(376, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(506, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Room");
        l6.setBounds(620, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Check-In Time");
        l7.setBounds(746, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(866, 10, 100, 20);
        add(l8);
        
        
        table = new JTable();
        table.setBounds(10, 40, 970, 400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(280,500,120,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        
        setBounds(300,200,1000,600);
        setLocation(150,90);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args)
    {
        new CustomerInfo();
    }
}
