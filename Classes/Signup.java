package travel.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener{
	JButton bt2,bt3;

	JTextField t1,t0,t9,ta;
	Choice c1 ;
	Signup(){
		setBounds(300,250,900,400);
		getContentPane().setBackground(Color.white);        //content pane is layer used to holds the object
		setTitle("SIGN UP PAGE");
		setLayout(null);

	// Left Panel
		JPanel p1  =new JPanel();
		p1.setBackground(new Color(113,193,233));
		p1.setBounds(0,0,500,400);
		p1.setLayout(null);
		add(p1);

	// Label
		JLabel li = new JLabel("USERNAME");
		li.setFont(new Font("Courier", Font.BOLD,17));
		li.setBounds(40,30,100,25);
		p1.add(li);

	// TextField
		t1 = new JTextField();
		t1.setBounds(210,30,180,25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);

	// Label
		JLabel lo = new JLabel("NAME");
		lo.setFont(new Font("Courier", Font.BOLD,17));
		lo.setBounds(40,80,180,25);
		p1.add(lo);

	// TextField
		t0 = new JTextField();
		t0.setBounds(210,80,180,25);
		t0.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t0);

	// Label
		JLabel ll = new JLabel("PASSWORD");
		ll.setFont(new Font("Courier", Font.BOLD,17));
		ll.setBounds(40,130,180,25);
		p1.add(ll);

	// TextField
		t9 = new JTextField();
		t9.setBounds(210,130,180,25);
		t9.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t9);

	// Label
		JLabel lm = new JLabel("SAFTEY QUESTION");
		lm.setFont(new Font("Courier", Font.BOLD,17));
		lm.setBounds(40,180,170,25);
		p1.add(lm);

	// Choice Box
		c1 = new Choice();
		c1.add("Your Favourite Movie");
		c1.add("Cptain Aermica or Iron Man");
		c1.add("Your Lucky Number?");
		c1.add("Youre Favourite Super Hero");
		c1.setBounds(210,180,180,25);
		p1.add(c1);

	// Label
		JLabel lc = new JLabel("ANSWER");
		lc.setFont(new Font("Courier", Font.BOLD,17));
		lc.setBounds(40,230,180,25);
		p1.add(lc);

	// TextField
		ta = new JTextField();
		ta.setBounds(210,230,180,25);
		ta.setBorder(BorderFactory.createEmptyBorder());
		p1.add(ta);

   //   ADD Image right side

		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/signup.png"));
		JLabel jj = new JLabel(ic);
	    jj.setBounds(550,20,300,300);
		add(jj);


   // Button
	    bt2 = new JButton("CREATE");
		bt2.setBounds(80, 300,100 ,30);
		bt2.addActionListener(this);
		p1.add(bt2);


   // Button
	    bt3 = new JButton("BACK");
		bt3.setBounds(220,300,100 ,30);
		bt3.addActionListener(this);
		p1.add(bt3);


	}
	// override method for interface
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == bt2) {
			// To get values of fields when click on create button
				String username = t1.getText();
				String name = t0.getText();
				String password = t9.getText();
				String security = c1.getSelectedItem();
				String answer = ta.getText();

			//  to save it on database
				if(t1.getText().equals("") && t0.getText().equals("") && t9.getText().equals("") && ta.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Please Enter Details");
				}else {
				String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
				try {
					Conn c = new Conn();
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Account Created Sucessfully");

					this.setVisible(false);
					new Login().setVisible(true);
				}catch(Exception e) {

				}
				}

			}else if(ae.getSource() == bt3) {
				new Login().setVisible(true);
				this.setVisible(false);
			}

		}


	public static void main(String[] args) {
		new Signup().setVisible(true);
	}

}
