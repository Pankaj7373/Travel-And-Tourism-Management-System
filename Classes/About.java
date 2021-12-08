package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class About extends JFrame  implements ActionListener{
	String s ;
	JButton b1;
	About(){
		setBounds(550,150,500,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel l1 = new JLabel("Travel And Trousim Management System");
		l1.setBounds(50,10,400,80);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));

		 s = "                                            About Projects          \n  "
	                + "\nThe objective of the Travel and Tourism Management System"
	                + "project is to develop a system that automates the processes "
	                + "and activities of a travel and the purpose is to design a "
	                + "system using which one can perform all operations related to "
	                + "traveling.\n\n"
	                + "This application will help in accessing the information related "
	                + "to the travel to the particular destination with great ease. "
	                + "The users can track the information related to their tours with "
	                + "great ease through this application. The travel agency information "
	                + "can also be obtained through this application.\n\n"
	                + "Advantages of Project:"
	                + "\nGives accurate information"
	                + "\nSimplifies the manual work"
	                + "\nIt minimizes the documentation related work"
	                + "\nProvides up to date information"
	                + "\nFriendly Environment by providing warning messages."
	                + "\ntravelers details can be provided"
	                + "\nbooking confirmation notification"
	        ;

		TextArea t1 = new TextArea(s, 10,40,Scrollbar.VERTICAL);
		t1.setEditable(false);
		t1.setBounds(20,100,450,300);

		add(t1);
		add(l1);

		b1= new JButton("Back");
		b1.setBounds(180,450,100,25);
		b1.addActionListener(this);
		add(b1);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			this.setVisible(false);

		}

	}


	public static void main(String[] args) {
		new About().setVisible(true);

	}

}
