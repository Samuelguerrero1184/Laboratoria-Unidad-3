package model;

public class Clients {
	private String cName;
	private String cLastName;
	private int id;
	private int cPhone;
	private String email;
	
	 /** 
	 this will transform the parameters into variables of this class creating objects<br> 
	 <b>pre: </b> the parameters cannot be null<br> 
	 <b>post: </b>transform the parameter to a variable of this class and create a object. 
	 @param cName the selection variable of the name. name!= null. 
	 @param cLastName the selection variable of the lastName. lastName!=null.
	 @param id the selection variable of the id. id!=null.
	 @param cphone the selection variable of the cphone. cphone != null. 
	 @param email the selection variable of the email. email !=null.
	 */
	public Clients (String cName, String cLastName, int id, int cPhone, String email) {
		this.cName = cName;
		this.cLastName = cLastName;
		this.id = id;
		this.cPhone = cPhone;
		this.email = email;
	}
	 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return cname. 
	 */	
	public String getCName() {
		return cName;
	}
	 /** 
	 * will modify the parameter into a variable of this class <br> 
	 * <b>pre: </b>The required parameter cannot be null <br> 
	 * <b>post: </b>transform the parameter to a variable of this class. 
	 * @param cname the selection variable of the cname. ncame != null. 
	 */
	public void setCName(String cName) {
		this.cName = cName;
	}
	 /** 
	 * get the element<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return clastname. 
	 */	
	public String getCLastName() {
		return cLastName;
	}
	 /** 
	 * will modify the parameter into a variable of this class <br> 
	 * <b>pre: </b>The required parameter cannot be null <br> 
	 * <b>post: </b>transform the parameter to a variable of this class. 
	 * @param clastName the selection variable of the clast Name. clastName != null. 
	 */
	public void setCLastName(String cLastName) {
		this.cLastName = cLastName;
	}
	 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return id. 
	 */	
	public int getId() {
		return id;
	}
	 /** 
	 * will modify the parameter into a variable of this class <br> 
	 * <b>pre: </b>The required parameter cannot be null <br> 
	 * <b>post: </b>transform the parameter to a variable of this class. 
	 * @param id the selection variable of the id. id != null. 
	 */
	public void setId(int id) {
		this.id = id;
	}
	 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return cphone. 
	 */	
	public int getCPhone() {
		return cPhone;
	}
	 /** 
	 * will modify the parameter into a variable of this class <br> 
	 * <b>pre: </b>The required parameter cannot be null <br> 
	 * <b>post: </b>transform the parameter to a variable of this class. 
	 * @param cphone the selection variable of the cphone. cphone != null. 
	 */
	public void setPhone(int cPhone) {
		this.cPhone = cPhone;
	}
	 /** 
	 * get the element that you selected<br> 
	 * <b>pre: </b>the variable to return must be entered <br> 
	 * <b>post: </b>get the object selected.
	 * @return email. 
	 */	
	public String getEmail() {
		return email;
	}
	 /** 
	 * will modify the parameter into a variable of this class <br> 
	 * <b>pre: </b>The required parameter cannot be null <br> 
	 * <b>post: </b>transform the parameter to a variable of this class. 
	 * @param email the selection variable of the email. email != null. 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	* Accumulates the data in a chain of information <br> 
	* <b>pre: </b>The required parameter cannot be null <br> 
	* <b>post: </b>returns a string of accumulated information. 
	* @return info. 
	*/
	public String infoClient() {
		String infoClient = "Nombre: " +getCName() +  "\nApellido: " + getCLastName() + "\nCedula: "
				+ getId() +  "\nTelefono: " + getCPhone() + "\nE-mail: "+ getEmail();
		return infoClient;
	}
}