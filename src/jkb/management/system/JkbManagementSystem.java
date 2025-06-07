package jkb.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JkbManagementSystem extends JFrame implements ActionListener
{
    
    
    JkbManagementSystem()
    {
        setSize(1166,565);
        setLocation(80,70);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1166,565);   //locationX,LocationY , length,breadth
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 400, 850, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,43));
        image.add(text);
        
        JButton next = new JButton("NEXT");
        next.setBounds(950,460,150,40);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.BOLD,15));
        image.add(next);
        
        setVisible(true);
        
        while(true)
        {
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) 
    {
        new JkbManagementSystem();
    }
    
}
