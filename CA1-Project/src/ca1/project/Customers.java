/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1.project;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author 2020310 Thiago de Souza
 */
public class Customers {
    /*
    Instance variables to store name, price, class and year of the costumers. Set to private so it can only be accessed with setters and getters.
    */
    private String name;
    private String firstName;
    private String secondName;
    private double price;
    private int theClass;
    private int currentYear;
    private int year;
    private double discount;
    private double finalPrice;
    private String error;

    Calendar calendar = Calendar.getInstance();
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
        this.discount = discount;
        this.finalPrice = finalPrice;
        setError(error);
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
            //set the error message to null initially. A fail safe in case the value from previous verifications are written.
            error = null;
            //If statement to check if the input is null or if theres no space between the names.
            if(input == null || !input.contains(" ")) {
                //Using trow illegal argument exception for error handling within a try and catch this will stop the function if an error is found and throw an error message to the user - https://rollbar.com/blog/how-to-throw-illegalargumentexception-in-java/
                 error = "Invalid name. There must be a space between the first and second name.";
                 throw new IllegalArgumentException(error);
            }
            String[] names = input.trim().split(" ");
            //If statement to check if there are more than two names.
            if(names.length != 2) {
                error = "Invalid name. Please enter only first and last name.";
                throw new IllegalArgumentException(error);
            }
            /*
            Validation of first name using Regex pattern to accept only letters on the first name.
            */
            if(names[0].matches("^[a-zA-Z]+$")) {
                this.firstName = names[0];
            } else {
                error = "First name invalid. The first name must contain only letters.";
                throw new IllegalArgumentException(error);
            }
            
            /*
            Validation of second name using regex pattern, but also accepting numbers as proposed.
            */
            if(names[1].matches("^[a-zA-Z0-9]+$")) {
                this.secondName = names[1];
            } else {
                error = "The second name must contain only letters or numbers.";
                throw new IllegalArgumentException(error);
            }    
            
            //holds full name
            this.name = input;
            
        }catch(Exception e){
            //Fail Safe.The Exception is global, and creates the "e" object, we are using the getMessage() method, which returns a synthax string related to the error identified.
            System.out.println(e.getLocalizedMessage());
        }
       
    }
    
    /**
     * 
     * @param input receive a double value
     */
    public void setPrice(String input){
        try{
            error = null;
            this.price = Double.valueOf(input);
        }catch(Exception e){
            //System.out.println("The price should be a double value.");
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
            if(theClass < 1 || theClass > 3){
                this.theClass = 0;
                throw new IllegalArgumentException("Invalid class. Customers class are defined 1,2 or 3.");
            }
        }catch(Exception e){
            //fail safe error message.
            System.out.println("The class must be an Integer between 1 and 3");
            this.theClass = 0;
       }
    }
    
    /**
     * 
     * @param input receives the integer year input
     */
    public void setYear(String input){
        try{
            this.currentYear = calendar.get(Calendar.YEAR);
            this.year = Integer.parseInt(input);
            if(year <= 1900 || year > currentYear){
                this.year =0;
               throw new IllegalArgumentException("The year should be higher than 1900 and lower than the current year.");
            }                
        }catch(Exception e){
            System.out.println("The year must be an Integer between 1900 and the current year");
            this.year = 0;
        }
    }
    
    public void setDiscount(){
        try{
            calcDisc(this.theClass, this.year);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public void setError(String errorMessage){
        try{
            this.error = errorMessage;
        }catch(Exception e){
            
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
    
    public double getFP(){
        return finalPrice;
    }
    
    
   public String getError(){
       return error;
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
   
    public double getDisc(){
        return discount;
    }
    /*
    Methods to define what the class can do.
    */
    /**
     * 
     * @param theClass - Method receives a Integer ref the customer class
     * @param theYear - Method receives a integer with the year of the last purchase
     * @return the discount based on the two parameters
     */
    public double calcDisc(int theClass, int theYear){
        try{
            switch(theClass){
                case 1:
                    if(theYear == this.currentYear){
                        this.discount = this.price * 0.30;
                        this.finalPrice = price - discount;
                        System.out.println("The customer gets a 30% discount.");
                    }else if((theYear +5) > this.currentYear){
                        this.discount = this.price * 0.20;
                        this.finalPrice = price - discount;
                        System.out.println("The customer gets a 20% discount.");
                    }else if((theYear +5) < this.currentYear){
                        this.discount = this.price * 0.10;
                        this.finalPrice = price - discount;
                        System.out.println("The customer gets a 10% discount.");
                    }
                    break;
                case 2:
                    if(theYear == this.currentYear){
                        this.discount = this.price * 0.15;
                        this.finalPrice = price - discount;
                        System.out.println("The customer gets a 15% discount.");
                    }else if((theYear +5) > this.currentYear){
                        this.discount = this.price * 0.13;
                        this.finalPrice = price - discount;
                        System.out.println("The customer gets a 13% discount.");
                    }else if((theYear +5) < this.currentYear){
                        this.discount = this.price * 0.05;
                        this.finalPrice = price - discount;
                        System.out.println("The customer gets a 5% discount.");
                    }
                    break;
                case 3:
                    if(theYear == this.currentYear){
                        this.discount = this.price * 0.03;
                        this.finalPrice = price - discount;
                        System.out.println("The customer gets a 3% discount.");
                    }else if((theYear +5) > this.currentYear){
                        this.discount = 0;
                        this.finalPrice = price;
                        System.out.println("No discounts available at the moment");
                    }
                    break;
                default:
                    System.out.println("The customer doesn't fit the requisites for discounts at the moment.");
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return discount;  
    }
    
    public void writeMessage(){
        try{
            
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
    
    
    
}  

