package jkb.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener
{
    JButton add, cancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    JRadioButton rbmale, rbfemale;
    
    public AddDriver() 
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel ("Add Driver");
        heading.setFont(new Font("Tahoma", Font.BOLD,18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel lblroomno = new JLabel ("Name");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblroomno.setBounds(60, 50, 120, 20);
        add(lblroomno);
        
        tfname = new JTextField();
        tfname.setBounds(200,50,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel ("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblage.setBounds(60, 90, 120, 30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,90,150,30);
        add(tfage);
        
        JLabel lblclean = new JLabel ("Gender");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblclean.setBounds(60, 130, 120, 30);
        add(lblclean);
        
//        String cleanOption[] = {"Male","Female"};
//        gendercombo =  new JComboBox(cleanOption);
//        gendercombo.setBackground(Color.WHITE);
//        gendercombo.setBounds(200, 130, 150, 30);
//        add(gendercombo);
        
        rbmale = new JRadioButton("male");
        rbmale.setBounds(195 , 134, 60, 25);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(275 , 134, 70, 25);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
//        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        JLabel lblprice = new JLabel ("Car Company");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblprice.setBounds(60, 174, 120, 30);
        add(lblprice);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200,174,150,30);
        add(tfcompany);
        
        JLabel lbltype = new JLabel ("Car Model");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbltype.setBounds(60, 214, 120, 30);
        add(lbltype);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200,214,150,30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel ("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblavailable.setBounds(60, 254, 120, 30);
        add(lblavailable);
        
        String availableOption[] = {"Available","Busy"};
        availablecombo =  new JComboBox(availableOption);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setBounds(200, 254, 150, 30);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel ("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbllocation.setBounds(60, 294, 120, 30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200,294,150,30);
        add(tflocation);
        
        //button
        add = new JButton("Add Driver");
        add.setBounds(60,360,130,30);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        cancel = new JButton("Back");
        cancel.setBounds(230,360,130,30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,65,500,300);
        add(image);
        
        
        
        setBounds(250,200,980,470);
        setLocation(220,140);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == add) {
           String name = tfname.getText();
           String age = tfage.getText();
           String gender = (String) gendercombo.getSelectedItem();
           String company = tfcompany.getText();
           String brand = tfmodel.getText();
           String available = (String) availablecombo.getSelectedItem();
           String location = tflocation.getText();
           
           
           try{
               Conn conn = new Conn();
               //(name varchar(20), age varchar(10), gender varchar(15), company varchar(20), brand varchar(20), available varchar(20),location varchar(40));
               String str = "insert into driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"','"+available+"','"+location+"')";
               
               conn.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                this.setVisible(false);

           }catch(Exception e){
               e.printStackTrace();
           }
           
           
        }else{
           setVisible(false);
           
        }
    }
    
    public static void main(String[] args)
    {
        new AddDriver();
    }
}
