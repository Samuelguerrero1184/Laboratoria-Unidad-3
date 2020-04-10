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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	public int getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}
	public int getMaxKg() {
		return MAX_KG;
	}
	public int getMinKg() {
		return MIN_KG;
	}
	public void addClient(Clients client) {
		sells.add(client);
	}
	public void showClients() {
		for (int i = 0; i < sells.size(); i++) {
			System.out.println(sells.get(i).getCName()+"<-->("+(i+1)+")");
		}
	}

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
	
	public int readWeigth() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-->INGRESE EL PESO DE LA CARGA");
		result = sc.nextInt();
		sc.nextLine();
		int a = counterMenu() + result;		
		setCounterMenu(a);
		return result;
	}
	
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
	
	public void typeCheckList() {
		String status = "";
		if(counterHazardous>=1&&counterPerishable>=1) {
			status += "\nHay cargamento peligroso y perecedero junto, y no es permitido, porfavor cambiar".toUpperCase();
			typeOfLoadAdded();
		}
	}
	
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
	
	public void setCounterMenu(int counterMenu) {
		this.counterMenu = counterMenu;
	}
	public int counterMenu() {
		return counterMenu;
	}
}
