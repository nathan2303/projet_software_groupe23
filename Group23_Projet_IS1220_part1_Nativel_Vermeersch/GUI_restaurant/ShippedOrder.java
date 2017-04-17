package GUI_restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import Food.Food;
import Main.MyFoodora;
import Policies.MostOrderedHalfMeal;
import Policies.MostOrderedItem;
import Users.Restaurant;

public class ShippedOrder implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel lab1 = new JLabel("menus");
	JComboBox<String> halfmeal = new JComboBox<String>();
	JLabel lab2 = new JLabel("plats");
	JComboBox<String> item = new JComboBox<String>();
	JButton retour = new JButton("revenir au menu principal");
	
	public ShippedOrder() {
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		frame.setTitle("Les plus commandés");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(800, 400);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		MostOrderedHalfMeal m1 = new MostOrderedHalfMeal();
		HashMap<Food, Integer> meals = m1.sortOrders(resto.getShippedOrders());
		for (Food f:meals.keySet())
			halfmeal.addItem(f.getName() + meals.get(f));
		MostOrderedItem i1 = new MostOrderedItem();
		HashMap<Food, Integer> items = i1.sortOrders(resto.getShippedOrders());
		for (Food f:items.keySet())
			item.addItem(f.getName() + items.get(f));	
		frame.add(panel);
		panel.add(lab1);
		panel.add(halfmeal);
		panel.add(lab2);
		panel.add(item);
		panel.add(retour);
		retour.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == retour){
		frame.setVisible(false);
		new MainInterface();
		}
		else
			new ShippedOrder();
		
	}
		

}
