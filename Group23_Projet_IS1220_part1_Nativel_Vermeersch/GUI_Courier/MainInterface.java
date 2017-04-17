package GUI_Courier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Identification;
import Main.MyFoodora;
import Users.Courier;

public class MainInterface implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel actualStatus;
	JButton changeStatus = new JButton("Changer son statut");
	JButton changePosition = new JButton("Changer sa position");
	JLabel orderstoconfirm = new JLabel("vous n'avez pas de nouvelle commande");
	JButton disconnect = new JButton("se déconnecter");
	
	public MainInterface() {
		MyFoodora system = MyFoodora.getInstance();
		Courier cour = new Courier();
		cour = (Courier) system.getConnectedUser();
		frame.add(panel);
		frame.setTitle("Bienvenue"+ cour.getName());
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 600);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(actualStatus);
		if (cour.isOnDuty())
			actualStatus.setText("Vous êtes en service");
		else
			actualStatus.setText("Vous êtes en repos");
		panel.add(changeStatus);
		panel.add(changePosition);
		panel.add(orderstoconfirm);
		panel.add(disconnect);
		changeStatus.addActionListener(this);
		changePosition.addActionListener(this);
		disconnect.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		MyFoodora system = MyFoodora.getInstance();
		Courier cour = new Courier();
		cour = (Courier) system.getConnectedUser();
		if (e.getSource()== changeStatus){
			if (cour.isOnDuty()){
				cour.setOnDuty(false);
				actualStatus.setText("Vous êtes en service");
			}
			else{
				cour.setOnDuty(true);
				actualStatus.setText("Vous êtes en service");
			}
		}
		else if (e.getSource() == changePosition){
			frame.setVisible(false);
			new ChangePosition();
		}
		else if (e.getSource() == disconnect){
			system.setConnectedUser(null);
			frame.setVisible(false);
			new Identification();
		}
	}
}
