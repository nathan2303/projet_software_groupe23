package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


import Main.MyFoodora;
import Users.Courier;
import Users.Customer;
import Users.Manager;
import Users.Restaurant;

public class Registration implements ActionListener{
	JFrame frame = new JFrame();
	JPanel usertype = new JPanel(new FlowLayout(4));
	String[] usertypes = {"restaurant","manager","client","courier"};
	JComboBox<String> user = new JComboBox<String>(usertypes);
	JButton ok = new JButton("ok");
	
	
	public Registration(){
		frame.add(usertype);
		usertype.add(user);
		usertype.add(ok);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usertype.setMaximumSize(new Dimension(420, 320));
		usertype.setBackground(Color.blue);
		ok.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		MyFoodora system = MyFoodora.getInstance();
		switch(user.getSelectedIndex()){
		case 0:
			frame.setVisible(false);
			new RestaurantRegistration();
			break;
		case 1:
			frame.setVisible(false);
			new ManagerRegistration();
			break;
			
		case 2:
			frame.setVisible(false);
			new CustomerRegistration();
			break;
			
		case 3:
			frame.setVisible(false);
			new CourierRegistration();
			break;
		
		}
		
		
		
		
	}
public static void main(String[] args) {
	new Registration();
}
}

