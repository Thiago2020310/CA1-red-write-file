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
        String fullName;
        String firstName = " Not set ";
        String secondName = " Not set ";
        
        String[] names = null;
        double price;
        int theClass, year;
        
        
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader("/Users/tgsouzadev/Desktop/PROGRAMMING AND MATHS FUNDAMENTALS/Java Applications/CA1-read-write-file/CA1-Project/customers.txt"));
            String line;
            while((line = fileReader.readLine()) != null){
                fullName = line;
                price = Double.parseDouble(fileReader.readLine());
                theClass = Integer.parseInt(fileReader.readLine());
                year = Integer.parseInt(fileReader.readLine());
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
            System.out.println("Please enter a valid integer.");
        }catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
}
