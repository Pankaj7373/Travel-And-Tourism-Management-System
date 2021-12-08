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
import javax.swing.JTextField;

public class ViewPackage  extends JFrame implements ActionListener {
	JButton b1 ,b2;
	JTextField ll1,ll6  ;
	JLabel ll2,ll3,ll4,ll5,ll7,newl1;
	ViewPackage(){
		setBounds(400,180,800,600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

	// Main Label
		JLabel heading = new JLabel("View Package Details");
		heading.setBounds(50,0,300,30);
		heading.setFont(new Font("Tahoma",Font.ITALIC,20));
		add(heading);

	// Image
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
		Image imn =img.getImage().getScaledInstance(450,570,Image.SCALE_DEFAULT);
		ImageIcon newimg = new ImageIcon(imn);
		JLabel j1 = new JLabel(newimg);
	    j1.setBounds(350,20,500,500);
	    add(j1);

	// Label
		JLabel l1 = new JLabel("Name :");
		l1.setBounds(30,70,100,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l1);

		ll1 = new JTextField();
		ll1.setBounds(190,70,100,30);
		ll1.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll1);

	// phone
		JLabel l6 = new JLabel("Phone  :");
		l6.setBounds(30,120,200,30);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l6);

		ll6 = new JTextField();
		ll6.setBounds(190,120,100,30);
		ll6.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll6);

		JLabel l2 = new JLabel("Package :");
		l2.setBounds(30,160,200,30);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l2);

		ll2 = new JLabel();
		ll2.setBounds(190,160,200,30);
		ll2.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll2);

		JLabel newll1 = new JLabel("Destination :");
		newll1.setBounds(30,200,200,30);
		newll1.setFont(new Font("Tahoma",Font.BOLD,15));
		add(newll1);

		newl1 = new JLabel();
		newl1.setBounds(190,200,200,30);
		newl1.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(newl1);

		JLabel l3 = new JLabel("Total Persons :");
		l3.setBounds(30,240,200,30);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l3);

		ll3 = new JLabel();
		ll3.setBounds(190,240,200,30);
		ll3.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll3);

		JLabel l4 = new JLabel("ID :");
		l4.setBounds(30,280,200,30);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l4);

		ll4 = new JLabel();
		ll4.setBounds(190,280,200,30);
		ll4.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll4);

		JLabel l5 = new JLabel("Number :");
		l5.setBounds(30,320,200,30);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l5);

		ll5 = new JLabel();
		ll5.setBounds(190,320,200,30);
		ll5.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll5);

		JLabel l7 = new JLabel("Price :");
		l7.setBounds(30,360,200,30);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l7);

		ll7 = new JLabel();
		ll7.setBounds(190,360,200,30);
		ll7.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll7);

	// Button
		b1 = new JButton("Search");
		b1.setBounds(30,420,100,30);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Back");
		b2.setBounds(170,420,100,30);
		b2.addActionListener(this);
		add(b2);


	}


	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==b1) {
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '"+ll1.getText()+"' and phone='"+ll6.getText()+"'");
				while(rs.next()) {

					ll2.setText(rs.getString("package"));
					newl1.setText(rs.getString("destination"));
					ll3.setText(rs.getString("persons"));
					ll4.setText(rs.getString("id"));
					ll5.setText(rs.getString("number"));
					ll7.setText(rs.getString("price"));

				}

			}catch(Exception e) {}
		}else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {

		new ViewPackage().setVisible(true);
	}


	}


