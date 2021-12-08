package travel.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Payment extends JFrame implements ActionListener{
	JButton b1 , b2;
	Payment(){
		setBounds(450,200,800,600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/paytm.jpeg"));
		Image i2 = l1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel jl = new JLabel(i3);
		jl.setBounds(0,0,800,600);
		add(jl);

		b1 = new JButton("Pay");
		b1.setBounds(40,20,90,30);
		b1.addActionListener(this);
		jl.add(b1);

		b2 = new JButton("Back");
		b2.setBounds(150,20,90,30);
		b2.addActionListener(this);
		jl.add(b2);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			this.setVisible(false);
			new Paytm().setVisible(true);

		}else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}
	public static void main(String[] args) {
		new Payment().setVisible(true);
	}
}
