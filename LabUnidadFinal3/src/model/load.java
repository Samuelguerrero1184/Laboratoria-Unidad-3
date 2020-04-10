package model;

public class load {
	private final static int HAZARDOUS = 390000;
	private final static int PERISHABLE = 250000;
	private final static int NON_PERISHABLE = 80000;
	private int totalWeight;
	private String typeLoad;
	private int numberContainers;
	private int containerWeight;
	private int priceLoad;
	public int price;
	
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return totalWeight
	*/
	public int getTotalWeight() {
		return totalWeight;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param totalWeight the variable for the loads total weight. totalWeight != null
	*/
	public void setTotalWeight(int totalWeight) {
		this.totalWeight += totalWeight; 
	}
	/**
	Get the string you entered<br>
	<b>pre:</b>the string to return must be entered<br>
	<b>post:</b> get the string entered
	@return typeLoad
	*/
	public String getTypeLoad() {
		return typeLoad;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param typeLoad the variable for the loads type. typeLoad != null
	*/
	public void setTypeLoad(String typeLoad) {
		this.typeLoad = typeLoad;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return numberContainers
	*/
	public int getNumberContainers() {
		return numberContainers;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param numberContainers the variable for the loads containers. numberContainers != null
	*/
	public void setNumberContainers(int numberContainers) {
		this.numberContainers = numberContainers;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return containerWeight
	*/
	public int getContianerWeight() {
		return containerWeight;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param containerWeight the variable for the loads containers weight. containerWeight != null
	*/
	public void setContainerWeight(int containerWeight) {
		this.containerWeight = containerWeight;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return priceLoad
	*/
	public int getPrice() {
		return priceLoad;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param priceLoad the variable for the loads price. priceLoad != null
	*/
	public void setPrice(int priceLoad) {
		this.priceLoad = priceLoad;
	}
	/**
	This method will return a price according to the cargos type and weight<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> returns the total price
	@param load the variable that is the weight of the cargo. load != null
	*/
	public int totalPrice(int load) {
		String typeLoad2 = getTypeLoad();
		if(typeLoad2.equals("HAZARDOUS")) {
			price = load*HAZARDOUS;
		}
		else if(typeLoad2.equals("PERISHABLE")) {
			price = load*PERISHABLE;
		}
		else if (typeLoad2.equals("NON PERISHABLE")) {
			price = load*NON_PERISHABLE;
		}
		return price;
	}
}
