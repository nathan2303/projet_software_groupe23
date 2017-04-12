
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class identification {
	public static void main(String[] args) {
		
	
	JFrame frame1 = new JFrame("test");
	JPanel panel1 = new JPanel();
	JTextField username = new JTextField("username",20);
	JButton identifier = new JButton("s'identifier");
	
	JTextField password = new JTextField("password",20);
	frame1.add(panel1);
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
	panel1.add(username);
	panel1.add(password);
	panel1.add(identifier);
	panel1.setSize(320, 160);
	panel1.setBackground(Color.green);
	panel1.setBorder(BorderFactory.createTitledBorder("Identification"));
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.pack();
	frame1.setVisible(true);
	identifier.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//for ()
			
			// TODO Auto-generated method stub
			
		}
	});
	}
	
}

