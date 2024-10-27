/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 2020310  - Thiago de Souza
 */
public class CA1Project {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String fullName, price, theClass, year;
        
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\CA1-red-write-file\\customers.txt"));
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("Output.txt",false));
            String line;
            //The variable for line is declared before the loop because the while condition will read the first line of the file, therefore we need to have already initialized so that it can store the name right after the condition for the loop.
            while((line = fileReader.readLine()) != null){
                //All the field will receive a String value and then validate within the class method setter, if the value received can be transformed into the right data type, it means that its valid. For example if the user inputs Price: "23.a" The validator will send a message saying that the input is invalid and set the value to 0
                fullName = line;
                price = fileReader.readLine();
                theClass = fileReader.readLine();
                year = fileReader.readLine();
                Customers newCus = new Customers(fullName, price, theClass, year);
                newCus.setDiscount();
                myWriter.write("Hello World!");
                myWriter.close();
                System.out.println("Customer information: \n"
                        + "Name: " + newCus.getFirstName()+ " " + newCus.getSecondName() + "\n"
                        + "Price: " + newCus.getPrice() + "\n"
                        + "Customer class: " + newCus.getTheClass() + "\n"
                        + "Last Purchase(y): " + newCus.getYear()+ "\n");
            }
        }
        catch(NumberFormatException | IOException e){
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
}
