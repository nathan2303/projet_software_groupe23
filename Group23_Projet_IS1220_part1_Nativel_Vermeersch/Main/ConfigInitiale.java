package Main;

import java.util.ArrayList;
import java.util.HashMap;

import Fidelity.PointFidelityCard;
import Food.Dessert;
import Food.DishType;
import Food.Food;
import Food.FullMeal;
import Food.HalfMeal;
import Food.MainDish;
import Food.Meal;
import Food.Starter;
import Policies.FastestDelivery;
import Users.Courier;
import Users.Customer;
import Users.Manager;
import Users.Restaurant;


public class ConfigInitiale  {
	
	
	private static MyFoodora system = MyFoodora.getInstance();
	
	public ConfigInitiale(){
		
	}
	
	
	public static void launch(){
		
		// creating new couriers
		ArrayList<String[]> list1 = new ArrayList<>();
		list1.add(new String[]{"Dupont","Jean"});
		list1.add(new String[]{"Dubois","Cyprien"});
		list1.add(new String[]{"Duparcq","Charles"});
		list1.add(new String[]{"Dumarais","Elodie"});
		list1.add(new String[]{"Ducrocq","Laure"});
		list1.add(new String[]{"Dujardin","Marie"});
		list1.add(new String[]{"Duhem","Edouard"});
		list1.add(new String[]{"Ducatteau","Isidore"});
		list1.add(new String[]{"Duval","Gonzague"});
		list1.add(new String[]{"Dupond","Chloe"});
		for (String[] i : list1){
			system.addUser(new Courier(i[0],i[1],i[1].toLowerCase().charAt(0)+i[0].toLowerCase(),"1234"));
		}
		
		// creating new restaurants
		ArrayList<String[]> list2 = new ArrayList<>();
		list2.add(new String[]{"Chez Marie","chezmarie"});
		list2.add(new String[]{"Le delice des papilles","delice"});
		list2.add(new String[]{"Traiteur asiatique","asiat"});
		list2.add(new String[]{"Pizzeria Paradise","pizzaparadise"});
		list2.add(new String[]{"Cuisines du monde","monde"});
		for (String[] i : list2){
			system.addUser(new Restaurant(i[0],i[1],"1234"));
		}
		
		// creating new customers
		ArrayList<String[]> list3 = new ArrayList<>();
		list3.add(new String[]{"Delalande","Heloise"});
		list3.add(new String[]{"Delaville","Eloi"});
		list3.add(new String[]{"Decagny","Baptiste"});
		list3.add(new String[]{"De Montmartre","Romain"});
		list3.add(new String[]{"Delabruyere","Hector"});
		list3.add(new String[]{"Deffontaines","Quentin"});
		list3.add(new String[]{"Degardin","Julie"});
		list3.add(new String[]{"Desjonqueres","Faustin"});
		list3.add(new String[]{"Descamps","Diane"});
		list3.add(new String[]{"Defossez","Ursule"});
		for (String[] i : list3){
			system.addUser(new Customer(i[0],i[1],i[1].toLowerCase().charAt(0)+i[0].toLowerCase(),"1234"));
		}
		// special customer whose birthday is on the 3rd of April 2017
		system.addUser(new Customer("Delachance","Félicien","fdelachance","1234",new Date(11,4)));
		// registering some customers to notifications
		system.getCustomersList().get("hdelalande").registerAllNotifications();
		system.getCustomersList().get("edelaville").registerAllNotifications();
		system.getCustomersList().get("fdelachance").registerAllNotifications();
		
		// creating new managers
		system.addUser(new Manager("Gates","Bill", "ceo","123456789"));
		system.addUser(new Manager("Vermeersch","Nathan", "nver","1234"));
		system.addUser(new Manager("Nativel","Quentin", "qnat","1234"));
		
		//setting DeliveryPolicy (no delivery policy by default!)
		system.setDeliveryPolicy(new FastestDelivery());
		
		// creating food
		Starter starter1 = new Starter(10, "Smoked salmon", DishType.Standard);
		Starter starter2 = new Starter(8, "Ceasar salad", DishType.Standard);
		Starter starter3 = new Starter(5, "Thai soup", DishType.Standard);
		Starter starter4 = new Starter(6, "Green salad", DishType.Vegetarian);
		Starter starter5 = new Starter(4, "Antipasti", DishType.Vegetarian);
		Starter starter6 = new Starter(3.5, "Nem", DishType.Standard);
		
		MainDish maindish1 = new MainDish(10, "Vegetarian pizza", DishType.Vegetarian);
		MainDish maindish2 = new MainDish(20, "Risotto", DishType.Standard);
		MainDish maindish3 = new MainDish(8, "Beef with onions", DishType.Standard);
		MainDish maindish4 = new MainDish(5, "Fried potatoes", DishType.Vegetarian);
		MainDish maindish5 = new MainDish(14, "Goulach", DishType.Vegetarian);
		MainDish maindish6 = new MainDish(6, "Fried noodles", DishType.Vegetarian);
		MainDish maindish7 = new MainDish(13, "Pepperoni pizza", DishType.Standard);
		
		Dessert dessert1 = new Dessert(8, "Tiramisu", DishType.Vegetarian);
		Dessert dessert2 = new Dessert(6, "Fruit salad", DishType.Vegetarian);
		Dessert dessert3 = new Dessert(4, "Coco pearls", DishType.Vegetarian);
		Dessert dessert4 = new Dessert(7, "Panna cotta", DishType.Vegetarian);
		Dessert dessert5 = new Dessert(5, "Apple crumble", DishType.Vegetarian);
		Dessert dessert6 = new Dessert(3, "Bean icecream", DishType.Vegetarian);
		
		// adding food to restaurants 
		HashMap<String, Restaurant> map1 = system.getRestaurantsList();
		Restaurant r1 =map1.get("chezmarie");
		r1.addDish(starter1);
		r1.addDish(starter4);
		r1.addDish(maindish4);
		r1.addDish(dessert5);
		r1.addDish(dessert2);
		
		Restaurant r2 =map1.get("delice");
		r2.addDish(starter1);
		r2.addDish(starter2);
		r2.addDish(maindish4);
		r2.addDish(maindish2);
		r2.addDish(dessert5);
		r2.addDish(dessert2);
		
		Restaurant r3 =map1.get("asiat");
		r3.addDish(starter3);
		r3.addDish(starter6);
		r3.addDish(maindish3);
		r3.addDish(maindish6);
		r3.addDish(dessert3);
		r3.addDish(dessert6);
		
		Restaurant r4 =map1.get("pizzaparadise");
		r4.addDish(starter4);
		r4.addDish(starter5);
		r4.addDish(maindish3);
		r4.addDish(maindish7);
		r4.addDish(dessert1);
		r4.addDish(dessert4);
		
		Restaurant r5 =map1.get("monde");
		r5.addDish(starter3);
		r5.addDish(starter5);
		r5.addDish(maindish2);
		r5.addDish(maindish5);
		r5.addDish(dessert4);
		r5.addDish(dessert5);
		
		Meal halfmeal1 = new HalfMeal(starter1, maindish4);
		r1.addMeal(halfmeal1);
		Meal halfmeal2 = new HalfMeal(maindish4, dessert2);
		r1.addMeal(halfmeal2);
		Meal halfmeal3 = new HalfMeal(starter3, maindish3);
		r3.addMeal(halfmeal3);
		Meal halfmeal4 = new HalfMeal(maindish6, dessert6);
		r3.addMeal(halfmeal4);
		Meal halfmeal5 = new HalfMeal(starter5, maindish1);
		r4.addMeal(halfmeal5);
		
		Meal fullmeal1 = new FullMeal(starter1, maindish4, dessert5);
		r1.addMeal(fullmeal1);
		Meal fullmeal2 = new FullMeal(starter4, maindish4, dessert2);
		r1.addMeal(fullmeal2);
		Meal fullmeal3 = new FullMeal(starter3, maindish3, dessert3);
		r3.addMeal(fullmeal3);
		Meal fullmeal4 = new FullMeal(starter6, maindish6, dessert6);
		r3.addMeal(fullmeal4);
		Meal fullmeal5 = new FullMeal(starter5, maindish7, dessert4);
		r4.addMeal(fullmeal5);
		Meal fullmeal6 = new FullMeal(starter2, maindish2, dessert1);
		r2.addMeal(fullmeal6);
		
		
		//set date to the first of March
		Date.setCounter(-30);
		
		Customer customer1 = system.getCustomersList().get("ddescamps");
		Customer customer2 = system.getCustomersList().get("qdeffontaines");
		customer1.registerPointFidelityCard(r2);
		ArrayList<Food> content1 = new ArrayList<>();
		content1.add(fullmeal6);
		
		ArrayList<Food> content2 = new ArrayList<>();
		content2.add(halfmeal5);
		
		for (int i=0;i<10;i++){
			customer1.order(content1, r2);
			Date.goTomorrow();
		}
		ArrayList<Food> content3 = new ArrayList<>();
		content3.add(maindish2);
		customer1.order(content3, r2);
		customer1.order(content3, r2);
		
		ArrayList<Food> content4 = new ArrayList<>();
		content4.add(starter1);
		customer1.order(content4, r2);
		
		ArrayList<Food> content5 = new ArrayList<>();
		content5.add(starter3);
		customer1.order(content5, r2);
		customer1.order(content5, r2);
		customer1.order(content5, r2);
		
		customer2.order(content2, r4);


		// set date to the 10th of April
		
		Date.setCounter(10);

		
	}
	public static void main(String[] args) {
		ConfigInitiale.launch();
		
	}

}
