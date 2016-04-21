import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;

import clock.Clocktype;




public class GUI_Questions 
{
	JPanel left = new JPanel();
	JPanel right = new JPanel();
	JFrame jf5 = new JFrame(); 
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,left,right);
	JLabel welcome = new JLabel(new ImageIcon("res/welcomeimage.jpg"));
	JPanel welcome_panel = new JPanel();
	//------------------------------------------------------------------------------------------------
	JLabel Question_tag = new JLabel("Question");//Swing constant to set alignment of text in label;
	JPanel pane = new JPanel();
	JPanel Question = new JPanel();
	JLabel Question_stmt = new JLabel();
	//-----------------------------------------------buttons of lower right panel----------------------
	JButton prev = new JButton("Prev");
    JButton next = new JButton("Next");
    JButton submit = new JButton("Submit");
    //----------------------------------------------Radio Button----------------------------------------
    JRadioButton option1 = new JRadioButton();
    JRadioButton option2 = new JRadioButton();
    JRadioButton option3 = new JRadioButton();
    JRadioButton option4 = new JRadioButton();
    ButtonGroup options = new ButtonGroup();
    //------------------------------------------------Questions_Array-----------------------------------
     String[][] QuestionList = new String[10][6];
    //------------------------------------------------Labels for left panel----------------------------- 
     JLabel[] Q = new JLabel[10];
     
     
	
	 public GUI_Questions(String name,String table) throws SQLException
    {  
	  jf5.setTitle(name);
	   left.setLayout( new BoxLayout(left,BoxLayout.Y_AXIS));
	   right.setLayout( new BorderLayout());
	   jf5.setVisible(true);
       jf5.setSize(1350,700);
       jf5.setDefaultCloseOperation(jf5.EXIT_ON_CLOSE);
       jf5.add(split);
       split.setDividerLocation(250);
       
       welcome_panel.add(welcome);
       right.add(welcome_panel,BorderLayout.NORTH);
       //---------------------------------------TAG ADDITION-----------------------------------------------------------
       Question_tag.setFont(new Font("Broadway",5,24)); // it takes frame a little delay due to this 
       pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
       pane.add(Question_tag);
       pane.add(Box.createVerticalStrut(20));
       right.add(pane,BorderLayout.CENTER);
//       ----------------------------------------------adding question in array-----------------------------------------------------
       Question_stmt.setFont(new Font("Times",20,16));
       pane.add(Question_stmt);
       Addques(table);  // table name is passes from after login page bases on the button which is clicked.
       
       
        
       
       
       //----------------------------------------------Radiobutton Group------------------------------------------------
 
       options.add(option1);
       options.add(option2);
       options.add(option3);
       options.add(option4);
       pane.add(Box.createVerticalStrut(20));
       pane.add(option1);
       pane.add(option2);
       pane.add(option3);
       pane.add(option4);
       option1.addActionListener(new Handler());
       option2.addActionListener(new Handler());
       option3.addActionListener(new Handler());
       option4.addActionListener(new Handler());
            
      
             //----------------------------------------------------leftpane-----------------------------------------------
       int j=0;
       Q[0] = new JLabel("Ques1 :");
       Q[1] = new JLabel("Ques2 :");
       Q[2] = new JLabel("Ques3 :");
       Q[3] = new JLabel("Ques4 :");
       Q[4] = new JLabel("Ques5 :");
       Q[5] = new JLabel("Ques6 :");
       Q[6] = new JLabel("Ques7 :");
       Q[7] = new JLabel("Ques8 :");
       Q[8] = new JLabel("Ques9 :");
       Q[9] = new JLabel("Ques10 :");
       Q[0].setForeground(Color.red);
       Q[1].setForeground(Color.red);
       Q[2].setForeground(Color.red);
       Q[3].setForeground(Color.red);
       Q[4].setForeground(Color.red);
       Q[5].setForeground(Color.red);
       Q[6].setForeground(Color.red);
       Q[7].setForeground(Color.red);
       Q[8].setForeground(Color.red);
       Q[9].setForeground(Color.red);
       //--------------------------------------------------Ques numbers in left pane-----------------------------
       left.add(Box.createHorizontalStrut(20));
       left.add(Q[0]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[1]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[2]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[3]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[4]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[5]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[6]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[7]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       left.add(Q[8]);
       left.add(Box.createHorizontalStrut(20));
       left.add(Box.createVerticalStrut(20));
       //left.add(Q[9]);
       
       left.add(Box.createVerticalStrut(10));
//-------------------------------------------------buttons------------------------------------------\
      JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
      pane.add(split1);       
      split.setOneTouchExpandable(true);
       
       JPanel button = new JPanel(new FlowLayout());
       setQuestion(QuestionList[0][0],QuestionList[0][1],QuestionList[0][2],QuestionList[0][3],QuestionList[0][4]); 
       button.add(prev);
       prev.addActionListener(new Handler());
       button.add(next);
       next.addActionListener(new Handler());
       button.add(submit);
       submit.addActionListener(new Handler());
       split1.setRightComponent(button);
       split1.setDividerLocation(500);
       Clocktype clk = new Clocktype(jf5);
      
       button.add(clk.jb);
       //clk.jb.setBorder(new EmptyBorder(10,15,20,25));
       clk.jb.setBackground(Color.black);
       jf5.validate();
    }

//------------------------------------------------setting text for Question------------------------------
	 public void setQuestion(String ques,String o1,String o2,String o3,String o4)
     {
		   Question_stmt.setText(ques);
		   option1.setText(o1);
	       option2.setText(o2);
	       option3.setText(o3);
	       option4.setText(o4);
     }
	 
int i = 1;

String[] user_ans = new String[10];

class Handler implements ActionListener
    {    
	   @Override
	   public void actionPerformed(ActionEvent e) 
	   {   
		   if(e.getSource()== prev)
		   {

			   prev.setVisible(true);
			   next.setVisible(true);
			   i--;
			   if(i<0)
			   {
				   i =0;
				   prev.setVisible(false);
			   }
			   
			   if(i>=0 && i<=8)  
			   {
				   setQuestion(QuestionList[i][0],QuestionList[i][1],QuestionList[i][2],QuestionList[i][3],QuestionList[i][4]); 
				   if(user_ans[i]== null)
				   { options.clearSelection();}
				   else
				   { 
					  
					   if(user_ans[i].equals(option1.getText()))
				            {option1.setSelected(true);}
				       else if(user_ans[i].equals(option2.getText()))
			                {option2.setSelected(true);}
				       else if(user_ans[i].equals(option3.getText()))
			                {option3.setSelected(true);}
				       else if(user_ans[i].equals(option4.getText()))
			                {option4.setSelected(true);}
				   }
				  
				  
				   
			   }

		   }
		  if(e.getSource() == next)
		  {
			  prev.setVisible(true);
		      next.setVisible(true);
		      
		      if(i>=0 && i<=8)  
		        {
		    	  i++;
		    	  if(i>8)
		          {
		        	  i = 8;
		        	  next.setVisible(false);
		          }
		    	  setQuestion(QuestionList[i][0],QuestionList[i][1],QuestionList[i][2],QuestionList[i][3],QuestionList[i][4]); 
				  
				  if(user_ans[i]== null)
		          { options.clearSelection();}
		          else
		          {  
		        	  
		        	  if(user_ans[i].equals(option1.getText()))
		                   {option1.setSelected(true);}
		              else if(user_ans[i].equals(option2.getText()))
		                   {option2.setSelected(true);}
		              else if(user_ans[i].equals(option3.getText()))
		                   {option3.setSelected(true);}
		              else if(user_ans[i].equals(option4.getText()))
		                   {option4.setSelected(true);}
		          }
		        }        
		     }
			  
		  if(e.getSource()==option1)
		  {
			  user_ans[i] = option1.getText();
			  Q[i].setText(Q[i].getText()+"---->(ANSWERED)");
			  Q[i].setForeground(Color.green);
		  }
		  else if(e.getSource()==option2)
		  {
			  user_ans[i] = option2.getText();
			  Q[i].setText(Q[i].getText()+"---->(ANSWERED)");
			  Q[i].setForeground(Color.green);
		  }
		  else if(e.getSource()==option3)
		  {
			  user_ans[i] = option3.getText();
			  Q[i].setText(Q[i].getText()+"---->(ANSWERED)");
			  Q[i].setForeground(Color.green);
		  }
		  else if(e.getSource()==option4)
		  {
			  user_ans[i] = option4.getText();
			  Q[i].setText(Q[i].getText()+"---->(ANSWERED)");
			  Q[i].setForeground(Color.green);
			  
		  }
		  
		  else if(e.getSource() == submit)
		  {
//			  for(i=0;i<10;i++)
//			  {System.out.println(i+"===="+user_ans[i]);}
			  Displayscore();
			  jf5.setEnabled(false);
			  jf5.setVisible(false);
			  
			  
		  }
		  
		  
		  
	   }
	}


//---------------------adding random questions and its option and answer in array-----------------------
int j = 0; 
void Addques(String table) throws SQLException
{
	Random index = new Random();
    HashSet<Integer> index_set  = new HashSet<Integer>();
    index_set.clear();
    while(index_set.size()!=10)
    {
 	   index_set.add(index.nextInt(11)+1);
    }
    Iterator<Integer> iterate = index_set.iterator(); 
    
    try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.137.1:3306/username_password","root","sachin");
	            Statement stat = con.createStatement(); 
	   
             ResultSet rs = stat.executeQuery("select * from "+table);
             rs.next();
             
//             while(rs.isLast()==true)
//             {
//            	 System.out.println(rs.getString("q_id"));
//            	 rs.next();
//             }
             i=0;
             j=0;
             while(rs.isAfterLast()!=true && j<=9)
             {
 	             if(index_set.contains(rs.getInt("q_id")))
 	                  {
 	                      QuestionList[j][0]  = rs.getString("q_des");
		                      QuestionList[j][1]  = rs.getString("opt_1");
		                      QuestionList[j][2]  = rs.getString("opt_2");
		                      QuestionList[j][3]  = rs.getString("opt_3");
		                      QuestionList[j][4]  = rs.getString("opt_4");
		                      QuestionList[j][5]  = rs.getString("ans");
		                     
		 
		                      j++;
 	                  }
 	            
 	             rs.next();
            }
//             System.out.print(j);
//   
//	      for(i=0;i<=9;i++)
//	      {System.out.println(i+"--"+QuestionList[i][0]);}
//  
	       } 
    catch(ClassNotFoundException cnfe)
     { cnfe.printStackTrace(); }
    
//    for(i=0;i<9;i++)
//    {System.out.print( QuestionList[i][5]+"---->");
//    System.out.println(user_ans[i]);}
    	
}

int correct_ans;
int wrong_ans;
int not_attempted;
int final_score;
void Displayscore()
{
	correct_ans = 0;
	wrong_ans   = 0;
	not_attempted = 0;
	final_score = 0;
	
   for(i=0;i<9;i++)
   {   //System.out.println(i+"--->"+user_ans[i]);
	   if(QuestionList[i][5].equals(user_ans[i]))
	   {
	           correct_ans++;	   
	   }
	   else if(user_ans[i]==null)
	   {
		   not_attempted++;
	   }
	   else
	   {
		   wrong_ans++;
	   }
   }
   final_score = correct_ans*10;
 // System.out.print(correct_ans+" "+wrong_ans);
 Gui_Result page7 = new Gui_Result(Integer.toString(correct_ans),Integer.toString(wrong_ans),Integer.toString(not_attempted),Integer.toString(final_score));
}




}















