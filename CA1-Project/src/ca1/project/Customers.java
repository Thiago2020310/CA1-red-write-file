/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1.project;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 *
 * @author 2020310 Thiago de Souza
 */
public class Customers {
    /*
    Instance variables to store name, price, class and year of the costumers. Set to private so it can only be accessed with setters and getters.
    */
    private String name;
    private String names[];
    private String firstName;
    private String secondName;
    private double price;
    private int theClass;
    private int year;
    
    /**
     * Constructor that takes the name, price, class and year from the file and creates an object with the set values.
     */
    public Customers(String name, String price, String theClass, String year){
        //call the function setName using the name input sent from the file.
        //The this.nameOfTheVariable indicates that the constructor is looking for the variable on the class and setting a value.
        setName(name);
        setPrice(price);
        setClass(theClass);
        setYear(year);
    }
    
    private Customers(){
        
    }
    
    //--METHODS--\\
    /*
    Setters to set the values for the variables. The setters will be public, which mens it can be accessed anywhere, void which means that this will not return any value.
    */
    /*
    setName setter will get the name from the input and assign to the variable name. 
    */
    public void setName(String input){
        try{
            //If statement to check if the input is null or if theres no space between the names.
            if(input == null || !input.contains(" ")) {
                //Using trow illegal argument exception for error handling this will stop the function if an error is found and throw an error message to the user - https://rollbar.com/blog/how-to-throw-illegalargumentexception-in-java/
                throw new IllegalArgumentException("Invalid name. There must be a space between the first and second name.");
            }
            String[] names = input.trim().split(" ");
            //If statement to check if there are more than two names.
            if(names.length != 2) {
                throw new IllegalArgumentException("Please enter only first and last name.");
            }
            /*
            Validation of first name using Regex pattern to accept only letters on the first name.
            */
            if(names[0].matches("^[a-zA-Z]+$")) {
                this.firstName = names[0];
            } else {
                throw new IllegalArgumentException("The first name must contain only letters.");
            }
            
            /*
            Validation of second name using regex pattern, but also accepting numbers as proposed.
            */
            if(names[1].matches("^[a-zA-Z0-9]+$")) {
                this.secondName = names[1];
            } else {
                throw new IllegalArgumentException("The second name must contain only letters or numbers.");
            }    
            
            //holds full name
            this.name = input;
            
        }catch(Exception e){
            //The Exception is global, and creates the "e" object, we are using the getMessage() method, which returns a synthax string related to the error identified.
            System.out.println(e.getLocalizedMessage());
        }
       
    }
    
    /**
     * 
     * @param input receive a double value
     */
    public void setPrice(String input){
        try{
            this.price = Double.valueOf(input);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            this.price = 0.0;
        }
    }
    
    /**
     * 
     * @param input receives the class input (digit)
     */
    public void setClass(String input){
        try{
            this.theClass = Integer.parseInt(input);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            this.theClass = 0;
        }
    }
    
    /**
     * 
     * @param input receives the integer year input
     */
    public void setYear(String input){
        try{
            this.year = Integer.parseInt(input);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            this.year = 0;
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

