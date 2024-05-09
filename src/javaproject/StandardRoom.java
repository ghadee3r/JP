/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
public class StandardRoom extends Room {
  private String bedType;

   public StandardRoom(int rNum,double p,String bType){
      super(rNum,p);
      bedType=bType;
   }
   public StandardRoom(StandardRoom SR){
      super(SR.roomNum,SR.price);
      bedType=SR.bedType;
   }
   public double calculatePrice(){
   
      if ( bedType.equals("single"))
         return price*NoNights;
      else 
         return 150+price*NoNights;
   }
   public String toString(){
      return super.toString()+"\ntype of bed: "+bedType;
   }

   public String getBedType(){
      return bedType;
   }   
}
