/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author 2020310  - Thiago de Souza
 */
public class CA1Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customers[] customersArr;
        
        try{
            Scanner fileReader = new Scanner(new FileReader("/Users/tgsouzadev/Desktop/PROGRAMMING AND MATHS FUNDAMENTALS/Java Applications/CA1-read-write-file/customers.txt"));
            for(int i =0; i<=4; i++){
                while(fileReader.hasNext()){ 
                    System.out.println(fileReader.nextLine());
                }
            }
//            customer1.setName(fileReader.nextLine());
//            System.out.println(customer1.getName());
//            System.out.println(customer1.getFirstName());
//            System.out.println(customer1.getSecondName());
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
