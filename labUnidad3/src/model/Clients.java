package model;


public class Clients {
	private final static int SILVER_BENEFIT =1;//ONLY FOR PERISHABLE LOADS
	private final static int GOLD_BENEFIT = 2;//ONLY FOR PERISHABLE & NONPERISHABLE
	private final static int PLATINUM_BENEFIT = 3;//FOR EVERYTHING
	public Clients result;
	private String cName = "";
	private int registrationNum;
	private int clientType;
	private int cLoad;
	private int cPayed;
	
	public Clients(String cName, int registrationNum, int clientType) {
		this.cName = cName;
		this.registrationNum = registrationNum;
		this.clientType = clientType;
	}
	public String getCName() {
		return cName;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
	public int getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(int registrationNum) {
		this.registrationNum = registrationNum;
	}
	public int getClientType() {
		return clientType;
	}
	public void setClientType(int clientType) {
		this.clientType = clientType;
	}
	
	public void updateClientLv1(){
		if(getCLoad()>35000) {
			setClientType(SILVER_BENEFIT);
		}
		else if(getCLoad()>55000) {
			setClientType(GOLD_BENEFIT);
	}
		else if(getCLoad()>5000||getCPayed()>5000000) {
			setClientType(PLATINUM_BENEFIT);
	}
	}
	public int getCLoad() {
		return cLoad;
	}
	public void setCLoad(int cLoad) {
		this.cLoad = cLoad;
	}
	public int getCPayed() {
		return cPayed;
	}
	public void setCPayed(int addPay) {
		cPayed = addPay;
	}
}
