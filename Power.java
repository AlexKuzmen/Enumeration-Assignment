/* Power.java
  This class stores the power level of the creature
  Programmer: A K
  Last Modified by: A K
  Last edit: 04/16/2023
*/

import java.util.*;

public class Power{ 

  private double powerLvl; //power of creature
  private double[] arrayT = {1,4,8,16}; //of size type using power of 2
  private double[] arrayS = {32,64,128}; //of size stage using power of 2
  private Creature creature; //get creature

  /**
  * Constructor that sets the info.
  * @param i The creature
  */
  public Power(Creature i){
    
    creature = new Creature(i);
  
  }//end Power

  /**
  * Returns the power level of a creature
  * @return powerLvl as a double
  */
  public double powerCalc(){

    Type t = creature.getType();
    Stage s = creature.getStage();
    
    switch (t){
      case HOBBIT:
        switch(s){
          case SIMPLETON:
            powerLvl = arrayT[0] + arrayS[0];
            break;
          case EXTRAVAGANT:
            powerLvl = arrayT[0] + arrayS[1];
            break;  
          case OMNIPOTENT:
            powerLvl = arrayT[0] + arrayS[2];
            break;
          default:
            System.out.println("Error, not a suitable stage.");
            System.exit(0);
        }
        break;
        
      case ELF:
        switch(s){
          case SIMPLETON:
            powerLvl = arrayT[1] + arrayS[0];
            break;
          case EXTRAVAGANT:
            powerLvl = arrayT[1] + arrayS[1];
            break;  
          case OMNIPOTENT:
            powerLvl = arrayT[1] + arrayS[2];
            break;
          default:
            System.out.println("Error, not a suitable stage.");
            System.exit(0);            
        }
        break;
        
      case WIZARD:
        switch(s){
          case SIMPLETON:
            powerLvl = arrayT[2] + arrayS[0];
            break;
          case EXTRAVAGANT:
            powerLvl = arrayT[2] + arrayS[1];
            break;  
          case OMNIPOTENT:
            powerLvl = arrayT[2] + arrayS[2];
            break;
          default:
            System.out.println("Error, not a suitable stage.");
            System.exit(0);            
        }
        break;
        
      case DRAGON:
        switch(s){
          case SIMPLETON:
            powerLvl = arrayT[3] + arrayS[0];
            break;
          case EXTRAVAGANT:
            powerLvl = arrayT[3] + arrayS[1];
            break;  
          case OMNIPOTENT:
            powerLvl = arrayT[3] + arrayS[2];
            break;
          default:
            System.out.println("Error, not a suitable stage.");
            System.exit(0);            
        }
        break;
        
      default:
        System.out.println("Error, not a suitable type.");
        System.exit(0);
    }//end powerCalc

    return powerLvl;
  
  }//end powerCalc

  /**
  * toString method
  * @return a string containing the info on the creature with power level
  */
  public String toString(){
    return creature + ", with a power level of: " + powerLvl;
  }//end to String
  
}//end class Power