package GUI_restaurant;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Food.Dish;
import Main.MyFoodora;
import Users.Restaurant;

public class RemoveDish extends ChangeMenu implements ActionListener {
	public RemoveDish(){
		
	}
	void actionPerformed(){
		MyFoodora system = MyFoodora.getInstance();
		Restaurant resto = new Restaurant();
		resto = (Restaurant) system.getConnectedUser();
		
		for (Dish dis: resto.getDishes()){
			if(dis.getName() == dishes.getSelectedItem())
				resto.removeDish(dis);
		}
		JDialog dial = new JDialog();
		JLabel lab = new JLabel("plat effacé de la carte");
		dial.add(lab);
		dial.setLocationRelativeTo(null);
		dial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dial.setVisible(true);
		dishes.removeItem(dishes.getSelectedItem());
		
		
	
	}

}
