/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

/**
 *
 * @author ghade
 */
public class InvalidPriceException extends RuntimeException {
   public InvalidPriceException(){
       super("Price must be positive");
   }
    public InvalidPriceException (String str){
        super(str);
    }
}
