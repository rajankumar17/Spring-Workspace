package com.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle extends ShapeService implements ApplicationContextAware{

	
	private String type;
	private int height;
	ApplicationContext context=null;
	
	public Triangle() {
	}
	
	public Triangle(String type) {
		super();
		this.type = type;
	}
	
	public Triangle(int height) {
		super();
		this.height = height;
	}
	
	public Triangle(String type, int height) {
		super();
		this.type = type;
		this.height = height;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	public void draw(String name){
		System.out.println(getType() + " Triangle with height "+getHeight()+" with name "+name);
	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context=context;
		System.out.println("context set here "+context);
		
	}
	
}
