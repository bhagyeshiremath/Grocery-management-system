import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class updateCustomer extends JFrame implements ActionListener
{
JLabel up,name,lcustname,label1,label2;
JLabel ename,ephone,eadd,ecity,epin;
JTextField tname,tadd,tphone,tpin,tcustname;
JCheckBox cname,cadd,cphone,cpin,city;
JComboBox ccity;
JPanel p,pa,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
JButton submit,update,reset,exit;

updateCustomer()
{
setVisible(true);
setSize(700,500);
setLocation(300,150);
setTitle("Update Customer Detail");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Font f1=new Font("Californian FB",0,20);
Font f=new Font("Bookman Old Style",0,30);

name=new JLabel("UPDATE CUSTOMER DETAIL",JLabel.CENTER);
name.setFont(f);


up=new JLabel("Update :");
up.setFont(f1);
lcustname=new JLabel("Enter name of customer");
lcustname.setFont(f1);
label1=new JLabel("		");
label2=new JLabel("		");

cname=new JCheckBox("Name");
cadd=new JCheckBox("address");
cphone=new JCheckBox("phone number");
city=new JCheckBox("City");
cpin=new JCheckBox("Pin-Code ");

tname=new JTextField(20);
tadd=new JTextField(20);
tphone=new JTextField(15);
tpin=new JTextField(6);
tcustname=new JTextField(15);

String  acity[]={"Select","Ahmednagar","Akola","Amravati","Beed","Bhandara","Chandrapur","Dhule","Gadchiroli","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Malegaon","Mumbai","Nagpur","Nashik","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara"};
ccity=new JComboBox(acity);
ccity.setFont(f1);
update=new JButton("Update");
reset=new JButton("Reset");
exit=new JButton("EXIT");
submit=new JButton("Submit");
submit.addActionListener(this);
update.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);

ename=new JLabel("Enter new name");
eadd=new JLabel("Enter new address");
epin=new JLabel("Enter new  pincode");
ephone=new JLabel("Enter new phone number");
ecity=new JLabel("Choose new city");


p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(up);
p1.add(cname);
p1.add(cphone);
p1.add(cadd);
p1.add(city);
p1.add(cpin);
p1.add(submit);

p6=new JPanel();
p6.add(lcustname);
p6.add(tcustname);

//p6.add(label1);
//p6.add(label2);



p=new JPanel();
p.setLayout(new GridLayout(2,1,1,1));
p.add(p6);
p.add(p1);

p7=new JPanel();
p7.setLayout(new BorderLayout());
p7.add(name,BorderLayout.NORTH);
p7.add(p,BorderLayout.CENTER);

add(p7,BorderLayout.NORTH);

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==submit)
{
p14=new JPanel();
p14.setLayout(new GridLayout(6,1));
if(cname.isSelected())
{
p8=new JPanel();
p8.add(ename);
p8.add(tname);
p14.add(p8);
}
if(cphone.isSelected())
{
p9=new JPanel();
p9.add(ephone);
p9.add(tphone);
p14.add(p9);
}
if(cadd.isSelected())
{
p10=new JPanel();
p10.add(eadd);
p10.add(tadd);
p14.add(p10);
}

if(cpin.isSelected())
{
p11=new JPanel();
p11.add(epin);
p11.add(tpin);
p14.add(p11);
}
if(city.isSelected())
{
p12=new JPanel();
p12.add(ecity);
p12.add(ccity);
p14.add(p12);
}

p13=new JPanel();
p13.add(update);
p13.add(reset);
p13.add(exit);

p14.add(p13);
add(p14,BorderLayout.CENTER);
}

if(ae.getSource()==reset)
{
city.setSelected(false);

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
//if(ae.getSource==update)
//{



//}
}

public static void main(String[] args)
{
new updateCustomer();
}

}
