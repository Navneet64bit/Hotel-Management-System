package jkb.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener {
    
    JLabel checkintime;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JComboBox comboid;
    JRadioButton rmale,rfemale;
    Choice croom;
    JButton add,back;

    AddCustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel ("NEW CUSTOMER FORM");
        text.setFont(new Font("Raileway", Font.BOLD,18));
        text.setBounds(100, 20, 300, 30);
        add(text);
        
        JLabel lblid = new JLabel("ID : ");
        lblid.setBounds(35 , 80, 100, 20);
        lblid.setFont(new Font("Raileway",Font.PLAIN,20));
        add(lblid);
        
        String idoption[] = {"Aadhar Card","Driving Licence","Passport","VoterID Card"};
        comboid = new JComboBox(idoption);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber = new JLabel ("Number");
        lblnumber.setFont(new Font("Raileway", Font.PLAIN,18));
        lblnumber.setBounds(35 , 120, 100, 20);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel ("Name");
        lblname.setFont(new Font("Raileway", Font.PLAIN,18));
        lblname.setBounds(35 , 160, 100, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblgender = new JLabel ("Gender");
        lblgender.setFont(new Font("Raileway", Font.PLAIN,18));
        lblgender.setBounds(35 , 200, 100, 20);
        add(lblgender);
        
        rmale = new JRadioButton("male");
        rmale.setBounds(200 , 200, 60, 25);
        rmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270 , 200, 70, 25);
        rfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lblcountry = new JLabel ("Country");
        lblcountry.setFont(new Font("Raileway", Font.PLAIN,18));
        lblcountry.setBounds(35 , 240, 100, 20);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lblroom = new JLabel ("Room");
        lblroom.setFont(new Font("Raileway", Font.PLAIN,18));
        lblroom.setBounds(35 , 280, 100, 20);
        add(lblroom);
        
        croom = new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
            croom.add(rs.getString("roomnumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel lbltime = new JLabel ("Check-in time");
        lbltime.setFont(new Font("Raileway", Font.PLAIN,18));
        lbltime.setBounds(35 , 320, 150, 20);
        add(lbltime);
        
        Date date = new Date();
        
        checkintime = new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raileway", Font.PLAIN,12));
        add(checkintime);
        
        JLabel lbldeposit = new JLabel ("Deposit");
        lbldeposit.setFont(new Font("Raileway", Font.PLAIN,18));
        lbldeposit.setBounds(35 , 360, 100, 20);
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        //button
        add = new JButton("Add Customer");
        add.setBounds(50,410,120,35);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(200,410,120,35);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        
        setBounds(250,130,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            //document varchar(20), number varchar(30), name varchar(30), gender varchar(15), country varchar (20), room varchar(10), checkintime varchar(80), deposit varchar(20));
            try{
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource() == back) {
            setVisible(false);
                new Reception();
        }
    }
    
    public static void main(String[] args)
    {
        new AddCustomer();
    }
}

