package com.java.immutableexample;

import java.util.Date;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		Address a1=new Address();
		a1.setStreet("Indirapuram");
		Employee e1=new Employee(1,a1,new Date(),"Rajan");
		System.out.println(e1.toString()+" "+e1.hashCode()+" "+e1.getId()+" "+e1.getAddress().getStreet()+" "+e1.getDob());
		e1.getAddress().setStreet("Ghaziabad");
		e1.getDob().setTime(50000);
		e1.getName().substring(2);
		System.out.println(e1.toString()+" "+e1.hashCode()+" "+e1.getId()+" "+e1.getAddress().getStreet()+" "+e1.getDob());
		
		/*Employee e2=e1;
		System.out.println(e2.toString()+" "+e2.hashCode()+" "+e2.getId()+" "+e2.getAddress().getStreet());
		e1.getAddress().setStreet("Ghaziabad");
		System.out.println(e2.toString()+" "+e2.hashCode()+" "+e2.getId()+" "+e2.getAddress().getStreet());*/
		
	}

}
