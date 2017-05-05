package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Food.Dessert;
import Food.Dish;
import Food.DishType;
import Food.Food;
import Food.FullMeal;
import Food.HalfMeal;
import Food.InvalidFullMealException;
import Food.InvalidHalfMealException;
import Food.MainDish;
import Food.Meal;
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
	
	public static LinkedList<String> checkInbox(Customer customer){
		LinkedList<String> inbox = customer.getInbox();
		if(inbox.isEmpty()){
			System.out.println("Your inbox is empty!");
			return null;
		}
		else{
			System.out.println("You have " + inbox.size() + " unread messages. Please use 'readInbox' to check them.");
			return inbox;
		}
	}
	
	public static void executeCLUI(){
		Scanner in = new Scanner(System.in);
		MyFoodora system = MyFoodora.getInstance();
		ConfigInitiale.launch();
		boolean running = true;
		System.out.println("Welcome to MyFoodora! We are on " + new Date() +".");
		String[] command;
		String command2;
		String username;
		String password;
		double x;
		double y;
		while (running){
			System.out.println("You are on the home page. Please enter a command. We are on " + new Date() +".");
			command = in.nextLine().split(" ");
			switch(command[0]){
			case "goTomorrow":
				Date.goTomorrow();
				System.out.println("Good morning! We are on " + new Date());
				break;
			
			case "exit":
				running = false;
				System.out.println("Good-bye!");
				in.close();
				break;
			case "runTest":
				try{
					MainTest.executeScenario(command[1]);
				}
				catch(Exception e){
					System.out.println("There was a problem with the scenario text file. Sorry!");
				}
				break;
				
			case "createAccount":
				System.out.println("We will create your account. Please complete the fields below.");
				System.out.println("Enter your family name.");
				in.nextLine();
				String name = in.nextLine();
				System.out.println("Enter your surname.");
				String surname = in.nextLine();
				System.out.println("Enter your username.");
				username = in.nextLine();
				while (system.getUsersList().containsKey(username)){
					System.out.println("Username already taken. Enter another username.");
					username = in.nextLine();
				}
				System.out.println("Enter your password.");
				password = in.nextLine();
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
					x = in.nextDouble();
					System.out.println("Enter your address y position");
					y = in.nextDouble();
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
				
				break;
			case "login":
				System.out.println("We're glad you're back! Please enter your identifiers below.");
				System.out.println("Enter your username.");
				username = in.nextLine();
				while (!system.getUsersList().containsKey(username)){
					System.out.println("Username does not exist. Enter another username.");
					username = in.nextLine();
				}
				User user = system.getUsersList().get(username);
				System.out.println("Enter your password.");
				password = in.nextLine();
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
					System.out.println("\n--------------NEW MANAGER SESSION--------------\n"+"Welcome "+manager.getSurname()+" "+manager.getName()+"! You are a manager.");
					while (connected){
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							System.out.println("\n--------------MANAGER SESSION CLOSED--------------\n");
							break;
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
							try{
							x = Integer.parseInt(command[2].split(",")[0]);
							y = Integer.parseInt(command[2].split(",")[1]);
							Restaurant r4 = new Restaurant(command[1],command[3],command[4],new Address(x,y));
							manager.addUser(r4);
							}
							catch(Exception e){
								System.out.println("You entered a wrong command. Please remember to put the arguments in the appropriate order.");
							}
							break;
						case "registerCustomer":
							try{
							x = Integer.parseInt(command[4].split(",")[0]);
							y = Integer.parseInt(command[4].split(",")[1]);
							Customer c4 = new Customer(command[2],command[1],command[3],command[5]);
							manager.addUser(c4);
							}
							catch(Exception e){
								System.out.println("You entered a wrong command. Please remember to put the arguments in the appropriate order.");
							}
							break;
						case "registerCourier":
							try{
							x = Integer.parseInt(command[4].split(",")[0]);
							y = Integer.parseInt(command[4].split(",")[1]);
							Courier c5 = new Courier(command[2],command[1],command[3],command[5]);
							manager.addUser(c5);
							}
							catch(Exception e){
								System.out.println("You entered a wrong command. Please remember to put the arguments in the appropriate order.");
							}
							break;
						case "setDeliveryPolicy":
							try{
								switch(command[1].toLowerCase()){
								case "fairoccupationdelivery":
									system.setDeliveryPolicy(new FairOccupationDelivery());
									break;
								case "fastestdelivery":
									system.setDeliveryPolicy(new FastestDelivery());
									break;
								default:
									System.out.println("You entered a wrong command.");
								}
							}
							catch(Exception e){
								System.out.println(e.getMessage());
								System.out.println("You entered a wrong command. Please specify the name of the policy.");
							}
						case "setProfitPolicy":
							try{
							switch(command[1].toLowerCase()){
							case "targetprofit_deliverycost":
								system.setProfitPolicy(new TargetProfit_DeliveryCost(Double.parseDouble(command[2]), Double.parseDouble(command[3]), Double.parseDouble(command[4])));
								break;
							case "targetprofit_markup":
								system.setProfitPolicy(new TargetProfit_Markup(Double.parseDouble(command[2]), Double.parseDouble(command[3]), Double.parseDouble(command[4])));
								break;
							case "targetprofit_servicefee":
								system.setProfitPolicy(new TargetProfit_ServiceFee(Double.parseDouble(command[2]), Double.parseDouble(command[3]), Double.parseDouble(command[4])));
								break;
							default:
								System.out.println("You entered a wrong command. ");
							}}
							catch(Exception e){
								System.out.println(e.getMessage());
								System.out.println("You entered a wrong command. Please specify the name of the policy.");
							}
						case "associateCard":
							try{
							switch(command[2].toLowerCase()){
							case "basicfidelitycard":
								system.getCustomersList().get(command[1]).unregisterFidelityCard(system.getRestaurantsList().get(command[3]));
								break;
							case "pointfidelitycard":
								system.getCustomersList().get(command[1]).registerPointFidelityCard(system.getRestaurantsList().get(command[3]));
								break;
							case "lotteryfidelitycard":
								system.getCustomersList().get(command[1]).registerLotteryFidelityCard(system.getRestaurantsList().get(command[3]));
								break;
							default:
								System.out.println("You entered a wrong command.");
							}}
							catch(Exception e){
								System.out.println(e.getMessage());
								System.out.println("You entered a wrong command.");
							}
							
						case "goTomorrow":
							Date.goTomorrow();
							System.out.println("Good morning! We are on " + new Date());
							break;
						case "showTotalProfit":
							try{
								String[] date1_string = command[1].split("/");
								Date date1 = new Date(Integer.parseInt(date1_string[0]), Integer.parseInt(date1_string[1]));
								String[] date2_string = command[2].split("/");
								Date date2 = new Date(Integer.parseInt(date2_string[0]), Integer.parseInt(date2_string[1]));
								System.out.println("Total profit from " + date1 + " to " + date2 + ": " + manager.computeProfit(date1, date2));
							}
							catch(Exception e){
								System.out.println("Total profit: " + manager.computeTotalProfit());
							}
							
							break;
						case "showCourierDeliveries":
							manager.determineMostLessActiveCourier();
							break;
						case "showRestaurantTop":
							manager.determineMostLessSellingRestaurant();
							break;
						case "showCustomers":
							System.out.println("\nLIST OF REGISTERED CUSTOMERS");
							System.out.println(system.getCustomersList());
							System.out.println("---------------");
							break;
						case "showMenuItem":
							Restaurant current_restaurant = system.getRestaurantsList().get(command[1]);
							System.out.println("\nMENU OF THE RESTAURANT " + current_restaurant);
							System.out.println(current_restaurant.getItems().values()+"\n");
							System.out.println("---------------");
							break;
						case "help":
							System.out.println("Available commands: logout, show customers, show orders, show restaurants, show couriers, show all, registerCustomer, registerCourier, registerRestaurant");
							System.out.println("showTotalProfit");
							System.out.println("showTotalProfit <startDate> <endDate>");
							System.out.println("showCustomers");
							System.out.println("showMenuItem");
							System.out.println("CourierDeliveries");
							System.out.println("RestaurantTop");
							break;
						default:
							System.out.println("You entered a wrong command. Please use 'help'.");
							break;
						
						}
					}
				}
				if (user instanceof Customer){
					Customer customer = (Customer)user;
					System.out.println("\n--------------NEW CUSTOMER SESSION--------------\nWelcome "+customer.getSurname()+" "+customer.getName()+"!");
					System.out.println("\nHere is the list of restaurants.");
					System.out.println(system.getRestaurantsList());
					System.out.println();
					LinkedList<String> inbox = MainTest.checkInbox(customer);
					while (connected){
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							System.out.println("\n--------------CUSTOMER SESSION CLOSED--------------\n");
							break;
						case "readInbox":
							if(inbox == null)
								System.out.println("You don't have any unread messages!");
							else{
								while(!inbox.isEmpty()){
									System.out.println(inbox.pop());
								}
								System.out.println("This was your last unread message for today.");
							}
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
					System.out.println("\n--------------NEW RESTAURANT SESSION--------------\n"+"Welcome "+restaurant.getName()+"! Here is your menu:");
					System.out.println(restaurant.getDishes());
					System.out.println(restaurant.getMeals());
					while (connected){
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							System.out.println("\n--------------RESTAURANT SESSION CLOSED--------------\n");
							break;
						case "addDishRestaurantMenu":
							try{
							switch(command[2].toLowerCase()){
							case "starter":
								Starter starter = new Starter(Double.parseDouble(command[4]), command[1], DishType.valueOf(command[3].toUpperCase().charAt(0)+command[3].toLowerCase().substring(1, command[3].length())));
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
							}
							catch(Exception e){
								System.out.println("You entered a wrong command. Remember to type the arguments in the appropriate order.");
							}
							break;
						case "createMeal":
							System.out.println("Interface not yet implemented. Please try later (part 2).");
							String mealName = null;
							try{
								mealName = command[1];
							}
							catch(Exception e){
								System.out.println("ERROR!");
								System.out.println("Please enter a one-word meal name after the command 'createMeal'.");
								break;
							}
							boolean creatingMeal = true;
							ArrayList<Dish> dishList = new ArrayList<>();
							while (creatingMeal){
								String[] commandMeal = in.nextLine().split(" ");
								switch(commandMeal[0]){
								case "addDish2Meal":
									command2 = commandMeal[1];
									for (int i=2;i<=command.length;i++){
										command2+=" " + commandMeal[i];
										}
									dishList.add((Dish)restaurant.getItems().get(command2));
									break;
								case "showMeal":
									System.out.println(dishList);
									break;
								case "saveMeal":
									creatingMeal=false;
									switch(dishList.size()){
									case(3):
										try{
											restaurant.addMeal(new FullMeal(mealName, dishList));
										}
										catch(InvalidFullMealException e){
											System.out.println("ERROR!");
											System.out.println(e.getMessage());
										}
										
										break;
									case(2):
										try{
											restaurant.addMeal(new HalfMeal(mealName, dishList));
										}
										catch(InvalidHalfMealException e){
											System.out.println("ERROR!");
											System.out.println(e.getMessage());
										}
										
										break;
									default:
										System.out.println("ERROR!");
										System.out.println("You entered a wrong number of dishes in your meal ");
										break;
									}
									break;
								case "help":
									System.out.println("Available commands:");
									System.out.println("addDish2Meal <dishName>");
									System.out.println("showMeal");
									System.out.println("saveMeal");
									break;
								default:
									System.out.println("You entered a wrong command. Please use 'help'.");
									break;
								}
							}
							
							break;
						case "setSpecialOffer":
							try{
							command2 = command[1];
							for (int i=2;i<command.length;i++){
								command2+=" " + command[i];
								}
							restaurant.addMealOfTheWeek((Meal)restaurant.getItems().get(command2));
							}
							catch(Exception e){
								System.out.println("You entered a wrong command. Remember to put the name of the meal you want to put in the special offers.");
							}
							break;
						case "removeFromSpecialOffer":
							command2 = command[1];
							try{
								for (int i=2;i<command.length;i++){
									command2+=" " + command[i];
									}
								restaurant.removeMealOfTheWeek((Meal)restaurant.getItems().get(command2));
							}
							catch(Exception e){
								System.out.println("You entered a wrong command. Remember to put the name of the meal you want to remove from the special offers.");
							}
							break;
						case "showSpecialOffer":
							System.out.println(restaurant.getMealsOfTheWeek());
							break;
						case "help":
							System.out.println("Available commands for a restaurant:");
							System.out.println("logout");
							System.out.println("addDishRestaurantMenu <dishName> <dishCategory> <foodCategory> <unitPrice>");
							System.out.println("createMeal<mealName>");
							System.out.println("setSpecialOffer <mealName>, removeSpecialOffer <mealName>, showSpecialOffer");
							break;
						default:
							System.out.println("You entered a wrong command. Please use the command 'help'.");
							break;
						}
					}	
				}
				if (user instanceof Courier){
					Courier courier = (Courier)user;
					System.out.println("\n--------------NEW COURIER SESSION--------------\n"+"Welcome "+courier.getName()+"! We have work for you!");
					while (connected){
						System.out.println("Enter a command.");
						command = in.nextLine().split(" ");
						switch(command[0]){
						case "logout":
							connected = false;
							System.out.println("\n--------------COURIER SESSION CLOSED--------------\n");
							break;
						case "onDuty":
							courier.setOnDuty(true);
							break;
						case "offDuty":
							courier.setOnDuty(false);
							break;
						case "help":
							System.out.println("Available commands: logout, onDuty, offDuty");
							break;
						default:
							System.out.println("You entered a wrong command. Please use the command 'help'.");
							break;
						}
					}
				}
				break;
			case "help":
				System.out.println("Available commands:");
				System.out.println("login");
				System.out.println("createAccount");
				System.out.println("goTomorrow");
				System.out.println("exit");
				break;
			
			default:
				System.out.println("You entered a wrong command. Please use'help'.");
				break;
				
		}
			
	}
}
	
	public static void executeScenario(String fileName){
		  FileReader file = null;
		  BufferedReader reader = null;
		  LinkedList<String> returnValue = new LinkedList<>();
		  
		  try {
			  // open input stream pointing at fileName
			  file = new FileReader(fileName);
			  
			  // open input buffered reader to read file line by line
			  reader = new BufferedReader(file);
			  String line = "";
			  
			  

			  
			  // reading input file line by line
			  while ((line = reader.readLine()) != null) {
				  returnValue.add(line);
			  }

		  } catch (Exception e) {
		      throw new RuntimeException(e);
		  } 			
		  finally {
			    if (file != null) {
			      try {
			        file.close();
			        reader.close();
			       
			      } catch (IOException e) {
			    	  System.out.println("File not found: " + fileName);
			        // Ignore issues during closing 
			      }
			    }
			  }

	}
	
	/**
	 * runs a first command line like test. Fulfills the basic requirements of the program
	 * @param args
	 */

	public static void main(String[] args) {
		MainTest.executeCLUI();
		
	}
}
