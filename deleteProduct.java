import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class deleteProduct extends JFrame implements ActionListener
{
JLabel del,name,lname,ltype,lprice,lexpiry,lprodname,ename,eprice,etype,eexpiry;
JTextField tname,ttype,tprice,texpiry,tprodname;
JButton submit,delete,reset,exit;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
JCheckBox cname,ctype,cprice,cexpiry;
deleteProduct()
{
setVisible(true);
setSize(700,500);
setLocation(300,150);
setTitle("Delete product detail");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Font f=new Font("Californian FB",0,20);
Font f1=new Font("Bookman Old Style",0,30);

name=new JLabel("DELETE PRODUCT DETAIL",JLabel.CENTER);
name.setFont(f1);

del=new JLabel("Delete by :");
del.setFont(f);
cname=new JCheckBox("Name");
ctype=new JCheckBox("Type");
cprice=new JCheckBox("Price");
cexpiry=new JCheckBox("Expiry Date");
tname=new JTextField(20);
ttype=new JTextField(20);
tprice=new JTextField(20);
texpiry=new JTextField(20);

delete=new JButton("Delete");
reset=new JButton("Reset");
exit=new JButton("EXIT");
submit=new JButton("Submit");
submit.addActionListener(this);
delete.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);

ename=new JLabel("Enter new product name");
etype=new JLabel("Enter new product type");
eprice=new JLabel("Enter new  price");
eexpiry=new JLabel("Enter new expiry date");

p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(del);
p1.add(cname);
p1.add(ctype);
p1.add(cprice);
p1.add(cexpiry);
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
if(cexpiry.isSelected())
{
p9=new JPanel();
p9.add(eexpiry);
p9.add(texpiry);
p5.add(p9);
}
p10=new JPanel();
p10.add(delete);
p10.add(reset);
p10.add(exit);

p5.add(p10);
add(p5,BorderLayout.CENTER);
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
new deleteProduct();
}
*/
}