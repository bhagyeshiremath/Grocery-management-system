import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
class Login implements ActionListener
{
JLabel l1,l2,l3,l4,l5;
JTextField t1;
JPasswordField t2;
JButton b1,b2;
JPanel p1;
Connection c=null;
Statement st;
ResultSet rs;

 public Login()
{
JFrame fr=new JFrame("LOGIN");
fr.setLayout(new GridLayout(2,4));
l4=new JLabel("                            ");
l1=new JLabel("HS GROCERY SHOP",JLabel.CENTER); 
l5=new JLabel("                            ");
l2=new JLabel("Username");
l3=new JLabel("Password");
t1=new JTextField(20);
t2=new JPasswordField(20);
b1=new JButton("Reset");
b1.addActionListener(this);
b2=new JButton("Submit");
b2.addActionListener(this);

p1=new JPanel();
p1.add(l4);
p1.add(l1);
p1.add(l5);
p1.add(l2);
p1.add(t1);
p1.add(l3);
p1.add(t2);
p1.add(b1);
p1.add(b2);

fr.add(p1);
fr.setLocation(500,300);
fr.setSize(350,250);
fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
fr.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
  String msg="";
  if(ae.getSource()==b1)
  { 
  t1.setText(msg);
  t2.setText(msg);
  }
  if(ae.getSource()==b2)
  {
    try{
     Class.forName("org.postgresql.Driver");
//DriverManager.register(new org.postgresql.Driver());     
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");  
      
      
    st=c.createStatement();
    String query="select * from admininfo";
     rs=st.executeQuery(query);      
     String x=t1.getText();
     String y=t2.getText();
     String user,pass,id;      
while(rs.next())
    {
      id=rs.getString(1);
      user=rs.getString(2);
      pass=rs.getString(3);
             
  if(x.equals(user))
    {
       if(y.equals(pass))
       {
          JOptionPane.showMessageDialog(null,"Login Successful");
          new MainHome();
         } 
        else
       {   
      JOptionPane.showMessageDialog(null,"Enter correct password");
        }
    }
     else
     {
     JOptionPane.showMessageDialog(null,"Enter valid username");
     }
   } 
}
     catch(Exception e)
     {System.out.println(e);}     
  }
}


public static void main(String arg[])
{
new Login();
}
}