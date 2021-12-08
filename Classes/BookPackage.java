package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class BookPackage extends JFrame implements ActionListener{
	JButton b1 , b2, b3, b4 ;
	Choice ch1,ch2 ;
	JTextField tf1 , tf2;
	JLabel ll4 ,ll5,ll6,ll7;
	BookPackage(){
		setBounds(500,180,800,600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

	// Main Lbel
		JLabel lm = new JLabel("Book Package");
		lm.setBounds(30,20,200,30);
		lm.setFont(new Font("Tahoma",Font.ITALIC,20));
		add(lm);

	// Image
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookpackage.jpg"));
		JLabel jl = new JLabel(img);
		jl.setBounds(350,0,400,500);
		add(jl);

		JLabel l1 = new JLabel("Name :");
		l1.setBounds(30,70,100,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l1);

		tf1 = new JTextField();
		tf1.setBounds(190,70,150,30);
		tf1.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(tf1);

		JLabel l2 = new JLabel("Select Package :");
		l2.setBounds(30,120,150,30);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l2);

	// Choice
		ch1 = new Choice();
		ch1.add("Gold Package");
		ch1.add("Silver Package");
		ch1.add("Bronze Package");
		ch1.setBounds(190,120,150,30);
		add(ch1);

		JLabel l3 = new JLabel("Total Persons :");
		l3.setBounds(30,200,200,30);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l3);

	//TextField
		tf2 = new JTextField();
		tf2.setBounds(190,200,150,30);
		add(tf2);

		JLabel newl1 = new JLabel("Destination :");
		newl1.setBounds(30,160,150,30);
		newl1.setFont(new Font("Tahoma",Font.BOLD,15));
		add(newl1);

	// Choice
		ch2 = new Choice();
		ch2.add("Kerala");
		ch2.add("Sikkim");
		ch2.add("Leh Ladakh");
		ch2.add("Gujrat");
		ch2.add("KanyaKumari");
		ch2.add("Banglore");
		ch2.add("Odisha");
		ch2.add("Kolkata");
		ch2.add("Manali");
		ch2.add("Kashmir");
		ch2.setBounds(190,160,150,30);
		add(ch2);

		JLabel l4 = new JLabel("ID :");
		l4.setBounds(30,240,200,30);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l4);

		ll4 = new JLabel();
		ll4.setBounds(190,240,200,30);
		ll4.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll4);

		JLabel l5 = new JLabel("Number :");
		l5.setBounds(30,280,200,30);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l5);

		ll5 = new JLabel();
		ll5.setBounds(190,280,200,30);
		ll5.setFont(new Font("Tahoma",Font.ITALIC,15));
		add(ll5);

		JLabel l6 = new JLabel("Phone  :");
		l6.setBounds(30,320,200,30);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l6);

		ll6 = new JLabel();
		ll6.setBounds(190,320,200,30);
		ll6.setFont(new Font("Tahoma", Font.ITALIC,15));
		add(ll6);


		JLabel l7 = new JLabel("Total Price :");
		l7.setBounds(30,360,200,30);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		add(l7);

		ll7 = new JLabel();
		ll7.setBounds(190,360,200,30);
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

		b3 = new JButton("Book Package");
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
				String username = tf1.getText();
				String sql = " select * from customer where username ='"+tf1.getText()+"'";
				ResultSet rs = c.s.executeQuery(sql);
				while(rs.next()) {
					String uname = rs.getString("username");
					if(username.equals(uname) ) {

						ll4.setText(rs.getString("id"));
						ll5.setText(rs.getString("number"));
						ll6.setText(rs.getString("phone"));

					}else {
						JOptionPane.showMessageDialog(null, "Enter valid name");
						this.setVisible(false);
					}
				}
			}catch(Exception e ) {

			}
		}else if(ae.getSource()== b2) {
			String p = ch1.getSelectedItem();
			int cost = 0;
			if(p.equals("Gold Package")) {
				cost += 12000;
			}else if(p.equals("Silver Package")) {
				cost += 25000;
			}else if(p.equals("Bronze Package")) {
				cost += 32000;
			}

			int person = Integer.parseInt(tf2.getText());    // to convert String text field into integer
			cost = cost * person ;
			ll7.setText("Rs"+ cost);

			}else if(ae.getSource()==b4) {

				this.setVisible(false);

			}else if(ae.getSource()== b3) {



				   Conn c = new Conn();


                   try{
			String s1 = ch1.getSelectedItem();

                       String q1 = "insert into bookPackage values('"+tf1.getText()+"', '"+ch1.getSelectedItem()+"','"+ch2.getSelectedItem()+"','"+tf2.getText()+"', '"+ll4.getText()+"', '"+ll5.getText()+"', '"+ll6.getText()+"', '"+ll7.getText()+"')";
                       c.s.executeUpdate(q1);

			JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                       setVisible(false);
                   }catch(Exception ee){
			System.out.println(ee.getMessage());
                   }

	}
			}


	public static void main(String[] args) {
		new BookPackage().setVisible(true);

	}
}
