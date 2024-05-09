/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
public abstract class Room {
     protected int roomNum;
   protected double price;
   protected int NoNights;
   protected boolean reserved;
   private Customer customer;
   public Room(int rNum,double p){
      roomNum=rNum;
      NoNights=1;
      reserved=false;
      customer=null;
      price=p;
   }
   public Room(Room r){
      roomNum=r.roomNum;
      NoNights=r.NoNights;
      reserved=r.reserved;
      customer=r.customer;
   }
   public abstract double calculatePrice();
   public int getRoomNum(){
      return roomNum;
   }
   public void setRoomNum(int rNum){
      roomNum=rNum;
   }

   public double getPrice(){
      return price;
   }
   public int getNoNights(){
      return NoNights;
   }
   public void setNoNights(int nNights){
      NoNights=nNights;
   }

   public boolean getReserved(){
      return reserved;
   }
   public void setReserved(boolean res){
      reserved=res;
   }

   public Customer getCustomer(){
      return customer;
   }
   public void setCustomer(Customer c){
      customer=c;
   }
   public String toString() {
      String str="Room Number: " + roomNum +"\nPrice: " + calculatePrice();
   
      if(reserved)
         str+=" \nCustomer's info:"+customer ;
      return str;}
}
