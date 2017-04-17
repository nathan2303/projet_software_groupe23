package GUI_restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Food.Dish;
import Main.MyFoodora;
import Users.Restaurant;

public class AddDishtoMenu extends AddMenu implements ActionListener{
	AddDishtoMenu(){
		
	}
	public void actionPerformed(ActionEvent e){
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		for(Dish d: resto.getDishes() )
			if (d.getName().equals( platsRestaurant.getSelectedItem())){
				
				plats.addItem(d.getName());
				platsMenu.add(d);
			}
	}
}
