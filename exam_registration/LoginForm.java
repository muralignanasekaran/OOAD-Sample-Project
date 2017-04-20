package exam_registration;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm 
{

	JButton SUBMIT,REGISTER,EXIT;
	JFrame f;

	JLabel label1,label2;
	JTextField text1; 
	JTextField text2;public String value1;
	LoginForm()
    {
    	f=new JFrame();
    	f.getContentPane().setLayout(null); 

    	label1 = new JLabel();
    	label1.setText("UserName:");
    	label1.setBounds(400,150,100,20);

    	text1 = new JTextField(25);
    	text1.setBounds(500,150,100,20); 

    	label2 = new JLabel();
    	label2.setText("Password:"); 
    	label2.setBounds(400,180,100,20);

    	text2 = new JPasswordField(25);
    	text2.setBounds(500,180,100,20); 

    	SUBMIT=new JButton("Login");
    	SUBMIT.setBounds(450,210,100,20);
    	
    	REGISTER = new JButton("Register");
    	REGISTER.setBounds(450,80,100,20);

    	EXIT= new JButton("EXIT");
    	EXIT.setBounds(450,250,100,20);

    	f.add(label1);
    	f.add(text1);
    	f.add(label2);
    	f.add(text2);
    	f.add(SUBMIT);
    	f.add(REGISTER);
    	f.add(EXIT);

    	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    	double width=screensize.getWidth();
    	double height=screensize.getHeight();
    	int w=(int)width;
    	int h=(int)height;
    	

    	f.setSize(w,h); 
    	


    	f.setTitle("Exam Registration System");
    	f.setVisible(true);
    	
    	REGISTER.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    		 System.out.println("check");        		
       		 f.dispose();    	    
       	     Register.main(null);
    		}
    		
    	});
    	
    	EXIT.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			//JOptionPane.showMessageDialog(null, "Do U want to EXIT");
    			//JOptionPane.showInternalConfirmDialog(null, );
    		    int ans = JOptionPane.showConfirmDialog(null,"Do U want to EXIT","confirmation",JOptionPane.YES_NO_OPTION);
                if(ans==0)
                {
                	f.setVisible(false);
                	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.pack();
            		
                }
    		}
    	});
    			 		
    			
    	
    	
    	
    	SUBMIT.addActionListener(new ActionListener()
    	{
    	public void actionPerformed(ActionEvent ae)

    	{
    	value1=text1.getText();System.out.println("Value 1"+  value1);
    	String value2=text2.getText(); 

    	String user1="";
    	String pass1=""; 
    	String user2=""; 
    	String pass2="";
    	String user3="admin";
    	String pass3="admin";

    	try
    	{ 

    	Connection con=DbConnection.getConnection();
    	Statement st = con.createStatement();

    	ResultSet res = st.executeQuery("SELECT * FROM login where USERNAME='"+value1+"' and PASSWORD='"+value2+"'");

    	while (res.next())

    	{
    		user1 = res.getString("USERNAME"); 
    		pass1 = res.getString("PASSWORD");

    	}
    	if(value1.equals("admin") && value1.equals("admin"))

    	{ 
    		System.out.println("check");
    		
    			
    		 f.dispose();   
    		 Admin a=new Admin();
    	     Admin.main(null);
    	 
    	}

    	else if(value1.equals(user2) && value2.equals(pass2))

    	{ 
    		JOptionPane.showMessageDialog(null,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
    		}
    	
    	else if(value1.equals(user1) && value2.equals(pass1))

    	{ 
    		System.out.println("check");
    		
    			
    		 f.dispose();   
    		 Student s=new Student(value1);
    	     s.main(null);
    	 
    	}
    	
    	else

    	{
    	JOptionPane.showMessageDialog(null,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
    	

    	}
    	}

    	catch(Exception e)
    	{

    	System.out.println(e.getMessage());
    	}
    	}
    	}); 
    }
	public static void main(String[] args) 
	{
		new LoginForm();

	}

}
