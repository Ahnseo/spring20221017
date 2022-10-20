package org.zerock.domain.lecture;

import lombok.Data;

@Data
public class Customer {
	// CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country
	private int customerID;
	private String customerName;
	private String contactName;
	private String address;
	private String city;
	private String postalCode;
	private String country;
	
}
