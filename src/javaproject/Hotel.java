/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
public class Hotel {
     private String name;

   private int numOR;
   Room [] roomList;

   public Hotel ( String name, int size ) {
      this.name=name;
      numOR=0;
      roomList= new Room[size];
   }

   public boolean isFull(){
   
      if ( numOR<roomList.length )
         return false;
      else
         return true;
   
   }

   public Room searchRoom ( int roomNum ){
      for ( int i=0; i< numOR; i++)
         if ( roomList[i].getRoomNum() == roomNum )
            return roomList[i] ;
   
      return null;
   
   }



   public boolean isAvailable(int roomNum) {
   
      for (int i = 0; i < numOR; i++) {
      
         if (roomList[i] != null && roomList[i].getRoomNum() == roomNum) {
         
         
            if (!roomList[i].getReserved()) {
            
            
               return true; // Room is available
            } else {             
               return false; // Room is already reserved
            }
         }
      }
      return false; // Room not found in the list
   }


   public void getReservations() {
   
   
      for (int i = 0; i < numOR; i++) {
      
         if (roomList[i] != null && roomList[i].getReserved()) 
         
            System.out.println(roomList[i]+"\n---------------------------");
        
          
      
      
      }}


   public boolean addRoom ( Room R ){
      if ( isFull())
         return false ;
      
      else {
         if ( R instanceof StandardRoom )
            roomList [ numOR++ ] = new StandardRoom( ( StandardRoom) R );
         else
            if ( R instanceof Suite )
               roomList [ numOR++ ] = new Suite ( (Suite) R );
      
         return true; }
   }

   public boolean deleteRoom ( int rNum ){
      for ( int i=0; i< numOR; i++)
         if ( roomList[i].getRoomNum()== rNum ){
            roomList[i]=roomList[numOR-1];
            numOR--;
            roomList[numOR]=null;
            return true;}
      return false;
   }

   public void makeReservation (Customer C, int noNights, int roomNum){
      if (searchRoom(roomNum)!=null && isAvailable(roomNum) ){
         for (int i =0; i < numOR; i++)
            if(roomList[i].getRoomNum()==roomNum){
               roomList[i].setCustomer(C);
               roomList[i].setNoNights(noNights);
               roomList[i].setReserved(true);
            }}
   }



   public void deleteReservation(int roomNum) {
    // Check if the room exists and is not available
      if (searchRoom(roomNum)!=null && !isAvailable(roomNum)) {
         for (int i = 0; i < numOR; i++) {
            if (roomList[i].getRoomNum() == roomNum) {
            
               roomList[i].setCustomer(null);
               roomList[i].setNoNights(0);   
               roomList[i].setReserved(false);
               System.out.println("Reservation for room " + roomNum + " has been deleted.");
               return; // Exit the method once the reservation is deleted
            }
         }
      } else {
        // If the room doesn't exist or is available, print a message
         System.out.println("Reservation for room " + roomNum + " does not exist.");
      }
   }
   public String toString(){
      String str="";
      str += "Name: "+ name + "\n Number of rooms: " + numOR +"\n";
   
      for ( int i=0; i< numOR; i++){
         str+= roomList[i].getClass().getName()+"\n";
         str+= roomList[i].toString()+"\n";
         str += "----------------------------------------\n";
      }
   
      return str;
   }

   public String availableRooms(){
   
      int numOfReservedRooms=0;
      String str="";
   
   
      str += "Name: "+ name + "\n Number of rooms: " + numOR +"\n";
   
      for ( int i=0; i< numOR; i++){
         if(roomList[i].getReserved())
            numOfReservedRooms++;
         else{
            str+= roomList[i].getClass().getName()+"\n";
            str+= roomList[i].toString()+"\n";
            str += "----------------------------------------\n";}
      }
      if(allRoomsReserved())
         str="all rooms are reserved. ";
      return str;
   }

   public boolean allRoomsReserved(){
   
      int numOfReservedRooms=0;
   
      for ( int i=0; i< numOR; i++)
         if(roomList[i].getReserved())
            numOfReservedRooms++;
   
   
      if(numOfReservedRooms==numOR)
      
         return true;
   
      return false;
   }


}
