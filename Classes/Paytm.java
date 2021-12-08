package travel.management.system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class Paytm extends JFrame implements ActionListener{
	JButton b1;

	Paytm(){
		JEditorPane  j = new JEditorPane();
		j.setEditable(false);
		setBounds(450,200,800,600);
		add(j);

		try {

			j.setPage("https://paytm.com/credit-card-payment");

		}catch(Exception e) {
			j.setContentType("text/html");
			j.setText("<html>Could Not Load,Error 404</html>");
		}

		b1 = new JButton("Back");
		b1.setBounds(650,20,80,40);
		b1.addActionListener(this);
		j.add(b1);

		JScrollPane jp = new JScrollPane(j);
		getContentPane().add(jp);


	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			this.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Paytm().setVisible(true);
	}

}
