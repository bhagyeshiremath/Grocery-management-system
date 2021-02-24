import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
class changePass extends JFrame implements ActionListener
{
JLabel lcurr,lnew,lnewconfirm,name;
JTextField tcurr,tnew,tnewconfirm;
JButton submit,exit,reset;
JPanel p01,p1,p02,p2,p03,p3;
Connection c=null;
Statement st;
PreparedStatement ps;
ResultSet rs;

changePass()
{
setVisible(true);
setSize(500,500);
setLocation(300,150);
setTitle("Change Password");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Font f=new Font("Imprint MT Shadow",0,50);
Font f1=new Font("Californian FB",0,20);

lcurr=new JLabel("Enter Current Password:",JLabel.CENTER);
lnew=new JLabel("Enter New Password:",JLabel.CENTER);
lnewconfirm=new JLabel("Enter New Password Again:",JLabel.CENTER);
name=new JLabel("Password Setting",JLabel.CENTER);

name.setFont(f);
lcurr.setFont(f1);
lnew.setFont(f1);
lnewconfirm.setFont(f1);

tcurr=new JTextField(15);
tnew=new JTextField(15);
tnewconfirm=new JTextField(15);

submit=new JButton("Submit");
exit=new JButton("Exit");
reset=new JButton("Reset");

submit.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);

p01=new JPanel();
p01.setLayout(new GridLayout(1,2,4,4));
p01.add(lcurr);
p01.add(tcurr);

p02=new JPanel();
p02.setLayout(new GridLayout(1,2,4,4));
p02.add(lnew);
p02.add(tnew);

p03=new JPanel();
p03.setLayout(new GridLayout(1,2,4,4));
p03.add(lnewconfirm);
p03.add(tnewconfirm);

p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(p01);
p1.add(p02);
p1.add(p03);

p2=new JPanel();
p2.add(submit);
p2.add(reset);
p2.add(exit);


p3=new JPanel();
p3.setLayout(new GridLayout(2,1,1,1));
p3.add(p1);
p3.add(p2);


add(name,BorderLayout.NORTH);
add(p3,BorderLayout.CENTER);

}
public void actionPerformed(ActionEvent ae)
{
String msg=" ";
 if(ae.getSource()==reset)
  { 
  tnew.setText(msg);
  tcurr.setText(msg);
  tnewconfirm.setText(msg);
  }
else if(ae.getSource()==exit)
 {
 int rt=JOptionPane.showConfirmDialog(null, "Really want to Exit from Window??", "Choose one",JOptionPane.YES_NO_OPTION);
	if(rt==JOptionPane.YES_OPTION )
	{
		dispose();
	}

 }

else if(ae.getSource()==submit)
  { 
   String passcurr=tcurr.getText();
   String passn=tnew.getText();
   String passcon=tnewconfirm.getText();
   if(passn.equals(passcon))
   {
    try
    {
       Class.forName("org.postgresql.Driver");
      c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");     
String qur="select password from admininfo";
st=c.createStatement();
rs=st.executeQuery(qur);

String check;

while(rs.next())
{
check=rs.getString(1);


   if(check.equals(passcurr))
   {  
   String qur1="update admininfo set password=?";
   ps=c.prepareStatement(qur1);
   ps.setString(1,passn);
      int n=ps.executeUpdate();
       if(n==1)
        JOptionPane.showMessageDialog(null,"Password Changed");
      else
         JOptionPane.showMessageDialog(null,"Password does not Changed");
    }
     else
   {
     JOptionPane.showMessageDialog(null,"Invalid Password ");
   }
  }
  }catch(Exception e)
       {System.out.println(e);}
    }
    else
    {
      JOptionPane.showMessageDialog(null,"Entered Password does not match");
       tnewconfirm.requestFocus(); 
    }

  }
}

public static void main(String args[])
{
new changePass();
}
}
