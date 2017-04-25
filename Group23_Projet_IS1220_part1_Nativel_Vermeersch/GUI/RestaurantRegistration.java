package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.MyFoodora;
import Users.Address;
import Users.Restaurant;

public class RestaurantRegistration implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	

	JTextField username = new JTextField("username",20);
	
	JButton enregistrer = new JButton("s'enregistrer");
	JTextField password = new JTextField("password",20);
	JTextField name = new JTextField("name",20);
	JTextField addressX = new JTextField("addressX",20);
	JTextField addressY = new JTextField("addressY",20);
	
	
	public RestaurantRegistration() {
		frame.add(panel);
		frame.setTitle("Enregistrez votre restaurant");
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.blue);
		panel.add(name);
		panel.add(username);
		panel.add(password);
		panel.add(addressX);
		panel.add(addressY);
		panel.add(enregistrer);
		frame.pack();
		enregistrer.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		
		int x = Integer.parseInt(addressX.getText(), 10);
		int y = Integer.parseInt(addressY.getText(), 10);
		Restaurant r = new Restaurant(name.getText(), username.getText(), password.getText(), new Address(x,y));
		MyFoodora system = MyFoodora.getInstance();
		if (system.getUsersList().containsKey(username.getText()) == false){
			system.addUser(r);
			frame.setVisible(false);
			new Identification();
		}
		else{
			JDialog dialog = new JDialog();
			dialog.setTitle("nom d'utilisateur déjà utilisé");
			dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
			dialog.setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args) {
		new RestaurantRegistration();
	}
}
