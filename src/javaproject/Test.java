/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
import java.util.Scanner;
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
   
      Hotel hotel=new Hotel("Sofitel",100);
      Room room1=new StandardRoom(1,500,"Single");
      Room room2=new StandardRoom(2,500,"Double");
      Room room3=new StandardRoom(3,500,"Double");
   
      Room room4=new Suite(4,850,true);
      Room room5=new Suite(5,850,false);
      Room room6=new Suite(6,850,true);
   
      hotel.addRoom(room1);
      hotel.addRoom(room2);
      hotel.addRoom(room3);
      hotel.addRoom(room4);
      hotel.addRoom(room5);
      hotel.addRoom(room6);
   
      int choice;
      do {
         System.out.println("Welcome to the Sofitle Hotel Reservation System");
         System.out.println("1. Reserve a room");
         System.out.println("2. Cancel a reservation");
         System.out.println("3. Review reservation");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();
         switch (choice) {
            case 1:
               System.out.println("Room reservation:");
               System.out.println(hotel.availableRooms());
               if(!hotel.allRoomsReserved()){
                  System.out.print("Enter room number: ");
                  int roomNum = scanner.nextInt();
                  if (hotel.isAvailable(roomNum)==false) {
                     System.out.println("Sorry, the room is not available for reservation.");
                     break;}
               
               
                  System.out.print("Enter number of nights: ");
                  int numNights = scanner.nextInt();
                  System.out.print("\nEnter customer name: ");
                  String customerName = scanner.next();
                  System.out.print("\nEnter customer phone number: ");
                  int phoneNum = scanner.nextInt();
                  System.out.print("\nEnter customer ID: ");
                  String customerID = scanner.next();
                  Customer customer = new Customer(customerName, phoneNum, customerID);
                  hotel.makeReservation(customer, numNights, roomNum);
                  System.out.println("\nReservation has been completed ");
               
               
                  System.out.println("the total cost= "+hotel.searchRoom( roomNum ).calculatePrice());
               }
               break;
            case 2:
            
               System.out.println("Cancel reservation:");
               System.out.print("Enter room number to cancel reservation: ");
               int roomToCancel = scanner.nextInt();
               hotel.deleteReservation(roomToCancel);
               break;
            case 3:
            
               System.out.println("Review reservation:");
               hotel.getReservations();
               break;
            case 4:
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid choice. Please enter a number between 1 and 4.");
               break;
         }
      } while (choice != 4);
    }
    
}
