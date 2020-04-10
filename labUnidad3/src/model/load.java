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
	
	public int getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(int totalWeight) {
		this.totalWeight += totalWeight; 
	}
	public String getTypeLoad() {
		return typeLoad;
	}
	public void setTypeLoad(String typeLoad) {
		this.typeLoad = typeLoad;
	}
	public int getNumberContainers() {
		return numberContainers;
	}
	public void setNumberContainers(int numberContainers) {
		this.numberContainers = numberContainers;
	}
	public int getContianerWeight() {
		return containerWeight;
	}
	public void setContainerWeight(int containerWeight) {
		this.containerWeight = containerWeight;
	}
	public int getPrice() {
		return priceLoad;
	}
	public void setPrice(int priceLoad) {
		this.priceLoad = priceLoad;
	}
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
