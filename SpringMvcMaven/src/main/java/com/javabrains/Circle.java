package com.javabrains;


public class Circle extends ShapeService {

	private int center;

	public Circle() {
	}

	public Circle(int center) {
		super();
		this.center = center;
	}

	public int getCenter() {
		return center;
	}

	public void setCenter(int center) {
		this.center = center;
	}

	@Loggable
	public void draw(String name) {
		System.out.println("Circle with center " + getCenter()+" with name "+name);
	}


}
