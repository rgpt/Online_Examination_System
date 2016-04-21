import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GUI_AfterLogin 
{
	JFrame jf2 = new JFrame("Examination System");
	ImageIcon Entrn_pic = new ImageIcon("res/Entertainment.png");
	    JButton Entrn = new JButton(Entrn_pic);
	ImageIcon Tech_pic = new ImageIcon("res/Tech.jpg");
	    JButton Tech = new JButton(Tech_pic);
	ImageIcon Sprt_pic = new ImageIcon("res/Sports.jpg");
	    JButton Sprt = new JButton(Sprt_pic);
	ImageIcon gk_pic = new ImageIcon("res/gk.png");
	    JButton gk = new JButton(gk_pic);
	
	//JPanel options = new JPanel();
	
	GUI_AfterLogin()
	{
		 jf2.setSize(738,700);
    	 jf2.setVisible(true);
    	 jf2.setDefaultCloseOperation(jf2.EXIT_ON_CLOSE);
    	 //BoxLayout boxLayout = new BoxLayout(options, BoxLayout.Y_AXIS);
    	 jf2.setLayout(new GridLayout(2,2));
    	 jf2.setLocation(300,10);
    	// options.setLayout(boxLayout);
    	 jf2.add(Entrn);
    	 jf2.add(Tech);
    	 jf2.add(Sprt);
    	 jf2.add(gk);
    	 jf2.validate();
    	 gk.addActionListener(new Handler());
    	 Entrn.addActionListener(new Handler());
    	 Tech.addActionListener(new Handler());
    	 Sprt.addActionListener(new Handler());
	    
	}
	
	class Handler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
		    	if(e.getSource()==Entrn)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("Entertainment","entrn");
		    		      jf2.dispose();} 
		    		catch (SQLException e1) {e1.printStackTrace();}
		    	}
		    	else if(e.getSource()==Sprt)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("Sports","sports");
		    		jf2.dispose();}
		    		catch (SQLException e1) {e1.printStackTrace();}
		    	}
		    	else if(e.getSource()==Tech)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("Technical","tech");
		    		jf2.dispose();}
		    		catch (SQLException e1) {e1.printStackTrace();
					}
		    	}
		    	else if(e.getSource()==gk)
		    	{
		    		try {GUI_Questions page5 = new GUI_Questions("General Knowledge","gk");
		    		jf2.dispose();} 
		    		catch (SQLException e1) {e1.printStackTrace();}
		    	}
			
		}
	}
}