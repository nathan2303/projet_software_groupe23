package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.MyFoodora;
import Users.Manager;

public class ManagerRegistration implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField username = new JTextField("username",20);
	JButton enregistrer = new JButton("s'enregistrer");
	JTextField password = new JTextField("password",20);
	JTextField name = new JTextField("name",20);
	JTextField surname = new JTextField("surname",20);
	
	public ManagerRegistration() {
		frame.add(panel);
		frame.setTitle("entrez vos coordonnées");
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 600);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(name);
		panel.add(surname);
		panel.add(username);
		panel.add(password);
		panel.add(enregistrer);
		enregistrer.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		Manager m = new Manager(name.getText(), surname.getText(), username.getText(), password.getText());
		MyFoodora system = MyFoodora.getInstance();
		if (system.getUsersList().containsKey(username.getText()) == false){
			system.addUser(m);
			new Identification();
		frame.setVisible(false);
		}
		else{
			JDialog dialog = new JDialog();
			dialog.setTitle("nom d'utilisateur déjà utilisé");
			dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
