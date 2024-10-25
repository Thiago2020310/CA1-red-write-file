/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 2020310  - Thiago de Souza
 */
public class CA1Project {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String fullName, price, theClass, year;
        String firstName = " Not set ";
        String secondName = " Not set ";
        
        String[] names = null;
        
        
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\CA1-red-write-file\\customers.txt"));
            String line;
            //The variable for line is declared before the loop because the while condition will read the first line of the file, therefore we need to have already initialized so that it can store the name right after the condition for the loop.
            while((line = fileReader.readLine()) != null){
                //All the field will receive a String value and then validate within the class method setter, if the value received can be transformed into the right data type, it means that its valid. For example if the user inputs Price: "23.a" The validator will send a message saying that the input is invalid and set the value to 0
                fullName = line;
                price = fileReader.readLine();
                theClass = fileReader.readLine();
                year = fileReader.readLine();
                Customers newCus = new Customers(fullName, price, theClass, year);
                System.out.println("Customer information: \n"
                        + "Name: " + newCus.getSecondName()+ "\n"
                        + "Price: " + newCus.getPrice() + "\n"
                        + "Customer class: " + newCus.getTheClass() + "\n"
                        + "Year: " + newCus.getYear()+ "\n");
                
            }
            
//            customer1.setName(fileReader.nextLine());
//            System.out.println(customer1.getName());
//            System.out.println(customer1.getFirstName());
//            System.out.println(customer1.getSecondName());
        }
        catch(NumberFormatException e){
            System.out.println("The number entered is invalid.");
        }catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
}
