
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.ConfigInitiale;
import Main.MyFoodora;
import Users.User;

public class Identification implements ActionListener {
	JFrame  frame1 = new JFrame("test");
	JPanel panel1 = new JPanel();
	JTextField username = new JTextField("username",20);
	JButton identifier = new JButton("s'identifier");
	JTextField password = new JTextField("password",20);
	JButton enregistrer =new JButton("s'enregistrer");
	public Identification(){
		
	
	frame1.add(panel1);
	frame1.setLocationRelativeTo(null);
	frame1.setSize(600, 300);
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
	panel1.add(username);
	panel1.add(password);
	panel1.add(identifier);
	panel1.add(enregistrer);
	panel1.setBackground(Color.green);
	panel1.setSize(320, 160);
	panel1.setBackground(Color.GREEN);
	panel1.setBorder(BorderFactory.createTitledBorder("Identification"));
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.pack();
	System.out.println("Hi I'm there");
	frame1.setVisible(true);
	frame1.setLocationRelativeTo(null);
	identifier.addActionListener(this);
	enregistrer.addActionListener(new EnregistrerListener());
		}
	

	public  void actionPerformed(ActionEvent e){
		
		String typedUsername = username.getText();
		String typedPassword = password.getText();
		System.out.println("actionperformed is called");
		MyFoodora system = MyFoodora.getInstance();
		HashMap<String, User> list = system.getUsersList();
		if (list.containsKey(typedUsername) && list.get(typedUsername).getPassword().equals(typedPassword)){
			User user = list.get(typedUsername);
			System.out.println("Bonjour " + user);
			system.setConnectedUser(system.getUsersList().get(user));
				
				
		}
		else{
				System.out.println("erreur d'identification");
				panel1.setBackground(Color.red);
				username.setText("username");
				password.setText("password");
				}
				}
			 
				

	
	public static void main(String[] args) {
		ConfigInitiale.launch();
		new Identification();
		System.out.println("Hi I'm here");
		
	}
}

