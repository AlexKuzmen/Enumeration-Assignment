/* Creature.java
  This class stores data about kind of the mythical creature
  Programmer: A K
  Last Modified by: A K
  Last edit: 04/16/2023
*/

enum Type {HOBBIT, ELF, WIZARD, DRAGON}//The possible creatures
enum Stage {SIMPLETON,EXTRAVAGANT,OMNIPOTENT}//The possible stage of creature

public class Creature{

  //creature info
  private String name;
  private Type type;
  private Stage stage;

  /**
  * Constructor that sets the info.
  * @param n The name of the creature
  * @param t The type of the creature
  * @param s The stage of the creature
  */
  public Creature(String n, Type t, Stage s){
//set the name but use switch case to check and use enum to set type and stage
    switch (t){
      case HOBBIT:
        type = Type.HOBBIT; 
        break;
      case ELF:
        type = Type.ELF; 
        break;
      case WIZARD:
        type = Type.WIZARD; 
        break;
      case DRAGON:
        type = Type.DRAGON;  
        break;
      default:
        System.out.println("Error, " + t + ", not a suitable type.");
        System.exit(0);
    }//type
    switch (s){
      case SIMPLETON:
        stage = Stage.SIMPLETON;
        break;
      case EXTRAVAGANT:
        stage = Stage.EXTRAVAGANT;
        break;
      case OMNIPOTENT:
        stage = Stage.OMNIPOTENT;
        break;
      default:
        System.out.println("Error, " + s + ", not a suitable stage.");
        System.exit(0);
    }//stage
    name = n;
  }//end Creature

  /**
  * The copy contstructor initializes the object as a copy of another Creature.
  * @param object 2 The object to copy
  */
  public Creature(Creature object2){
    name = object2.name;
    type = object2.type;
    stage = object2.stage;
  }//end Creature copy

  /**
  * Returns the name of the creature.
  * @return name as an String
  */
  public String getName(){
    return name;
  }//end getName
  
  /**
  * Returns the type of the creature.
  * @return type as a Type
  */
  public Type getType(){
    return type;
  }//end getType
  
  /**
  * Returns the stage of the creature.
  * @return stage as a Stage
  */
  public Stage getStage(){
    return stage;
  }//end getStage
  
  /**
  * toString method
  * @return a string containing the creature information
  */
  public String toString(){
    return name + " is a(n) " + stage.toString() + " " + type.toString();
  }//end to String
  
}//end class Creature