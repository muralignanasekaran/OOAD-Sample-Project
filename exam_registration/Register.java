package exam_registration;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

public class Register implements ActionListener 
{

    JLabel lblFName,lblLname,lblAddress,lblRoll,lblCollege,lblQualification,lblDob,lblEmail,lblPhone,lblPassword;
    JTextField txtFName,txtLName,txtAddress,txtRoll,txtCollege,txtQualification,txtDob,txtEmail,txtPhone,txtPassword;
    JButton btnAdd,btnUpdate;
    ResultSet rs;
    JFrame frame;
       



    public static void main(String[] args) 
        {
    	Register obj = new Register();
        obj.createUI();
    }


   private void createUI()
    {
        frame = new JFrame("Regitration Form");
        JPanel pnlInput = new JPanel(new GridLayout(11,2));
        
        
        lblFName = new JLabel("  First Name : ");
        txtFName = new JTextField(15);
      
       lblLname = new JLabel("  Last Name : ");
        txtLName = new JTextField();
      
      lblAddress = new JLabel("  Address : ");
        txtAddress = new JTextField();
     
      lblRoll = new JLabel(" Roll No  : ");
        txtRoll = new JTextField();
        
        lblCollege = new JLabel(" College Name  : ");
        txtCollege = new JTextField();
        
        lblQualification = new JLabel(" Qualification  : ");
        txtQualification = new JTextField();
        
        lblDob = new JLabel(" Date Of Birth  : ");
        txtDob = new JTextField();
        
        lblEmail = new JLabel(" e-mail Id : ");
        txtEmail = new JTextField();
        
        lblPhone = new JLabel(" Phone No  : ");
        txtPhone = new JTextField();
        
        lblPassword = new JLabel("  Enter new Password : ");
        txtPassword = new JTextField();
                
        pnlInput.add(lblFName);
        pnlInput.add(txtFName);

 
        pnlInput.add(lblLname);
        pnlInput.add(txtLName);
        
        pnlInput.add(lblPassword);
        pnlInput.add(txtPassword);

 
        pnlInput.add(lblAddress);
        pnlInput.add(txtAddress);


        pnlInput.add(lblRoll);
        pnlInput.add(txtRoll);
        
        pnlInput.add(lblCollege);
        pnlInput.add(txtCollege);

        
        pnlInput.add(lblQualification);
        pnlInput.add(txtQualification);

        
        pnlInput.add(lblDob);
        pnlInput.add(txtDob);

        
        pnlInput.add(lblEmail);
        pnlInput.add(txtEmail);

        
        pnlInput.add(lblPhone);
        pnlInput.add(txtPhone);
        
       



    JPanel pnlButton = new JPanel(new GridLayout(1,2));

 

        btnAdd = new JButton("Add");

        btnAdd.addActionListener(this);

 

        btnUpdate = new JButton("Update");

        btnUpdate.addActionListener(this);

        
        pnlButton.add(btnAdd);
        pnlButton.add(btnUpdate);
           
       frame.getContentPane().setBackground(Color.CYAN);

        
 
        Container cn = frame.getContentPane();

       cn.setLayout(new BoxLayout(cn,BoxLayout.Y_AXIS));
 

        frame.add(pnlInput);
        frame.add(pnlButton);
        

       

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JOptionPane.showMessageDialog(null, "First Name entered will be used as Username",null, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override

    public void actionPerformed(ActionEvent evt) 
    {



        String action = evt.getActionCommand();

        if(action.equals("Add"))

        {
            addOperation();
            

        }
        else if(action.equals("Update"))

        {

            updateOperation();
            }

        }
        
        

    private void addOperation()

    {

        try

        {

            

           Class.forName ("oracle.jdbc.OracleDriver");

           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522/orcl","system","murali");

            String sql = "INSERT INTO Registration (FName,LName,Address,Roll,College,Qualification,Dob,Email,Phone,Password) " + "Values ('"+txtFName.getText()+"'," + "'"+txtLName.getText()+"',"+"'"+txtAddress.getText()+"',"+"'"+txtRoll.getText()+"',"+"'"+txtCollege.getText()+"',"+"'"+txtQualification.getText()+"',"+"'"+txtDob.getText()+"',"+"'"+txtEmail.getText()+"',"+"'"+txtPhone.getText()+"','"+txtPassword.getText()+"')";
            
            
            Statement st = con.createStatement();

            st.execute(sql);


            JOptionPane.showMessageDialog(null, "Record Added Succesfully.","Record Added", JOptionPane.INFORMATION_MESSAGE);
            
            String sql1 = "insert into Login(username,password)"+"values('"+txtFName.getText()+"','"+txtPassword.getText()+"')";
            
            st.execute(sql1);
            
            JOptionPane.showMessageDialog(null, "Login Created Succesfully.","Login Created", JOptionPane.INFORMATION_MESSAGE);
            
            frame.dispose();   
   		 LoginForm l=new LoginForm();
   	     l.main(null);

           

        }
        catch(Exception e)

        {

            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }

    }

    private void updateOperation()

    {

        try

        {
        	Class.forName ("oracle.jdbc.OracleDriver");

        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522/orcl","system","murali");
 

            String sql = "Update Registration " + "SET FName = '"+txtFName.getText()+"',LName = '"+txtLName.getText()+"'," + "Address = '"+txtAddress.getText()+"'," + "Roll = '"+txtRoll.getText()+"'," + "College = '"+txtCollege.getText()+"'," + "Qualification = '"+txtQualification.getText()+"'," + "Dob = '"+txtDob.getText()+"'," + "Email = '"+txtEmail.getText()+"'," + "Phone = '"+txtPhone.getText()+"'," + "Password = '"+txtPassword.getText()+"'"+ "Where FName = '"+txtFName.getText()+"'";

 
            JOptionPane.showMessageDialog(null, sql,"Record Updated", JOptionPane.INFORMATION_MESSAGE);

            Statement st = con.createStatement();

            st.execute(sql);


            JOptionPane.showMessageDialog(null, "Record Update Succesfully.", "Record Updated",JOptionPane.INFORMATION_MESSAGE);

            String sql2 = "update login " + "set username = '"+txtFName.getText()+"'," + "Password = '"+txtPassword.getText()+"' "+ "Where username = '"+txtFName.getText()+"'";
            
            st.execute(sql2);
            
            frame.dispose();   
      		 LoginForm l=new LoginForm();
      	     l.main(null);

            
            
          

        }
        catch(Exception e)

        {

            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",  JOptionPane.ERROR_MESSAGE);
        }

    }
  

    

}


