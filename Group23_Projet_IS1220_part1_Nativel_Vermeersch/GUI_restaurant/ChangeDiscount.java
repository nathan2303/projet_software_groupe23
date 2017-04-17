package GUI_restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.MyFoodora;
import Users.Restaurant;

public class ChangeDiscount implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel lab1 = new JLabel();
	JTextField field1 = new JTextField("enter the new general discount factor");
	JButton button1 = new JButton("change the general discount factor");
	JLabel lab2 = new JLabel();
	JTextField field2 = new JTextField("enter the new special discount factor");
	JButton button2 = new JButton("change the special discount factor");
	JButton retour = new JButton("revenir au menu précédent");
	
	ChangeDiscount(){
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		frame.setTitle("Changer les réductions");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(800, 400);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		lab2.setText("le 'special discount factor vaut" + resto.getSpecialDiscountFactor());
		lab1.setText("le 'generic discount factor vaut" + resto.getGenericDiscountFactor());frame.add(panel);
		panel.add(lab1);
		panel.add(field1);
		panel.add(button1);
		panel.add(lab2);
		panel.add(field2);
		panel.add(button2);
		panel.add(retour);
		button2.addActionListener(this);
		button1.addActionListener(this);
		retour.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		if (e.getSource()== button1){
			double discount = Double.parseDouble(field1.getText());
			resto.setGenericDiscountFactor(discount);
			lab1.setText("le 'generic discount factor vaut" + resto.getGenericDiscountFactor());
			}
		else if (e.getSource() == button2){
			double discount = Double.parseDouble(field2.getText());
		resto.setSpecialDiscountFactor(discount);
		lab2.setText("le 'special discount factor vaut" + resto.getSpecialDiscountFactor());
		}
		else if (e.getSource() == retour){
			frame.setVisible(false);
			new MainInterface();
		}
		else
			new ChangeDiscount();
	}
}
