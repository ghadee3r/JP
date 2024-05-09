/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
public class Suite extends Room {
     private boolean balcony;
   public Suite(int rNum,double p,boolean balc){
      super(rNum,p);
      balcony=balc;
   }
   public Suite(Suite Su){
      super(Su.roomNum,Su.price);
      balcony=Su.balcony;
   }

   public double calculatePrice(){
      if ( balcony)
         return price*NoNights+350;
      else
         return price*NoNights;}

   public String toString(){
      String str = super.toString()+"\nBalcony prefrance: ";
      if ( balcony)    
         str=str+"with balcony.";
      else
         str=str+"with out balcony.";
      return str;
   }
}
