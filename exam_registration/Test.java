package exam_registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Test 
{
	JLabel q1,q2,note;
	JTextField a1,a2;
	JFrame f;
	JButton Submit;
	ResultSet rs,rs1;
	String qu1,qu2,ans1,ans2;
	String evala1,evala2;
	int intmarks=0;
	String name;
	
	
	Test(String value1)
	{
		name = value1;
		f=new JFrame();
		f.getContentPane().setLayout(null);
		
		q1 = new JLabel();
		q2 = new JLabel();
		note = new JLabel();
		a1 = new JTextField();
		a2 = new JTextField();
		Submit = new JButton("Submit");
		
		note.setBounds(20, 50, 100, 20);
		q1.setBounds(20, 100, 500, 20);
		q2.setBounds(20, 150, 500, 20);
		a1.setBounds(800, 100, 100, 20);
		a2.setBounds(800, 150, 100, 20);
		Submit.setBounds(1000,500 ,100 ,20 );
		
		
		
		
		
		f.add(note);
		f.add(q1);
		f.add(a1);
		f.add(q2);
		f.add(a2);
		f.add(Submit);
		
		f.setTitle("Exam");
		f.setVisible(true);
		f.setSize(2000, 2000);
		
		display();
	}

	private void display()
	{
		try
		{
			
		  Connection con = DbConnection.getConnection();
    	  Statement st = con.createStatement();
    	  String sql = "SELECT * FROM QB ";
    	  rs = st.executeQuery(sql);
    	  
    	  if(rs.next())
    	  {
    		  
    		  qu1 = rs.getString("QUESTION"); 
    		  q1.setText(qu1);
    			
    	  }
    	  if(rs.next())
    	  {
    		  qu2 = rs.getString("QUESTION"); 
    		  q2.setText(qu2);
    	  }
    	  
    	 
    	  
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",  JOptionPane.ERROR_MESSAGE);
		}
		
		
	
		
	
	Submit.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent ae)

	{
		try
		{
			Connection con = DbConnection.getConnection();
	    	Statement st = con.createStatement();
			String sql = "SELECT * FROM QB ";
	    	rs = st.executeQuery(sql);
	    	
	    	
			if(rs.next())
	    	  {
	    		  ans1=a1.getText();
	    		  evala1=rs.getString("answer");
	    		  if(ans1.equalsIgnoreCase(evala1))
	    		  {
	    			  intmarks = intmarks+5;
	    		  }
	    	  }
			if (rs.next())
	        {
	    		  ans2=a2.getText();
	    		  evala2=rs.getString("answer");
	    		  if(ans2.equalsIgnoreCase(evala2))
	    		  {
	    			  intmarks = intmarks+5;
	    		  }
	    	  
	        }
			System.out.println(intmarks);
	    }
		catch(Exception e)
		{
			
		}
		try
		{
			Connection con = DbConnection.getConnection();
	    	Statement st = con.createStatement();
	    	
	    	String sql1 = "Select * from Registration where Fname ='" +name+"'";
	    	rs1 = st.executeQuery(sql1);
	    	
	    	if(rs1.next())
	    	{
	    	
	    	String tFNmae = rs1.getString("FName");
	    	String tLName  = rs1.getString("LName");
	    	String tAddress  = rs1.getString("Address");
	    	String tRoll  = rs1.getString("Roll");
	    	String tCollege = rs1.getString("College");
	    	String tQualification = rs1.getString("Qualification");
	    	String tDob = rs1.getString("Dob");
	    	String tEmail = rs1.getString("Email");
	    	String tPhone = rs1.getString("Phone");
	    	int tmarks=intmarks;
	    	
	    	
	    	String sql2 = "Update Registration " + "SET LName = '"+tLName+"'," + "Address = '"+tAddress+"'," + "Roll = '"+tRoll+"'," + "College = '"+tCollege+"'," + "Qualification = '"+tQualification+"'," + "Dob = '"+tDob+"'," + "Email = '"+tEmail+"'," + "Phone = '"+tPhone+"',"+"marks= '"+tmarks+"'"+ "Where FName = '"+name+"'";
	        st.execute(sql2);
	        JOptionPane.showMessageDialog(null,"Record Updated Successfully",null, JOptionPane.INFORMATION_MESSAGE);
	    	
	    	}
	  	}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",  JOptionPane.ERROR_MESSAGE);
		}
		
		
		f.dispose();
		Student s=new Student(name);
	    s.main(null);
	}
	
	});
	
	
	
	}
    public static void main(String args[])
    {
	}
	
	
	
}







