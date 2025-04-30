package lec250430.task;

public class Rectangle extends Shape{
	int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println("사각형을 그리다.");
    }

    public double findArea() {
        return width * height;
    }

}
