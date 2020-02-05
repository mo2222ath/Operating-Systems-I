/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Moaaz
 */
class semaphore {

  protected int value = 0 ;

  protected semaphore() { value = 0 ; }

  protected semaphore(int initial) { value = initial ; }

  public synchronized void P(String name) {
	  
    value-- ;
    if (value < 0)
      try { 
          System.out.println(name + " : arrived and waiting !!!");
          Network.appendStrToFile(name + " : arrived and waiting !!!");
          wait() ; 
      } catch(  InterruptedException e ) { }
  }

  public synchronized void V() {
    value++ ; if (value <= 0) notify() ;
  }
}
