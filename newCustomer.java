import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
class newCustomer extends JFrame implements ActionListener
{
JLabel name,lname,ladd,lphone,label1,lcity,lpin;
JTextField tname,tadd,tphone,tpin;
JButton submit,reset,exit;
JPanel p01,p1,p2,p3,p4,p5,p6;
JComboBox ccity;
Connection c=null;
PreparedStatement ps;
Statement st;
ResultSet rs;
static int num;

public newCustomer()
{
setVisible(true);
setSize(500,500);
setLocation(300,150);
setTitle("Enter New Customer Detail");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Font f2=new Font("Elephant",0,30);
Font f=new Font("Imprint MT Shadow",0,50);
Font f1=new Font("Californian FB",0,20);

name=new JLabel("   HS Grocery Shop");
name.setFont(f);
label1=new JLabel("   Enter new customer Details");
label1.setFont(f2);

lname=new JLabel("      Name :",JLabel.RIGHT);
lname.setFont(f1);
ladd=new JLabel("  address:",JLabel.RIGHT);
ladd.setFont(f1);
lphone=new JLabel("phone number",JLabel.RIGHT);
lphone.setFont(f1);
lcity=new JLabel("City:",JLabel.RIGHT);
lcity.setFont(f1);
lpin=new JLabel("Pin-Code ");
lpin.setFont(f1);

tname=new JTextField(20);
tadd=new JTextField(20);
tphone=new JTextField(15);
tpin=new JTextField(6);

String  acity[]={"Select","Ahmednagar","Akola","Amravati","Beed","Bhandara","Chandrapur","Dhule","Gadchiroli","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Malegaon","Mumbai","Nagpur","Nashik","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara"};
ccity=new JComboBox(acity);
ccity.setFont(f1);



submit=new JButton("Submit");
reset=new JButton("Reset");
exit=new JButton("EXIT");
submit.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);


p01=new JPanel();
p01.setLayout(new GridLayout(2,1,10,20));
p01.add(name);
p01.add(label1);


p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(lname);
p1.add(tname);

p2=new JPanel();
p2.setLayout(new FlowLayout());
p2.add(ladd);
p2.add(tadd);

p3=new JPanel();
p3.setLayout(new FlowLayout());
p3.add(lphone);
p3.add(tphone);



p4=new JPanel();
p4.setLayout(new FlowLayout());
p4.add(submit);
p4.add(reset);
p4.add(exit);

p5=new JPanel();
p5.setLayout(new FlowLayout());
p5.add(lcity);
p5.add(ccity);
p5.add(lpin);
p5.add(tpin);

p6=new JPanel();
p6.setLayout(new FlowLayout());
p6.add(p1);
p6.add(p3);
p6.add(p2);
p6.add(p5);
p6.add(p4);

add(p01,BorderLayout.NORTH);
add(p6,BorderLayout.CENTER);
}

public void actionPerformed(ActionEvent ae)
{
String msg=" ";
 if(ae.getSource()==reset)
  { 
  tname.setText(msg);
  tadd.setText(msg);
  tphone.setText(msg);
  }
 if(ae.getSource()==exit)
 {
 int rt=JOptionPane.showConfirmDialog(null, "Really want to Exit from Window??", "Choose one",JOptionPane.YES_NO_OPTION);
	if(rt==JOptionPane.YES_OPTION )
	{
		dispose();
	}

}

 if(ae.getSource()==submit)
  { 
  //JOptionPane.showMessageDialog(null,"Successful");  
  try
{
Class.forName("org.postgresql.Driver");
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");
String custname=tname.getText();
String custadd=tadd.getText();
int custpin=Integer.parseInt(tpin.getText());
String custcity=(String)ccity.getSelectedItem();
String custphone=tphone.getText();


String qur1="select cid from customer";
st=c.createStatement();
rs=st.executeQuery(qur1);

while(rs.next())
{
num=Integer.parseInt(rs.getString(1));
}
int cid=num+ 1;

String qur2="insert into customer values(?,?,?,?,?,?)";  
ps=c.prepareStatement(qur2);
ps.setInt(1,cid);
ps.setString(2,custname);
ps.setString(3,custadd);
ps.setString(4,custcity);
ps.setString(5,custphone);
ps.setInt(6,custpin);

int res=ps.executeUpdate();
if(res!=1)
JOptionPane.showMessageDialog(null,"Error in Updation");
else
JOptionPane.showMessageDialog(null,"Updation Succesful");
}
 catch(Exception e)
     {System.out.println(e);}

  }
}

public static void main(String arg[])
{
new newCustomer();
}

}