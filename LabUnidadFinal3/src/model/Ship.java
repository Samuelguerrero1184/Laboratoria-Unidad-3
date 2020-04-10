package model;

import java.util.*;

import ui.menu;

public class Ship {
	private final static int MAX_KG = 28000;
	private final static int MIN_KG = 12000;
	public int currentWeight;
	public int result;
	public int cargo;
	public int profile;
	public String t;
	private int counterHazardous = 0;
	private int counterPerishable = 0;
	private int counterNonPerishable = 0;
	private int counterMenu;
	private int price;
	private String name;
	private String captainName;
	private ArrayList<Clients>sells;
	private load load;
	private menu menu = new menu();
	
	
	public Ship(String name, String captainName ) {
		this.name = name;
		this.captainName = captainName;
		sells = new ArrayList<Clients>();
	}
	/**
	Get the string you entered<br>
	<b>pre:</b>the string to return must be entered<br>
	<b>post:</b> get the string entered
	@return name
	*/
	public String getName() {
		return name;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param name the variable for the boats name. name != null
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	Get the string you entered<br>
	<b>pre:</b>the string to return must be entered<br>
	<b>post:</b> get the string entered
	@return captainName
	*/
	public String getCaptainName() {
		return captainName;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param captainName the variable for the captain name. captainName != null
	*/
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return currentWeight
	*/
	public int getCurrentWeight() {
		return currentWeight;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param currentWeight the variable for the ships current load. currentWeight != null
	*/
	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return MAX_KG
	*/
	public int getMaxKg() {
		return MAX_KG;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return MIN_KG
	*/
	public int getMinKg() {
		return MIN_KG;
	}
	/**
	Adds the client created to the clients arraylist<br>
	<b>pre:</b>the clients must be entered<br>
	<b>post:</b> create a profile for each client
	@param client is a variable with all the information needed to create a new class Clients. client != null
	*/
	public void addClient(Clients client) {
		sells.add(client);
	}
	/**
	this method prints out every clients profile<br>
	<b>pre:</b>the clients must be created<br>
	<b>post:</b> prints every client
	*/
	public void showClients() {
		for (int i = 0; i < sells.size(); i++) {
			System.out.println(sells.get(i).getCName()+"<-->("+(i+1)+")");
		}
	}
	/**
	this method allows you to select which client owns the cargo <br>
	<b>pre:</b><br>
	<b>post:</b>
	@return profile-1
	*/
	public int chooseAddLoad() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-->A CONTINUACION VA A LLENAR EL FORMULARIO PARA MONTAR LA CARGA<--");
		System.out.println("-->A QUIEN PERTENECE LA CARGA:");
		showClients();
		System.out.println("ELIJE UNA OPCION :");
		profile = sc.nextInt();
		sc.nextLine();
		return (profile-1);
	}
	/**
	this method allows you to select which type the cargo is <br>
	<b>pre:</b><br>
	<b>post:</b> 
	@return typeCargo
	*/	
	public String typeOfLoadAdded() {
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESE EL TIPO DE CARGA : HAZARDOUS - PERISHABLE - NON PERISHABLE");
		String typeCargo = sc.nextLine().toUpperCase();
		if (typeCargo.equals("HAZARDOUS")) {
			counterHazardous +=1;
		}
		else if(typeCargo.equals("PERISHABLE")) {
			counterPerishable += 1;
		}
		else if(typeCargo.equals("NON PERISHABLE")) {
			counterNonPerishable += 1;
		}
		else {
			System.out.println("NO INGRESO UNA OPCION VALIDA, NO SE PREUCUPE POR MAYUSCULAS\nINGRESE TAL CUAL COMO APARECERAN ABAJO.");
			typeOfLoadAdded();
		}
		return typeCargo;
	}
	/**
	this method allows the program to read the cargo <br>
	<b>pre:</b><br>
	<b>post:</b>
	@return result
	*/
	public int readWeigth() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-->INGRESE EL PESO DE LA CARGA");
		result = sc.nextInt();
		sc.nextLine();
		int a = counterMenu() + result;		
		setCounterMenu(a);
		return result;
	}
	/**
	this method allows you to select which client owns the cargo <br>
	<b>pre:</b>the parameter must be different from null<br>
	<b>post:</b> updates the clients level
	@param profile variable that chooses certain position in the clients arraylist.
	*/
	public void updateProfile(int profile){
		if(sells.get(profile).getCLoad()>35000) {
			sells.get(profile).setClientType(1);
		}
		else if(sells.get(profile).getCLoad()>55000) {
			sells.get(profile).setClientType(2);
	}
		else if(sells.get(profile).getCLoad()>5000||sells.get(profile).getCPayed()>5000000) {
			sells.get(profile).setClientType(3);
	}
	}
	
	public void clientLoadHistory(int result, int profile) {
		//Set the clients total cargo history for updating there lvl
		int counter = sells.get(profile).getCLoad();
		int a = counter+result;
		sells.get(profile).setCLoad(a);
		//Start adding weight to the ship
	}
	/**
	this method increases the clients payment history <br>
	<b>pre:</b>the client mustve loaded something<br>
	<b>post:</b> total payed overtime
	@param result is the variable of the price. result != null
	@param profile is the variable that selects a certain client. profile != null
	*/
	public void clientPaymentHistory(int result, int profile) {
		//Set the clients total payment history for updating there lvl
		int counter = sells.get(profile).getCPayed();
		switch(sells.get(profile).getClientType()) {
		case 1:
			result = (int) (result*0.985);
			break;
		case 2:
			result = (int) (result*0.97);
			break;
		case 3:
			result = (int) (result*0.95);
			break;
		}
		int a = counter+result;
		sells.get(profile).setCPayed(a);
	}
	/**
	this method show all the clients info <br>
	<b>pre:</b>clients must be created<br>
	<b>post:</b> prints every client
	*/
	public void showCLient() {
		String resultString = "";
		for (int i = 0; i<sells.size(); i++) {
			resultString = "Cliente :"+(i+1)+"\n";
			resultString += "Nombre :"+sells.get(i).getCName()+"\n";
			resultString += "Registro :"+sells.get(i).getRegistrationNum()+"\n";
			switch (sells.get(i).getClientType()) {
			case 1:
				resultString += "Level : PLATA\n";
				break;
			case 2:
				resultString += "Level : ORO\n";
				break;
			case 3:
				resultString += "Level : PLATINO\n";
				break;
			}
			resultString += "Cargos :"+sells.get(i).getCLoad()+"Kg"+"\n";
			System.out.println(resultString);
		}
	}
	/**
	this method show all the clients info with price<br>
	<b>pre:</b>clients must be created<br>
	<b>post:</b> prints every client with price to pay
	*/
	public void showCLientPrice() {
		String resultString = "";
		for (int i = 0; i<sells.size(); i++) {
			resultString = "Cliente :"+(i+1)+"\n";
			resultString += "Nombre :"+sells.get(i).getCName()+"\n";
			switch (sells.get(i).getClientType()) {
			case 1:
				resultString += "Level : PLATA\n";
				break;
			case 2:
				resultString += "Level : ORO\n";
				break;
			case 3:
				resultString += "Level : PLATINO\n";
				break;
			}
			resultString += "Cargos :"+sells.get(i).getCLoad()+"Kg"+"\n";
			resultString += "Total a pagar :"+"$"+sells.get(i).getCPayed()+" Pesos\n";
;			System.out.println(resultString);
		}
	}
	/**
	this method checks if the boat is ready by revising the type of cargos that are together <br>
	<b>pre:</b>the boat must be loaded<br>
	<b>post:</b> says if the boat is ready or not
	*/
	public void typeCheckList() {
		String status = "";
		if(counterHazardous>=1&&counterPerishable>=1) {
			status += "\nHay cargamento peligroso y perecedero junto, y no es permitido, porfavor cambiar".toUpperCase();
			typeOfLoadAdded();
		}
	}
	/**
	this method checks if the boat is ready by revising the total weight <br>
	<b>pre:</b>the boat must be loaded<br>
	<b>post:</b> says if the boat is ready or not
	*/
	public void weightCheckList() {
		if(counterMenu()>28000) {
			System.out.println("SE EXCEDE EL PESO MAXIMO, REDUCIR CARGA");
			
			readWeigth();
		}
	}
	
	public String checkList(){
		String status = "El barco no esta listo para zarpar";
		if(counterMenu()>=12000||counterMenu()<=28000) {
			status = "El barco no esta listo para zarpar";	
		}
		else {
			status += "\nPeso total no permitido, reduzca o aumente el peso";
		}
		if(counterHazardous>=1&&counterPerishable>=1) {
			status += "\nHay cargamento peligroso y perecedero junto, y no es permitido, porfavor cambiar";
		}
		
		return status;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param counterMenu the variable used in the menu. counterMenu != null
	*/
	public void setCounterMenu(int counterMenu) {
		this.counterMenu = counterMenu;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return counterMenu
	*/
	public int counterMenu() {
		return counterMenu;
	}
}