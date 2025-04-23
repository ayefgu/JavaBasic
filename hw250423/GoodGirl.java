package hw250423;

public class GoodGirl extends Girl {
	
	GoodGirl(String name) {
		super(name);
	}
	@Override
	void show() {
		System.out.println(name + "는 자바를 잘 안다.");
		
	}

}
