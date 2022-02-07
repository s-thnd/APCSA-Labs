public class PayCheck
{
  /* Static Constants Go Here */

  public static final double BASIC_HOURLY = 9.75;
  public static final double OVERTIME_HOURLY = BASIC_HOURLY*1.5;
  public static final double MANAGER_BONUS = 100;

  public static final double LOWER_BOUND1 = 0;
  public static final double UPPER_BOUND1 = 99.99;
  public static final double LOWER_BOUND2 = 100;
  public static final double UPPER_BOUND2 = 299.99;
  public static final double LOWER_BOUND3 = 300;

  public static final double PERCENTAGE1 = .05;
  public static final double PERCENTAGE2 = .08;
  public static final double PERCENTAGE3 = .13;



  /* Instance variables */
  private String employee;
  private double hoursWorked;
  private boolean isManager;
  private double weeklySales;

  /**
  *  Creates a PayCheck object for an employee given the name and
  *  whether or not this employee is a manager.
  *  @param name the name of the employee
  *  @param manager indicates whether or not this is a manager
  *     (true if a manager, false if a sales clerk)
  */
  public PayCheck(String name, boolean manager)
  {
    employee = name;
    isManager = manager;
    hoursWorked = 0;
    weeklySales = 0;
  }

  /**
  * Calculates the amount of money that a person has earned using
  * the appropriate formulas.
  * @return will return the amount of money due
  */
  public double calcWages()
  {
    double wageDue = 0;

    if(hoursWorked <= 40) {
      wageDue = hoursWorked * BASIC_HOURLY;
    }
    else if(hoursWorked > 40) {
      wageDue = 40 * BASIC_HOURLY + (hoursWorked - 40) * OVERTIME_HOURLY;
    }

    if(isManager) {
      wageDue += 100;
    }

    wageDue += calcCommission();

    return wageDue;
  }

  /**
  * Calculates the commission due based on the formula provided
  * @return The bonus amount of money earned
  */
  private double calcCommission()
  {
    double bonus = 0;

    if(weeklySales >= LOWER_BOUND1 && weeklySales <= UPPER_BOUND1) {
      bonus = weeklySales*PERCENTAGE1;
    }
    else if(weeklySales >= LOWER_BOUND2 && weeklySales <= UPPER_BOUND2) {
      bonus = weeklySales*PERCENTAGE2;
    }
    else if(weeklySales >= LOWER_BOUND3) {
      bonus = weeklySales*PERCENTAGE3;
    }

    return bonus;
  }

  /** Retrieves the employee's name
  *  @return the name of this employee
  */
  public String getName()
  {
    return employee;
  }

  /** Reports whether or not this employee is a manager
  *  @return true if this employee is a manager, false otherwise
  */
  public boolean isManager()
  {
    return isManager;
  }

  /** Retrieves the number of hours worked
  *  @return the number of hours worked this pay period
  */
  public double getHours()
  {
    return hoursWorked;
  }

  /** Resets the number of hours worked to newHours
  *  @param newHours the number of hours worked this pay period
  */
  public void setHours(double newHours)
  {
    hoursWorked = newHours;
  }

  /** Retrieves the total amount of sales generated
  *  @return the total amount of sales generated this pay period
  */
  public double getSales()
  {
    return weeklySales;
  }

  /** Resets the amount of sales generated to newSales
  *  @param newSales the total amount of sales generated this pay period
  */
  public void setSales(double newSales)
  {
    weeklySales = newSales;
  }
}
