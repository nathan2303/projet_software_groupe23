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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Food.Dessert;
import Food.Dish;
import Food.DishType;
import Food.MainDish;
import Food.Starter;
import Main.MyFoodora;
import Users.Restaurant;

public class AddDish extends ChangeMenu implements ActionListener{
	JFrame frameA = new JFrame();
	JPanel panA = new JPanel();
	JTextField name = new JTextField("nom",20);
	JTextField price = new JTextField("prix",20);
	String[] dishTypes = {"entrée","plat principal","dessert"};
	JComboBox<String>  type = new JComboBox<String>(dishTypes);
	String[] dishTypes2 = {"Standard","Vegetarian",
			"GlutenFree",
			"VegetarianAndGlutenFree"};
	JComboBox<String>  type2 = new JComboBox<String>(dishTypes2);
	
	JButton ok	= new JButton("ok");
	DishType d;
	
	
	
	AddDish(){
		frameA.add(panA);
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameA.setTitle("ajouter un plat");
		frameA.setLocationRelativeTo(null);
		frameA.setSize(800, 400);
		panA.setLayout(new BoxLayout(dish,BoxLayout.PAGE_AXIS));
		panA.add(name);
		panA.add(price);
		panA.add(type);
		panA.add(type2);
		panA.add(ok);
		ok.addActionListener(this);
		
	}
	void actionPerformed(){
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		double pri = Double.parseDouble(price.getText());
		switch(type2.getSelectedIndex()){
		case 0:
			d = DishType.Standard;
		case 1:
			d = DishType.Vegetarian;
		case 2:
			d = DishType.GlutenFree;
		case 3:
			d = DishType.VegetarianAndGlutenFree;
		}
		switch(type.getSelectedIndex()){
		case 0:
			resto.addDish(new Starter(pri,name.getText(),d));
		
		case 1:
			resto.addDish(new MainDish(pri,name.getText(),d));
		case 2:
			resto.addDish(new Dessert(pri,name.getText(),d));
			
		}	
		frameA.setVisible(false);
		JDialog dial = new JDialog();
		JLabel lab = new JLabel("plat ajouté à la carte");
		dial.add(lab);
		dial.setLocationRelativeTo(null);
		dial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dial.setVisible(true);
		dishes.addItem(name.getText());
		
		}
		
	
}