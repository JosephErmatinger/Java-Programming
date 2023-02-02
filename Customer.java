/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-14
 * Program Name: Customer.java
 * Purpose . . : Create a class "Customer" that extends the Person class
 */
package program8;

class Customer extends Person 
{
	private int custNum;
	private boolean mailingList;

	public Customer() {
		super();
		custNum = 999999;
		mailingList = false;
	}

	public Customer(String name, String address, String phone, int custNum, boolean mailingList) {
		super(name, address, phone);
		this.custNum = custNum;
		this.mailingList = mailingList;
	}
	
	//field getters
	public int getcustNum() {
		return custNum;
	}

	public boolean isMailingList() {
		return mailingList;
	}
	
	//field setters
	public void setcustNum(int custNum) {
		this.custNum = custNum;
	}

	public void setMailingList(boolean mailingList) {
		this.mailingList = mailingList;
	}

	@Override
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("Name . . . . . .:\t");
		message.append(super.getName());
		message.append("\nAddress. . . . .:\t");
		message.append(super.getAddress());
		message.append("\nTelephone Number:\t");
		message.append(super.getPhone());
		message.append("\nCustomer Number.:\t");
		message.append(custNum);
		message.append("\nSubscribed . . .:\t");
		message.append(mailingList);
		
		return message.toString();
	}
	
}