/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
public class Customer {
     private String customerName;

   private int phoneNum;

   private String customerID;

   public Customer ( String cN, int pN, String customerID ){
   
      customerName=cN;
   
      phoneNum=pN;
   
      this.customerID= customerID;}

   public String toString(){
      return "Name: "+customerName+"\nPhone number: "+phoneNum+"\nID: "+customerID;
   
   }
}
