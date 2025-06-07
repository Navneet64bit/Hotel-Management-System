package jkb.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener {
    
    JButton newCustomer,rooms,department,allEmployee,customers,managerInfo,update,roomStatus,searchRoom;
    JButton pickup,checkout,logout;
    Reception() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(14,30,200,30);
        newCustomer.addActionListener(this);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        add(newCustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(14,70,200,30);
        rooms.addActionListener(this);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(14,110,200,30);
        department.addActionListener(this);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        add(department);
        
        allEmployee = new JButton("All Employee");
        allEmployee.setBounds(14,150,200,30);
        allEmployee.addActionListener(this);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        add(allEmployee);
        
        customers = new JButton("Customer Info");
        customers.setBounds(14,190,200,30);
        customers.addActionListener(this);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        add(customers);
        
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(14,230,200,30);
        managerInfo.addActionListener(this);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        add(managerInfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(14,270,200,30);
//        checkout.addActionListener(this);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);
        
        update = new JButton("Update Status");
        update.setBounds(14,310,200,30);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(14,350,200,30);
        roomStatus.addActionListener(this);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        add(roomStatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(14,390,200,30);
        pickup.addActionListener(this);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(14,430,200,30);
        searchRoom.addActionListener(this);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        add(searchRoom);
        
        logout = new JButton("Logout");
        logout.setBounds(14,470,200,30);
        logout.addActionListener(this);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        
        
        
        setBounds(350,200,800,570);
        setLocation(300,130);
        setVisible(true);    
    }
    //department,allEmployee,customers,managerInfo,checkout,update,roomStatus,pickup,searchRoom,logout;
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource() == rooms ){
            setVisible(false);
            new Room();
        }else if(ae.getSource() == department ){
            setVisible(false);
            new Department();
//            
        }else if(ae.getSource() == allEmployee ){
            setVisible(false);
            new EmployeeInfo();
//            
        }else if(ae.getSource() == managerInfo ){
            setVisible(false);
            new ManagerInfo();
                  
        }else if(ae.getSource() == customers ){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource() == checkout ){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource() == update ){
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource() == roomStatus ){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource() == pickup ){
            setVisible(false);
              new Pickup();
        }else if(ae.getSource() == searchRoom ){
            setVisible(false);
            new SearchRoom();           
        }else if(ae.getSource() == logout ){
            setVisible(false);
            System.exit(0);
        }
    }
    
    
    public static void main(String[] args){
        new Reception();
        
    }
}
