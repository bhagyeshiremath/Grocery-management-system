import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
class newProduct extends JFrame implements ActionListener
{
JLabel name,lname,ltype,lprice,lqty,lexpiry,l1,l2,l3;
JTextField tname,tprice,tqty,tyear;
JButton submit,reset,exit;
JRadioButton kg,lit;
JComboBox ttype,tmonth,tdate;
JPanel p1,p2,p3,p4,p5,p06,p006,p6,p7,p8,pb1,pb2;
ButtonGroup bg;
Connection c=null;
PreparedStatement ps;
Statement st;
ResultSet rs;
static int num;
int pid;
public newProduct()
{
setVisible(true);
setSize(500,400);
setLocation(300,250);
setTitle("Enter Product Detail");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Font f=new Font("Californian FB",0,20);
Font f1=new Font("Britannic",0,30);
l1=new JLabel("  	   	");
l2=new JLabel("	  ");
l3=new JLabel("	  ");
name=new JLabel("New Product Detail",JLabel.CENTER);
name.setFont(f1);
lname=new JLabel("Name",JLabel.CENTER);
lname.setFont(f);
ltype=new JLabel("Type",JLabel.CENTER);
ltype.setFont(f);
lprice=new JLabel("Price",JLabel.CENTER);
lprice.setFont(f);
lqty=new JLabel("Quantity",JLabel.CENTER);
lqty.setFont(f);
//lqty2=new JLabel("Quantity(litre)",JLabel.CENTER);
//lqty2.setFont(f);
lexpiry=new JLabel("Expiry");
lexpiry.setFont(f);

bg=new ButtonGroup();
kg=new JRadioButton("Kg",true);
lit=new JRadioButton("litre");
bg.add(kg);
bg.add(lit);

tname=new JTextField(15);
tprice=new JTextField(15);
tqty=new JTextField(5);
//tqty2=new JTextField(15);
tyear=new JTextField("year");
String amonth[]={"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
tmonth=new JComboBox(amonth);
tmonth.setBounds(30,30,50,10);
tmonth.setFont(f);
String adate[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
tdate=new JComboBox(adate);
tdate.setFont(f);
//tdate.setPreferredSize(new Dimension(50,20));
//tdate.setBounds(50,50,90,20);
//tdate.setPrototypeDisplayValue("Select");
String  atype[]={"Select","Beverages","Bread/Bakery","Spices","Canned/Jarred Food","Dairy","Dry/Baking Goods","Cereals/Flour","Cleaners","Paper Goods","Personal care","Baby items","Snacks","Other"};
ttype=new JComboBox(atype);
ttype.setFont(f);

submit=new JButton("Submit");
reset=new JButton("Reset");
exit=new JButton("EXIT");
submit.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);

p1=new JPanel();
p1.setLayout(new GridLayout(1,2,4,4));
p1.add(lname);
p1.add(tname);


p2=new JPanel();
p2.setLayout(new GridLayout(1,2,4,4));
p2.add(ltype);
p2.add(ttype);


p3=new JPanel();
p3.setLayout(new GridLayout(1,2,4,4));
p3.add(lprice);
p3.add(tprice);


p4=new JPanel();
p4.setLayout(new GridLayout(1,4,4,4));
p4.add(lqty);
p4.add(kg);
p4.add(lit);
p4.add(tqty);



p06=new JPanel();
p06.setLayout(new GridLayout(1,2,4,4));
p06.add(lexpiry);
p06.add(tyear);

p006=new JPanel();
p006.setLayout(new GridLayout(1,2,4,4));
p006.add(tmonth);
p006.add(tdate);

p6=new JPanel();
p6.setLayout(new GridLayout(1,2,4,4));
p6.add(p06);
p6.add(p006);


pb1=new JPanel();
pb1.setLayout(new GridLayout(1,2));
pb1.add(l1);
pb1.add(submit);


pb2=new JPanel();
pb2.setLayout(new FlowLayout());
pb2.add(pb1);
pb2.add(reset);
pb2.add(exit);

p7=new JPanel();
p7.setLayout(new FlowLayout());
p7.add(p1);
p7.add(p2);
p7.add(p3);
p7.add(p4);
//p7.add(p5);
p7.add(p6);
p7.add(pb2);

p8=new JPanel();
p8.setLayout(new GridLayout(2,1));
p8.add(l2);
p8.add(name);

add(p8,BorderLayout.NORTH);
add(p7,BorderLayout.CENTER);

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==submit)
  { 
  //JOptionPane.showMessageDialog(null,"Submit");  
     try
     {
     Class.forName("org.postgresql.Driver");
      c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grocery","postgres","12345");
     String prodname=tname.getText();
     String prodtype=(String)ttype.getSelectedItem();
    float prodprice=Float.parseFloat(tprice.getText());
    int prodyear=Integer.parseInt(tyear.getText());
    String val1=(String)tmonth.getSelectedItem();
    int prodmonth=Integer.parseInt(val1);
    String val2=(String)tdate.getSelectedItem();
    int proddate=Integer.parseInt(val2);
 float prodqty1=Float.parseFloat(tqty.getText());
   float prodqty2=Float.parseFloat(tqty.getText());
if(kg.isSelected())
{
//float prodqty1=Float.parseFloat(tqty.getText());
prodqty2=0;
}
else    
{
//float prodqty2=Float.parseFloat(tqty.getText());
prodqty1=0;
}   

 String qur1="select pid from product";
 st=c.createStatement();
 rs=st.executeQuery(qur1);

  while(rs.next())
   {
   num=Integer.parseInt(rs.getString(1));
   }

 pid=num+ 1;

 String qur2="insert into product values(?,?,?,?,?,?,?,?,?)";  
 ps=c.prepareStatement(qur2);
 ps.setInt(1,pid);
 ps.setString(2,prodname);
 ps.setString(3,prodtype);
 ps.setFloat(4,prodprice);
 ps.setFloat(5,prodqty1);
 ps.setFloat(6,prodqty2); 
 ps.setInt(7,prodyear);
 ps.setInt(8,prodmonth);
 ps.setInt(9,proddate);
 int res=ps.executeUpdate();
  if(res!=1)
  JOptionPane.showMessageDialog(null,"Error in Updation");
  else
  JOptionPane.showMessageDialog(null,"Updation Succesful");
  
   }
 catch(Exception e)
     {System.out.println(e);}
}
if(ae.getSource()==exit)
 {
 int rt=JOptionPane.showConfirmDialog(null, "Really want to Exit from Window??", "Choose one",JOptionPane.YES_NO_OPTION);
	if(rt==JOptionPane.YES_OPTION )
	{
		dispose();
	}

}
String msg=" ";
 if(ae.getSource()==reset)
  { 
  tname.setText(msg);
  ttype.setSelectedItem("Select");
  tprice.setText(msg);
  tqty.setText(msg);
  //tqty2.setText(msg);
  tyear.setText(msg);
  tmonth.setSelectedItem("Month");
  tdate.setSelectedItem("Date");
  }
} 

public static void main(String arg[])
{new newProduct();}

}