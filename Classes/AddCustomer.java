package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class AddCustomer extends JFrame implements ActionListener {

	JTextField t1 ,t2,t3,t4,t5,t6,t7 ;
	JButton b1,b2 ;
	JComboBox jb1 ;
	JRadioButton r1 , r2;
	String username;
	AddCustomer(String username){
		this.username=username;
		setBounds(500,180,750,530);
		setTitle("Add Customer") ;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/loginBackground.png"));
		Image i = im.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
		ImageIcon img = new ImageIcon(i);
		JLabel jj = new JLabel(img);
		jj.setBounds(0,0,450,530);
		add(jj);

	// Panel

		JPanel pn = new JPanel();
		pn.setBounds(450,0,600,600);
		pn.setBackground(Color.WHITE);
		pn.setLayout(null);
		add(pn);

	// image on panel

		ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/newcustomer.jpg"));
		Image i1 = im1.getImage().getScaledInstance(500,370,Image.SCALE_DEFAULT);
		ImageIcon img1 = new ImageIcon(i1);
		JLabel jl = new JLabel(img1);
		jl.setBounds(0,100,300,300);
		pn.add(jl);

	// Label
		JLabel l1 = new JLabel("Name");
		l1.setBounds(20,10,100,50);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l1);

	// Text field

		t1 = new JTextField();
		t1.setBounds(130,20,200,25);
		jj.add(t1);

	// Label

		JLabel l2 = new JLabel("ID");
		l2.setBounds(20,50,100,50);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l2);

	// Combo box

		jb1 =  new JComboBox(new String[] {"Passport","Adhar card","Pan Card","Ration Card"});
		jb1.setBounds(130,60,200,25);
		jj.add(jb1);

	// Label
		JLabel l3 = new JLabel("Number");
		l3.setBounds(20,90,100,50);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l3);

	// Textfield

		t2 = new JTextField();
		t2.setBounds(130,100,200,25);
		jj.add(t2);

	// Label
		JLabel l4 = new JLabel("Last Name");
		l4.setBounds(20,130,100,50);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l4);

	// Textfield
		t3 = new JTextField();
		t3.setBounds(130,140,200,25);
		jj.add(t3);


	// Label
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(20,170,100,50);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l5);

	// Radio Button
		r1 = new JRadioButton("Male");
		r1.setBounds(130 ,180,80,25 );
		r1.setBackground(Color.WHITE);
		jj.add(r1);

	// Radio Button
		r2 = new JRadioButton("Female");
		r2.setBounds(250 ,180,80,25 );
		r2.setBackground(Color.WHITE);
		jj.add(r2);

	// Label
		JLabel l41 = new JLabel("Country");
		l41.setBounds(20,210,100,50);
		l41.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l41);

	// Textfield
		t4 = new JTextField();
		t4.setBounds(130,220,200,25);
		jj.add(t4);

	// Label
		JLabel l6 = new JLabel("Address");
		l6.setBounds(20,250,100,50);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l6);

	// Textfield
		t5 = new JTextField();
		t5.setBounds(130,260,200,25);
		jj.add(t5);

	// Label
		JLabel l7 = new JLabel("Phone");
		l7.setBounds(20,290,100,50);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l7);

	// Textfield
		t6 = new JTextField();
		t6.setBounds(130,300,200,25);
		jj.add(t6);

	// Label
		JLabel ll7 = new JLabel("Email");
		ll7.setBounds(20,330,100,50);
		ll7.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll7);

	// Textfield

		t7 = new JTextField();
		t7.setBounds(130,340,200,25);
		jj.add(t7);

	// Button
		b1 =new JButton("ADD");
		b1.setBounds(20,400,70,30);
		b1.addActionListener(this);
		jj.add(b1);

	// Button
		b2 =new JButton("Back");
		b2.setBounds(130,400,70,30);
		b2.addActionListener(this);
		jj.add(b2);


	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			// To get values of fields when click on create button
				String username = t1.getText();
				String id = (String) jb1.getSelectedItem() ;
				String number = t2.getText();
				String name = t3.getText();
				String radio = null ;
				if(r1.isSelected()) {
					radio="Male" ;
				}else if(r2.isSelected())
				{
					radio="Female";
				}
				String country = t4.getText();
				String address = t5.getText();
				String phone = t6.getText();
				String email = t7.getText();

			//  to save it on database

				if(t1.getText().equals("") && jb1.getSelectedItem().equals("") && t2.getText().equals("") && t3.getText().equals("")
					&&	t4.getText().equals("") && t5.getText().equals("") && t6.getText().equals("") && t7.getText().equals(""))
				{

					JOptionPane.showMessageDialog(null, "Please Enter Details");
					this.setVisible(false);

				}else {
					String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+radio+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
					try {
						Conn c = new Conn();
						c.s.executeUpdate(query);

						JOptionPane.showMessageDialog(null, "Customer Added Sucessfully");

						this.setVisible(false);

					}catch(Exception e) {

					}
				}

				}else if(ae.getSource() == b2) {
					this.setVisible(false);
			}

		}


	public static void main(String[] args) {
		new AddCustomer("").setVisible(true);
	}
}


