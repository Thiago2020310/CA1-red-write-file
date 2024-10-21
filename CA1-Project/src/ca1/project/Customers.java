/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1.project;
import java.time.LocalDate;

/**
 *
 * @author 2020310 Thiago de Souza
 */
public class Customers {
    /*
    Variables to store name, price, class and year of the costumers. Set to private so it can only be accessed with setters and getters.
    */
    private String name;
    private String firstName;
    private String secondName;
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
            String[] names = name.split(" ");
            firstName = names[0];
            secondName = names[1];
            
        }catch(Exception e){
            //The Exception is global, and creates the "e" object, we are using the getMessage() method, which returns a synthax string related to the error identified.
            System.out.println(e.getLocalizedMessage());
        }
       
    }
    
    public void setPrice(double input){
        try{
            this.price = input;
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public void setClass(int input){
        try{
            this.theClass = input;
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public void setYear(int input){
        try{
            this.year = input;
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    /**
    *
    * @return The name of the customer.
    */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @return The customer First name;
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * 
     * @return The customer Second name;
     */
    public String getSecondName(){
        return secondName;
    }
    /**
     * 
     * @return The total price
     */
    public double getPrice(){
        return price;
    }
    
    /**
     *
     * @return The class of the customer
     */
    public int getTheClass(){
        return theClass;
    }
    
    /**
     * 
     * @return The year input
     */
    public int getYear(){
        return year;
    }
    
    
    /*
    Methods to define what the class can do.
    */
    
}  

