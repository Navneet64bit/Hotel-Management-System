
package jkb.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available; 
    Pickup() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pick-UP Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(55, 103, 95, 20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()) {
                typeofcar.add(rs.getString("brand"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel l1 = new JLabel("name");
        l1.setBounds(14, 150, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(165, 150, 50, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(306, 150, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(445, 150, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(590, 150, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(730, 150, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(870, 150, 100, 20);
        add(l7);
        
        
        table = new JTable();
        table.setBounds(10, 200, 1000, 300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBounds(300,500,120,30);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        
        back = new JButton("Back");
        back.setBounds(450,500,120,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        
        setBounds(300,200,1000,600);
        setLocation(150,90);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            try{
                String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();           
        }
    }
    
    public static void main(String[] args)
    {
        new Pickup();
    }
}
