import java.util.*;

public class BodyMassIndex 
{
  // Define constants for unit conversions
  public static final double CM_TO_M = 100.0;
  public static final double LBS_TO_KG = 0.453592; //lbs*this constant = kgs
  public static final double IN_TO_CM = 2.54; //in*this constant = cm


  // Do not make any changes to the main!
  public static void main(String[] args) 
  {
    // 80-point version
    // Input user's weight and height in metric units and calculate BMI
    calculateMetricBMI();
    System.out.println();

    // 100-point version
    // Input user's weight and height in imperial units and calculate BMI
    calculateImperialBMI();
    System.out.println();
  }

  /** 
  */
  public static void calculateMetricBMI()
  {
    // complete for 80 pt version
    Scanner input = new Scanner(System.in);

    System.out.print("Enter your weight in kilograms: ");
    int weightKg = input.nextInt();
    System.out.println("");
    System.out.print("Enter your height in centimeters: ");
    int heightCm = input.nextInt();

    double output = getBMI(weightKg, heightCm);

    System.out.println("");
    System.out.println("A body mass index of 20 - 25 is considered \"normal\" ");
    System.out.printf("Your BMI is %.2f", output);
  } 


  /** 
  */ 
  public static double getBMI(int weightKG, int heightCM)
  {
    // complete for 80 pt version

    double BMI = weightKG/(Math.pow((heightCM/CM_TO_M), 2));
    return BMI;
  }

  /** 
  */
  public static void calculateImperialBMI()
  {
    // complete for 100 pt version
    Scanner input = new Scanner(System.in);
    System.out.println("");
    System.out.print("Enter your weight in pounds: ");
    int weightLbs = input.nextInt();
    System.out.println("");
    System.out.print("Enter your height in inches: ");
    int heightIn = input.nextInt();

    int convertedKg = convertPoundsToKG(weightLbs);
    int convertedCm = convertInchesToCM(heightIn);

    double output = getBMI(convertedKg, convertedCm);
    System.out.println("");
    System.out.println("A body mass index of 20 - 25 is considered \"normal\" ");
    System.out.printf("Your BMI is %.2f", output);
  }

  /** 
  */
  public static int convertPoundsToKG(int numPounds)
  {
    // complete for 100 pt version

    int convertedKgs = (int) (Math.round(numPounds*LBS_TO_KG));
    return convertedKgs;
  }

  /** 
  */
  public static int convertInchesToCM(int numInches)
  {
    // complete for 100 pt version
    int convertedIn = (int) (Math.round(numInches*IN_TO_CM));
    return convertedIn;
  }
}
