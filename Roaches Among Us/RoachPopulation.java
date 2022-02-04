public class RoachPopulation 
{
  private static final int DEFAULT_POPULATION = 10;

  private int numRoaches; // The roach population

  /** Default constructor, initializes the population to 10 
  */
  public RoachPopulation() 
  {
    numRoaches = DEFAULT_POPULATION;
  }

  public RoachPopulation (int startingNumber) {
    numRoaches = startingNumber;
  }


  /** Provides the current roach population
  *  @return number of roaches remaining
  */
  public int getRoaches() 
  {
    return numRoaches;
  }


  /** Doubles the number of roaches
  */
  public void waitForDoubling() 
  {
    numRoaches = numRoaches * 2;
  }

  /** Kills the percentage of roaches that the user puts in
  *  @param killPercent represents the percentage of roaches within the population that will die
  *  @return the new number of roaches after spraying
  */
  public int spray(double killPercent) 
  {
    double killDecimal = killPercent/100;
    double roachesKilled = Math.ceil(killDecimal*numRoaches);
    int newRoaches = (int) (numRoaches - roachesKilled);
    numRoaches = newRoaches;
    return numRoaches;
  }
}
