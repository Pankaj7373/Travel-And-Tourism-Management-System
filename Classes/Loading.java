package travel.management.system;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
public class Loading extends JFrame implements Runnable{
	JProgressBar p;
	String username ;
	Loading(String user){

		 username = user;

		setBounds(450,200,600,400);
		getContentPane().setBackground(Color.orange);
		setTitle("Loading Window");
		setLayout(null);

		JLabel j1 = new JLabel("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
		j1.setBounds(73,10,500,80);
		j1.setFont(new Font("courier",Font.BOLD,20));
		j1.setForeground(Color.BLUE);
		j1.setLayout(null);
		add(j1);

		p = new JProgressBar();
		p.setBounds(130,90,300,20);
		p.setLayout(null);
		p.setStringPainted(true);
		add(p);


		JLabel j2 = new JLabel("LOADING PLEASE WAIT...");
		j2.setBounds(153,120,270,15);
		j2.setFont(new Font("courier",Font.ITALIC,20));
		j2.setForeground(Color.RED);
		j2.setLayout(null);
		add(j2);


		JLabel j3 = new JLabel("Welocme " +username);
		j3.setBounds(50,300,300,50);
		j3.setFont(new Font("courier",Font.ITALIC,20));
	//	j3.setForeground(Color.GRAY);
		j3.setLayout(null);
		add(j3);

		Thread t = new Thread(this);
		t.start();

	}
	@Override
	public void run() {

		try {
			for(int i = 1 ; i <= 101 ;i++)
			{
				int m = p.getMaximum();
				int n = p.getValue();
				if(n < m) {
					p.setValue(p.getValue() + 1);
			}else {
					 i = 101 ;
					 setVisible(false);
					 new Dashboard(username).setVisible(true);
				}
				Thread.sleep(50);
			}
		}catch(Exception e ) {}
	}


	public static void main(String[] args) {
		new Loading("").setVisible(true);
	}
	}


