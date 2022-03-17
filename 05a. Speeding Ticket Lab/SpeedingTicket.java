import java.util.*;

public class SpeedingTicket 
{
  /** Define your static constants here */
  static final int MIN_COST = 50;
  static final int STANDARD_INCREASE = 7;
  static final int SCHOOL_ZONE_INCREASE = 15;
  static final int SPEED_THRESHOLD = 30;
  static final int EXCESSIVE_SPEED = 175; 

  public static void main(String[] args) 
  {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter driver's name: ");
    String name = input.nextLine();
    System.out.print("Enter driver's speed: ");
    int speed = input.nextInt(); 
    System.out.print("Enter speed limit: ");
    int speedLimit = input.nextInt();
    System.out.print("Was driver in a school zone? ");
    input.nextLine();
    String schoolZone = input.nextLine();

    int ticketCost = calcTicket(speed, speedLimit, schoolZone);

    System.out.println("");

    System.out.printf("%-17s", "Speed travelled: ");
    System.out.println(speed);


    System.out.printf("%-17s", "Speed limit: ");
    System.out.println(speedLimit);

    System.out.printf("%-17s", "In school zone: ");
    System.out.println(schoolZone);

    System.out.print(name + " owes $" + ticketCost);
  }

  /** The calcTicket will calculate the final price of the ticket
  *  as defined by the outlines
  *  @param speedDriving, this is the speed the person was driving at
  *  @param speedLimit, this is the speed limit of the place
  *  @param schoolZone, this is whether or not the driver was in a school zone
  */ 
  public static int calcTicket(int speedDriving, int speedLimit, String schoolZone)
  {

    int cost = MIN_COST;
    int speedDifference = speedDriving - speedLimit;

    if(schoolZone.equalsIgnoreCase("yes")) {
    cost = cost + (speedDifference * SCHOOL_ZONE_INCREASE);
    }
    else {
    cost = cost + (speedDifference * STANDARD_INCREASE);
    }

    if(speedDifference > SPEED_THRESHOLD) {
    cost = cost + EXCESSIVE_SPEED;
    }

    return cost;
  }
}  
