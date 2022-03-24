public class FuelTankTester
{
    public static void main(String[] args)
    {
    	// Create a Car object using the default constructor
    	// Create a Car object using the 3-parameter constructor
		// Display both cars using toString

    	Car firstCar = new Car();
    	Car secondCar = new Car(2002, "Porsche 911", 1700);
    	System.out.println("Car 1: " + firstCar.toString());
    	System.out.println("Car 2: " + secondCar.toString() + "\n");

    	// Drive both cars. Display each car's fuel tank level and odometer 
    	// using accessor methods (not toString)
		
		firstCar.drive(750);
		secondCar.drive(5280);
		
		System.out.println("Car 1's odometer: " + firstCar.getMileage());
		System.out.println("Car 1's fuel level: " + firstCar.getFuelLevel() + "\n");
		
		System.out.println("Car 2's odometer: " + secondCar.getMileage());
		System.out.println("Car 2's fuel level: " + secondCar.getFuelLevel() + "\n");

    	// 100-pt Version:
    	
    	// Create a Car object using your 6-parameter constructor
    	// Display the car using toString
	
		Car thirdCar = new Car(1951, "Hudson Hornet", 87293.8, 10, 18.5, 16);
		System.out.println("Car 3: " + thirdCar.toString() + "\n");
	

    	// Drive your car and add fuel, displaying the results
    	// as directed on your lab sheet

		thirdCar.drive(100);
		System.out.println("After 100 miles: " + thirdCar.toString());

		thirdCar.drive(75);
		System.out.println("After 75 miles: " + thirdCar.toString());
		
		thirdCar.addFuel();
		System.out.println("After filling tank: " + thirdCar.getFuelLevel() + "\n");

		thirdCar.drive(500);
		System.out.println("After 500 miles: " + thirdCar.toString() + "\n");
		
		System.out.println("Able to add 6.8 gallons? " + thirdCar.addFuel(6.8));
		System.out.println("Current fuel level: " + thirdCar.getFuelLevel());
		System.out.println("Able to add 11.7 gallons? " + thirdCar.addFuel(11.7));
		System.out.println("Current fuel level: " + thirdCar.getFuelLevel());
		System.out.println("Able to add 5.25 gallons? " + thirdCar.addFuel(5.25));
		System.out.println("Current fuel level: " + thirdCar.getFuelLevel());
		System.out.println("Car 3: " + thirdCar.toString());
    }
}
