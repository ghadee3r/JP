
package JavaProject;
import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author ghade
 */
public class Hotel implements Serializable{
    
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
   public int getSize(){
       return roomList.length;
   }

   public Room searchRoom ( int roomNum ){
      for ( int i=0; i< numOR; i++)
         if ( roomList[i].getRoomNum() == roomNum )
            return roomList[i] ;
   
      return null;
   
   }

    public String getName(){
    
        return name;
    
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


   public String getReservations() {
   
   String stri="";
          
      for (int i = 0; i < numOR; i++) {
      
         if (roomList[i] != null && roomList[i].getReserved())
        
        stri+=roomList[i]+"\n---------------------------\n";
         
      
      } 
      return stri;
}


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

   public boolean makeReservation (Customer C, int noNights, int roomNum){
      if (searchRoom(roomNum)!=null && isAvailable(roomNum) ){
         for (int i =0; i < numOR; i++)
            if(roomList[i].getRoomNum()==roomNum){
               roomList[i].setCustomer(C);
               roomList[i].setNoNights(noNights);
               roomList[i].setReserved(true);
               return true;
            }
      
      }
      return false;
   }



   public boolean deleteReservation(int roomNum) {
    // Check if the room exists and is not available
      if (searchRoom(roomNum)!=null && !isAvailable(roomNum)) {
         for (int i = 0; i < numOR; i++) {
            if (roomList[i].getRoomNum() == roomNum) {
            
               roomList[i].setCustomer(null);
               roomList[i].setNoNights(0);   
               roomList[i].setReserved(false);
              
               return true; // Exit the method once the reservation is deleted
            }
         }
      } return false;
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
   
 


/*

 public boolean load (String fileName){

       try{
File f= new File (fileName);
if(! f.exists() ){
return false;
}
FileInputStream fi = new FileInputStream(f);
ObjectInputStream in=new ObjectInputStream(fi);

int size= in.readInt();
String Name =(String) in.readObject();

name=Name;

for (int i=0; i<size; i++){
    Room obj= (Room) in.readObject();
    this.addRoom(obj);
            }
in.close();
   }
   catch(ClassNotFoundException ex) { 
                  JOptionPane.showMessageDialog(null,"error") ;}

   
   catch(IOException ex){
          JOptionPane.showMessageDialog(null,"error"+ ex.toString()) ;
   }       
   
       return true;


}*/

}
 



