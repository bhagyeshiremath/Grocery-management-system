import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class deleteCustomer extends JFrame implements ActionListener
{
JLabel del,name,lname,ladd,lphone,lcity,lpin,lcustname,ename,ephone,eadd,ecity,epin;
JTextField tname,tadd,tphone,tpin,tcustname,tcity;
JCheckBox cname,cadd,cphone,cpin,city;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
JButton submit,delete,reset,exit;

deleteCustomer()
{
setVisible(true);
setSize(700,500);
setLocation(300,150);
setTitle("Update Customer Detail");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Font f1=new Font("Californian FB",0,20);
Font f=new Font("Bookman Old Style",0,30);

name=new JLabel("DELETE CUSTOMER DETAIL",JLabel.CENTER);
name.setFont(f);

del=new JLabel("Delete by :");
del.setFont(f1);


cname=new JCheckBox("Name");
cadd=new JCheckBox("address");
cphone=new JCheckBox("phone number");
city=new JCheckBox("City");
cpin=new JCheckBox("Pin-Code ");


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
//tcustname=new JTextField(15);
tcity=new JTextField(15);

delete=new JButton("Delete");
reset=new JButton("Reset");
exit=new JButton("EXIT");
submit=new JButton("Submit");
submit.addActionListener(this);
delete.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);


ename=new JLabel("Enter name");
eadd=new JLabel("Enter address");
epin=new JLabel("Enter  pincode");
ephone=new JLabel("Enter phone number");
ecity=new JLabel("Enter city name");


p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(del);
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

add(p4,BorderLayout.NORTH);
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
if(cphone.isSelected())
{
p7=new JPanel();
p7.add(ephone);
p7.add(tphone);
p5.add(p7);
}
if(cadd.isSelected())
{
p8=new JPanel();
p8.add(eadd);
p8.add(tadd);
p5.add(p8);
}

if(cpin.isSelected())
{
p9=new JPanel();
p9.add(epin);
p9.add(tpin);
p5.add(p9);
}
if(city.isSelected())
{
p10=new JPanel();
p10.add(ecity);
p10.add(tcity);
p5.add(p10);
}

p11=new JPanel();
p11.add(delete);
p11.add(reset);
p11.add(exit);

p5.add(p11);
add(p5,BorderLayout.CENTER);
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
if(cadd.isSelected())
{
  tadd.setText(msg);
  cadd.setSelected(false);
}
if(cphone.isSelected())
{
  tphone.setText(msg);
  cphone.setSelected(false);
}
if(cpin.isSelected())
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
		dispose();
	}

}
}
/*
public static void main(String arg[])
{
new deleteCustomer();
}
*/
}