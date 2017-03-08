package sillygame;

public class Dice {
  public final int MAX= 6;
   public int roll(){
     return (int)(Math.random()*MAX)+1;
   }  
}

