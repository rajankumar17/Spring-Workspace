package com.java.immutableexample;

import java.util.Date;

public final class Employee {
	private final int id;
	private final Address address;
	private Date dob;
	private String name;

	public Employee(int id, Address address,Date dob,String name) {
		// for immutable
		//this.id = id;
		//this.address = new Address(); // defensive copy
		//this.address.setStreet(address.getStreet());
		
		
		//for mutable
		this.id = id;
		this.address=address;
		this.dob=dob;
		this.name=name;
		//System.out.println("In employee constructor "+address.getStreet());
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		//for immuatble
		Address address1 = new Address(); // must copy here too
		address1.setStreet(address.getStreet());
		
		//for mutable
		//Address address1=address;
		
		//System.out.println("In employee get Addresss "+address1.getStreet());
		return address1;
	}

	public Date getDob() {
		Date d=new Date();
		d.setDate((int) dob.getTime());
		return d;
	}

	public String getName() {
		return name;
	}

}
