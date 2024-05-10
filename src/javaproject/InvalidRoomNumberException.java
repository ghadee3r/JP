/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

/**
 *
 * @author ghade
 */
public class InvalidRoomNumberException extends Exception {
   
    public InvalidRoomNumberException (){
        super("Invalid Room number  , try agin");
    }
    public InvalidRoomNumberException (String str){
        super(str);
    }
}
