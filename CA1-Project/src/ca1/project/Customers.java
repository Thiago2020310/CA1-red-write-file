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
    private String discMessage;
    private double finalPrice;
    private String finalMessage;
    private String error;

    Calendar calendar = Calendar.getInstance();
    /**
     * Constructor that takes the name, price, class and year from the file and creates an object with the set values.
     */
    public Customers(String name, String price, String theClass, String year){
        //call the function setName using the name input sent from the file.
        //The this.nameOfTheVariable indicates that the constructor is looking for the variable on the class and setting a value. At the end I choose to call the methods inside the constructor as set methods, which would potentially not be recommended, but I wans't sure and it fitted my logic.
        setName(name);
        setPrice(price);
        setClass(theClass);
        setYear(year);
        setDiscount();
        setError(error);
        writeMessage();
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
                //Using trow illegal argument exception for error handling within a try and catch this will stop the function if an error is found and throw an error message to the user - https://rollbar.com/blog/how-to-throw-illegalargumentexception-in-java/
                 setError("Invalid name. There must be a space between the first and second name.");
                 return;
            }
            String[] names = input.trim().split(" ");
            //If statement to check if there are more than two names.
            if(names.length != 2) {
                setError("Invalid name. Please enter only first and last name.");
                return;
            }
            /*
            Validation of first name using Regex pattern to accept only letters on the first name.
            */
            if(names[0].matches("^[a-zA-Z]+$")) {
                this.firstName = names[0];
            } else {
                setError("First name invalid. The first name must contain only letters.");
                return;
            }
            
            /*
            Validation of second name using regex pattern, but also accepting numbers as proposed.
            */
            if(names[1].matches("^[a-zA-Z0-9]+$")) {
                this.secondName = names[1];
            } else {
                setError("The second name must contain only letters or numbers.");
                return;
            }
            //holds full name
            this.name = input;
            
        }catch(Exception e){
            //Fail Safe.The Exception is global, and creates the "e" object, we are using the getMessage() method, which returns a synthax string related to the error identified.
            setError("First and last name required. There must be an space between them. Only letters are accepted on first name and letters and/or numbers are accepted on last name.");
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
            setError("The price should be a double value.");
            System.out.println(this.error);
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
                setError("Invalid class. Customers class are defined 1,2 or 3.");
                this.theClass = 0;
                throw new IllegalArgumentException(this.error);
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
                setError("The year should be higher than 1900 and lower than the current year.");
                this.year = 0;
                throw new IllegalArgumentException(this.error);
            }                
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            this.year = 0;
        }
    }
    
    //Call the function calcDic created that will do the mathematics behind the discount, and assisgn the value to the discount variable. This probably isn't necessary, since the only reason for the method is to call another method.
    public void setDiscount(){
        try{
            calcDisc(this.theClass, this.year);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    
    //Set the error message based on the error found during validation. This method will be used on the setters.
    public void setError(String error){
        try{
            this.error = error;
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
    
    /**
     * 
     * @return The final price
     */
    public double getFP(){
        return finalPrice;
    }
    
    /**
     * 
     * @return the error message
     */
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
   
    //get the discount value.
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
            //Fail safe to reset the discount message before executes the code.
            discMessage = null;
            
            /*
            Switch statement based on the class variable.
            Each case reflects the classes.
            Inside the cases a if statement to do the logic behind the possible discounts.
            The break will stop the conditions if one of the cases is accessed.
            */
            switch(theClass){
                case 1:
                    if(theYear == this.currentYear){
                        discMessage = "The customer gets a 30% discount.";
                        this.discount = this.price * 0.30;
                        this.finalPrice = price - discount;
                        //System.out.println(discMessage);
                    }else if((theYear +5) > this.currentYear){
                        discMessage = "The customer gets a 20% discount.";
                        this.discount = this.price * 0.20;
                        this.finalPrice = price - discount;
                        //System.out.println(discMessage);
                    }else if((theYear +5) < this.currentYear){
                        discMessage = "The customer gets a 10% discount.";
                        this.discount = this.price * 0.10;
                        this.finalPrice = price - discount;
                        //System.out.println(discMessage);
                    }
                    break;
                case 2:
                    if(theYear == this.currentYear){
                        discMessage = "The customer gets a 15% discount.";
                        this.discount = this.price * 0.15;
                        this.finalPrice = price - discount;
                        //System.out.println(discMessage);
                    }else if((theYear +5) > this.currentYear){
                        discMessage = "The customer gets a 13% discount.";
                        this.discount = this.price * 0.13;
                        this.finalPrice = price - discount;
                        //System.out.println(discMessage);
                    }else if((theYear +5) < this.currentYear){
                        discMessage = "The customer gets a 5% discount.";
                        this.discount = this.price * 0.05;
                        this.finalPrice = price - discount;
                        //System.out.println(discMessage);
                    }
                    break;
                case 3:
                    if(theYear == this.currentYear){
                        discMessage = "The customer gets a 3% discount.";
                        this.discount = this.price * 0.03;
                        this.finalPrice = price - discount;
                        //System.out.println(discMessage);
                    }else if((theYear +5) > this.currentYear){
                        discMessage = "No discounts available at the moment";
                        this.discount = 0;
                        this.finalPrice = price;
                        //System.out.println(discMessage);
                    }
                    break;
                default:
                    //The remaining possible values for the class are not applicable to a discount, therefore not calculated and the final price is given the same as initial price.
                    discMessage = "The customer doesn't fit the requisites for discounts at the moment.";
                    this.finalPrice = price;
                    System.out.println(discMessage);
            }
        }catch(Exception e){
            //Fail safe exception in case any other error is found.
            System.out.println(e.getLocalizedMessage());
        }
        return discount;  
    }
    
    /**
     * 
     * Write message method to set the final message variable to hold the String to be written on the new file. 
     * The if condition checks if any error was found on the process, if so the error is also written on the customer information.
     */
    public void writeMessage(){
        try{
            if(this.error == null){
                finalMessage = "Customer information: \n"
                        +"Name:" + firstName +" " + secondName + "\n"
                        + discMessage + "\n"
                        +"Final Price: $" + finalPrice + "($"+discount+" discount)\n";
            }else if (this.error != null){
                finalMessage = "Customer information: \n"
                        + this.error + "\n"
                        +"Name:" + firstName +" " + secondName + "\n"
                        + discMessage + "\n"
                        +"Final Price: $" + finalPrice + "($"+discount+" discount)\n";
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
    /**
     * 
     * @return the message to be written to the customer.
     */
    public String getMesssage(){
        return finalMessage;
    }
    
    
    
}  

