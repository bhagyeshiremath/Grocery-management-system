import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
class searchProduct implements ActionListener
{
JFrame fr1,fr2;
JLabel sea,name,lid,lname,ltype,lprice,lqkg,lqlt,lyear,lmonth,ldate,lprodname,ename,eprice,etype,eexpyear,eexpdate,eexpmon;
JTextField tname,tprice,texpyear,texpmon,texpdate,tprodname;
JButton submit,search,reset,exit;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p09,p009,p0009;
JCheckBox cname,ctype,cprice,ceyear,cedate,cemon;
JComboBox ttype,tmonth,tdate;
ButtonGroup bg;
Connection c=null;
PreparedStatement ps;
Statement st;
ResultSet rs;

searchProduct()
{
fr1=new JFrame();
fr1.setVisible(true);
fr1.setSize(700,500);
fr1.setLocation(300,150);
fr1.setTitle("Search Product Detail");
fr1.setLayout(new BorderLayout());
fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Font f=new Font("Californian FB",0,20);
Font f1=new Font("Comic Sans MS",0,30);

name=new JLabel("SEARCH PRODUCT DETAIL",JLabel.CENTER);
name.setFont(f1);

sea=new JLabel("Search by:");
sea.setFont(f);

cname=new JCheckBox("Name");
ctype=new JCheckBox("Type");
cprice=new JCheckBox("Price");
cemon=new JCheckBox("Expiry Month");
ceyear=new JCheckBox("Expiry Year");
cedate=new JCheckBox("Expiry Date");
bg.add(cname);
bg.add(ctype);
bg.add(cprice);
bg.add(cemon);
bg.add(ceyear);
bg.add(cedate);


tname=new JTextField(20);
tprice=new JTextField(20);
texpyear=new JTextField(20);


String amonth[]={"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
tmonth=new JComboBox(amonth);
tmonth.setBounds(30,30,50,10);
tmonth.setFont(f);
String adate[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
tdate=new JComboBox(adate);
tdate.setFont(f);
String  atype[]={"Select","Beverages","Bread/Bakery","Spices","Canned/Jarred Food","Dairy","Dry/Baking Goods","Cereals/Flour","Cleaners","Paper Goods","Personal care","Baby items","Snacks","Other"};
ttype=new JComboBox(atype);
ttype.setFont(f);


search=new JButton("Search");
reset=new JButton("Reset");
exit=new JButton("EXIT");
submit=new JButton("Submit");
submit.addActionListener(this);
search.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);

ename=new JLabel("Enter product name");
etype=new JLabel("Choose product type");
eprice=new JLabel("Enter price");
eexpyear=new JLabel("Enter expiry year");
eexpmon=new JLabel("Choose expiry month");
eexpdate=new JLabel("Choose expiry date");

p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(sea);
p1.add(cname);
p1.add(ctype);
p1.add(cprice);
p1.add(ceyear);
p1.add(cemon);
p1.add(cedate);
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
p5.setLayout(new GridLayout(5,1));
if(cname.isSelected())
{
p6=new JPanel();
p6.add(ename);
p6.add(tname);
p5.add(p6);
}
if(ctype.isSelected())
{
p7=new JPanel();
p7.add(etype);
p7.add(ttype);
p5.add(p7);
}
if(cprice.isSelected())
{
p8=new JPanel();
p8.add(eprice);
p8.add(tprice);
p5.add(p8);
}
if(ceyear.isSelected())
{
p09=new JPanel();
p09.add(eexpyear);
p09.add(texpyear);
p5.add(p09);
}
if(cemon.isSelected())
{
p009=new JPanel();
p009.add(eexpmon);
p009.add(texpmon);
p5.add(p009);
}

if(cedate.isSelected())
{
p0009=new JPanel();
p0009.add(eexpdate);
p0009.add(texpdate);
p5.add(p0009);
}

p10=new JPanel();
p10.add(search);
p10.add(reset);
p10.add(exit);

p5.add(p10);
fr1.add(p5,BorderLayout.CENTER);
}
if(ae.getSource()==reset)
{
String msg=" ";
if(cname.isSelected())
{
  tname.setText(msg);
  cname.setSelected(false);
}
if(ctype.isSelected())
{
  ttype.setSelectedItem("Select");
  ctype.setSelected(false);
}
if(cprice.isSelected())
{
  tprice.setText(msg);
  cprice.setSelected(false);
}
if(ceyear.isSelected())
{
  texpyear.setText(msg);
  ceyear.setSelected(false);
}

if(cemon.isSelected())
{
  tmonth.setSelectedItem("Select");
  cemon.setSelected(false);
}
if(cedate.isSelected())
{
  tdate.setSelectedItem("Select");
  cedate.setSelected(false);
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
String prodname,prodtype,prodprice,prodqty,expyear,expmonth,expdate;
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
l3=new JLabel("TYPE",JLabel.CENTER);
l4=new JLabel("PRICE",JLabel.CENTER);
l5=new JLabel("QUANTITY",JLabel.CENTER);
l6=new JLabel("EXPIRY DATE",JLabel.CENTER);

l1.setFont(f1);
l2.setFont(f1);
l3.setFont(f1);
l4.setFont(f1);
l5.setFont(f1);
l6.setFont(f1);

try
{
Class.forName("org.postgresql.Driver");
c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");

if(cname.isSelected())
{
fr2.add(l1);
fr2.add(l3);
fr2.add(l4);
fr2.add(l5);
fr2.add(l6);

prodname=tname.getText();
String qur="select * from product where pname=?";

ps=c.prepareStatement(qur);
ps.setString(1,prodname);
rs=ps.executeQuery();

for(int p=0;rs.next();p++)
{

String id1=rs.getString(1);
String name1=rs.getString(2);
String type1=rs.getString(3);
String price1=rs.getString(4);
String qkg=rs.getString(5);
String qlt=rs.getString(6);
String year=rs.getString(7);
String month=rs.getString(8);
String date=rs.getString(9);

lid=new JLabel(id1,JLabel.CENTER);
lname=new JLabel(name1,JLabel.CENTER);
ltype=new JLabel(type1,JLabel.CENTER);
lprice=new JLabel(price1,JLabel.CENTER);
lqkg=new JLabel(qkg,JLabel.CENTER);
lqlt=new JLabel(qlt,JLabel.CENTER);
lyear=new JLabel(year,JLabel.CENTER);
lmonth=new JLabel(month,JLabel.CENTER);
ldate=new JLabel(date,JLabel.CENTER);



fr2.add(lid);
fr2.add(lname);
fr2.add(ltype);
fr2.add(lprice);
fr2.add(lqkg);
fr2.add(lqlt);
fr2.add(lyear);
fr2.add(lmonth);
fr2.add(ldate);

}//for

}

/*
if(ctype.isSelected())
{
  ttype.setText(msg);
  ctype.setSelected(false);
}
if(cprice.isSelected())
{
  tprice.setText(msg);
  cprice.setSelected(false);
}
if(cexpiry.isSelected())
{
  texpiry.setText(msg);
  cexpiry.setSelected(false);
}
*/
c.close();
ps.close();
}catch(Exception e)
{System.out.println(e);}

}

}

public static void main(String arg[])
{
new searchProduct();
}

}