package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ViewCustomer extends JFrame implements ActionListener{
	JButton b1,b2 ;
	JTextField tf1 ;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9;
	ViewCustomer(){

		setBounds(500,180,800,570);
		setTitle("View Customer") ;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/loginBackground.png"));
		Image i = im.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
		ImageIcon img1 = new ImageIcon(i);
		JLabel jj = new JLabel(img1);
		jj.setBounds(0,0,800,570);
		add(jj);

	// Image
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/updateCustomer.png"));
		JLabel jl = new JLabel(img);
		jl.setBounds(400,160,400,400);
		jj.add(jl);



	// Label
		l1 = new JLabel("Name :");
		l1.setBounds(20,10,100,50);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l1);

	// TextField
		tf1 = new JTextField();
		tf1.setBounds(130,20,150,30);
		tf1.setBackground(Color.white);
		jj.add(tf1);

		l2 = new JLabel("Id :");
		l2.setBounds(20,60,100,50);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l2);


		ll2 = new JLabel();
		ll2.setBounds(130,60,100,50);
		ll2.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll2);

		l3 = new JLabel("Number :");
		l3.setBounds(20,110,100,50);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l3);

		ll3 = new JLabel();
		ll3.setBounds(130,110,150,50);
		ll3.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll3);


		l4 = new JLabel("Last Name :");
		l4.setBounds(20,160,100,50);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l4);

		ll4 = new JLabel();
		ll4.setBounds(130,160,100,50);
		ll4.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll4);


		l5 = new JLabel("Gender :");
		l5.setBounds(20,210,100,50);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l5);

		ll5 = new JLabel();
		ll5.setBounds(130,210,100,50);
		ll5.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll5);


		l6 = new JLabel("Country :");
		l6.setBounds(400,10,100,50);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l6);

		ll6 = new JLabel();
		ll6.setBounds(500,10,100,50);
		ll6.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll6);


		l7 = new JLabel("Address :");
		l7.setBounds(400,60,100,50);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l7);

		ll7 = new JLabel();
		ll7.setBounds(500,60,200,50);
		ll7.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll7);


		l8 = new JLabel("Phone :");
		l8.setBounds(400,110,100,50);
		l8.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l8);

		ll8 = new JLabel();
		ll8.setBounds(500,110,100,50);
		ll8.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll8);

		l9 = new JLabel("Email :");
		l9.setBounds(400,160,300,50);
		l9.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(l9);

		ll9 = new JLabel();
		ll9.setBounds(500,160,250,50);
		ll9.setFont(new Font("Tahoma",Font.BOLD,15));
		jj.add(ll9);

	// Button
		b1 = new JButton("Search");
		b1.setBounds(20,300,100,25);
		b1.addActionListener(this);
		jj.add(b1);
	//Button
		b2 = new JButton("Back");
		b2.setBounds(200,300,100,25);
		b2.addActionListener(this);
		jj.add(b2);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				String username = tf1.getText();
				String sql = " select * from customer where username ='"+tf1.getText()+"'";      // gettext get string entered in 1st textfield

				ResultSet rs = c.s.executeQuery(sql);     // present in sql class  executequery return result set class object so store it in result set

				while(rs.next())            // to jump next column in database
				{
					String uname = rs.getString("username");
					if(username.equals(uname) ) {

							ll2.setText(rs.getString("id"));
							ll3.setText(rs.getString("number"));
							ll4.setText(rs.getString("name"));
							ll5.setText(rs.getString("radio"));
							ll6.setText(rs.getString("country"));
							ll7.setText(rs.getString("address"));
							ll8.setText(rs.getString("phone"));
							ll9.setText(rs.getString("email"));
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter valid Name");
					}
				}
			}catch(Exception e) {}
		}else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}


	public static void main(String[] args) {
		new ViewCustomer().setVisible(true);

	}
}
