import java.util.Scanner;

public class RoachMotel 
{
  public static void main(String[] args) 
  {
  /*
  * 70-point version
  */

  // Using the default constructor, declare and instantiate a 
  // RoachPopulation object to represent the roach population 
  // in the computer lab. 
  // Display the initial population using the accessor method.

  RoachPopulation labRoaches = new RoachPopulation();
  System.out.println("My lab has an inital population of " + labRoaches.getRoaches() + " roaches. \n");


  // Using the starting population provided by the user and 1-parameter
  // constructor, declare and instantiate a RoachPopulation object to
  // represent the roach population in your kitchen. 
  // Display initial population using the accessor method.
  Scanner scan = new Scanner(System.in);
  System.out.print("Enter starting population of the kitchen (an integer): ");
  int initialPopulation = scan.nextInt();

  RoachPopulation kitchenRoaches = new RoachPopulation(initialPopulation);
  System.out.println("My kitchen has an initial population of " + kitchenRoaches.getRoaches() + " roaches. \n");


  /*
  * 85-point version
  */

  // Wait for the kitchen population to double and display the results

  System.out.println("Waiting for the kitchen population to grow....");
  kitchenRoaches.waitForDoubling();
  System.out.println("My kitchen now has " + kitchenRoaches.getRoaches() + " roaches. \n");

  // Wait for the lab population to double and display the results

  System.out.println("Waiting for the lab population to grow....");
  labRoaches.waitForDoubling();
  System.out.println("My lab now has " + labRoaches.getRoaches() + " roaches. \n");

  /*
  * 100-point version (uncomment section below)
  */

  int oldRoaches;
  int newRoaches;
  int roachDifference;
  // Spray insecticide in the kitchen and display the results
  System.out.print("Enter strength of kitchen insecticide used (ex, 22.75): ");
  double kitchenSpray = scan.nextDouble();

  oldRoaches = kitchenRoaches.getRoaches();
  kitchenRoaches.spray(kitchenSpray);

  newRoaches = kitchenRoaches.getRoaches();
  roachDifference = oldRoaches - newRoaches;

  System.out.println("My kitchen now has " + kitchenRoaches.getRoaches() + " roaches after killing " + roachDifference + " roaches. \n");


  // Spray insecticide in the lab and display the results
  System.out.print("Enter strength of lab insecticide used (ex, 22.75): ");
  double labSpray = scan.nextDouble();


  oldRoaches = labRoaches.getRoaches();
  labRoaches.spray(labSpray);
  newRoaches = labRoaches.getRoaches();
  roachDifference = oldRoaches - newRoaches;

  System.out.println("My kitchen now has " + labRoaches.getRoaches() + " roaches after killing " + roachDifference + " roaches. \n");


  }
}
