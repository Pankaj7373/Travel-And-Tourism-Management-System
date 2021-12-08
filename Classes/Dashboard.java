package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Dashboard extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	String username;
	Dashboard(String username){
		this.username = username ;
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLayout(null);

	// top side panel

		JPanel pn = new JPanel() ;
		pn.setLayout(null);
		pn.setBounds(0,0,1950,60);
		pn.setBackground(new Color(0,0,102));
		add(pn);

	// panel image

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/updateCustomer.png"));
		Image i2 = img1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
		ImageIcon mn = new ImageIcon(i2);
		JLabel j2 = new JLabel(mn);
		j2.setBounds(10,0,60,60);
		pn.add(j2);

	// Label

		JLabel l1  = new JLabel("Dashboard");
		l1.setLayout(null);
		l1.setFont(new Font("Tahoma", Font.BOLD , 25));
		l1.setForeground(Color.WHITE);
		l1.setBounds( 80 , 10 , 300 ,40);
		pn.add(l1);

	// left panel

		JPanel p1 = new JPanel() ;
		p1.setLayout(null);
		p1.setBounds(0,60,300,1000);
		p1.setBackground(new Color(0,0,102));
		add(p1);

	// Buttons
		b1 = new JButton("Add Customer Details");
		b1.setBackground(new Color(0,0,102));
		b1.setFont(new Font("Tahoma",Font.PLAIN,20));
		b1.setForeground(Color.WHITE);
		b1.setBounds(0,0,300,40);
		b1.setMargin(new Insets(0,0,0,60));
		b1.addActionListener(this);
		p1.add(b1);

		b2 = new JButton("Update Customer Details");
		b2.setBackground(new Color(0,0,102));
		b2.setFont(new Font("Tahoma",Font.PLAIN,20));
		b2.setForeground(Color.WHITE);
		b2.setBounds(0,50,300,40);
		b2.setMargin(new Insets(0,0,0,40));
		b2.addActionListener(this);
		p1.add(b2);

		b3 = new JButton("View Customer Details");
		b3.setBackground(new Color(0,0,102));
		b3.setFont(new Font("Tahoma",Font.PLAIN,20));
		b3.setForeground(Color.WHITE);
		b3.setBounds(0,100,300,40);
		b3.setMargin(new Insets(0,0,0,50));
		b3.addActionListener(this);
		p1.add(b3);

		b4 = new JButton("Delete Customer Details");
		b4.setBackground(new Color(0,0,102));
		b4.setFont(new Font("Tahoma",Font.PLAIN,20));
		b4.setForeground(Color.WHITE);
		b4.setBounds(0,150,300,40);
		b4.setMargin(new Insets(0,0,0,45));
		b4.addActionListener(this);
		p1.add(b4);

		b11 = new JButton("Destination");
		b11.setBackground(new Color(0,0,102));
		b11.setFont(new Font("Tahoma",Font.PLAIN,20));
		b11.setForeground(Color.WHITE);
		b11.setBounds(0,200,300,40);
		b11.setMargin(new Insets(0,0,0,150));
		b11.addActionListener(this);
		p1.add(b11);

		b5 = new JButton("Check Package");
		b5.setBackground(new Color(0,0,102));
		b5.setFont(new Font("Tahoma",Font.PLAIN,20));
		b5.setForeground(Color.WHITE);
		b5.setBounds(0,250,300,40);
		b5.setMargin(new Insets(0,0,0,120));
		b5.addActionListener(this);
		p1.add(b5);

		b6 = new JButton("Book Package");
		b6.setBackground(new Color(0,0,102));
		b6.setFont(new Font("Tahoma",Font.PLAIN,20));
		b6.setForeground(Color.WHITE);
		b6.setBounds(0,300,300,40);
		b6.setMargin(new Insets(0,0,0,130));
		b6.addActionListener(this);
		p1.add(b6);

		b7 = new JButton("View Package");
		b7.setBackground(new Color(0,0,102));
		b7.setFont(new Font("Tahoma",Font.PLAIN,20));
		b7.setForeground(Color.WHITE);
		b7.setBounds(0,350,300,40);
		b7.setMargin(new Insets(0,0,0,130));
		b7.addActionListener(this);
		p1.add(b7);

		b8 = new JButton("View Hotel");
		b8.setBackground(new Color(0,0,102));
		b8.setFont(new Font("Tahoma",Font.PLAIN,20));
		b8.setForeground(Color.WHITE);
		b8.setBounds(0,400,300,40);
		b8.setMargin(new Insets(0,0,0,155));
		b8.addActionListener(this);
		p1.add(b8);

		b9 = new JButton("Book Hotel");
		b9.setBackground(new Color(0,0,102));
		b9.setFont(new Font("Tahoma",Font.PLAIN,20));
		b9.setForeground(Color.WHITE);
		b9.setBounds(0,450,300,40);
		b9.setMargin(new Insets(0,0,0,151));
		b9.addActionListener(this);
		p1.add(b9);

		b10 = new JButton("View Booked Hotel");
		b10.setBackground(new Color(0,0,102));
		b10.setFont(new Font("Tahoma",Font.PLAIN,20));
		b10.setForeground(Color.WHITE);
		b10.setBounds(0,500,300,40);
		b10.setMargin(new Insets(0,0,0,80));
		b10.addActionListener(this);
		p1.add(b10);

		b12 = new JButton("Payment");
		b12.setBackground(new Color(0,0,102));
		b12.setFont(new Font("Tahoma",Font.PLAIN,20));
		b12.setForeground(Color.WHITE);
		b12.setBounds(0,550,300,40);
		b12.setMargin(new Insets(0,0,0,170));
		b12.addActionListener(this);
		p1.add(b12);

		b13 = new JButton("Calculator");
		b13.setBackground(new Color(0,0,102));
		b13.setFont(new Font("Tahoma",Font.PLAIN,20));
		b13.setForeground(Color.WHITE);
		b13.setBounds(0,600,300,40);
		b13.setMargin(new Insets(0,0,0,160));
		b13.addActionListener(this);
		p1.add(b13);

		b14 = new JButton("Notepad");
		b14.setBackground(new Color(0,0,102));
		b14.setFont(new Font("Tahoma",Font.PLAIN,20));
		b14.setForeground(Color.WHITE);
		b14.setBounds(0,650,300,40);
		b14.setMargin(new Insets(0,0,0,170));
		b14.addActionListener(this);
		p1.add(b14);

		b15 = new JButton("About US");
		b15.setBackground(new Color(0,0,102));
		b15.setFont(new Font("Tahoma",Font.PLAIN,20));
		b15.setForeground(Color.WHITE);
		b15.setBounds(0,700,300,40);
		b15.setMargin(new Insets(0,0,0,170));
		b15.addActionListener(this);
		p1.add(b15);

	// Main image

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
		Image i3 = img.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
		ImageIcon mm = new ImageIcon(i3);
		JLabel j1 = new JLabel(mm);
		j1.setBounds(0,0,1950,1000);
		add(j1);

	//  Main Label
		JLabel jj = new JLabel("Travel And Tourism Management System");
		jj.setBounds(570,80,1000,70);
		jj.setForeground(Color.WHITE);
		jj.setFont(new Font("Tahoma", Font.PLAIN,40));
		j1.add(jj);

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1){
			new AddCustomer(username).setVisible(true);

		}else if(ae.getSource()== b13) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e) {}
		}else if(ae.getSource()== b14)
		{
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e) {}
		}else if(ae.getSource()==b2) {
			try {
				new UpdateCustomer().setVisible(true);

			}catch(Exception e) {}
		}else if(ae.getSource() == b3) {
			new ViewCustomer().setVisible(true);
		}else if(ae.getSource() == b5) {
			new CheckPackage().setVisible(true);
		}else if(ae.getSource()==b7) {
			new ViewPackage().setVisible(true);
		}else if(ae.getSource()==b4) {
			new DeleteCustomer().setVisible(true);
		}else if(ae.getSource()==b6) {
			new BookPackage().setVisible(true);
		}else if(ae.getSource() == b8) {
			new CheckHotels().setVisible(true);
		}else if(ae.getSource()==b11) {
			new CheckDestination().setVisible(true);
		}else if(ae.getSource()==b9) {
			new BookHotel().setVisible(true);
		}else if(ae.getSource()==b10) {
			new ViewBookedHotel().setVisible(true);
		}else if(ae.getSource()==b12) {
			new Payment().setVisible(true);
		}else if(ae.getSource()==b15) {
			new About().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Dashboard("").setVisible(true);

	}

}
