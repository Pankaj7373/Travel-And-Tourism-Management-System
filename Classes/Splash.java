package travel.management.system;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash {
	public static void main(String [] args)
	{
		SplashFrame frame = new SplashFrame();
		frame.setVisible(true);
		int x = 1 ;
		for(int i = 1 ; i<=600 ; i +=3 , x+=3)
		{

			frame.setBounds(800 -(x/1),670 - (x-3) , x+i ,i);
			try {
				Thread.sleep(9);

			}catch(Exception e) {}
		}

		frame.setVisible(true);
	}
}
class SplashFrame extends JFrame implements Runnable{

	SplashFrame()                   // created constructor
	{
		// TO get image from system
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/World.jpg"));
		Image li = l1.getImage().getScaledInstance(1200 , 550 , Image.SCALE_DEFAULT);  // Used to Scale the image
		ImageIcon m1 = new ImageIcon(li);
		JLabel l2 = new JLabel(m1);
		add(l2);
		setUndecorated(true);
		Thread t1 = new Thread(this) ;   //current class reference
		t1.start();
	}


	@Override
	public void run(){
		try {
			Thread.sleep(7000);
			this.setVisible(false);
			new Login().setVisible(true);
		}catch(Exception e) {}
	}
}

