package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnregistrerListener implements ActionListener{
	EnregistrerListener(){}
	
	public void actionPerformed(ActionEvent e){
		new Registration();
	}
	
	

}
