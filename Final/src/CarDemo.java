
public class CarDemo {

	public static void test(AbstractCar car)
	{
		if (car.goFaster() == -1)
		{
			System.out.println("Can't go faster. Car not started.");
			
		}
		else
		{
			System.out.println(car);
		}
	}
	
	public static void main(String[] args) {
		AbstractCar c1 = new Car(false);
		System.out.println("Car 1 test");
		test(c1);
		test(c1);
		test(c1);
		c1.toggleIgnition();
		test(c1);
		test(c1);
		test(c1);
		c1.toggleIgnition();
		test(c1);
		test(c1);
		test(c1);
		
		
		AbstractCar c2 = new Car(false);
		System.out.println("Car 2 test");			
		test(c2);
		test(c2);
		test(c2);
		c2.toggleIgnition();
		test(c2);
		test(c2);
		test(c2);
		c2.toggleIgnition();
		test(c2);
		test(c2);
		test(c2);
		test(c2);
		test(c2);
		test(c2);
		test(c2);

	}

}
