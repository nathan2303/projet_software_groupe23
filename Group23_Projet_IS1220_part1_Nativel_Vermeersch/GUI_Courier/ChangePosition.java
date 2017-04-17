package GUI_Courier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.MyFoodora;
import Users.Address;
import Users.Courier;

public class ChangePosition implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField addressX = new JTextField("addressX",20);
	JTextField addressY = new JTextField("addressY",20);
	JButton ok = new JButton("ok");
	
	public ChangePosition() {
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 400);
		frame.setTitle("entrez vos coordonnées");
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(addressX);
		panel.add(addressY);
		panel.add(ok);
		ok.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		int x = Integer.parseInt(addressX.getText(), 10);
		int y = Integer.parseInt(addressY.getText(), 10);
		MyFoodora system = MyFoodora.getInstance();
		Courier cour = new Courier();
		cour = (Courier) system.getConnectedUser();
		cour.setPosition(new Address(x, y));
		frame.setVisible(false);
		new MainInterface();
	}
}
