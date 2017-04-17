package GUI_restaurant;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Identification;
import Main.MyFoodora;

public class MainInterface implements ActionListener {
JFrame frame = new JFrame();
JPanel panel  = new JPanel(new FlowLayout());
JButton changemenu = new JButton("change the menu");
JButton changediscount = new JButton("change the discount factor");
JButton shippedorders = new JButton("voir les commandes");
JButton disconnect = new JButton("se déconnecter");

public MainInterface() {
	frame.setTitle("Interface Restaurant");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setSize(800, 400);
	panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
	frame.add(panel);
	panel.add(changemenu);
	panel.add(changediscount);
	panel.add(shippedorders);
	panel.add(disconnect);
	changemenu.addActionListener(new ChangeMenu());
	changediscount.addActionListener(new ChangeDiscount());
	shippedorders.addActionListener(new ShippedOrder());
	disconnect.addActionListener(this);
	frame.pack();
	frame.setVisible(true);
	}

public void actionPerformed(ActionEvent e){
	MyFoodora system = MyFoodora.getInstance();
	system.setConnectedUser(null);
	frame.setVisible(false);
	new Identification();
}
}
