/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Moaaz
 */
public class Router extends Thread {
    
    ArrayList<Device> listOfConnection = new ArrayList();
     int limit;
    semaphore sem  ;
   
    
    

    Router() {
       sem = new semaphore(Network.limit);
    }


    
    
   
   public void OccupyConnection(String nameDevice){
       System.out.println(nameDevice + ": arrived.");
       Network.appendStrToFile(nameDevice + "arrived.");
       sem.P(nameDevice);
       System.out.println(nameDevice + ": Occupied.");
       Network.appendStrToFile(nameDevice + ": Occupied.");
       
       
   }
   
   public void relaseConnection(){
      sem.V();
   }
   
}
