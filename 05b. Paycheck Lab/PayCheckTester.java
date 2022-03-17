import java.util.Scanner;

public class PayCheckTester
{
  public static void main(String[] args)
  {
    boolean manager = false;

    // Input name and type of worker
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter employee's name: ");
    String name = scan.nextLine();

    System.out.print("Enter M (Manager) or S (Sales Clerk): ");
    String type = scan.next();
    System.out.println();

    // Declare and instantiate a Paycheck object
    if(type.equalsIgnoreCase("m")) {
    manager = true;
  }


  PayCheck employee = new PayCheck(name, manager);

  // Set the hours and sales. Display the expected wage
  changeHoursAndSales(scan, employee);
  displayWages(employee);

  // Change the hours and sales. Display the expected wage
  changeHoursAndSales(scan, employee);
  displayWages(employee);
  }

  /** Updates worker's weekly hours and sales with information
  *  input by the user
  *  @param scan the Scanner to use to get input from user
  *  @param worker the Paycheck to update
  */
  public static void changeHoursAndSales(Scanner scan, PayCheck worker)
  {
    System.out.print("Enter total number of hours worked: ");
    double hours = scan.nextDouble();

    System.out.print("Enter total sales generated: ");
    double sales = scan.nextDouble();
    System.out.println();

    // Update PayCheck object's hours and sales
    worker.setHours(hours);
    worker.setSales(sales);
  }
  /**
  * Returns the output of the wage calculation stuff
  * @param worker, a worker object that has hours worked and sales generated
  */

  public static void displayWages(PayCheck worker)
  {
    String title = "";
    if(worker.isManager()) {
     title = "Manager ";
    }
    else {
      title = "Sales Clerk ";
    }
    System.out.print(title + worker.getName() + ": " + worker.getHours() + " hours, $");
    System.out.printf("%.2f", worker.getSales());
    System.out.print(" in sales \n");
    System.out.printf("Total wages: $" + "%.2f \n", worker.calcWages());
    System.out.println("");
  }
}
