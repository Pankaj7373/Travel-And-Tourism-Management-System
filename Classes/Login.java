package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class Login extends JFrame implements ActionListener{
	JButton bt1, bt2,bt4 ;
	JTextField t4;
	JPasswordField tt ;
	Login(){
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setBounds(300,200,800,400);
		setTitle("LOGIN");

	// Left Side Panel
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131,193,233));
		p1.setBounds(0,0,400,400);
		p1.setLayout(null);
		add(p1);

		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/Login.png"));
		Image i3 = li.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon ll = new ImageIcon(i3);
		JLabel l1 = new JLabel(ll);
		l1.setBounds(0,0,400,400);
		p1.add(l1);


   // Right Side Panel
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(300,30,450,300);
		add(p2);


   // Labels
		JLabel j1 = new JLabel("USERNAME");
		j1.setBounds(150,10,100,25);
		j1.setFont(new Font("Courier", Font.BOLD,17));
		p2.add(j1);

   // textfield

		t4 = new JTextField();
		t4.setBounds(150,40,200,25);
		t4.setBorder(BorderFactory.createEmptyBorder());
		p2.add(t4);

   // Label
		JLabel lb = new JLabel("PASSWORD");
		lb.setBounds(150,70,100,25);
		lb.setFont(new Font("Courier", Font.BOLD,17));
		p2.add(lb);

   // textfield

		tt = new JPasswordField();
		tt.setBounds(150,100,200,25);
		tt.setBorder(BorderFactory.createEmptyBorder());
		tt.addActionListener(this);
		p2.add(tt);

   // Button
	    bt1 = new JButton("Login");
		bt1.setBounds(150,150,90,30);
		bt1.setBorder(null);
		bt1.setBorder(new LineBorder(new Color(113,191,233)));
		bt1.addActionListener(this);
		p2.add(bt1);

   // Button
	    bt2 = new JButton("Sign Up");
		bt2.setBounds(256,150,90,30);
		bt2.setBorder(null);
		bt2.setBorder(new LineBorder(new Color(113,191,233)));
		bt2.addActionListener(this);
		p2.add(bt2);

	// Button
	    bt4 = new JButton("Forgot Password");
		bt4.setBounds(190,200,120,30);
		bt4.setBorder(null);
		bt4.setBorder(new LineBorder(new Color(113,191,233)));
		bt4.addActionListener(this);
		p2.add(bt4);


		setVisible(true);
	}

	// override method for interface

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == bt1) {
			try {
				Conn c = new Conn();
				String username = t4.getText();
				String password = tt.getText();

				String sql = "select * from account where username ='"+username+"'AND password = '"+password+"'";
				ResultSet rs = c.s.executeQuery(sql);
				if(rs.next())
				{
					String pass = rs.getString("password");
					String uname = rs.getString("username");
					if(username.equals(uname)  && password.equals(pass) )
					{
						new Loading(username).setVisible(true);
						this.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Credentials Dosen't Match ");
					}

				}else {
					JOptionPane.showMessageDialog(null, "Inavlid Login");
				}

			}catch(Exception e) {}
			}else if(ae.getSource() == bt2) {
			new Signup().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource() == bt4) {
			this.setVisible(false);
			new ForgotPassword().setVisible(true);
		}
	}
	public static void main(String[] args)
	{
		new Login();
	}
}
