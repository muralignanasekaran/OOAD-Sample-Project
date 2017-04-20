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


public class Admin implements ActionListener
{
	JLabel lblFName,lblLName,lblAddress,lblRoll,lblCollege,lblQualification,lblDob,lblEmail,lblPhone,lblmarks;
	JLabel lblFNameval,lblLNameval,lblAddressval,lblRollval,lblCollegeval,lblQualificationval,lblDobval,lblEmailval,lblPhoneval,lblmarksval;
	JFrame frame=new JFrame("ADMIN");
	ResultSet rs;
	JButton btnPrev,btnNext;

	public static void main(String[] args) 
	{

		Admin obj = new Admin();
        obj.createUI();
	}

	 private void createUI()
	 {
		 JPanel pnlNavigate = new JPanel(new GridLayout(1,2));

	        btnPrev = new JButton(" << ");
	        btnPrev.setActionCommand("Prev");
	        btnPrev.addActionListener(this);
	 
	        btnNext = new JButton(" >> ");
	        btnNext.setActionCommand("Next");
	        btnNext.addActionListener(this);

	        
	        pnlNavigate.add(btnPrev);
	        pnlNavigate.add(btnNext);
	 
		 
		 JPanel pnlNavAns = new JPanel(new GridLayout(10,2));
		 
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
			
			lblmarks = new JLabel("Total marks : ");
			lblmarksval = new JLabel("val");
			
			pnlNavAns.add(lblFName);
			pnlNavAns.add(lblFNameval);
			
			pnlNavAns.add(lblLName);
			pnlNavAns.add(lblLNameval);
			
			pnlNavAns.add(lblRoll);
			pnlNavAns.add(lblRollval);
			
			pnlNavAns.add(lblAddress);
			pnlNavAns.add(lblAddressval);
			
			pnlNavAns.add(lblCollege);
			pnlNavAns.add(lblCollegeval);
			
			pnlNavAns.add(lblQualification);
			pnlNavAns.add(lblQualificationval);
			
			pnlNavAns.add(lblDob);
			pnlNavAns.add(lblDobval);
			
			pnlNavAns.add(lblEmail);
			pnlNavAns.add(lblEmailval);
			
			pnlNavAns.add(lblPhone);
			pnlNavAns.add(lblPhoneval);
			
			pnlNavAns.add(lblmarks);
			pnlNavAns.add(lblmarksval);
			
			Container cn = frame.getContentPane();

		       cn.setLayout(new BoxLayout(cn,BoxLayout.Y_AXIS));
		       
		       frame.add(pnlNavigate);
		       frame.add(pnlNavAns);
		       
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		frame.pack();
	    		frame.setVisible(true);
	 }
	 
	 @Override
	 
	 public void actionPerformed(ActionEvent evt) 
	 {
        
		 String action = evt.getActionCommand();

	        if(action.equals("Prev"))

	        {

	          preNavigation();

	       }
	        else if(action.equals("Next"))

	        {

	            nextNavigation();

	        }
	 }
	 private void preNavigation()

	    {

	        try{

	            if(rs == null)

	            {

	            	Connection con = DbConnection.getConnection();

	            String sql = "SELECT * FROM registration";


	            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

	            rs = st.executeQuery(sql);

	            }

	            if(rs.previous())

	            {

	                populateValue();

	            }

	            }
	        catch(Exception e)

	            {

	                JOptionPane.showMessageDialog(null, e.getMessage(),"Error",  JOptionPane.ERROR_MESSAGE);
	            }

	    }

	    private void nextNavigation()

	    {

	        try{

	            if(rs == null)

	            {

	            	Connection con = DbConnection.getConnection();

	 

	            String sql = "SELECT * FROM registration";



	            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

	            rs = st.executeQuery(sql);

	            }

	            if(rs.next())

	            {

	                populateValue();

	            }

	            }catch(Exception e)

	            {

	                JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);

	            }

	    }
	    private void populateValue() throws Exception
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
            int marks = rs.getInt("marks");
	    	
	    	lblFNameval.setText(FNmae);
	    	lblLNameval.setText(LName);
	    	lblAddressval.setText(Address);
	    	lblRollval.setText(Roll);
	    	lblCollegeval.setText(College);
	    	lblQualificationval.setText(Qualification);
	    	lblDobval.setText(Dob);
	    	lblEmailval.setText(Email);
	    	lblPhoneval.setText(Phone);
	    	lblmarksval.setDisplayedMnemonic(marks);
	    	
	    }

}
