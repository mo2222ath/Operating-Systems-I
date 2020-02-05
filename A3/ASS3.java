/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ass3.mariamPackage.PushedProcess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Muaath , Yageen , Mariam and Nadia ^_^
 */
public class ASS3 {

    
    public static HashMap<String, Integer> processesArrivalTime = new HashMap<>();
    public static HashMap<String, Integer> processesBurstTime = new HashMap<>();
    public static HashMap<String, Process> processesArr = new HashMap<>();
    public static HashMap<String, Integer> waitingList = new HashMap<>();
//    public static ArrayList<Process> processesArr = new ArrayList<>();
    public static ArrayList<ass3.mariamPackage.PushedProcess> GANTT = new ArrayList<>();
//    public static HashMap<String, Integer> processesArrivalTime = new HashMap<>();
//    public static HashMap<String, Integer> processesBurstTime = new HashMap<>();
    //*****************************************************************
    public static ArrayList<Process> readyQueue = new ArrayList<>();
    public static ArrayList<Process> chartQueue = new ArrayList<>();
    //**************************************************************
    public static int numberOfProcesses;
    public static int roundRobinTimeQuantum;
    public static int contextSwitching;

    public static void main(String[] args) {

//         Scanner scan = new Scanner(System.in);
//         System.out.print("Enter number of processes:");
//         numberOfProcesses = scan.nextInt();
//         System.out.print("Enter round Robin Time Quantum:");
//         roundRobinTimeQuantum = scan.nextInt();
//         System.out.print("Enter context switching:");
//         contextSwitching = scan.nextInt();
//         Process processObject = new Process();
//
//         for (int i = 0; i < numberOfProcesses; i++) {
//         System.out.print("Enter Name of processes number_" + (i + 1) + ":");
//         String name = scan.next();
//         processObject.setName(name);
//         System.out.print("Enter color of process number_" + (i + 1) + ":");
//         String color = scan.next();
//         processObject.setProcessColor(color);
//         System.out.print("Enter arrival time of process number_" + (i + 1) + ":");
//         int arrivalTime = scan.nextInt();
//         processObject.setArrivalTime(arrivalTime);
//         System.out.print("Enter burst time of process number_" + (i + 1) + ":");
//         int burstTime = scan.nextInt();
//         processObject.setBurstTime(burstTime);
//         System.out.print("Enter priority Number of process number_" + (i + 1) + ":");
//         int priorityNumber = scan.nextInt();
//         processObject.setPriorityNumber(priorityNumber);
//         processesArr.add(processObject);
//         processesArrivalTime.put(processObject.getName(),processObject.getArrivalTime());
//         processesBurstTime.put(processObject.getName(), processObject.getBurstTime());
//         processObject = new Process();
//         }
//
//         for (int i = 0; i < processesArr.size(); i++) {
//         System.out.println(processesArr.get(i).getName() + "  "
//         + processesArr.get(i).getProcessColor() + "  "
//         + processesArr.get(i).getArrivalTime() + "  "
//         + processesArr.get(i).getBurstTime() + "  "
//         + processesArr.get(i).getPriorityNumber());
//
//         }
//        
//        
//         mariam_function();
//         SJF(); // Shortest- Job First (SJF) Scheduling NON-preemptive
        roundRobinTimeQuantum = 4;
        Process P1 , P2 , P3 , P4;
        
        P1 = new Process("p1", 0, 17, 4);
        P2 = new Process("p2", 3, 6, 9);
        P3 = new Process("p3", 4, 10, 3);
        P4 = new Process("p4", 29, 4, 8);
        processesArr.put(P1.getName(), P1);
        processesArr.put(P2.getName(), P2);
        processesArr.put(P3.getName(), P3);
        processesArr.put(P4.getName(), P4);
        processesArrivalTime.put(P1.getName(), P1.getArrivalTime());
        processesArrivalTime.put(P2.getName(), P2.getArrivalTime());
        processesArrivalTime.put(P3.getName(), P3.getArrivalTime());
        processesArrivalTime.put(P4.getName(), P4.getArrivalTime());
        processesBurstTime.put(P1.getName(), P1.getBurstTime());
        processesBurstTime.put(P2.getName(), P2.getBurstTime());
        processesBurstTime.put(P3.getName(), P3.getBurstTime());
        processesBurstTime.put(P4.getName(), P4.getBurstTime());
//        mariam_function();
//        SJF(); // Shortest- Job First (SJF) Scheduling NON-preemptive
        AG_Sceduling();
        
    }

    public static void mariam_function() {

        int x = 0;
        while (true) {

            PushedProcess pushedObject = new PushedProcess();
            ///*********************************************************
            int minimumIndex = 0;
            Process minimum = new Process();
            minimum = processesArr.get(0);
            for (int i = 1; i < processesArr.size(); ++i) {
                if (minimum.getPriorityNumber() > processesArr.get(i).getPriorityNumber()) {
                    minimum = new Process();
                    minimum = processesArr.get(i);
                    minimumIndex = i;
                }

            }
            ///*******************************************************

            if (GANTT.isEmpty()) {
                pushedObject.setName(minimum.getName());
                pushedObject.setStartTime(0);
                pushedObject.setFinishTime(minimum.getBurstTime());
            } else {
                pushedObject.setName(minimum.getName());
                pushedObject.setStartTime(GANTT.get(x - 1).getFinishTime());
                pushedObject.setFinishTime(GANTT.get(x - 1).getFinishTime() + minimum.getBurstTime());

            }

            GANTT.add(pushedObject);
            processesArr.remove(processesArr.get(minimumIndex));

            if (processesArr.isEmpty()) {
                break;
            }
            ++x;
        }

        // printing the whole GANTT...
        for (int i = 0; i < GANTT.size(); i++) {

            System.out.println(GANTT.get(i).getName() + "  "
                    + GANTT.get(i).getStartTime() + "  "
                    + GANTT.get(i).getFinishTime());
        }

        // printing the waiting time......
        System.out.println("**************************************************************");
        System.out.print("Waiting Time:");
        for (int i = 0; i < GANTT.size(); i++) {

            System.out.print(GANTT.get(i).getStartTime() + "  ");
        }
        // printing the Average waiting time and filling the turnaround list !......

        System.out.println("\n**************************************************************");
        float averageWaitingTime = 0;
        float waitingTime = 0;
        float sum = 0;

        ArrayList<Float> listOfturnArroundTimes = new ArrayList<>();
        for (int i = 0; i < GANTT.size(); i++) {
            sum += GANTT.get(i).getStartTime();
            float turnArroundTime = 0;
            turnArroundTime = GANTT.get(i).getStartTime() + (GANTT.get(i).getFinishTime() - GANTT.get(i).getStartTime());//TaT = wt + bt
            listOfturnArroundTimes.add(turnArroundTime);
        }
        averageWaitingTime = sum / GANTT.size();
        System.out.println(averageWaitingTime);

        // printing the turnaround time for each process in the GANTT !.....
        System.out.println(listOfturnArroundTimes);

        // printing the Average turnaround time for all processes in the GANTT !.....
        float sum2 = 0;
        for (int i = 0; i < listOfturnArroundTimes.size(); i++) {

            sum2 += listOfturnArroundTimes.get(i);
        }
        System.out.println(sum2 / listOfturnArroundTimes.size());
    }

    //##########################################################################
    //MUAATH'S FUNCTION ( Shortest- Job First (SJF) Scheduling ) 
    public static void SJF() {

        HashMap<String, Integer> arrivalTime = sortByValue(processesArrivalTime);
        HashMap<String, Integer> burstTime = sortByValue(processesBurstTime);
        HashMap<String, Integer> completionTime = new HashMap<>();
        HashMap<String, Integer> turnAroundTime = new HashMap<>();
        HashMap<String, Integer> watingTime = new HashMap<>();

        Map.Entry<String, Integer> arrival = arrivalTime.entrySet().iterator().next(); // TO GET THE FRIST VALUE IN MAP
        String keyArrival = arrival.getKey();
        int valueArrival = arrival.getValue();
        String prekey = keyArrival;
        boolean flag = true; // TO EXECUTE THE FRIST PROCESS
        while (true) {

            if (flag) {
                completionTime.put(keyArrival, burstTime.get(keyArrival));
                turnAroundTime.put(keyArrival, completionTime.get(keyArrival) - valueArrival);
                watingTime.put(keyArrival, turnAroundTime.get(keyArrival) - burstTime.get(keyArrival));
                flag = false;
                arrivalTime.remove(keyArrival);
                burstTime.remove(keyArrival);
            } else {
                Map.Entry<String, Integer> burst = burstTime.entrySet().iterator().next();
                String keyBurst = burst.getKey();

                completionTime.put(keyBurst, completionTime.get(prekey) + burstTime.get(keyBurst));
                turnAroundTime.put(keyBurst, completionTime.get(keyBurst) - arrivalTime.get(keyBurst));
                watingTime.put(keyBurst, turnAroundTime.get(keyBurst) - burstTime.get(keyBurst));
                burstTime.remove(keyBurst);
                arrivalTime.remove(keyBurst);
                prekey = keyBurst;
            }

            if (arrivalTime.isEmpty()) {
                break;
            }

        }//###END WHILE LOOP ...

        HashMap<String, Integer> orderProcesses = sortByValue(completionTime);

        //PRINT THE INFORMATION
        int averageWaitingTime = 0;
        float averageTurnaroundTime = 0;

        System.out.println("****************Shortest- Job First (SJF) Scheduling ******************");
        System.out.println("Processes    " + "Waiting Time   " + "Turnaround Time");
        orderProcesses.keySet().forEach((name) -> {
            System.out.println(name + "              " + watingTime.get(name) + "                  " + turnAroundTime.get(name));
        });

        for (String name : orderProcesses.keySet()) {
            averageWaitingTime += watingTime.get(name);
            averageTurnaroundTime += turnAroundTime.get(name);
        }
        System.out.println("##################################################");
        System.out.println("The Average Waiting Time is " + averageWaitingTime / orderProcesses.size());
        System.out.println("The Average TurnAround Time is " + averageTurnaroundTime / orderProcesses.size());

    } //END SJF FUNCTION 

    //TO SORT THE HashMap BY VALUE
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // put data from sorted list to hashmap 
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    //END sortByValue FUNCTION #################################################

///*****************************************Thoria, yageen***********************************
///****************************************AG Sceduling***************************************
    
    public static void AG_Sceduling() {
        
        HashMap<String, Integer> arrivalTime = sortByValue(processesArrivalTime);
        HashMap<String, Integer> burstTime = sortByValue(processesBurstTime);
        HashMap<String, Integer> completionTime = new HashMap<>();
        HashMap<String, Integer> turnAroundTime = new HashMap<>();
        HashMap<String, Integer> watingTime = new HashMap<>();
        ArrayList<PushedProcess> ganttChart = new ArrayList<>();
        ArrayList<PushedProcess> quantumHistory = new ArrayList<>();
        PushedProcess gantt = new PushedProcess();
        PushedProcess quantum = new PushedProcess();
        int sumOFBurstTime = 0;
        for(Map.Entry<String, Integer> entry: processesBurstTime.entrySet()){
            String key = entry.getKey();
            sumOFBurstTime += processesBurstTime.get(key);
        }
//        System.out.println("sumOFBurstTime: "+ sumOFBurstTime);
        int time = 0;
        int count = 0;
        int newBurst;
        String Minimum = "";
        double amountIncrease;
        
        processesArrivalTime = sortByValue(processesArrivalTime);
        Map.Entry<String, Integer> Arriavel = processesArrivalTime.entrySet().iterator().next();
        String fristArrival = Arriavel.getKey();
        String currentProcess = fristArrival;
        gantt.setStartTime(time);
        gantt.setName(currentProcess);
        processesArrivalTime.remove(fristArrival);
        Map.Entry<String, Integer> Arriavell = processesArrivalTime.entrySet().iterator().next();
        String lowestArrival = Arriavell.getKey();
        System.out.println(lowestArrival);
        
        while(true){
            
            
//************************  Add to waitingList from arrival time  ***************************************************//          
            if (!processesArrivalTime.isEmpty()){
                if(processesArrivalTime.get(lowestArrival) <= time){
                    waitingList.put(lowestArrival,processesArr.get(lowestArrival).getAgFactor());
                    processesArrivalTime.remove(lowestArrival);
                    if (!processesArrivalTime.isEmpty()){
                        Map.Entry<String, Integer> Arriavel2 = processesArrivalTime.entrySet().iterator().next();
                        lowestArrival = Arriavel2.getKey();
                    }

//                    System.out.println(lowestArrival);
//                    System.out.println("***********Add to waitingList from arrival time ***********");
//                    System.out.println("The wait list : " + waitingList);
//                    System.out.println("Time:" + time);
//                    System.out.println("Count:" + count);
//                    System.out.println("processesArrivalTime:" + processesArrivalTime);
//                    System.out.println("processesBurstTime:"+processesBurstTime);
//                    System.out.println("currentProcess:" + currentProcess);
//                    System.out.println("the next Arruval time to enter to wait list:" + lowestArrival);
                }
            }
//************************  Switch from wait list (lowest AG)  ***************************************************//
            if (!waitingList.isEmpty() && !processesBurstTime.isEmpty()) {
                if(count >= processesArr.get(currentProcess).getQuantum()/2 && count < processesArr.get(currentProcess).getQuantum()){
                    Minimum = findMinimum(waitingList);
                    if (Minimum != null) {
                        if (processesArr.get(currentProcess).getAgFactor() > processesArr.get(Minimum).getAgFactor()) {
                            waitingList.put(currentProcess,processesArr.get(currentProcess).getAgFactor());
                            waitingList.remove(Minimum);
                            processesArr.get(currentProcess).increaseQuantum(processesArr.get(currentProcess).getQuantum() - count);
                            for(Map.Entry<String, Process> entry: processesArr.entrySet()){
                                String key = entry.getKey();
                                quantum.setName(key);
                                quantum.setQuantum(processesArr.get(key).getQuantum());
                                quantumHistory.add(quantum);
                                quantum = new PushedProcess();
                            }                           
                            newBurst = processesBurstTime.get(currentProcess);
                            newBurst -= 1;
                            processesBurstTime.remove(currentProcess);
                            processesBurstTime.put(currentProcess, newBurst);
                            if(processesBurstTime.get(currentProcess)<=0){
                                processesBurstTime.remove(currentProcess);
                                waitingList.remove(currentProcess);
                                processesArr.get(currentProcess).worked = true;
                                time += newBurst;
//                                System.out.println("remove burst from minimum");
//                                System.out.println("The minimum : "+ Minimum );
                            }
                            gantt.setFinishTime(time);
                            gantt.setQuantum(processesArr.get(currentProcess).getQuantum());
                            ganttChart.add(gantt);
                            currentProcess = Minimum;
                            gantt = new PushedProcess();
                            gantt.setStartTime(time);
                            gantt.setName(currentProcess);
                            count = 0;
//                            System.out.println("***********Switch from wait list lowest AG ***********");
//                            System.out.println("The wait list : " + waitingList);
//                            System.out.println("Time:" + time);
//                            System.out.println("Count:" + count);
//                            System.out.println("processesArrivalTime:" + processesArrivalTime);
//                            System.out.println("processesBurstTime:"+processesBurstTime);
//                            System.out.println("currentProcess:" + currentProcess);
//                            System.out.println("the next Arruval time to enter to wait list:" + lowestArrival);
                        }
                    }else{
                        if (processesArrivalTime.isEmpty() && processesBurstTime.isEmpty() && time == sumOFBurstTime){break;}
                        else{
                            time++;
                            count++;
                            newBurst = processesBurstTime.get(currentProcess);
                            newBurst -= 1;
                            processesBurstTime.remove(currentProcess);
                            processesBurstTime.put(currentProcess, newBurst);
                            if(processesBurstTime.get(currentProcess)<=0){
                                processesBurstTime.remove(currentProcess);
                                processesArr.get(currentProcess).worked = true;
                                if (!waitingList.isEmpty()) {
                                    waitingList.remove(currentProcess);
                                }
                                time += newBurst;
//                                System.out.println("remove burst from minimum");
                            }
                            continue;
                        }
                    }
                }
            }
            
//************************  Switch from wait list (Frist AG)  ***************************************************//
            if (!waitingList.isEmpty() && !processesBurstTime.isEmpty()) {
                if (count == processesArr.get(currentProcess).getQuantum()){
                    Map.Entry<String, Integer> turnFristWait = waitingList.entrySet().iterator().next();
                    String fristWait = turnFristWait.getKey();
                    waitingList.remove(fristWait);
                    waitingList.put(currentProcess,processesArr.get(currentProcess).getAgFactor());
                    if (processesBurstTime.containsKey(currentProcess)) {
                        newBurst = processesBurstTime.get(currentProcess);
                        newBurst -= 1;
                        processesBurstTime.remove(currentProcess);
                        processesBurstTime.put(currentProcess, newBurst);
                    }else{
                        newBurst = 0;
                    }
                    
                    if(processesBurstTime.get(currentProcess)<=0){
                        processesBurstTime.remove(currentProcess);
                        processesArr.get(currentProcess).worked = true;
                        waitingList.remove(currentProcess);
                        time += newBurst;
//                        System.out.println("remove burst from full Quant");
                    }
                    amountIncrease = CalculateMeanQuantum10();
                    processesArr.get(currentProcess).increaseQuantum(amountIncrease);
                    for(Map.Entry<String, Process> entry: processesArr.entrySet()){
                        String key = entry.getKey();
                        quantum.setName(key);
                        quantum.setQuantum(processesArr.get(key).getQuantum());
                        quantumHistory.add(quantum);
                        quantum = new PushedProcess();
                    }
                    gantt.setFinishTime(time);
                    gantt.setQuantum(processesArr.get(currentProcess).getQuantum());
                    ganttChart.add(gantt);
                    currentProcess = fristWait;
                    gantt = new PushedProcess();
                    gantt.setStartTime(time);
                    gantt.setName(currentProcess);
                    count = 0;
//                    System.out.println("***********Switch from wait list Frist AG ***********");
//                    System.out.println("amount Increase for quantum: " + amountIncrease);
//                    System.out.println("The wait list : " + waitingList);
//                    System.out.println("Time:" + time);
//                    System.out.println("Count:" + count);
//                    System.out.println("processesArrivalTime:" + processesArrivalTime);
//                    System.out.println("processesBurstTime:"+processesBurstTime);
//                    System.out.println("currentProcess:" + currentProcess);
//                    System.out.println("the next Arruval time to enter to wait list:" + lowestArrival);
                }
                if (processesBurstTime.containsKey(currentProcess)){
                    newBurst = processesBurstTime.get(currentProcess);
                    newBurst -= 1;
                    processesBurstTime.remove(currentProcess);
                    processesBurstTime.put(currentProcess, newBurst);
                    if(processesBurstTime.get(currentProcess)<=0){
                        processesBurstTime.remove(currentProcess);
                        processesArr.get(currentProcess).worked = true;
                        waitingList.remove(currentProcess);
                        time += newBurst;
//                        System.out.println("remove burst from Frist");
                        if (!waitingList.isEmpty()) {
                            Map.Entry<String, Integer> turnFristWait = waitingList.entrySet().iterator().next();
                            String fristWait = turnFristWait.getKey();
                            gantt.setFinishTime(time);
                            gantt.setQuantum(processesArr.get(currentProcess).getQuantum());
                            ganttChart.add(gantt);
                            currentProcess = fristWait;
                            gantt = new PushedProcess();
                            gantt.setStartTime(time);
                            gantt.setName(currentProcess);
                            count = 0;
                        }
                    }
                }else{
                    if (!waitingList.isEmpty()) {
                        waitingList.remove(currentProcess);
                        Map.Entry<String, Integer> turnFristWait = waitingList.entrySet().iterator().next();
                        String fristWait = turnFristWait.getKey();
                        waitingList.remove(fristWait);
                        gantt.setFinishTime(time);
                        gantt.setQuantum(processesArr.get(currentProcess).getQuantum());
                        ganttChart.add(gantt);
                        currentProcess = fristWait;
                        gantt = new PushedProcess();
                        gantt.setStartTime(time);
                        gantt.setName(currentProcess);
                        count = 0;
                    }
                }
            }
            
            if (processesBurstTime.size() == 1){
                gantt.setFinishTime(time);
                gantt.setQuantum(processesArr.get(currentProcess).getQuantum());
                ganttChart.add(gantt);
                currentProcess = lowestArrival;
                gantt = new PushedProcess();
                gantt.setStartTime(time);
                gantt.setName(currentProcess);
                count = 0;
                while(true){
                    newBurst = processesBurstTime.get(currentProcess);
                    newBurst -= 1;
                    processesBurstTime.remove(currentProcess);
                    processesBurstTime.put(currentProcess, newBurst);
                    time++;
                    count++;
                    if(processesBurstTime.get(currentProcess)<=0){
                        processesBurstTime.remove(currentProcess);
                        processesArr.get(currentProcess).worked = true;
                        time += newBurst;
//                        System.out.println("remove last burst time ");
                        break;
                    }
//                    System.out.println("***********last burst ***********");
//                    System.out.println("The wait list : " + waitingList);
//                    System.out.println("Time:" + time);
//                    System.out.println("Count:" + count);
//                    System.out.println("processesArrivalTime:" + processesArrivalTime);
//                    System.out.println("processesBurstTime:"+processesBurstTime);
//                    System.out.println("currentProcess:" + currentProcess);
//                    System.out.println("the next Arruval time to enter to wait list:" + lowestArrival);
                }
                gantt.setFinishTime(time);
                gantt.setQuantum(processesArr.get(currentProcess).getQuantum());
                ganttChart.add(gantt);
                for(Map.Entry<String, Process> entry: processesArr.entrySet()){
                    String key = entry.getKey();
                    quantum.setName(key);
                    quantum.setQuantum(processesArr.get(key).getQuantum());
                    quantumHistory.add(quantum);
                    quantum = new PushedProcess();
                }
                break;
            }
            
//            if (time >= sumOFBurstTime) {
//                break;
//            }
            
            if (waitingList.isEmpty() && !processesArrivalTime.isEmpty() && !processesBurstTime.isEmpty() && processesBurstTime.containsKey(currentProcess)){
                newBurst = processesBurstTime.get(currentProcess);
                newBurst -= 1;
                processesBurstTime.remove(currentProcess);
                processesBurstTime.put(currentProcess, newBurst);
                if(processesBurstTime.get(currentProcess)<=0){
                    processesBurstTime.remove(currentProcess);
                    processesArr.get(currentProcess).worked = true;
                    time += newBurst;
//                    System.out.println("remove burst time ");
                }
            }
            
//            if (waitingList.isEmpty() && !processesArrivalTime.isEmpty() && !processesBurstTime.isEmpty() ) {
//                time++;
//                count++;
//                continue;
//            }
            
            
            time++;
            count++;
            
            
//            if (processesBurstTime.isEmpty()) {break;}
            
//            System.out.println("***********last Update ***********");
//            System.out.println("The wait list : " + waitingList);
//            System.out.println("Time:" + time);
//            System.out.println("Count:" + count);
//            System.out.println("processesArrivalTime:" + processesArrivalTime);
//            System.out.println("processesBurstTime:"+processesBurstTime);
//            System.out.println("currentProcess:" + currentProcess);
//            System.out.println("the next Arruval time to enter to wait list:" + lowestArrival);
//            System.out.println("The Quan for current processes:" + processesArr.get(currentProcess).getQuantum());
            
        }
        
        
        System.out.println("\n\n************************ Calculate the information about AG *******************************");
        System.out.println("*****************************Gantt Chart*********************************");
        for (int i = 0; i < ganttChart.size(); i++) {
            System.out.println(ganttChart.get(i));
        }
        
        for (int i = ganttChart.size()-1; i > 0; i--) {
            if (i != ganttChart.size()-1){
                if(!completionTime.containsKey(ganttChart.get(i).getName())) {
                    completionTime.put(ganttChart.get(i).getName(), ganttChart.get(i).getFinishTime());
                }
            }else{
                completionTime.put(ganttChart.get(i).getName(), ganttChart.get(i).getFinishTime());
            }
        }
//        arrivalTime-burstTime-turnAroundTime-watingTime
//        System.out.println("\ncompletionTime:\n" + completionTime);
            
        
        System.out.println("\n ***************** turnAround Time for each process **************************");
        for(Map.Entry<String, Process> entry: processesArr.entrySet()){
            String key = entry.getKey();
            turnAroundTime.put(key, completionTime.get(key) - arrivalTime.get(key) );
        }
        for(Map.Entry<String, Process> entry: processesArr.entrySet()){
            String key = entry.getKey();
            watingTime.put(key, turnAroundTime.get(key) - burstTime.get(key));
        }
        
        System.out.println("Processes    " + "Waiting Time   " + "Turnaround Time");
        processesArr.keySet().forEach((name) -> {
            System.out.println(name + "              " + watingTime.get(name) + "                  " + turnAroundTime.get(name));
        });
        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        for (String name : processesArr.keySet()) {
            averageWaitingTime += watingTime.get(name);
            averageTurnaroundTime += turnAroundTime.get(name);
        }
        System.out.println("##################################################");
        System.out.println("The Average Waiting Time is " + averageWaitingTime / processesArr.size());
        System.out.println("The Average TurnAround Time is " + averageTurnaroundTime / processesArr.size());
        System.out.println("##################################################");
        System.out.println("\n************* History Quantum ... *****************************");
        for (int i = 0; i < quantumHistory.size(); i++) {
            System.out.println( "NameProcess: " +  quantumHistory.get(i).getName() + ", Quantum: " + quantumHistory.get(i).getQuantum() );
        }
    }
    
    
    
    public static double CalculateMeanQuantum10(){
        double mean = 0;
        for(Map.Entry<String, Process> entry: processesArr.entrySet()){
            String key = entry.getKey();
            mean += processesArr.get(key).getQuantum();
        }
        mean /= processesArr.size();
        return (mean * 0.1) + 1 ;
    }
    
    public static  String findMinimum(HashMap<String, Integer> waiting){
        if (waiting.isEmpty()) {
            return null;
        }
        HashMap<String, Integer> tempMin = sortByValue(waiting);
        Map.Entry<String, Integer> list = tempMin.entrySet().iterator().next();
        String keywait = list.getKey();
        
        return keywait;
    }
    
}