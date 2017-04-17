package GUI_restaurant;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Food.Dish;
import Food.Meal;
import Main.MyFoodora;
import Users.Restaurant;

public class RemoveMenu extends ChangeMenu implements ActionListener {
public RemoveMenu(){
		
	}
	void actionPerformed(){
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		
		for (Meal m: resto.getMeals()){
			if(m.getName().equals(menus.getSelectedItem()))
				resto.removeMeal(m);
		}
		JDialog dial = new JDialog();
		JLabel lab = new JLabel("plat effacé de la carte");
		dial.add(lab);
		dial.setLocationRelativeTo(null);
		dial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dial.setVisible(true);
		menus.removeItem(menus.getSelectedItem());
		
		
	
	}


}
