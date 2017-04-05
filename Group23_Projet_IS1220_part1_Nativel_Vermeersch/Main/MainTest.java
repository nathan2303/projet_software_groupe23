package Main;

import java.util.Scanner;

import Users.Manager;
import Users.User;

public class MainTest {
	
	

	public MainTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MyFoodora system = MyFoodora.getInstance();
		boolean running = true;
		System.out.println("Welcome to MyFoodora!");
		while (running){
			System.out.println("Do you already have an account?");
			System.out.println("1 - Yes / 2 - No");
			int hasAccount = in.nextInt();
			if (hasAccount == 1){
				System.out.println("Enter your family name.");
				String name = in.nextLine();
				System.out.println("Enter your surname.");
				String surname = in.nextLine();
				System.out.println("Enter your username.");
				String username = in.nextLine();
				while (system.getUsersList())
				System.out.println("Enter your password.");
				String password = in.nextLine();
				System.out.println("Are you: 1. a manager? 2. a customer? 3. a restaurant? 4. a courier?");
				switch(in.nextInt()){
				case 1:
					User manager = new Manager
					
					
				}
				
			}
			
		}
	}

}
