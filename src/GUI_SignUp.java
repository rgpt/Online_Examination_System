import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI_SignUp 
{
	 Random random_id = new Random();
	 JFrame jf3 = new JFrame("Enter Details");
	 JButton ok = new JButton("OK"); 
	 JPanel jp1 = new JPanel();
     JPanel jp2 = new JPanel();
     JPanel jp3 = new JPanel();
     JPanel jp4 = new JPanel();
     JLabel id = new JLabel("ID");
     JLabel name = new JLabel("NAME");
     JLabel password = new JLabel("PASSWORD");
     JLabel msg = new JLabel("PLEASE NOTE YOUR USER ID");
     JTextField id_tf = new JTextField(20);
     JTextField name_tf = new JTextField(20);
     JTextField password_tf = new JTextField(20);
    
     public GUI_SignUp() 
	 { 
    	 
		  jf3.setSize(350,200);
    	  jf3.setVisible(true);
    	  jf3.setDefaultCloseOperation(jf3.EXIT_ON_CLOSE);
		  BoxLayout l = new BoxLayout(jf3.getContentPane(),BoxLayout.Y_AXIS);
	      jf3.setLayout(l);
	      jf3.setLocation(500,300);
		 
		  jp1.add(id);
	      jp1.add(id_tf);
	      id_tf.setText(String.valueOf(random_id.nextInt(250000)));
	      jp2.add(name);
	      jp2.add(name_tf);
	      jp3.add(password);
	      jp3.add(password_tf);
	      
	      jf3.add(jp1);
	      jf3.add(jp2);
	      jf3.add(jp3);
	      jf3.add(ok);
	      ok.addActionListener(new Handler());
	      jp4.add(msg);
	      jf3.add(jp4);
	      
	 }
     
     void SignUp() throws SQLException
     {
    	  try
   	       {
    	    Class.forName("com.mysql.jdbc.Driver");
    	    Connection con = DriverManager.getConnection("jdbc:mysql://192.168.137.1:3306/username_password","root","sachin");
    	    Statement stat = con.createStatement(); 
    	    int id = Integer.parseInt(id_tf.getText()); // USED WRAPPER CLASSES
    	    String name = name_tf.getText();
    	    String password = password_tf.getText();
    	    stat.executeUpdate("insert into user values('"+id+"','"+name+"','"+password+"')");
    	    
    	    
   	       } 
           catch(ClassNotFoundException cnfe)
            { cnfe.printStackTrace(); }
   
      }
     
	 
	 class Handler implements ActionListener
	 {
		  @Override
		public void actionPerformed(ActionEvent e) 
		  {
			if(e.getSource()==ok)
			    {
				    jf3.dispose();
				    try 
				    {SignUp();} 
				    catch (SQLException e1)
					{e1.printStackTrace();}
				    GUI page1 = new GUI();
			    }
		  } 
	 }
	 
    }
