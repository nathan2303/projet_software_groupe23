package Main;

import java.util.Scanner;

import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Manager;
import Users.Restaurant;
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
				while (system.getUsersList().containsKey(username)){
					System.out.println("Username already taken. Enter another username.");
					username = in.nextLine();
				}
				System.out.println("Enter your password.");
				String password = in.nextLine();
				System.out.println("Are you: 1. a manager? 2. a customer? 3. a restaurant? 4. a courier?");
				switch(in.nextInt()){
				case 1:
					User manager = new Manager(name,surname,username,password);
				case 2:
					System.out.println("Enter your adress x position");
					double x = in.nextDouble();
					System.out.println("Enter your adress y position");
					double y = in.nextDouble();
					Address adress = new Address(x,y);
					System.out.println("Enter your email adress");
					String emailAdress = in.nextLine();
					System.out.println("Enter your phone number");
					String phoneNumber = in.nextLine();
					
					User customer = new Customer(name, surname, username, password, adress, emailAdress, phoneNumber);
				case 3:
					System.out.println("Enter your adress x position");
					double xResto = in.nextDouble();
					System.out.println("Enter your adress y position");
					double yResto = in.nextDouble();
					Address adressResto = new Address(xResto,yResto);
					User restaurant = new Restaurant(name,username,password, adressResto);
				
				case 4:	
					System.out.println("Enter your adress x position");
					double xCourier = in.nextDouble();
					System.out.println("Enter your adress y position");
					double yCourier = in.nextDouble();
					Address adressCourier = new Address(xCourier,yCourier);
					System.out.println("Enter your phone number");
					String phoneNumberC = in.nextLine();
					User courier = new Courier(name, username,password,adressCourier, phoneNumberC);
					
					
					
				}
				
			}
			
		}
	}

}
