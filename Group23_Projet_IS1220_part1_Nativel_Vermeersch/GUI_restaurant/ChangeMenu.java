package GUI_restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Food.Dish;
import Food.Meal;
import Main.MyFoodora;

public class ChangeMenu implements ActionListener {
	static String resto;
	JFrame frame = new JFrame();
	JTabbedPane tabbedpane = new JTabbedPane();
	JPanel dish = new JPanel();
	JPanel menu = new JPanel();
	JPanel retour = new JPanel();
	JButton adddish = new JButton("ajouter un plat");
	static JComboBox<String> dishes = new JComboBox<String>();
	JButton removedish = new JButton("retirer ce plat");
	JButton addmenu = new JButton("ajouter un menu");
	static JComboBox<String> menus = new JComboBox<String>();
	JButton removemenu = new JButton("retirer ce plat");
	JButton retour1 = new JButton("retour");
	
	ChangeMenu(){
		MyFoodora system = MyFoodora.getInstance();
		dishes.setEditable(true);
		for (Dish dish1: system.getRestaurantsList().get(system.getConnectedUser().getUsername()).getDishes()){
			
			dishes.addItem(dish1.getName());
		}
		menus.setEditable(true);
		for (Meal meal: system.getRestaurantsList().get(system.getConnectedUser().getUsername()).getMeals())
			menus.addItem(meal.getName());
		frame.add(tabbedpane);
		tabbedpane.add("Plats", dish);
		tabbedpane.add("Menus", menu);
		tabbedpane.add("Revenir en arrière", retour);
		dish.setLayout(new BoxLayout(dish,BoxLayout.PAGE_AXIS));
		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		retour.add(retour1);
		dish.add(adddish);
		dish.add(dishes);
		dish.add(removedish);
		menu.add(addmenu);
		menu.add(menus);
		menu.add(removemenu);

		removedish.addActionListener(new RemoveDish());
		adddish.addActionListener(new AddDish2());
		addmenu.addActionListener(new AddMenu2());
		removemenu.addActionListener(new RemoveMenu());
		retour1.addActionListener(this);
		frame.setTitle("Changer la carte");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.pack();
		frame.setVisible(true);
			
		}
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == retour1)
			new MainInterface();
		/*
		 * je teste une nouvelle technique pour éviter d'avoir à faire trop de classes d'actionlistener
		 * le cas if correspond au bouton retour de l'interface changemenu
		 * le cas else correspond au bouton changemenu de l'interface principale du restaurant
		 */
		else
			new ChangeMenu();
	}
	

}
