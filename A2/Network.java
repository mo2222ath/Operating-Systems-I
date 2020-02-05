/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Moaaz
 */
public class Network {
    public static Integer limit ;
    
    public static  Router myMainRouter ;

    public  static Device D;
    
    public static void appendStrToFile(String str)
    { 
        try { 
  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter("NetWork.txt", true)); 
            out.write(str);
            out.write("\n");
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    } 
    
    
    
    
    public static void main(String[] args) throws InterruptedException {
    
    
    List<Device> arrDevices = new ArrayList();
    Scanner in = new Scanner(System.in);
    System.out.println("What is number of WI-FI Connections?");
    int numberOfConnection = in.nextInt();
    
    limit = numberOfConnection;
    
     myMainRouter = new Router();
    
    System.out.println("What is number of devices Clients want to connect?");
    int numberOfDevices = in.nextInt();
    
        for (int i = 0; i < numberOfDevices; i++) {
            
            D = new Device();
            String n = in.next();
            String t = in.next();
            D.name = n;
            D.type = t;
            
            arrDevices.add(D);
            
        }
        appendStrToFile("************ Muaath - Yageen - Mariam ******************");
        appendStrToFile("Program is Running with " + numberOfConnection +" Of Connection and " + numberOfDevices + " Of Devices" );
        for (int i = 0; i < numberOfDevices; i++) {
            //System.out.println(arrDevices.get(i).name);
            
            arrDevices.get(i).start();
        }
      
        
    }
    
    
}
