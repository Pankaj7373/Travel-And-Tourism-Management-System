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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgotPassword extends JFrame implements ActionListener {
	JButton bt1 , bt2,bt3 ;
	JTextField t1,t2,t3,t4,t5;

	ForgotPassword(){
		setBounds(300,200,900,450);
		getContentPane().setBackground(Color.white);        //content pane is layer used to holds the object
		setTitle("Forgot Password");
		setLayout(null);

		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBounds(40,30,530,350);
		add(p);

	// iMAGE
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/forgotpassword.jpg"));
		Image i2 = i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel  jj = new JLabel(i3);
		jj.setBounds(570,50,300,300);
		add(jj);

	// Label
		JLabel j1 = new JLabel("USERNAME");
		j1.setBounds(30 , 30 ,100, 25);
		j1.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(j1);

	// TextField
	    t1 = new JTextField();
		t1.setBounds(200,30,180,25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p.add(t1);

	// Button
		bt1 = new JButton("SEARCH");
		bt1.setBounds(400,30,100,25);
		bt1.setForeground(Color.GRAY);
		bt1.setBackground(Color.white);
		bt1.addActionListener(this);
		p.add(bt1);

	// Label
		JLabel j2 = new JLabel("NAME");
		j2.setBounds(30 , 80 ,100, 25);
		j2.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(j2);

	// TextField
		t2 = new JTextField();
		t2.setBounds(200,80,180,25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p.add(t2);

	// Label
		JLabel j3 = new JLabel("SAFTEY QUESTION");
		j3.setBounds(30 , 130 ,150, 25);
		j3.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(j3);

	// TextField
		t3 = new JTextField();
		t3.setBounds(200,130,180,25);
		t3.setBorder(BorderFactory.createEmptyBorder());
		p.add(t3);

	// Label
		JLabel j4 = new JLabel("ANSWER");
		j4.setBounds(30 , 180 ,100, 25);
		j4.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(j4);

	// Button
		bt2 = new JButton("RETRIEVE");
		bt2.setBounds(400,180,100,25);
		bt2.setForeground(Color.GRAY);
		bt2.setBackground(Color.white);
		bt2.addActionListener(this);
		p.add(bt2);

    // TextField
		t4 = new JTextField();
		t4.setBounds(200,180,180,25);
		t4.setBorder(BorderFactory.createEmptyBorder());
		p.add(t4);

	// Label
		JLabel j5 = new JLabel("PASSWORD");
		j5.setBounds(30 , 230 ,100, 25);
		j5.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(j5);

    // TextField
		t5 = new JTextField();
		t5.setBounds(200,230,180,25);
		t5.setBorder(BorderFactory.createEmptyBorder());
		p.add(t5);

	// Button
		bt3 = new JButton("BACK");
		bt3.setForeground(Color.GRAY);
		bt3.setBackground(Color.WHITE);
		bt3.setBounds(200,280,100,25);
		p.add(bt3);
		bt3.addActionListener(this);

		setVisible(true);
	}


	// Override method
		@Override
		public void actionPerformed(ActionEvent ae) {
			Conn c  = new Conn();

			if(ae.getSource()==bt1) {
				try {

					String sql = " select * from account where username ='"+t1.getText()+"'";      // gettext get string entered in 1st textfield

					ResultSet rs = c.s.executeQuery(sql);     // present in sql class  executequery return result set class object so store it in result set

					while(rs.next())            // to jump next column in database
					{
						t2.setText(rs.getString("name"));              // settext set that string to texfield
						t3.setText(rs.getString("security"));
					}

				}catch(Exception e) {}

			}
			else if(ae.getSource()== bt2)
			{
				try {
					String sql = " select * from account where answer ='"+t4.getText()+"' AND username ='"+t1.getText()+"'";      // gettext get string entered in 1st textfield

					ResultSet rs = c.s.executeQuery(sql);     // present in sql class   executequery return result set class object so store it in result set

					while(rs.next())            // to jump next column in database
						{
							t5.setText(rs.getString("password"));              // settext set that string to texfield
						}
				}catch(Exception e) { }

			}
			else if(ae.getSource()== bt3)
			{
				new Login().setVisible(true);
				this.setVisible(false);
			}
		}


public static void main(String[] args) {
	new ForgotPassword().setVisible(true);
}
}