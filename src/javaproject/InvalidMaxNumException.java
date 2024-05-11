/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

/**
 *
 * @author ghade
 */
public class InvalidMaxNumException extends Exception {
      public InvalidMaxNumException(){
       super("ID and PhoneNumber must be both 10 digits");
   }
    public InvalidMaxNumException (String str){
        super(str);
    }
}
