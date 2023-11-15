/* Mythical creature battle!
    This program takes in a csv file then outputs the power level of each creature and which is the strongest

  Programmer: A K
  Last Modified by: A K
  Last Edit: 04/18/2023
*/

import java.io.*;//needs exception
import java.util.Scanner;
import java.util.concurrent.TimeUnit;//needs exception

class Main {
  public static void main(String[] args) throws IOException, InterruptedException{

    perform();//do what user specified
    
    System.out.println("-------Program close.");
    
  }//end main method

  /**
  *  Method that asks the user what they wish to do
  *  @return the user choice
  */
  public static String userChoice() {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Welcome to the Mythical Creature Battle!\nMenu:\n1) Print creature power level\n2) Print strongest creature\n3) Exit");
    String userC = keyboard.nextLine();
    
    return userC;
  }//end userChoice

  /**
  *  Method to count lines in file
  */
  public static int countLines() throws IOException{
    
    File tempF = new File("Input.txt");
    Scanner f = new Scanner(tempF);

    int totalLines = 0;
    while(f.hasNext()){
      f.nextLine();
      totalLines++;     
    }
    f.close();

    return totalLines;
  }//end countLines

  /**
  *  Method that sees if the user wishes to restart the program
  */
  public static void checker(){
    Scanner keyboard = new Scanner(System.in);
    
    boolean ccheck = false;
    do{
      System.out.println("Would you like to run the program again? (yes or no)");
    String c = keyboard.nextLine();
      ccheck = false;
      
      if(c.equalsIgnoreCase("n") | c.equalsIgnoreCase("no")){
        System.exit(0);
      }else if(!(c.equalsIgnoreCase("y") | c.equalsIgnoreCase("yes"))){
        System.out.println("Please input yes or no.");
        ccheck = true;
      }
    }while(ccheck);
  }//checker
  
  /**
  *  Method that does what the user specified
  */
  public static void perform() throws IOException, InterruptedException{
    do{
      reConsole();
      String c = userChoice();
      if(c.equalsIgnoreCase("1")){
        //split file into array
        int l = countLines();
        String[] array = splitFile(l);//array of size l-1
        
        //create an array of objects of each line
        Creature[] creatures = createCreatures(array);//array of size l-1
        
        //create another array of objects with powers (and calculate power)
        Power[] powerLvls = createPower(creatures);//array of size l-1
        
        //print out powerLvls array
        printPowerLvls(powerLvls);
        
        powerLvls = null;//garbage collector

        checker();
        
      }else if(c.equalsIgnoreCase("2")){
        //split file into array
        int l = countLines();
        String[] array = splitFile(l);//array of size l-1
        
        //create an array of objects of each line
        Creature[] creatures = createCreatures(array);//array of size l-1
        
        //create another array of objects with powers (and calculate power)
        Power[] powerLvls = createPower(creatures);//array of size l-1
      
        //print out strongest creature(s)
        printStrong(powerLvls);
  
        powerLvls = null;

        checker();
        
      }else if(c.equalsIgnoreCase("3")){
        System.exit(0);
      }else{
        System.out.println("Error, invalid input. Please enter a number 1-3.");
      }
    }while(true);
    
  }//end perform

  /**
  *  Method that splits the file into an array
  *  @param lM The total # of lines in the file
  *  @return arr The array of file lines
  */
  public static String[] splitFile(int lM) throws IOException{

    String[] arr = new String[lM-1];
    
    File tempF = new File("Input.txt");
    Scanner f = new Scanner(tempF);
    f.nextLine();//remove first line with exemplar

    for(int i = 0; i < lM-1; i++){
      arr[i] = f.nextLine();
    }

    f.close();

    return arr;
  }//end splitFile

  /**
  *  Method that splits the array into creature objects
  *  @param arrayM The array of lines from file
  *  @return arrC The array of creatures
  */
  public static Creature[] createCreatures(String[] arrayM){

    Creature[] arrC = new Creature[arrayM.length];
    
    for(int i = 0; i < arrayM.length; i++){

      String[] splitArrayM = arrayM[i].split(",");
      String n = splitArrayM[0];
      Type t = null;
      Stage s = null;

      String tempT = splitArrayM[1];//add type to creature
      if(tempT.equalsIgnoreCase("HOBBIT")){
        t = Type.HOBBIT;
      }else if(tempT.equalsIgnoreCase("ELF")){
        t = Type.ELF;
      }else if(tempT.equalsIgnoreCase("WIZARD")){
        t = Type.WIZARD;
      }else if(tempT.equalsIgnoreCase("DRAGON")){
        t = Type.DRAGON;
      }else{
        System.out.println("Invalid Type: " + tempT);
        System.exit(0);
      }

      String tempS = splitArrayM[2];//add type to creature
      if(tempS.equalsIgnoreCase("SIMPLETON")){
        s = Stage.SIMPLETON;
      }else if(tempS.equalsIgnoreCase("EXTRAVAGANT")){
        s = Stage.EXTRAVAGANT;
      }else if(tempS.equalsIgnoreCase("OMNIPOTENT")){
        s = Stage.OMNIPOTENT;
      }else{
        System.out.println("Invalid Stage: " + tempS);
        System.exit(0);
      }
      
      arrC[i] = new Creature(n,t,s);
    }

    return arrC;
  }//end createCreatures

  /**
  *  Method that creates an array of power objects
  *  @param arrC1 The array of creature objects
  *  @return arrP The array of power objects
  */
  public static Power[] createPower(Creature[] arrC1){
    Power[] arrP = new Power[arrC1.length];

    for(int i = 0; i < arrC1.length; i++){
      arrP[i] = new Power(arrC1[i]);
      arrP[i].powerCalc();
    }

    return arrP;
  }//end createPower

  /**
  *  Method that prints out the creatures
  *  @param arrP1 The array of power objects
  */
  public static void printPowerLvls(Power[] arrP1){

    for(int i = 0; i < arrP1.length; i++){
      System.out.println("\n" + arrP1[i]);
    }
    
  }//end printPowerLvls

  /**
  *  Method that finds the strongest creatures
  *  @param arrP2 The array of power objects
  */  
  public static void printStrong(Power[] arrP2){

    double x = 0;//strongest power level
    
    for(int i = 0; i < arrP2.length; i++){
      double y = arrP2[i].powerCalc();
      if(y>x){
        x = y;
      }
    }//x is now the strongest power level

    if(x == 0){
      System.out.println("No creatures present!");
      System.exit(0);
    }

    int totalStrong = 0;
    for(int i = 0; i < arrP2.length; i++){     
      if(x == arrP2[i].powerCalc()){
        totalStrong++;
      }
    }//# of dupes
    
//fill array with strongest creatures
    int counter = 0;
    Power[] strongest = new Power[totalStrong];

    for(int i = 0; i < arrP2.length; i++){

      if(x==arrP2[i].powerCalc()){
        strongest[counter] = arrP2[i];
        counter++;
      }
      
    }

    System.out.println("\n-------The strongest creature(s) are: ");
    for(int i = 0; i < strongest.length; i++){
      System.out.println("\n" + strongest[i] + "\n");
    }
    
  }//end printStrong
  
  /**
  * Method that slows time and clears screen
  */
  public static void reConsole() throws InterruptedException{
    System.out.print("Clearing Screen");
    TimeUnit.SECONDS.sleep(1);
    System.out.print(" .");
    TimeUnit.SECONDS.sleep(1);
    System.out.print(" .");
    TimeUnit.SECONDS.sleep(1);
    System.out.print(" .\n");
    TimeUnit.SECONDS.sleep(1);
    System.out.print("\033[H\033[2J");
  }//end reConsole
  
}//end class Main