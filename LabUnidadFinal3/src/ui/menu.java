package ui;

import java.util.Scanner;

import model.*;

public class menu {
	
	private final static int ADD_LOAD = 1;
	private final static int UNLOAD = 2;
	private final static int SHOW_LOAD = 3;
	private final static int VIEW_PRICE_PER_CLIENT = 4;
	private final static int STATUS_FOR_LEAVING = 5;
	private final static int ADD_CLIENTS = 6;
	private final static int SHOW_CLIENTS = 7;
	private final static int MODIFY = 8;
	
	public boolean clientsAdded;
	public int option;
	private Ship ship;
	public load l1 = new load();
		
	/**
	This method will repeat 5 times, reading 5 different clients with the other method<br>
	<b>pre:</b>Get called by the program<br>
	<b>post:</b> It will loop 5 times calling the readClient method 5 times
	*/
	public void addClients() {
		for (int i = 0; i < 5; i++) {
			System.out.println("-------NUMERO "+(i+1)+"-------");
			readClient();
		}
		clientsAdded = true;
	}
	/**
	This method will start the rest of the program<br>
	<b>pre:</b>Get called by main<br>
	<b>post:</b> The whole program will execute after this method
	*/
	public void initialize() {
		int option;
		do {
		menuOptions();
		option = readOption();
		operate(option);
		}while(option!=0);
	}
	/**
	This method will set the boats and captains name<br>
	<b>pre:</b>the required variables cannot be different from a string<br>
	<b>post:</b> The boats and captains name will be set
	*/
	public void boatName() {
		Scanner sc = new Scanner(System.in);
		String boatName = "";
		System.out.println("-->Ingrese el nombre del barco : ");
		boatName = sc.nextLine();
		String captainName = "";
		System.out.println("-->Ingrese el nombre del capitan : ");
		captainName = sc.nextLine();
		
		ship = new Ship(boatName, captainName);
	}
	/**
	This method will read each client info and create them as new<br>
	<b>pre:</b>Have a constructor method created in Clients.java<br>
	<b>post:</b> Have a new client
	*/
	public void readClient() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-->Ingrese el nombre del cliente :");
		String name = sc.nextLine();
		
		System.out.println("-->Ingrese el numero de registro mercantil de "+name+".");
		int registrationNum = sc.nextInt();
		sc.nextLine();
		
		System.out.println("-->Ingrese en que nivel se encuentra "+name+":\n(0) NINGUNO\n(1)PLATA\n(2)ORO\n(3)PLATINO");
		int clientType = sc.nextInt();
		sc.nextLine();
		
		Clients newClient = new Clients(name, registrationNum, clientType);
		ship.addClient(newClient);
		}

	public void priceClients() {
		ship.showCLientPrice();
	}
	/**
	This method is the menu<br>
	<b>pre:</b><br>
	<b>post:</b> Show menu
	*/
	public void menuOptions(){
		System.out.println("MENU DE OPCIONES \n(1) Cargar");
		System.out.println("(2) Descargar ");
		System.out.println("(3) Ver peso actual de el barco");
		System.out.println("(4) Ver precio por cliente");
		System.out.println("(5) ¿Esta listo el barco para zarpar?");
		System.out.println("(6) Agregar informacion de los clientes");
		System.out.println("(7) VER informacion de los clientes");
		System.out.println("(0) EXIT");
	}
	/**
	This method will read the option of the menu selected by the user<br>
	<b>pre:</b><br>
	<b>post:</b> Option to execute
	@return choice;
	*/	
	public int readOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-->Ingrese la opcion que desea ejecutar:");
		int choice = sc.nextInt();
		return choice;
	}
	/**
	This method is the responsible for operating all the options<br>
	<b>pre:</b>the option must be read and be between 0 and 7<br>
	<b>post:</b> Any of the 7 options the menu provides
	@param choice Its what the previous method returns which selects what operation to do next. choice !=null
	*/
	public void operate(int choice) {
		switch (choice) {
		case ADD_LOAD:
			if(clientsAdded == true) {
			int profile = ship.chooseAddLoad();
			String t = ship.typeOfLoadAdded();
			ship.checkList();
			l1.setTypeLoad(t);
			int w = ship.readWeigth();
			ship.weightCheckList();
			int p = l1.totalPrice(w);
			ship.clientLoadHistory(w, profile);
			ship.clientPaymentHistory(p, profile);
			ship.updateProfile(profile);
			initialize();
			}
			else
				System.out.println("-----ERROR-----\n\nTodavia no tiene ningun cliente creado, porfavor ingreselos a continuacion:\n\n\n\n");
				addClients();
			break;
		case UNLOAD:
			ship.setCounterMenu(0);
		case SHOW_LOAD:
			System.out.println(ship.counterMenu()+"Kg");
			break;
		case VIEW_PRICE_PER_CLIENT:
			ship.showCLientPrice();
			break;
		case STATUS_FOR_LEAVING:
			System.out.println(ship.checkList());
			Scanner sc = new Scanner(System.in);
			System.out.println("¿DESEA MODIFICAR EL CARGAMENTO?");
			System.out.println("(1): SI\n(2): NO");
			int i = sc.nextInt();
			switch(i) {
			case 1:
				ship.setCounterMenu(0);
				menuOptions();
				break;
			case 2:
				menuOptions();
			}
			break;
		case ADD_CLIENTS: 
			addClients();
			break;
		case SHOW_CLIENTS:
			ship.showCLient();
			break;
		}
	}
}
	