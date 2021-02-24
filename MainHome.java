import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainHome extends JFrame implements ActionListener
{
JLabel cust,prod,admin,name,space;
JButton cnew,csearch,cupdate,cdel,pnew,psearch,pupdate,pdel,adpass,exit,bill;
JPanel pnm,p1,p2,p3,p4;
MainHome()
{
setVisible(true);
setSize(1000,700);
setTitle("Home");
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Font f=new Font("Imprint MT Shadow",0,70);
//Font f1=new Font("Elephant",0,25);
space=new JLabel("		");
//space2=new JLabel("	");
name=new JLabel("HS Grocery Shop");
name.setFont(f);

pnm=new JPanel();
pnm.add(space);
pnm.add(name);

//customer 

ImageIcon ic1=new ImageIcon("C:/GROCERY/IMAGES/CUSTOMER1.JPG");//load image to ic1
Image image1=ic1.getImage();			//transform it
Image newimg1=image1.getScaledInstance(200,150,java.awt.Image.SCALE_SMOOTH);	//scale it the smooth way
ic1=new ImageIcon(newimg1);		//transform it back


cust=new JLabel(ic1);
cnew=new JButton("New");
cnew.addActionListener(this);
csearch=new JButton("Search");
csearch.addActionListener(this);
cupdate=new JButton("Update");
cupdate.addActionListener(this);
cdel=new JButton("Delete");
cdel.addActionListener(this);



//product
ImageIcon ic2=new ImageIcon("C:/GROCERY/IMAGES/PRODUCT.JPG");
Image image2=ic2.getImage();
Image newimg2=image2.getScaledInstance(200,150,java.awt.Image.SCALE_SMOOTH);
ic2=new ImageIcon(newimg2);


prod=new JLabel(ic2);
pnew=new JButton("New");
pnew.addActionListener(this);
psearch=new JButton("Search");
psearch.addActionListener(this);
pupdate=new JButton("Update");
pupdate.addActionListener(this);
pdel=new JButton("Delete");
pdel.addActionListener(this);


//admin
ImageIcon ic3=new ImageIcon("C:/GROCERY/IMAGES/ADMIN.JPG");
Image image3=ic3.getImage();
Image newimg3=image3.getScaledInstance(200,150,java.awt.Image.SCALE_SMOOTH);
ic3=new ImageIcon(newimg3);

admin=new JLabel(ic3);
adpass=new JButton("Change password");
adpass.addActionListener(this);
exit=new JButton("EXIT");
exit.addActionListener(this);
//bill=new JButton("Bill");
//bill.addActionListener(this);


//customer panel
p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(cust);
p1.add(cnew);
p1.add(csearch);
p1.add(cupdate);
p1.add(cdel);


//product panel
p2=new JPanel();
p2.setLayout(new FlowLayout());
p2.add(prod);
p2.add(pnew);
p2.add(psearch);
p2.add(pupdate);
p2.add(pdel);


//admin and bill panel
p3=new JPanel();
p3.setLayout(new FlowLayout());
p3.add(admin);
p3.add(adpass);
p3.add(exit);
//p3.add(bill);


p4=new JPanel();
p4.setLayout(new GridLayout(3,1));
p4.add(p1);
p4.add(p2);
p4.add(p3);

add(pnm,BorderLayout.NORTH);
add(p4,BorderLayout.CENTER);
//add(p3,BorderLayout.SOUTH);
}

public void actionPerformed(ActionEvent ae)
{
  
if(ae.getSource()==cnew)
  { 
	new newCustomer(); 
  }
else if(ae.getSource()==csearch)
  { 
	new searchCustomer();  
  }

else if(ae.getSource()==cupdate)
  { 
	new updateCustomer();  
  }
  
else if(ae.getSource()==cdel)
  { 
	new deleteCustomer();  
  }

else if(ae.getSource()==pnew)
  { 
	new newProduct();
  }

else if(ae.getSource()==psearch)
  { 
	//new searchProduct();  
  }

else if(ae.getSource()==pupdate)
  { 
	new updateProduct();  
  }
  
else if(ae.getSource()==pdel)
  { 
	new deleteProduct();  
  }

else if(ae.getSource()==adpass)
  { 
	new changePass();  
  }

else if(ae.getSource()==exit)
{
     int rt=JOptionPane.showConfirmDialog(null, "Really want to Exit from Window??", "Choose one", JOptionPane.YES_NO_OPTION);
	if(rt==JOptionPane.YES_OPTION )
	{
		dispose();
	}
}


}

public static void main(String args[])
{
new MainHome();
}
}
