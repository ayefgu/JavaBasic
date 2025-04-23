package hw250423;

public class GirlTest {
	public static void main(String[] args) {
		Girl[] girls = {
		new Girl ("지수"),
		new GoodGirl("제니"),
		new BestGirl("아이유")
		
	};
	for(Girl g : girls) {
		g.show();
	}
	}

}
