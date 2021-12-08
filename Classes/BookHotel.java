package travel.management.system;
import java.awt.Choice;
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
public class BookHotel extends JFrame implements ActionListener {
	JButton b1 , b2, b3, b4 ;
	Choice ch1 , ch2,ch3;
	JTextField tf1 , tf2 ,tf3, tf4;
	JLabel ll4 ,ll5,ll6,ll7, newL1,newL2 , newL3;


	BookHotel(){

			setBounds(500,170,800,620);
			setLayout(null);
			getContentPane().setBackground(Color.WHITE);

		// Main Lbel
			JLabel lm = new JLabel("Book Hotel");
			lm.setBounds(30,10,200,30);
			lm.setFont(new Font("Tahoma",Font.ITALIC,20));
			add(lm);

		// Image
			ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
			Image i20 = img.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
			ImageIcon img1 = new ImageIcon(i20);
			JLabel jl = new JLabel(img1);
			jl.setBounds(360,0,400,550);
			add(jl);

			JLabel l1 = new JLabel("Name :");
			l1.setBounds(30,60,100,30);
			l1.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l1);

			tf1 = new JTextField();
			tf1.setBounds(190,60,150,30);
			tf1.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(tf1);

			JLabel l2 = new JLabel("Select Hotel :");
			l2.setBounds(30,110,150,30);
			l2.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l2);

		// Choice
			ch1 = new Choice();
			try {
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery("select * from hotel");
				while(rs.next()) {
					ch1.add(rs.getString("name"));
				}
			}catch(Exception e) {}
			ch1.setBounds(190,110,150,30);
			add(ch1);

			JLabel l3 = new JLabel("Total Persons :");
			l3.setBounds(30,150,200,30);
			l3.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l3);

		//TextField
			tf2 = new JTextField();
			tf2.setBounds(190,150,150,30);
			add(tf2);

			newL1 = new JLabel("No. Of Days :");
			newL1.setBounds(30,190,200,30);
			newL1.setFont(new Font("Tahoma",Font.BOLD,15));
			add(newL1);

		// textField
			tf3 = new JTextField();
			tf3.setBounds(190,190,150,30);
			add(tf3);

			newL2 = new JLabel("AC / Non-AC :");
			newL2.setBounds(30,230,150,30);
			newL2.setFont(new Font("Tahoma",Font.BOLD,15));
			add(newL2);

		// Coice
			ch2  = new Choice();
			ch2.add("YES");
			ch2.add("NO");
			ch2.setBounds(190,230,150,30);
			add(ch2);

			newL3 = new JLabel("Food Included :");
			newL3.setBounds(30,270,150,30);
			newL3.setFont(new Font("Tahoma",Font.BOLD,15));
			add(newL3);
		// Choice
			ch3  = new Choice();
			ch3.add("YES");
			ch3.add("NO");
			ch3.setBounds(190,270,150,30);
			add(ch3);

			JLabel l4 = new JLabel("ID :");
			l4.setBounds(30,310,200,30);
			l4.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l4);

			ll4 = new JLabel();
			ll4.setBounds(190,310,200,30);
			ll4.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll4);

			JLabel l5 = new JLabel("Number :");
			l5.setBounds(30,345,200,30);
			l5.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l5);

			ll5 = new JLabel();
			ll5.setBounds(190,345,200,30);
			ll5.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll5);

			JLabel l6 = new JLabel("Phone  :");
			l6.setBounds(30,375,200,30);
			l6.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l6);

			ll6 = new JLabel();
			ll6.setBounds(190,375,200,30);
			ll6.setFont(new Font("Tahoma", Font.ITALIC,15));
			add(ll6);


			JLabel l7 = new JLabel("Total Price :");
			l7.setBounds(30,405,200,30);
			l7.setFont(new Font("Tahoma",Font.BOLD,15));
			add(l7);

			ll7 = new JLabel();
			ll7.setBounds(190,405,200,30);
			ll7.setFont(new Font("Tahoma",Font.ITALIC,15));
			add(ll7);

		// Buttons
			b1 = new JButton("Search Customer");
			b1.setBounds(20,450,150,30);
			b1.addActionListener(this);
			add(b1);

			b2 = new JButton("Check Price");
			b2.setBounds(180,450,150,30);
			b2.addActionListener(this);
			add(b2);

			b3 = new JButton("Book Hotel");
			b3.setBounds(20,500,150,30);
			b3.addActionListener(this);
			add(b3);

			b4 = new JButton("Back");
			b4.setBounds(180,500,150,30);
			b4.addActionListener(this);
			add(b4);

		}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==b1) {
			try {
				Conn c = new Conn();
				String username = "tf1.getText()";
				String sql ="select * from customer where username='"+tf1.getText()+"'";
				ResultSet rs = c.s.executeQuery(sql);
				while(rs.next()) {

						ll4.setText(rs.getString("id"));
						ll5.setText(rs.getString("number"));
						ll6.setText(rs.getString("phone"));
				}
			}catch(Exception e) {}
		}else if(ae.getSource()== b2) {
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from hotel where name='"+ch1.getSelectedItem()+"'");
				while(rs.next()) {
					int cost = Integer.parseInt(rs.getString("cost_per_day"));
					int food = Integer.parseInt(rs.getString("food_charge"));
					int ac = Integer.parseInt(rs.getString("ac_charge"));

				// get total persons and number of days
					int persons = Integer.parseInt(tf2.getText());
					int days = Integer.parseInt(tf3.getText());

				// get ac and food selected
					String acprice = ch2.getSelectedItem();
					String foodprice = ch3.getSelectedItem();

				if(persons * days >0) {
					int total = 0 ;
					total += acprice.equals("YES") ? ac: 0;          // ternary operator
					total += foodprice.equals("YES") ? food : 0;
					total += cost;

					total = total * persons * days ;

					ll7.setText(""+total);                           // ""+ convert int into string



				}else {
					ll7.setText("Enter Valid Number");
				}
				}
			}catch(Exception e) {}
		}else if(ae.getSource()==b3) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("insert into bookHotel values('"+tf1.getText()+"','"+ch1.getSelectedItem()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+ch2.getSelectedItem()+"','"+ch3.getSelectedItem()+"','"+ll4.getText()+"','"+ll5.getText()+"','"+ll6.getText()+"','"+ll7.getText()+"')");

				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
				this.setVisible(false);
			}catch(Exception e) {}
		}else if(ae.getSource()==b4) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args){

		new BookHotel().setVisible(true);
	}



	}

