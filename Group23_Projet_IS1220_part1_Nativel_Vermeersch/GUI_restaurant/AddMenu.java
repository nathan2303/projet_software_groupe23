package GUI_restaurant;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Food.Dish;
import Food.FullMeal;
import Food.HalfMeal;
import Food.InvalidFullMealException;
import Food.InvalidHalfMealException;
import Main.MyFoodora;
import Users.Restaurant;

public class AddMenu extends ChangeMenu implements ActionListener {
	JFrame frameA = new JFrame();
	JPanel panA = new JPanel();
	JTextField name = new JTextField("nom",20);
	
	String[] menuTypes = {"full meal","half meal"};
	JComboBox<String>  type = new JComboBox<String>(menuTypes);
	JLabel label = new JLabel("voici ci dessous les plats qui composent votre menu");
	ArrayList<Dish> platsMenu =new ArrayList<Dish>();
	JComboBox<String>  plats = new JComboBox<String>();
	JLabel label2  = new JLabel("ci dessous les plats à la carte de votre restaurant");
	JComboBox<String>  platsRestaurant = new JComboBox<String>();
	JButton addDishtoMenu = new JButton("ajouter ce plat au menu");
	JButton ok	= new JButton("ok");

	
	
	
	AddMenu(){
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		frameA.add(panA);
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameA.setTitle("ajouter un menu");
		frameA.setLocationRelativeTo(null);
		frameA.setSize(800, 400);
		panA.setLayout(new BoxLayout(panA,BoxLayout.PAGE_AXIS));
		panA.add(name);
		panA.add(type);
		panA.add(label);
		panA.add(plats);
		panA.add(label2);
		panA.add(platsRestaurant);
		for (Dish d: resto.getDishes())
			platsRestaurant.addItem(d.getName());
		panA.add(addDishtoMenu);
		addDishtoMenu.addActionListener(new AddDishtoMenu());
		panA.add(ok);
		ok.addActionListener(this);
		
	}
	void actionPerformed() throws InvalidFullMealException, InvalidHalfMealException{
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		
		
		switch(type.getSelectedIndex()){
		case 0:
			resto.addMeal(new FullMeal(name.getText(), platsMenu));	
		case 1:
			resto.addMeal(new HalfMeal(name.getText(), platsMenu));


			
		}	
		frameA.setVisible(false);
		JDialog dial = new JDialog();
		JLabel lab = new JLabel("menu ajouté à la carte");
		dial.add(lab);
		dial.setLocationRelativeTo(null);
		dial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dial.setVisible(true);
		menus.addItem(name.getText());
		
		}
		

}
