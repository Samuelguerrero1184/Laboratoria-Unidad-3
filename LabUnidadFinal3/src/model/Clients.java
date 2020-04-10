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
	
	/**
	this is the constructor method, it assigns new info to the variables defined<br>
	<b>pre:</b>declare variables<br>
	<b>post:</b> 
	@param cName Variable for clients name. cName != null
	@param registrationNum variable for clients registration number. registrationNum != null
	@param clientType variable for clients level. clientType != null
	*/
	public Clients(String cName, int registrationNum, int clientType) {
		this.cName = cName;
		this.registrationNum = registrationNum;
		this.clientType = clientType;
	}
	/**
	Get the string you entered<br>
	<b>pre:</b>the string to return must be entered<br>
	<b>post:</b> get the string entered
	@return cName
	*/
	public String getCName() {
		return cName;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param cName the variable of the clients name. cName != null
	*/
	public void setCName(String cName) {
		this.cName = cName;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return registrationNum
	*/
	public int getRegistrationNum() {
		return registrationNum;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param registrationNum the variable of the clients registration id. registrationNum != null
	*/
	public void setRegistrationNum(int registrationNum) {
		this.registrationNum = registrationNum;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return clientType
	*/
	public int getClientType() {
		return clientType;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param clientType the variable of the clients level. clientType != null
	*/
	public void setClientType(int clientType) {
		this.clientType = clientType;
	}
	/**
	update the clients price depending on their lvl<br>
	<b>pre:</b>the clients must be created<br>
	<b>post:</b> the clients price have discount
	*/
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
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return cLoad
	*/
	public int getCLoad() {
		return cLoad;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param cLaod the variable of the clients load. cLoad != null
	*/
	public void setCLoad(int cLoad) {
		this.cLoad = cLoad;
	}
	/**
	Get the integer you entered<br>
	<b>pre:</b>the integer to return must be entered<br>
	<b>post:</b> get the integer entered
	@return cPayed
	*/
	public int getCPayed() {
		return cPayed;
	}
	/**
	This method will change the parameter to a variable of this class<br>
	<b>pre:</b>the value of the parameter cannot be null<br>
	<b>post:</b> change the parameter to a variable of this class
	@param cPayed the variable of the clients pay. cPayed != null
	*/
	public void setCPayed(int addPay) {
		cPayed = addPay;
	}
}
