package com.javabrains;

public abstract class ShapeService {

	Triangle triangle;
	
	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	public void draw(String name){
		System.out.println("In shape draw"+" with name "+name);
	}
}
