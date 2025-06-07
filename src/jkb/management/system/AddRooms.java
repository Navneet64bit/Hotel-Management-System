package jkb.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddRooms extends JFrame implements ActionListener
{
    JButton add, cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    
    public AddRooms() 
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel ("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD,18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblroomno = new JLabel ("Rooms Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblroomno.setBounds(60, 80, 120, 20);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel ("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String availableOption[] = {"Available","Occupied"};
        availablecombo =  new JComboBox(availableOption);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setBounds(200, 130, 150, 30);
        add(availablecombo);
        
        JLabel lblclean = new JLabel ("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String cleanOption[] = {"Cleaned","Occupied"};
        cleancombo =  new JComboBox(cleanOption);
        cleancombo.setBackground(Color.WHITE);
        cleancombo.setBounds(200, 180, 150, 30);
        add(cleancombo);
        
        
        JLabel lblprice = new JLabel ("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype = new JLabel ("Bed Type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);
        
        String typeOption[] = {"Single Bed","Double Bed","Triple Bed","Four Bed"};
        typecombo =  new JComboBox(typeOption);
        typecombo.setBackground(Color.WHITE);
        typecombo.setBounds(200, 280, 150, 30);
        add(typecombo);
        
        //button
        add = new JButton("Add Room");
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        cancel = new JButton("Back");
        cancel.setBounds(230,350,130,30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,65,500,300);
        add(image);
        
        
        
        setBounds(330,200,940,470);
        setLocation(220,140);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == add) {
           String roomnumber = tfroom.getText();
           String availability = (String) availablecombo.getSelectedItem();
           String status = (String) cleancombo.getSelectedItem();
           String price = tfprice.getText();
           String type = (String) typecombo.getSelectedItem();
           
           try{
               Conn conn = new Conn();
               String str = "insert into room values( '"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";
               
               conn.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Added Successfully");
                this.setVisible(false);

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
        new AddRooms();
    }
}
