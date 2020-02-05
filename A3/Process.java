/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hp
 */
public class Process {
public String name;
public String processColor;
public int arrivalTime;
public int burstTime;
public int priorityNumber;
public int quantum;
public int agFactor;
public int start;  
public int finish;
public boolean worked = false; //flag to know if this process worked at least once or not worked at all
 

    public Process() {
        agFactor = priorityNumber + burstTime + arrivalTime;
        this.quantum = 4;
    }

    public Process(String name, int arrivalTime, int burstTime, int priorityNumber) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priorityNumber = priorityNumber;
        agFactor = priorityNumber + burstTime + arrivalTime;
        this.quantum = 4;
        this.start = 0;
        this.finish = 0;
    }
    
    public void increaseQuantum(double amount){
        this.quantum += amount;
    }
    
    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getAgFactor() {
        return agFactor;
    }

    public void setAgFactor(int agFactor) {
        this.agFactor = agFactor;
    }
    
    public String getProcessColor() {
        return processColor;
    }

    public void setProcessColor(String processColor) {
        this.processColor = processColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }
 
 
 
}
