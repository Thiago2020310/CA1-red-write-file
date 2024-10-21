/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.project;

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
        Customers customer1 = new Customers();
        
        
        try{
            Scanner fileReader = new Scanner(new FileReader("/Users/tgsouzadev/Desktop/PROGRAMMING AND MATHS FUNDAMENTALS/Java Applications/CA1-read-write-file/customers.txt"));
            customer1.setName(fileReader.nextLine());
            System.out.println(customer1.getName());
            customer1.setName(fileReader.nextLine());
            System.out.println(customer1.getName());
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
