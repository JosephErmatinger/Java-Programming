/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-01
 * Program Name: Person.java
 * Purpose . . : Create a class "person" that has a name, address, and telephone number.
 */
package program8;

class Person {
	private String name;
	private String address;
	private String phone;

	public Person() {
		name = "";
		phone = "";
		address = "";
	}

	public Person(String name, String address, String phone) {

		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	// field getters
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	// field setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}