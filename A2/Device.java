/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moaaz
 */
class Device extends Thread {
    public  String name;
    public  String type;
 


    public void connect (){
        String namedev = name + "(" + type + ")";
       // Network.R.OccupyConnection(namedev);
        Network.myMainRouter.OccupyConnection(namedev);
    }
    
    public void activity () throws InterruptedException{
        System.out.println(name + "(" +type +")"+ " : performs online activity...");
        Network.appendStrToFile(name + "(" +type +")"+ " : performs online activity...");
        long r = (long) (Math.random() * 2000);
        Thread.sleep(r);
    }
    
    public void Logout(){
        String namedev = name + "(" + type + ")";
        System.out.println(namedev  + " : Logged Out.");
        Network.appendStrToFile(namedev  + " : Logged Out.");

       Network.myMainRouter.relaseConnection();
        }
    
    
    

	@Override
	public void run() { 
        
            connect();
        try {
            activity();
        } catch (InterruptedException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
            Logout();
        
        }
 
    
}
