package lec250430.circle;

public class Circle extends CircleType {
	
	
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this. radius = radius;
	}
	@Override
	public double getArea() {
		return PI * radius * radius;
	}

}
