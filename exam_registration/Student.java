package exam_registration;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Student implements ActionListener
{
	JLabel lblFName,lblLName,lblAddress,lblRoll,lblCollege,lblQualification,lblDob,lblEmail,lblPhone,lblmarks,lblFName1,lblLName1,lblRoll1;
	JLabel lblFNameval,lblLNameval,lblAddressval,lblRollval,lblCollegeval,lblQualificationval,lblDobval,lblEmailval,lblPhoneval,lblmarksval,lblFNameval1,lblLNameval1,lblRollval1;
	JButton btndetail,btntest,btnresult,btnback,btnlogout;
	String name,mark;
	JFrame frame = new JFrame("STUDENT DETAIL");
	JFrame f=new JFrame("EXAM RESULTS");
	
	ResultSet rs;
	
	
	
	Student(String value1)
	{
	  name = value1;
	  createUI();
	}
	
	public static void main(String args[])
	{
	  
	}
	
	private void createUI()
	{
		
		JPanel pnlButton = new JPanel(new GridLayout(1,3));
		JPanel detail = new JPanel(new GridLayout(9,2));
		
		btndetail =new JButton("My Details");
		btndetail.addActionListener(this);
		btndetail.setBounds(100,150,100,20);
		
		btntest = new JButton ("Write Test");
		btntest.addActionListener(this);
		btntest.setBounds(300,150,100,20);
		
		btnresult = new JButton("My Result");
		btnresult.addActionListener(this);
		btnresult.setBounds(500,150,100,20);
		
		btnback =new JButton("Back");
		btnback.addActionListener(this);
		btnback.setBounds(300,2000,100,20);
		
		btnlogout =new JButton("LOGOUT");
		btnlogout.addActionListener(this);
		btnlogout.setBounds(300,2000,100,20);
		
		
		pnlButton.add(btndetail);
		pnlButton.add(btntest);
		pnlButton.add(btnresult);
		pnlButton.add(btnresult);
		pnlButton.add(btnlogout);
		
		lblFName = new JLabel("First Nmae : ");
		lblFNameval = new JLabel("val");
		
		lblLName = new JLabel("  Last Name : ");
		lblLNameval = new JLabel("val");
		
		lblAddress = new JLabel("  Address : ");
		lblAddressval = new JLabel("val");
		
		lblRoll = new JLabel(" Roll No  : ");
		lblRollval = new JLabel("val");
		
		lblCollege = new JLabel(" College Name  : ");
		lblCollegeval = new JLabel("val");
		
		lblQualification = new JLabel(" Qualification  : ");
		lblQualificationval = new JLabel("val");
		
		lblDob = new JLabel(" Date Of Birth  : ");
		lblDobval = new JLabel("val");
		
		lblEmail = new JLabel(" e-mail Id : ");
		lblEmailval = new JLabel("val");
		
		lblPhone = new JLabel(" Phone No  : ");
		lblPhoneval = new JLabel("val");
		
		
		
		
		
		detail.add(lblFName);
		detail.add(lblFNameval);
		
		detail.add(lblLName);
		detail.add(lblLNameval);
		
		detail.add(lblAddress);
		detail.add(lblAddressval);
		
		detail.add(lblRoll);
		detail.add(lblRollval);
		
		detail.add(lblCollege);
		detail.add(lblCollegeval);
		
		detail.add(lblQualification);
		detail.add(lblQualificationval);
		
		detail.add(lblDob);
		detail.add(lblDobval);
		
		detail.add(lblEmail);
		detail.add(lblEmailval);
		
		detail.add(lblPhone);
		detail.add(lblPhoneval);
		
		JPanel results = new JPanel(new GridLayout(5,2));
		
		lblFName1 = new JLabel("First Nmae : ");
		lblFNameval1 = new JLabel("val");
		
		lblLName1 = new JLabel("  Last Name : ");
		lblLNameval1 = new JLabel("val");
		
		lblRoll1 = new JLabel(" Roll No : ");
		lblRollval1 = new JLabel("val");
		
		lblmarks = new JLabel("Total marks : ");
		lblmarksval = new JLabel("val");
		
		results.add(lblFName1);
		results.add(lblFNameval1);
		
		results.add(lblLName1);
		results.add(lblLNameval1);
		
		results.add(lblRoll1);
		results.add(lblRollval1);
		
		results.add(lblmarks);
		results.add(lblmarksval);
		
		results.add(btnback);
		
		
		
		
		Container cn =frame.getContentPane();
		cn.setLayout(new BoxLayout(cn,BoxLayout.Y_AXIS));
		
		
		
		frame.add(pnlButton);
		frame.add(detail);
		
		f.add(results);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1024,768);
		
		
	}
	
	@Override
	
	public void actionPerformed(ActionEvent evt)
	{
		String action = evt.getActionCommand();
		if(action.equals("My Details"))
		{
			viewOperation();
		}
		if(action.equals("Write Test"))
		{
			writeOperation();
		}
		if(action.equals("My Result"))
		{
			resultOperation();
		}
		if(action.equals("Back"))
		{
			backpage();
		}
		if(action.equals("LOGOUT"))
		{
			frame.dispose();
			LoginForm l=new LoginForm();
			l.main(null);
		}
		
	}

	private void viewOperation()
	{
	
		
		try
		{
			Connection con = DbConnection.getConnection();
	    	Statement st = con.createStatement();
	    	
	    	String sql = "Select * from Registration where Fname ='" +name+"'";
	    	rs = st.executeQuery(sql);
	    	
	    	if(rs.next())
	    	{
	    	
	    	String FNmae = rs.getString("FName");
	    	String LName  = rs.getString("LName");
	    	String Address  = rs.getString("Address");
	    	String Roll  = rs.getString("Roll");
	    	String College = rs.getString("College");
	    	String Qualification = rs.getString("Qualification");
	    	String Dob = rs.getString("Dob");
	    	String Email = rs.getString("Email");
	    	String Phone = rs.getString("Phone");
	    	
	    	lblFNameval.setText(FNmae);
	    	lblLNameval.setText(LName);
	    	lblAddressval.setText(Address);
	    	lblRollval.setText(Roll);
	    	lblCollegeval.setText(College);
	    	lblQualificationval.setText(Qualification);
	    	lblDobval.setText(Dob);
	    	lblEmailval.setText(Email);
	    	lblPhoneval.setText(Phone);
	    	}
	    	
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",  JOptionPane.ERROR_MESSAGE);
		}
	}

	private void writeOperation()
	{       		
  		 frame.dispose();
  		 Test t=new Test(name);
  	     t.main(null);
	}
	
	private void resultOperation()
	{
		try
		{
			Connection con = DbConnection.getConnection();
	    	Statement st = con.createStatement();
	    	
	    	String sql = "Select * from Registration where Fname ='" +name+"'";
	    	rs = st.executeQuery(sql);
	    	if(rs.next())
	    	{	    		
	    		
	    		String FNmae = rs.getString("FName");
	        	String LName  = rs.getString("LName");
	        	String Roll = rs.getString("Roll");
	    		mark = rs.getString("marks");
	    		
	    		lblFNameval1.setText(FNmae);
	        	lblLNameval1.setText(LName);
	        	lblRollval1.setText(Roll);
	        	lblmarksval.setText(mark);
	        	
	        	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		f.pack();
	    		frame.setVisible(false);
	    		f.setVisible(true);
	    		f.setSize(500,500);
	    	}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",  JOptionPane.ERROR_MESSAGE);
		}
		
	}
    private void backpage()
    {
    	f.dispose();
    	frame.setVisible(true);
    }
}
	
	

		
    	
		
		
		
		

