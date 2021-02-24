import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
class billGeneration extends JFrame implements ActionListener
{
Connection c=null;
PreparedStatement ps;
Statement st;
ResultSet rs;
static int num;
JLabel lname,ltype,lprice,lqty,ltotal,ldate,date,lcname,lcid,ltotamt;
JLabel s1,s2,s3,s4,s5,e1,e2,e3,e4,e5;
JComboBox type1,type2,type3,type4,type5;
JTextField tcname,tcid,name1,name2,name3,name4,name5,price1,price2,price3,price4,price5,qty1,qty2,qty3,qty4,qty5,total1,total2,total3,total4,total5,totamt;
JButton tot,submit,reset,exit;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p,p07;

public billGeneration()
{
setVisible(true);
setSize(1000,400);
setLocation(300,250);
setTitle("Bill Generation");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Font f=new Font("Californian FB",0,18);
Font f1=new Font("Britannic",0,17);
tot=new JButton("Calculate");
submit=new JButton("Submit");
reset=new JButton("Reset");
exit=new JButton("EXIT");
tot.addActionListener(this);
submit.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);


lname=new JLabel("Product Name",JLabel.CENTER);
ltype=new JLabel("Type",JLabel.CENTER);
lprice=new JLabel("Price",JLabel.CENTER);
lqty=new JLabel("Quantity",JLabel.CENTER);
ltotal=new JLabel("Total",JLabel.CENTER);
ldate=new JLabel("Date:",JLabel.LEFT);


Date date1 = Calendar.getInstance().getTime();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
String strDate = dateFormat.format(date1);

date=new JLabel(strDate,JLabel.LEFT);
lcname=new JLabel("Customer name"); 
lcid=new JLabel("Customer ID");

s1=new JLabel("*");
s2=new JLabel("*");
s3=new JLabel("*");
s4=new JLabel("*");
s5=new JLabel("*");
e1=new JLabel("=");
e2=new JLabel("=");
e3=new JLabel("=");
e4=new JLabel("=");
e5=new JLabel("=");

lname.setFont(f1);
ltype.setFont(f1);
lprice.setFont(f1);
lqty.setFont(f1);
ltotal.setFont(f1);
ldate.setFont(f);
date.setFont(f1);
lcname.setFont(f);
lcid.setFont(f);
tcname=new JTextField(15);
tcid=new JTextField(5);
tcid.setEnabled(false);
 
String  atype[]={"Select","Beverages","Bread/Bakery","Spices","Canned/Jarred Food","Dairy","Dry/Baking Goods","Cereals/Flour","Cleaners","Paper Goods","Personal care","Baby items","Snacks","Other"};


name1=new JTextField(17);
type1=new JComboBox(atype);
price1=new JTextField(17);
total1=new JTextField(17);
total1.setEnabled(false);		
qty1=new JTextField(17);


name2=new JTextField(17);
type2=new JComboBox(atype);
price2=new JTextField(17);
qty2=new JTextField(17);
total2=new JTextField(17);
total2.setEnabled(false);

name3=new JTextField(17);
type3=new JComboBox(atype);
price3=new JTextField(17);
qty3=new JTextField(17);
total3=new JTextField(17);
total3.setEnabled(false);

name4=new JTextField(17);
type4=new JComboBox(atype);
price4=new JTextField(17);
qty4=new JTextField(17);
total4=new JTextField(17);
total4.setEnabled(false);

name5=new JTextField(17);
type5=new JComboBox(atype);
price5=new JTextField(17);
qty5=new JTextField(17);
total5=new JTextField(17);
total5.setEnabled(false);

ltotamt=new JLabel("Total amount:");
totamt=new JTextField(5);
totamt.setEnabled(false);

p=new JPanel();
p.setVisible(true);
p.setLayout(new FlowLayout());
p.add(ldate);
p.add(date);
p.add(lcname);
p.add(tcname);
p.add(lcid);
p.add(tcid);

p1=new JPanel();
p1.setVisible(true);
p1.setLayout(new GridLayout(1,5,4,4));
p1.add(lname);
p1.add(ltype);
p1.add(lprice);
p1.add(lqty);
p1.add(ltotal);

p2=new JPanel();
p2.setVisible(true);
p2.setLayout(new FlowLayout());
p2.add(name1);
p2.add(type1);
p2.add(price1);
p2.add(s2);
p2.add(qty1);
p2.add(e2);
p2.add(total1);

p3=new JPanel();
p3.setVisible(true);
p3.setLayout(new FlowLayout());
p3.add(name2);
p3.add(type2);
p3.add(price2);
p3.add(s3);
p3.add(qty2);
p3.add(e3);
p3.add(total2);

p4=new JPanel();
p4.setVisible(true);
p4.setLayout(new FlowLayout());
p4.add(name3);
p4.add(type3);
p4.add(price3);
p4.add(s4);
p4.add(qty3);
p4.add(e4);
p4.add(total3);

p5=new JPanel();
p5.setVisible(true);
p5.setLayout(new FlowLayout());
p5.add(name4);
p5.add(type4);
p5.add(price4);
p5.add(s5);
p5.add(qty4);
p5.add(e5);
p5.add(total4);

p6=new JPanel();
p6.setVisible(true);
p6.setLayout(new FlowLayout());
p6.add(name5);
p6.add(type5);
p6.add(price5);
p6.add(s1);
p6.add(qty5);
p6.add(e1);
p6.add(total5);

p07=new JPanel();
p07.setVisible(true);
p07.setLayout(new FlowLayout());
p07.add(ltotamt);
p07.add(totamt);

p7=new JPanel();
p7.setVisible(true);
p7.add(tot);
p7.add(submit);
p7.add(reset);
p7.add(exit);

p8=new JPanel();
p8.setVisible(true);
p8.setLayout(new GridLayout(8,1,4,4));
p8.add(p1);
p8.add(p2);
p8.add(p3);
p8.add(p4);
p8.add(p5);
p8.add(p6);
p8.add(p07);
p8.add(p7);


add(p8,BorderLayout.CENTER);
add(p,BorderLayout.NORTH);

}

public void actionPerformed(ActionEvent ae)
 {
 if(ae.getSource()==tot)
 {
   float temp=0;
  float a,b,c;
  String ans;

if(isEmpty(price1.getText()))
 a=0;
else
 a=Float.parseFloat(price1.getText());
if(qty1.getText()==null)
 b=0;
else
 b=Float.parseFloat(qty1.getText());
   c=a*b;
  temp+=c;
  ans=Float.toString(c);
  total1.setText(ans);

  a=Float.parseFloat(price2.getText());
  b=Float.parseFloat(qty2.getText());
  c=a*b;temp+=c;
  ans=Float.toString(c);
  total2.setText(ans);

  a=Float.parseFloat(price3.getText());
  b=Float.parseFloat(qty3.getText());
  c=a*b;temp+=c;
  ans=Float.toString(c);
  total3.setText(ans);

  a=Float.parseFloat(price4.getText());
  b=Float.parseFloat(qty4.getText());
  c=a*b;temp+=c;
  ans=Float.toString(c);
  total4.setText(ans);

  a=Float.parseFloat(price5.getText());
  b=Float.parseFloat(qty5.getText());
  c=a*b;temp+=c;
  ans=Float.toString(c);
  total5.setText(ans);

  totamt.setText(Float.toString(temp));
  
}
if(ae.getSource()==submit)
{
  String prodname1=name1.getText();
  String prodname2=name2.getText();
  String prodname3=name3.getText();
  String prodname4=name4.getText();
  String prodname5=name5.getText();

  String prodtype1=(String)type1.getSelectedItem();
  String prodtype2=(String)type2.getSelectedItem();
  String prodtype3=(String)type3.getSelectedItem();
  String prodtype4=(String)type4.getSelectedItem();
  String prodtype5=(String)type5.getSelectedItem();
  
  float prodprice1=Float.parseFloat(price1.getText());
  float prodprice2=Float.parseFloat(price2.getText());
  float prodprice3=Float.parseFloat(price3.getText());
  float prodprice4=Float.parseFloat(price4.getText());
  float prodprice5=Float.parseFloat(price5.getText());

  float prodqty1=Float.parseFloat(qty1.getText());
  float prodqty2=Float.parseFloat(qty2.getText());
  float prodqty3=Float.parseFloat(qty3.getText());
  float prodqty4=Float.parseFloat(qty4.getText());
  float prodqty5=Float.parseFloat(qty5.getText());
  
 float prodtot1=Float.parseFloat(total1.getText());
 float prodtot2=Float.parseFloat(total2.getText());
 float prodtot3=Float.parseFloat(total3.getText());
 float prodtot4=Float.parseFloat(total4.getText());
 float prodtot5=Float.parseFloat(total5.getText());
     
 
try
{
   Class.forName("org.postgresql.Driver");
   c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");
 

}
catch(Exception e)
{System.out.println(e);}

}
if(ae.getSource()==reset)
{
String msg=" ";
name1.setText(msg);name2.setText(msg);name3.setText(msg);name4.setText(msg);name5.setText(msg);
price1.setText(msg);price2.setText(msg);price3.setText(msg);price4.setText(msg);price5.setText(msg);
qty1.setText(msg);qty2.setText(msg);qty3.setText(msg);qty4.setText(msg);qty5.setText(msg);
total1.setText(msg);total2.setText(msg);total3.setText(msg);total4.setText(msg);total5.setText(msg);
type1.setSelectedItem("Select");type2.setSelectedItem("Select");
type3.setSelectedItem("Select");type4.setSelectedItem("Select");type5.setSelectedItem("Select");
}

if(ae.getSource()==exit)
{
int rt=JOptionPane.showConfirmDialog(null, "Really want to Exit from Window??", "Choose one",JOptionPane.YES_NO_OPTION);
	if(rt==JOptionPane.YES_OPTION )
	{
		//dispose();
	}

}
}

public static void main(String arg[])
{new billGeneration();}
}