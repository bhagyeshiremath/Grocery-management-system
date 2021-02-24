import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;

class searchCustomer implements ActionListener
{
JFrame fr1,fr2;
JLabel sea,name,lname,ladd,lphone,lcity,lpin,lcustname,ename,ephone,eadd,ecity,epin;
JLabel idl,namel,addl,phonel,pinl,cityl;
JTextField tname,tadd,tphone,tpin,tcustname,tcity;
JCheckBox cname,cadd,cphone,cpin,city;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,panel;
JButton submit,search,reset,exit;


ButtonGroup bg;
Connection c=null;
PreparedStatement ps;
Statement st;
ResultSet rs;
searchCustomer()
{
fr1=new JFrame();
fr1.setVisible(true);
fr1.setSize(700,500);
fr1.setLocation(300,150);
fr1.setTitle("Search Customer Detail");
fr1.setLayout(new BorderLayout());
fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Font f1=new Font("Californian FB",0,20);
Font f=new Font("Bookman Old Style",0,30);

name=new JLabel("SEARCH CUSTOMER DETAIL",JLabel.CENTER);
name.setFont(f);

sea=new JLabel("Search by :");
sea.setFont(f1);


cname=new JCheckBox("Name");
cadd=new JCheckBox("address");
cphone=new JCheckBox("phone number");
city=new JCheckBox("City");
cpin=new JCheckBox("Pin-Code ");
bg=new ButtonGroup();
bg.add(cname);
bg.add(cadd);
bg.add(cphone);
bg.add(city);
bg.add(cpin);

//lcustname=new JLabel("Enter name of customer");
//lcustname.setFont(f1);
lname=new JLabel("Name ");
lname.setFont(f1);
ladd=new JLabel("address");
ladd.setFont(f1);
lphone=new JLabel("phone number");
lphone.setFont(f1);
lcity=new JLabel("City");
lcity.setFont(f1);
lpin=new JLabel("Pin-Code ");
lpin.setFont(f1);

tname=new JTextField(20);
tadd=new JTextField(20);
tphone=new JTextField(15);
tpin=new JTextField(6);
tcity=new JTextField(15);

search=new JButton("Search");
reset=new JButton("Reset");
exit=new JButton("EXIT");
submit=new JButton("Submit");
submit.addActionListener(this);
search.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);


ename=new JLabel("Enter name");
eadd=new JLabel("Enter address");
epin=new JLabel("Enter  pincode");
ephone=new JLabel("Enter phone number");
ecity=new JLabel("Enter city name");

p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(sea);
p1.add(cname);
p1.add(cphone);
p1.add(cadd);
p1.add(city);
p1.add(cpin);
p1.add(submit);



p4=new JPanel();
p4.setLayout(new BorderLayout());
p4.add(name,BorderLayout.NORTH);
p4.add(p1,BorderLayout.CENTER);

fr1.add(p4,BorderLayout.NORTH);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==submit)
{

p5=new JPanel();
p5.setLayout(new GridLayout(6,1));

if(cname.isSelected())
{
p6=new JPanel();
p6.add(ename);
p6.add(tname);
p5.add(p6);
}
else if(cphone.isSelected())
{
p7=new JPanel();
p7.add(ephone);
p7.add(tphone);
p5.add(p7);
}
else if(cadd.isSelected())
{
p8=new JPanel();
p8.add(eadd);
p8.add(tadd);
p5.add(p8);
}

else if(cpin.isSelected())
{
p9=new JPanel();
p9.add(epin);
p9.add(tpin);
p5.add(p9);
}
else if(city.isSelected())
{

p10=new JPanel();
p10.add(ecity);
p10.add(tcity);
p5.add(p10);
}

p11=new JPanel();
p11.add(search);
p11.add(reset);
p11.add(exit);

p5.add(p11);
fr1.add(p5,BorderLayout.CENTER);
}

if(ae.getSource()==reset)
{
if(city.isSelected())
{
 tcity.setText("");
 city.setSelected(false);
}
String msg=" ";

if(cname.isSelected())
{
  tname.setText(msg);
  cname.setSelected(false);
}
else if(cadd.isSelected())
{
  tadd.setText(msg);
  cadd.setSelected(false);
}
else if(cphone.isSelected())
{
  tphone.setText(msg);
  cphone.setSelected(false);
}
else if(cpin.isSelected())
{
  tpin.setText(msg);
  cpin.setSelected(false);
}
}

if(ae.getSource()==exit)
{
int rt=JOptionPane.showConfirmDialog(null, "Really want to Exit from Window??", "Choose one",JOptionPane.YES_NO_OPTION);
	if(rt==JOptionPane.YES_OPTION )
	{
		//dispose();
	}

}
if(ae.getSource()==search)
{
Font f1=new Font("Californian FB",0,20);
System.out.println("Search clicked");
 String custname,custadd,custphone,custcity,custpin;
fr2=new JFrame();
fr2.setVisible(true);
fr2.setSize(700,500);
fr2.setLocation(300,150);
fr2.setTitle("Customer Details");
fr2.setLayout(new GridLayout(10,5,4,4));
fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JLabel l1,l2,l3,l4,l5,l6;

l1=new JLabel("ID",JLabel.CENTER);
l2=new JLabel("NAME",JLabel.CENTER);
l3=new JLabel("ADDRESS",JLabel.CENTER);
l4=new JLabel("CITY",JLabel.CENTER);
l5=new JLabel("PHONE",JLabel.CENTER);
l6=new JLabel("PINCODE",JLabel.CENTER);

l1.setFont(f1);
l2.setFont(f1);
l3.setFont(f1);
l4.setFont(f1);
l5.setFont(f1);
l6.setFont(f1);
//pan=new JPanel();
//pan.setLayout(new GridLayout(1,5,4,4));
//panel=new JPanel();
//panel.setLayout(new GridLayout(1,5,4,4));

if(city.isSelected())
{
fr2.add(l1);
fr2.add(l2);
fr2.add(l3);
fr2.add(l5);
fr2.add(l6);
//fr2.add(panel);
try
{ 
Class.forName("org.postgresql.Driver");
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");

String qur="select * from customer where city=?";
custcity=tcity.getText();

ps=c.prepareStatement(qur);
ps.setString(1,custcity);
rs=ps.executeQuery();

for(int p=0;rs.next();p++)
{

String id1=rs.getString(1);
String name1=rs.getString(2);
String add1=rs.getString(3);
String phone1=rs.getString(5);
String pin1=rs.getString(6);

idl=new JLabel(id1,JLabel.CENTER);
namel=new JLabel(name1,JLabel.CENTER);
addl=new JLabel(add1,JLabel.CENTER);
phonel=new JLabel(phone1,JLabel.CENTER);
pinl=new JLabel(pin1,JLabel.CENTER);

fr2.add(idl);
fr2.add(namel);
fr2.add(addl);
fr2.add(phonel);
fr2.add(pinl);

//fr2.add(pan);
}//for

c.close();
ps.close();

}catch(Exception e)
 {System.out.println(e);}

}//if


else if(cname.isSelected())
{
fr2.add(l1);
fr2.add(l3);
fr2.add(l4);
fr2.add(l5);
fr2.add(l6);
//fr2.add(panel,BorderLayout.NORTH);
try
{ 
Class.forName("org.postgresql.Driver");
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");

String qur="select * from customer where cname=?";
custname=tname.getText();

ps=c.prepareStatement(qur);
ps.setString(1,custname);
rs=ps.executeQuery();

for(int p=0;rs.next();p++)
{

String id1=rs.getString(1);
String add1=rs.getString(3);
String city1=rs.getString(4);
String phone1=rs.getString(5);
String pin1=rs.getString(6);

System.out.println(id1+""+city1+""+add1);
idl=new JLabel(id1,JLabel.CENTER);
addl=new JLabel(add1,JLabel.CENTER);
cityl=new JLabel(city1,JLabel.CENTER);
phonel=new JLabel(phone1,JLabel.CENTER);
pinl=new JLabel(pin1,JLabel.CENTER);

fr2.add(idl);
fr2.add(addl);
fr2.add(cityl);
fr2.add(phonel);
fr2.add(pinl);

//fr2.add(pan);
}//while
c.close();
ps.close();

}catch(Exception e)
 {System.out.println(e);}

}
else if(cadd.isSelected())
{
fr2.add(l1);
fr2.add(l2);
fr2.add(l4);
fr2.add(l5);
fr2.add(l6);
//fr2.add(panel,BorderLayout.NORTH);
try
{ 
Class.forName("org.postgresql.Driver");
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");

String qur="select * from customer where cadd=?";
custadd=tadd.getText();

ps=c.prepareStatement(qur);
ps.setString(1,custadd);
rs=ps.executeQuery();

for(int p=0;rs.next();p++)
{

String id1=rs.getString(1);
String name1=rs.getString(2);
String city1=rs.getString(4);
String phone1=rs.getString(5);
String pin1=rs.getString(6);

System.out.println(id1+""+name+""+city1);
idl=new JLabel(id1,JLabel.CENTER);
namel=new JLabel(name1,JLabel.CENTER);
cityl=new JLabel(city1,JLabel.CENTER);
phonel=new JLabel(phone1,JLabel.CENTER);
pinl=new JLabel(pin1,JLabel.CENTER);

fr2.add(idl);
fr2.add(namel);
fr2.add(cityl);
fr2.add(phonel);
fr2.add(pinl);

//fr2.add(pan);
}//while

c.close();
ps.close();

}catch(Exception e)
 {System.out.println(e);}

}

else if(cphone.isSelected())
{
fr2.add(l1);
fr2.add(l2);
fr2.add(l3);
fr2.add(l4);
fr2.add(l6);
//fr2.add(panel,BorderLayout.NORTH);

try
{ 
Class.forName("org.postgresql.Driver");
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");

String qur="select * from customer where cphone=?";
custphone=tphone.getText();

ps=c.prepareStatement(qur);
ps.setString(1,custphone);
rs=ps.executeQuery();

for(int p=0;rs.next();p++)
{

String id1=rs.getString(1);
String name1=rs.getString(2);
String add1=rs.getString(3);
String city1=rs.getString(4);
String pin1=rs.getString(6);

idl=new JLabel(id1,JLabel.CENTER);
namel=new JLabel(name1,JLabel.CENTER);
addl=new JLabel(add1,JLabel.CENTER);
cityl=new JLabel(city1,JLabel.CENTER);
pinl=new JLabel(pin1,JLabel.CENTER);

fr2.add(idl);
fr2.add(namel);
fr2.add(addl);
fr2.add(cityl);
fr2.add(pinl);

//fr2.add(pan);
}//while

c.close();
ps.close();

}catch(Exception e)
 {System.out.println(e);}

}

else if(cpin.isSelected())
{
fr2.add(l1);
fr2.add(l2);
fr2.add(l3);
fr2.add(l4);
fr2.add(l5);
//fr2.add(panel,BorderLayout.NORTH);
try
{ 
Class.forName("org.postgresql.Driver");
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");

String qur="select * from customer where pincode=?";
custpin=tpin.getText();
int custpin1=Integer.parseInt(custpin);

ps=c.prepareStatement(qur);
ps.setInt(1,custpin1);
rs=ps.executeQuery();

for(int p=0;rs.next();p++)
{

String id1=rs.getString(1);
String name1=rs.getString(2);
String add1=rs.getString(3);
String city1=rs.getString(4);
String phone1=rs.getString(5);

idl=new JLabel(id1,JLabel.CENTER);
namel=new JLabel(name1,JLabel.CENTER);
addl=new JLabel(add1,JLabel.CENTER);
cityl=new JLabel(city1,JLabel.CENTER);
phonel=new JLabel(phone1,JLabel.CENTER);

fr2.add(idl);
fr2.add(namel);
fr2.add(addl);
fr2.add(cityl);
fr2.add(phonel);

//fr2.add(pan);
}//while

c.close();
ps.close();

}catch(Exception e)
 {System.out.println(e);}

}


}

}

public static void main(String arg[])
{
new searchCustomer();
}

}
