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
        
        /*
        Set the String variables that will be used to collect full name, price, class and year that will be used for validation and calculation on the class. The data could have been collected as they proper data types,
        which means that price could be collected as double, year as int etc. I chose to collect as a String so that the error occours after all the data is processed and then the error message is written on the file
        instead of throwing the error to the console. 
        To print the error to the console we could simply collect the data as it should be done (int, double, etc) and validate with the try/illegalexpression/catch, if's else conditions or even a validation method.
        */
        String fullName, price, theClass, year;
        
        try{
            //Create a bufferedReader and store to the variable file reader that we will use with FileReader Class to read the file.
            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\CA1-red-write-file\\customers.txt"));
            //Create a BufferedWriter with the FileWritter class to create a new file, set it to false so it can update the file everytime we loop through it.
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("customerdiscount.txt",false));
            //Note: that both files above are on the same path, but just refferenced different as relative and absolute paths.
            String line;
            //The variable for line is declared before the loop because the while condition will read the first line of the file, therefore we need to have already initialized so that it can store the name right after the condition for the loop.
            while((line = fileReader.readLine()) != null){
                //All the field will receive a String value and then validate within the class method setter, if the value received can be transformed into the right data type, it means that its valid. For example if the user inputs Price: "23.a" The validator will send a message saying that the input is invalid and set the value to 0
                fullName = line;
                price = fileReader.readLine();
                theClass = fileReader.readLine();
                year = fileReader.readLine();
                //Call the constructo from the class. Note that we need to pass the full name, price, class and year. The default constructo given in Java with no parameters was made private, so that it cannot be used in order to not break the logic.
                Customers newCus = new Customers(fullName, price, theClass, year);
                //Call thw Writer write function to update the file with the information give.
                myWriter.write(newCus.getMesssage());
                //Create a new line between users for better visibility.
                myWriter.newLine();
                //I'm keeping this so we can validate the data read from the file. It can be erased if needed. Won't change anything on the logic.
                System.out.println("Customer information: \n"
                        + "Name: " + newCus.getFirstName()+ " " + newCus.getSecondName() + "\n"
                        + "Price: " + newCus.getPrice() + "\n"
                        + "Customer class: " + newCus.getTheClass() + "\n"
                        + "Last Purchase(y): " + newCus.getYear()+ "\n");
                // End of system print 
            }
            myWriter.close();
        }
        catch(NumberFormatException | IOException e){
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
}
