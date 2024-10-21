/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1.project;

/**
 *
 * @author 2020310 Thiago de Souza
 */
public class Customers {
    /*
    Variables to store name, price, class and year of the costumers. Set to private so it can only be accessed with setters and getters.
    */
    private String name;
    private double price;
    private int theClass;
    private int year;
    
    /*
    Setters to set the values for the variables. The setters will be public, which mens it can be accessed anywhere, void which means that this will not return any value.
    */
    /*
    setName setter will get the name from the input and assign to the variable name. 
    */
    public void setName(String input){
        try{
            //the "this.variable" here mans that we are looking for the variable on this class.
            this.name = input;
        }catch(Exception e){
            //The Exception is global, and creates the "e" object, we are using the getMessage() method, which returns a synthax string related to the error identified.
            e.getMessage();
        }
       
    }
    /*
    Getters to get the values from the variables.
    */
    public String getName(){
        return name;
    }
    /*
    Methods to define what the class can do.
    */
    
}  

