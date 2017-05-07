package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Food.Dessert;
import Food.DishType;
import Food.Food;
import Food.MainDish;
import Food.Meal;
import Food.Order;
import Food.Starter;
import Policies.FairOccupationDelivery;
import Policies.FastestDelivery;
import Policies.TargetProfit_DeliveryCost;
import Policies.TargetProfit_Markup;
import Policies.TargetProfit_ServiceFee;
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
	
	/**
	 * runs a first command line like test. Fulfills the basic requirements of the program
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MyFoodora system = MyFoodora.getInstance();
		ConfigInitiale.launch();
		boolean running = true;
		System.out.println("Welcome to MyFoodora! We are on " + new Date() +".");
		String[] command;
		String command2;
		while (running){
			System.out.println("You are on the home page. Do you already have an account?");
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
					in.nextLine();
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
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							break;
						case "showRestaurantTop":
							
						case "show":
							switch(command[1].toLowerCase()){
							case "orders":
								System.out.println("\nHISTORY OF ORDERS");
								System.out.println(system.getCompletedOrders());
								System.out.println("---------------");
								break;
							case "customers":
								System.out.println("\nLIST OF REGISTERED CUSTOMERS");
								System.out.println(system.getCustomersList());
								System.out.println("---------------");
								break;
							case "restaurants":
								System.out.println("\nLIST OF REGISTERED RESTAURANTS AND THEIR MENU");
								for (Restaurant r : system.getRestaurantsList().values()){
									System.out.println(r.getName());
									System.out.println(r.getItems().values()+"\n");
								}
								System.out.println("---------------");
								break;
							case "couriers":
								System.out.println("\nLIST OF REGISTERED COURIERS");
								System.out.println(system.getCouriersList());
								System.out.println("---------------");
								break;
							case "all":
								System.out.println("\nHISTORY OF ORDERS");
								System.out.println(system.getCompletedOrders());
								System.out.println("---------------");
								System.out.println("\nLIST OF REGISTERED CUSTOMERS");
								System.out.println(system.getCustomersList());
								System.out.println("---------------");
								System.out.println("\nLIST OF REGISTERED RESTAURANTS AND THEIR MENU");
								for (Restaurant r : system.getRestaurantsList().values()){
									System.out.println(r.getName());
									System.out.println(r.getItems().values()+"\n");
								}
								System.out.println("---------------");
								System.out.println("\nLIST OF REGISTERED COURIERS");
								System.out.println(system.getCouriersList());
								System.out.println("---------------");
								break;								
							default:
								System.out.println("You entered a wrong command. Please use the command 'help'.");
								break;
								
							}
							break;
						case "registerRestaurant":
							double x = Integer.parseInt(command[2].split(",")[0]);
							double y = Integer.parseInt(command[2].split(",")[1]);
							Restaurant r4 = new Restaurant(command[1],command[3],command[4],new Address(x,y));
							System.out.println("The restaurant "+ command[1] + "has been registered");
							manager.addUser(r4);
							break;
						case "registerCustomer":
							x = Integer.parseInt(command[4].split(",")[0]);
							y = Integer.parseInt(command[4].split(",")[1]);
							Customer c4 = new Customer(command[2],command[1],command[3],command[5]);
							System.out.println("The customer"+ command[1] + " "+ command[2] + " has been registered");
							manager.addUser(c4);
							break;
						case "registerCourier":
							x = Integer.parseInt(command[4].split(",")[0]);
							y = Integer.parseInt(command[4].split(",")[1]);
							Courier c5 = new Courier(command[2],command[1],command[3],command[5]);
							manager.addUser(c5);
							System.out.println("The courier"+ command[1] + " "+ command[2] + " has been registered");
							break;
						case "goTomorrow":
							Date.goTomorrow();
							System.out.println("Good morning! We are on " + new Date());
							break;
						case "showTotalProfit":
							if (command.length == 1)
								System.out.println("Total profit: " + manager.computeTotalProfit());
							else{
								try{
								int x1 = Integer.parseInt(command[1].split(",")[0]);
								int y1 = Integer.parseInt(command[1].split(",")[1]);
								int x2 = Integer.parseInt(command[2].split(",")[0]);
								int y2 = Integer.parseInt(command[2].split(",")[1]);
								Date d1 = new Date(x1,y1);
								Date d2 = new Date(x2,y2);
								System.out.println("Total profit from "+ d1.toString() + " to " + d2.toString()+ " : " + String.valueOf(manager.computeProfit(d1, d2)));
								}
								catch(Exception e){
									System.out.println("You entered wrong arguments: showTotalProfit <jour,mois> <jour,mois>");
								}
								}
								
						
							break;
						case "setDeliveryPolicy":
							switch(command[1]){
							case "fastestDelivery":
								system.setDeliveryPolicy(new FastestDelivery());
								System.out.println("Delivery policy changed to fastest delivery policy");
								break;
							case "fairOccupationDelivery":
								system.setDeliveryPolicy(new FairOccupationDelivery());
								System.out.println("Delivery policy changed to fair occupation delivery policy");
								break;
							default:
								System.out.println("You entered a delivery policy which doesn't exist! Available policies are fastestDelivery and fairOccupationDelivery");
								break;
							
							}
						case "setProfitPolicy":
							try{ switch(command[1]){
								case "deliveryCost":
									system.setProfitPolicy(new TargetProfit_DeliveryCost(Double.parseDouble(command[2]), Double.parseDouble(command[3]), Double.parseDouble(command[3])));
									System.out.println("Target profit policy changed to delivery cost policy");
									break;
								case "markUp":
									system.setProfitPolicy(new TargetProfit_Markup(Double.parseDouble(command[2]), Double.parseDouble(command[3]), Double.parseDouble(command[3])));
									System.out.println("Target profit policy changed to markup policy");
									break;
								case "serviceFee":
									system.setProfitPolicy(new TargetProfit_ServiceFee(Double.parseDouble(command[2]), Double.parseDouble(command[3]), Double.parseDouble(command[3])));
									System.out.println("Target profit policy changed to service fee policy");
									break;
								default:
									System.out.println("You entered a profit policy which doesn't exist! Available policies are deliveryCost, markUp, serviceFee");
									break;
								}}
							
							catch(Exception e){
								System.out.println("You entered wrong arguments: setProfitPolicy <policyName> <double> <double> <double>");
								
							}
							break;
						case "associateCard":
							try{
								Restaurant r = system.getRestaurantsList().get(command[3]);
								Customer c = system.getCustomersList().get(command[1]);
								manager.associateCard(c, r, command[2]);
								}
							catch(Exception e){
								System.out.println("You entered wrong arguments. associateCard <customerName> <point or fidelity><restaurant>");
								
							}
							break;
								
						case "help":
							System.out.println("Available commands: logout, show customers, show orders, show restaurants, show couriers, show all, registerCustomer, registerCourier, registerRestaurant, goTomorrow, setDeliveryPolicy, setProfitPolicy");
							break;
						default:
							System.out.println("You entered a wrong command. Please use 'help'");
							break;
						
						}
					}
				}
				if (user instanceof Customer){
					Customer customer = (Customer)user;
					System.out.println("Welcome "+customer.getSurname()+" "+customer.getName()+"!");
					System.out.println("Here is the list of restaurants.");
					System.out.println(system.getRestaurantsList());
					while (connected){
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							break;
						case "createOrder":
							Restaurant restaurant = system.getRestaurantsList().get(command[1]);
							ArrayList<Food> content = new ArrayList<>();
							System.out.println("Here is the menu of "+restaurant.getName());
							System.out.println(restaurant.getDishes());
							System.out.println(restaurant.getMeals());
							boolean ordering = true;
							while (ordering){
								command = in.nextLine().split(" ");
								if (command[0].equals("endOrder")){
									ordering = false;
									break;}
								command2 = command[1];
								for (int i=2;i<command.length;i++){
									command2+=" " + command[i];
									}
								content.add(restaurant.getItems().get(command2));							
							}
							System.out.println(content);
							customer.order(content,restaurant);
							break;
						case "help":
							System.out.println("Available commands for a customer:");
							System.out.println("logout");
							System.out.println("createOrder <restaurant>");
							break;
						default:
							System.out.println("You entered a wrong command. Please use the command 'help'.");
							break;
						}
					
					}	
				}	
				if (user instanceof Restaurant){
					Restaurant restaurant = (Restaurant)user;
					System.out.println("Welcome "+restaurant.getName()+"! Here is your menu:");
					System.out.println(restaurant.getDishes());
					System.out.println(restaurant.getMeals());
					while (connected){
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							break;
						case "addDishRestaurantMenu":
							switch(command[2].toLowerCase()){
							case "starter":
								Starter starter = new Starter(Double.parseDouble(command[4]), command[1], DishType.valueOf(command[3]));
								restaurant.addDish(starter);
								break;
							case "main":
								MainDish maindish = new MainDish(Double.parseDouble(command[4]), command[1], DishType.valueOf(command[3]));
								restaurant.addDish(maindish);
								break;
							case "dessert":
								Dessert dessert = new Dessert(Double.parseDouble(command[4]), command[1], DishType.valueOf(command[3]));
								restaurant.addDish(dessert);
								break;
							default:
								System.out.println("Please enter one of the following food categories: starter, main or dessert.");
						}
							break;
						case "createMeal":
							System.out.println("Interface not yet implemented. Please try later (part 2).");
							break;
						case "setSpecialOffer":
							command2 = command[1];
							for (int i=2;i<command.length;i++){
								command2+=" " + command[i];
								}
							restaurant.addMealOfTheWeek((Meal)restaurant.getItems().get(command2));
							break;
						case "removeFromSpecialOffer":
							command2 = command[1];
							for (int i=2;i<command.length;i++){
								command2+=" " + command[i];
								}
							restaurant.removeMealOfTheWeek((Meal)restaurant.getItems().get(command2));
							break;
						case "findDeliverer":
							Order o = null;
							for ( Order i: restaurant.getShippedOrders())
								if (i.getId() == Integer.parseInt( command[1]))
										o = i;
							Courier c = o.findCourier();
							if ( c == null)
								System.out.println("MyFoodora could not find any available courier to ship your order. Please try again later");
							else
								System.out.println("Your order has been processed. The courier is" + c.getName());
							
								
							
							
						case "help":
							System.out.println("Available commands for a customer:");
							System.out.println("logout");
							System.out.println("addDishRestaurantMenu <dishName> <dishCategory> <foodCategory> <unitPrice>");
							System.out.println("createMeal");
							System.out.println("setSpecialOffer <mealName>, removeSpecialOffer <mealName>");
							System.out.println("findDeliverer <orderName>");
							break;
						default:
							System.out.println("You entered a wrong command. Please use the command 'help'.");
							break;
						}
					}	
				}
				if (user instanceof Courier){
					Courier courier = (Courier)user;
					System.out.println("Welcome "+courier.getName()+"! We have work for you!");
					while (connected){
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							break;
						case "onDuty":
							courier.setOnDuty(true);
							System.out.println("You're on duty!");
							break;
						case "offDuty":
							courier.setOnDuty(false);
							System.out.println("You're off duty!");
							break;
						case "help":
							System.out.println("Available commands: logout, onDuty, offDuty");
						default:
							System.out.println("You entered a wrong command. Please use the command 'help'.");
							break;
						}
					}
				}		
			}
		}
	}
}
