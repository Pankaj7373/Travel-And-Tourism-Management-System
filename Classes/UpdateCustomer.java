package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class UpdateCustomer extends JFrame implements ActionListener{

	JTextField t1 ,t2,t3,t4,t5,t6,t7,t8,t9 ;
	JButton b1,b2,b3 ;
	JComboBox jb1 ;
	JRadioButton r1 , r2;

	UpdateCustomer(){

			setBounds(500,180,750,530);
			setTitle("Update Customer Details") ;
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

			ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/update.png"));
			Image i1 = im1.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
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

			t2 = new JTextField();
			t2.setBounds(130,60,200,25);
			jj.add(t2);

		// Label
			JLabel l3 = new JLabel("Number");
			l3.setBounds(20,90,100,50);
			l3.setFont(new Font("Tahoma",Font.BOLD,15));
			jj.add(l3);

		// Textfield

			t3 = new JTextField();
			t3.setBounds(130,100,200,25);
			jj.add(t3);

		// Label
			JLabel l4 = new JLabel("Last Name");
			l4.setBounds(20,130,100,50);
			l4.setFont(new Font("Tahoma",Font.BOLD,15));
			jj.add(l4);

		// Textfield
			t4 = new JTextField();
			t4.setBounds(130,140,200,25);
			jj.add(t4);


		// Label
			JLabel l5 = new JLabel("Gender");
			l5.setBounds(20,170,100,50);
			l5.setFont(new Font("Tahoma",Font.BOLD,15));
			jj.add(l5);

		// Radio Button
			t5 = new JTextField();
			t5.setBounds(130 ,180,200,25 );
			jj.add(t5);


		// Label
			JLabel l41 = new JLabel("Country");
			l41.setBounds(20,210,100,50);
			l41.setFont(new Font("Tahoma",Font.BOLD,15));
			jj.add(l41);

		// Textfield
			t6 = new JTextField();
			t6.setBounds(130,220,200,25);
			jj.add(t6);

		// Label
			JLabel l6 = new JLabel("Address");
			l6.setBounds(20,250,100,50);
			l6.setFont(new Font("Tahoma",Font.BOLD,15));
			jj.add(l6);

		// Textfield
			t7 = new JTextField();
			t7.setBounds(130,260,200,25);
			jj.add(t7);

		// Label
			JLabel l7 = new JLabel("Phone");
			l7.setBounds(20,290,100,50);
			l7.setFont(new Font("Tahoma",Font.BOLD,15));
			jj.add(l7);

		// Textfield
			t8 = new JTextField();
			t8.setBounds(130,300,200,25);
			jj.add(t8);

		// Label
			JLabel ll7 = new JLabel("Email");
			ll7.setBounds(20,330,100,50);
			ll7.setFont(new Font("Tahoma",Font.BOLD,15));
			jj.add(ll7);

		// Textfield

			t9 = new JTextField();
			t9.setBounds(130,340,200,25);
			jj.add(t9);

		// Button
			b1 =new JButton("Update");
			b1.setBounds(20,400,100,30);
			b1.addActionListener(this);
			jj.add(b1);

	// Button
			b2 =new JButton("Back");
			b2.setBounds(130,400,100,30);
			b2.addActionListener(this);
			jj.add(b2);

		// Button

			b3 = new JButton("Search");
			b3.setBounds(350,16,90,30);
			b3.addActionListener(this);
			jj.add(b3);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b3) {
		try {
			Conn c = new Conn();
			String username = t1.getText();
			String sql = " select * from customer where username ='"+t1.getText()+"'";      // gettext get string entered in 1st textfield

			ResultSet rs = c.s.executeQuery(sql);     // present in sql class  executequery return result set class object so store it in result set

			while(rs.next())            // to jump next column in database
			{
				String uname = rs.getString("username");
				if(username.equals(uname) ) {

				t2.setText(rs.getString("id"));
				t3.setText(rs.getString("number"));
				t4.setText(rs.getString("name"));
				t5.setText(rs.getString("radio"));
				t6.setText(rs.getString("country"));
				t7.setText(rs.getString("address"));
				t8.setText(rs.getString("phone"));
				t9.setText(rs.getString("email"));
			}
			else {
				JOptionPane.showMessageDialog(null, "Enter valid Name");
			}
			}
		}catch(Exception e) {}

		}else if(ae.getSource() == b1) {
			String username = t1.getText();
			String id = t2.getText();
			String number = t3.getText();
			String name = t4.getText();
			String radio = t5.getText();
			String country = t6.getText();
			String address = t7.getText();
			String phone = t8.getText();
			String email = t9.getText();

			String q = "update customer set username ='"+username+"', id ='"+id+"', number ='"+number+"', name='"+name+"', radio='"+radio+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"' where username='"+t1.getText()+"'";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(q);

				JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
				this.setVisible(false);
			}catch(Exception e) {}
		}else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}



	public static void main(String[] args) {
		new UpdateCustomer().setVisible(true);

	}

}
