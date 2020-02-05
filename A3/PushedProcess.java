/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3.mariamPackage;

/**
 *
 * @Mariam !!!!!!
 */
public class PushedProcess{
    
   public String name;
   public int startTime;
   public int finishTime;
   public  int Quantum;

    public PushedProcess(){
      
      // ass3.Process pr = ASS3.processesArr.get(0);
    }

    
    public PushedProcess(String name, int startTime, int finishTime , int Quantum) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.Quantum = Quantum;
    }

    public int getQuantum() {
        return Quantum;
    }

    public void setQuantum(int Quantum) {
        this.Quantum = Quantum;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PushedProcess{" + "name=" + name + ", startTime=" + startTime + ", finishTime=" + finishTime + ", Quantum=" + Quantum + '}';
    }

    

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
    
    
    
}
