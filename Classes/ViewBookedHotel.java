package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class ViewBookedHotel extends JFrame implements ActionListener{
	JButton b1 ,b2;
	JTextField ll1  ;
	JLabel ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9,ll0;

	ViewBookedHotel() {


			setBounds(400,180,800,600);
			setLayout(null);
			getContentPane().setBackground(Color.WHITE);

		// Main Label
			JLabel heading = new JLabel("View Booked Hotel");
			heading.setBounds(50,0,300,30);
			heading.setFont(new Font("Tahoma",Font.ITALIC,20));
			add(heading);

		// Image
			ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
			JLabel j1 = new JLabel(img);
		    j1.setBounds(350,0,500,600);
		    add(j1);

		// Label
			JLabel l1 = new JLabel("Name :");
			l1.setBounds(30,70,100,30);
			l1.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l1);

			ll1 = new JTextField();
			ll1.setBounds(190,70,150,30);
			ll1.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll1);

			JLabel l2 = new JLabel("Hotel Name :");
			l2.setBounds(30,120,200,30);
			l2.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l2);

			ll2 = new JLabel();
			ll2.setBounds(190,120,200,30);
			ll2.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll2);

			JLabel l3 = new JLabel("Total Persons :");
			l3.setBounds(30,160,200,30);
			l3.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l3);

			ll3 = new JLabel();
			ll3.setBounds(190,160,200,30);
			ll3.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll3);

			JLabel l4 = new JLabel("Total Days :");
			l4.setBounds(30,200,200,30);
			l4.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l4);

			ll4 = new JLabel();
			ll4.setBounds(190,200,200,30);
			ll4.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll4);

			JLabel l5 = new JLabel("Ac Included :");
			l5.setBounds(30,240,200,30);
			l5.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l5);

			ll5 = new JLabel();
			ll5.setBounds(190,240,200,30);
			ll5.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll5);

			JLabel l6 = new JLabel("Food Included :");
			l6.setBounds(30,280,200,30);
			l6.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l6);

			ll6 = new JLabel();
			ll6.setBounds(190,280,200,30);
			ll6.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll6);

			JLabel l7 = new JLabel("Id :");
			l7.setBounds(30,320,200,30);
			l7.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l7);

			ll7 = new JLabel();
			ll7.setBounds(190,320,200,30);
			ll7.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll7);

			JLabel l8 = new JLabel("Number :");
			l8.setBounds(30,360,200,30);
			l8.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l8);

			ll8 = new JLabel();
			ll8.setBounds(190,360,200,30);
			ll8.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll8);

			JLabel l9 = new JLabel("Phone :");
			l9.setBounds(30,400,200,30);
			l9.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l9);

			ll9 = new JLabel();
			ll9.setBounds(190,400,200,30);
			ll9.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll9);

			JLabel l0 = new JLabel("Cost :");
			l0.setBounds(30,440,200,30);
			l0.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l0);

			ll0 = new JLabel();
			ll0.setBounds(190,440,200,30);
			ll0.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll0);


		// Button
			b1 = new JButton("Search");
			b1.setBounds(30,500,100,30);
			b1.addActionListener(this);
			add(b1);

			b2 = new JButton("Back");
			b2.setBounds(170,500,100,30);
			b2.addActionListener(this);
			add(b2);


		}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== b1) {
			try {
				Conn c = new Conn();
				String username = "ll1.getText()";
				String sql = "select * from bookHotel where username = '"+ll1.getText()+"'";
				ResultSet rs= c.s.executeQuery(sql);
				while(rs.next()) {
					ll2.setText(rs.getString("hotel"));
					ll3.setText(rs.getString("persons"));
					ll4.setText(rs.getString("days"));
					ll5.setText(rs.getString("ac"));
					ll6.setText(rs.getString("food"));
					ll7.setText(rs.getString("id"));
					ll8.setText(rs.getString("number"));
					ll9.setText(rs.getString("phone"));
					ll0.setText(rs.getString("cost"));
				}

			}catch(Exception e) {}
			}else if(ae.getSource()==b2) {
				this.setVisible(false);
			}

	}
	public static void main(String[] args) {
		new ViewBookedHotel().setVisible(true);

	}
	}
