package model;

import java.util.*;

public class CarDealer {
private String name;
private int nit;
private float totalProfit;
private float salesNumber;
private final static int COLS = 10;
private final static int ROWS = 5;
private Vehicles[][] parkingSpace;
private ArrayList<Vehicles> vehicles;
private ArrayList<Clients> clients;
private ArrayList<SalesMan> salesMan;

/** 
* will transform the parameters into a variables of this class and create type of object <br> 
* <b>pre: </b> the parameters cannot be null<br> 
* <b>post: </b>transform the parameter to a variable of this class and create a object. 
* @param name the selection variable of the name. name!= null. 
* @param nit the selection variable of the nit. nit!=null.
* @param totalProfit the selection variable of the total Profit. totalProfit !=null.
* @param salesNumber the selection variable of the sales Number. salesNumber != null. 
*/
public CarDealer (String name, int nit, float totalProfit, float salesNumber) {
	this.name = name;
	this.nit = nit;
	this.totalProfit = totalProfit;
	this.salesNumber = salesNumber;
	vehicles = new ArrayList<Vehicles>();
	clients = new ArrayList<Clients>();
	salesMan = new ArrayList<SalesMan>();
	parkingSpace = new Vehicles [COLS][ROWS];
}
public void addVehicles(Vehicles car) {
	boolean registered = false;
	for(int i = 0; i < ROWS && !registered; i++ ) {
		for (int j = 0; j < COLS && !registered; j++) {
			if (parkingSpace[i][j]==null) {
				parkingSpace[i][j] = car;
				registered = true;
			}
		}
	}
}
/** 
* Add an item to a list<br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>transform the parameter to a variable of this class and add to a list. 
* @param seller the selection object of the seller. seller != null. 
*/
public void addSeller(SalesMan sales) {
	salesMan.add(sales);
}
/** 
* get the object that you selected<br> 
* <b>pre: </b>the variable to return must be entered <br> 
* <b>post: </b>get the object selected.
* @return sellers.get(index). 
*/	
public SalesMan getSeller(int index) {
	return salesMan.get(index);	
}
/** 
* Add an item to a list<br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>transform the parameter to a variable of this class and add to a list. 
* @param vehicle the selection object of the vehicle. vehicle != null. 
*/
public void addVehicle(Vehicles vehicle) {
	vehicles.add(vehicle);
}
/** 
* get the object that you selected<br> 
* <b>pre: </b>the variable to return must be entered <br> 
* <b>post: </b>get the object selected.
* @return vehicles.get(index). 
*/	
public Vehicles getVehicle(int index) {
	return vehicles.get(index);	
}
/** 
* Add an item to a list<br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>transform the parameter to a variable of this class and add to a list. 
* @param client the selection object of the client. client != null. 
*/
public void addClient(Clients client) {
	clients.add(client);
	
}
/** 
* get the object that you selected<br> 
* <b>pre: </b>the variable to return must be entered <br> 
* <b>post: </b>get the object selected.
* @return clients.get(index). 
*/	
public Clients getClient(int index) {
	return clients.get(index);	
}
/** 
* get the arraylist that you selected<br> 
* <b>pre: </b>the variable to return must be entered <br> 
* <b>post: </b>get the object selected.
* @return clients. 
*/	
public ArrayList<Clients> getClients() {
	return clients;	
}
 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return name. 
	 */	
public String getName() {
	return name;
}
/** 
* will transform the parameter into a variable of this class <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>transform the parameter to a variable of this class. 
* @param name the selection variable of the name. name != null. 
*/
public void setName(String name) {
	this.name = name;
}
 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return nit. 
	 */	
public int getNit() {
	return nit;
}
/** 
* will transform the parameter into a variable of this class <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>transform the parameter to a variable of this class. 
* @param nit the selection variable of the nit. nit != null. 
*/
public void setNit(int nit) {
	this.nit = nit;
}
 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return totalProfit. 
	 */	
public float getTotalProfit() {
	return totalProfit;
}
/** 
* will transform the parameter into a variable of this class <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>transform the parameter to a variable of this class. 
* @param totalProfit the selection variable of the total Profit. totalProfit != null. 
*/
public void setTotalProfit(float totalProfit) {
	this.totalProfit = totalProfit;
}
 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return salesNumber. 
	 */	
public float getSalesNumber() {
	return salesNumber;
}
/** 
* will transform the parameter into a variable of this class <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>transform the parameter to a variable of this class. 
* @param salesNumber the selection variable of the sales Number. salesNumber != null. 
*/
public void setSalesNumber(float salesNumber) {
	this.salesNumber = salesNumber;
}
/** 
* Accumulates the data in a chain of information <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>returns a string of accumulated information. 
* @return info. 
*/
public String infoVehicles() {
	  String info = "Nuestro catalogo de Autos es:\n";
		for (int i = 0; i < vehicles.size() ; i++) {
				info += "- "+i + ") " +  vehicles.get(i).basicInfo()+"\n";
			
		}
return info;


}
/** 
* Accumulates the data in a chain of information about the clients <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>returns a string of accumulated information. 
* @return info. 
*/
public String infoClients() {
	String info = "Los clientes ingresados son:\n";
	for (int i = 0; i < clients.size() ; i++) {
		info += "- "+i + ") " +  clients.get(i).infoClient()+"\n";
	
}
return info;
}
public String infoSellers() {
	String info = "Los asesores de la empresa son:\n";
	for (int i = 0; i < salesMan.size() ; i++) {
		info += "- "+i + ") " + salesMan.get(i).infoSalesMan()+"\n";

}
return info;
}
/** 
* Accumulates the data in a chain of information <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>returns a string of accumulated information. 
* @return info. 
*/
public String ShowSaleManNames() {
	String info = "Los asesores de la empresa son:\n";
	for (int i = 0; i < salesMan.size() ; i++) {
		info += "- "+i + ") " +  salesMan.get(i).getName()+"\n";
	
}
return info;
}
/** 
* Accumulates the data in a chain of information <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>returns a string of accumulated information. 
* @return info. 
*/
public String getInfoParking() {
	String info = "\nVehiciulos que hay en el parqueadero\n";
	for(int i = 0; i < parkingSpace.length; i++) {
		for(int j = 0; j < parkingSpace[i].length; j++){
			if(parkingSpace[i][j] != null) {
				info += "\n\nVehiculo en la posicion:" + i + "." + j + "\n" + "-------" + parkingSpace[i][j].basicInfo();
			}
		}
	}
	return info;
}

/** 
* Accumulates the data in a chain of information <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>returns a string of accumulated information. 
* @param a the selection object of the index. a != null.
* @return info. 
*/
public String getInfoTypeVehicle(int infov) {
	String info = "La informacion de estos vehiculos es:\n";
	if (infov == 1){
		for (int i = 0; i < vehicles.size() ; i++) {
			if (!vehicles.get(i).getSoldStatus() && vehicles.get(i) instanceof PetrolCar) {
			info += "------\n"+i + ") " +  vehicles.get(i).basicInfo()+"\n";
			}
	}
		
	}else 	if (infov == 2){
		for (int i = 0; i < vehicles.size() ; i++) {
			if (!vehicles.get(i).getSoldStatus() && vehicles.get(i) instanceof ElectricCar) {
				info += "------\n"+i + ") " +  vehicles.get(i).basicInfo()+"\n";
			}		
	}
		
	}else 	if (infov == 3){
		for (int i = 0; i < vehicles.size() ; i++) {
			if (!vehicles.get(i).getSoldStatus() && vehicles.get(i) instanceof HybridCar) {
				info += "------\n"+i + ") " +  vehicles.get(i).basicInfo()+"\n";
			}		
	}
		
	} else 	if (infov == 4){
		for (int i = 0; i < vehicles.size() ; i++) {
			if (!vehicles.get(i).getSoldStatus() && vehicles.get(i) instanceof Motocycle) {
				info += "------\n"+i + ") " +  vehicles.get(i).basicInfo()+"\n";
			}		
	}
		
	}else if (infov == 5) {
		info = "";
	}
	return info;
	
}
/** 
* Accumulates the data in a chain of information <br> 
* <b>pre: </b>The required parameter cannot be null <br> 
* <b>post: </b>returns a string of accumulated information. 
* @return info. 
* @param index the selection object of the index. index != null.
*/
public String infoIfUsed(int index) {
	String info = "La informacion de estos vehiculos es:\n";
	switch (index){
	case 1:for (int i = 0; i < vehicles.size() ; i++) {
		if (!vehicles.get(i).getSoldStatus() && !vehicles.get(i).getUsed()){
			info += "======================\n"+i + ") " +  vehicles.get(i).basicInfo()+"\n";
		}		
}
		
		break;
	case 2:for (int i = 0; i < vehicles.size() ; i++) {
		if (!vehicles.get(i).getSoldStatus() && vehicles.get(i).getUsed()){
		info += "========================\n"+i + ") " +  vehicles.get(i).basicInfo()+"\n";
		}			
}
		
		break;
	case 3:for (int i = 0; i < vehicles.size() ; i++) {
		if (!vehicles.get(i).getSoldStatus()){
			info += "======================\n"+i + ") " +  vehicles.get(i).basicInfo()+"\n";
		}			
}
		
		break;
	case 4: info = "";
		break;
	}
	return info;
	
}

}