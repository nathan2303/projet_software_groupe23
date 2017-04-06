package Main;

import java.util.HashMap;
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
		ConfigInitiale.launch();
		boolean running = true;
		System.out.println("Welcome to MyFoodora!");
		while (running){
			System.out.println("Do you already have an account?");
			System.out.println("1 - Yes / 2 - No");
			int hasAccount = in.nextInt();
			if (hasAccount == 2){
				System.out.println("We will create your account. Please complete the fields below.");
				System.out.println("Enter your family name.");
				in.nextLine();
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
					Manager manager = new Manager(name,surname,username,password);
					System.out.println("Do you want to save your account ?");
					System.out.println("1 - Yes / 2 - No");
					int createAccount = in.nextInt();
					if (createAccount == 1){
						system.addUser(manager);
						System.out.println("Your account has been created. Please log in to enter the MyFoodora system.");
					}
					break;
				case 2:
					System.out.println("Enter your address x position");
					double x = in.nextDouble();
					System.out.println("Enter your address y position");
					double y = in.nextDouble();
					Address adress = new Address(x,y);
					System.out.println("Enter your email adress");
					String emailAdress = in.nextLine();
					System.out.println("Enter your phone number");
					String phoneNumber = in.nextLine();
					Customer customer = new Customer(name, surname, username, password, adress, emailAdress, phoneNumber);
					System.out.println("Do you want to receive notifications?");
					System.out.println("1 - Yes / 2 - No");
					switch(in.nextInt()){
					case 1:
						customer.registerAllNotifications();
						break;
					}
					
					System.out.println("Do you want to save your account ?");
					System.out.println("1 - Yes / 2 - No");
					int createAccount2 = in.nextInt();
					if (createAccount2 == 1){
						system.addUser(customer);
						System.out.println("Your account has been created. Please log in to enter the MyFoodora system.");
					}
					break;
				case 3:
					System.out.println("Enter your address x position");
					double xResto = in.nextDouble();
					System.out.println("Enter your address y position");
					double yResto = in.nextDouble();
					Address adressResto = new Address(xResto,yResto);
					Restaurant restaurant = new Restaurant(name,username,password, adressResto);
					System.out.println("Do you want to save your account ?");
					System.out.println("1 - Yes / 2 - No");
					int createAccount3 = in.nextInt();
					if (createAccount3 == 1){
						system.addUser(restaurant);
						System.out.println("Your account has been created. Please log in to enter the MyFoodora system.");
					}
					break;
				case 4:	
					System.out.println("Enter your address x position");
					double xCourier = in.nextDouble();
					System.out.println("Enter your address y position");
					double yCourier = in.nextDouble();
					Address adressCourier = new Address(xCourier,yCourier);
					System.out.println("Enter your phone number");
					String phoneNumberC = in.nextLine();
					Courier courier = new Courier(name, surname, username,password,adressCourier, phoneNumberC);
					System.out.println("Do you want to save your account ?");
					System.out.println("1 - Yes / 2 - No");
					int createAccount4 = in.nextInt();
					if (createAccount4 == 1){
						system.addUser(courier);
						System.out.println("Your account has been created. Please log in to enter the MyFoodora system.");
					}
					System.out.println("Are you on duty?");
					System.out.println("1 - Yes / 2 - No");
					switch(in.nextInt()){
					case 1:
						courier.setOnDuty(true);
						break;
					case 2:
						courier.setOnDuty(false);
						break;
					}
					break;
				default:
					System.out.println("Error. You should enter an integer btw 1 and 4.");
					break;				
				}
				
				
				
			}
			if (hasAccount == 1){
				System.out.println("We're glad you're back! Please enter your identifiers below.");
				System.out.println("Enter your username.");
				in.nextLine();
				String username = in.nextLine();
				while (!system.getUsersList().containsKey(username)){
					System.out.println("Username does not exist. Enter another username.");
					username = in.nextLine();
				}
				User user = system.getUsersList().get(username);
				System.out.println("Enter your password.");
				String password = in.nextLine();
				while (!password.equals(user.getPassword())){
					System.out.println("Your username and your password do not match. Please enter your password again.");
					password = in.nextLine();
				}
				System.out.println("You have successfully logged in. You are now connected to your MyFoodora account.");
				boolean connected = true;
				if (!system.getActivatedUsersList().containsKey(username)){
					System.out.println("Sorry, your account has been deactivated. Please contact a manager to get further help.");
					connected = false;
				}

				if (user instanceof Manager){
					Manager manager = (Manager)user;
					System.out.println("Welcome "+manager.getSurname()+" "+manager.getName()+"!");
					while (connected){
						System.out.println("What do you want to do?");
						System.out.println("0 - Disconnect");
						System.out.println("1 - Add user");
						System.out.println("2 - Remove user");
						System.out.println("3 - Activate user");
						System.out.println("4 - Deactivate user");
						System.out.println("5 - Change profit figure");
						System.out.println("6 - Compute profit or income");
						int answer = in.nextInt();
						switch(answer){
						case 0:
							System.out.println("You will be disconnected. Good-bye!");
							connected = false;
							break;
						
						}
					}
				}
				if (user instanceof Customer){
					Customer customer = (Customer)user;
					System.out.println("Welcome "+customer.getSurname()+" "+customer.getName()+"!");
					while (connected){
						System.out.println("What do you want to do?");
						System.out.println("0 - Disconnect");
						System.out.println("1 - Order a meal");
						switch(in.nextInt()){
						case 0:
							System.out.println("You will be disconnected. Good-bye!");
							connected = false;
							break;
						case 1:
							System.out.println("Here is the list of the restaurants:");
							HashMap<String, Restaurant> list = system.getRestaurantsList();
							for (String r : list.keySet()){
								System.out.println(r + ": "+list.get(r));
							}
							System.out.println("Type the username of the restaurant you want.");
							Restaurant chosenRestaurant = list.get(in.nextLine());
							System.out.println("Here is the menu 'à la carte' of the restaurant "+chosenRestaurant.getName());
							System.out.println(chosenRestaurant.getDishes());
						}
					}
				}	
			}
		}
	}
}
