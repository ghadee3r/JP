/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
public class InvalidPriceException extends RuntimeException {
   public InvalidPriceException(){
       super("Price must be positive, and more than 450");
   }
    public InvalidPriceException (String str){
        super(str);
    }
}
