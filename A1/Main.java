
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> commandLine;
    public static String wd = "D:\\";
    public static  String input;
    public static String inp;
    public static String[] pipe_list ;
    Parse parser = new Parse();
    Terminal terminal =new Terminal();



    public void display() throws IOException {
        if (parser.parse(input)) {
            if (parser.checkExist()) {
                switch (commandLine.indexOf(parser.getCmd())) {
                    case 0:
                        System.out.println("CommandLine------------- " + terminal.pwd());
                        break;
                    case 1: {
                        if (parser.getArgs().size()==0)
                        {
                            terminal.ls();
                        }

                        if (parser.getArgs().size()==2) {
                        terminal.redirectOperator();
                    }}
                    break;
                    case 2 :{
                        terminal.clear();}

                    break;
                    case 3: {
                        String str = parser.getArgs().get(0);
                        String str2 = parser.getArgs().get(1);
                        terminal.cp(str, str2);
                    }
                    break;
                    case 4: {
                        String s = parser.args.get(1);
                        String s1 = parser.args.get(2);
                        terminal.mv(s, s1);
                    }
                    break;
                    case 5: {
                        String s = parser.args.get(1);
                        terminal.rm(s);
                    }
                    break;
                    case 6: {
                        if (parser.getArgs().size() == 0) {
                            terminal.Date();
                        }

                        if (parser.getArgs().size() == 2) {
                            terminal.redirectOperator();
                        }
                    }

                    break;
                    case 7: {
                        String s = parser.getArgs().get(1);
                        terminal.cd(s);
                    }

                    break;
                    case 8: {
                        String s = parser.getArgs().get(1);
                        terminal.rmdir(s);
                    }
                    break;
                    case 9: {
                        String s = parser.getArgs().get(1);
                        terminal.mkdir(s);
                    }
                    break;
                    case 10: {
                             if(parser.getArgs().get(0)=="<" ||parser.getArgs().get(0) =="<<"){
                                 terminal.redirectOperator();
                             }
                             else{

                            for (int i = 0; i < parser.getArgs().size(); i++) {
                                terminal.cat(parser.getArgs().get(i));

                        }}
                    }
                    break;

                    case 11: {
                        String s = parser.args.get(0);
                        terminal.args(s);
                    }
                    break;
                    case 12: {
                        if (parser.getArgs().size()==0)
                        {
                            terminal.Help();
                        }

                        if (parser.getArgs().size()==2) {
                            terminal.redirectOperator();
                        }
                    }
                    break;
                    case 13: {

                        terminal.more("data.txt",terminal.pwd());
                    }
                    break;

                    case 14:
                       terminal.exit();
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + commandLine.indexOf(parser.getCmd()));
                }
            } else {
                System.out.println("not exist command");
            }
        } else {
            System.out.println("CommandLine------------- error args");
        }
    }

    public static void getCommands()
    {
        commandLine.add("pwd");
        commandLine.add("ls");
        commandLine.add("clear");
        commandLine.add("cp");
        commandLine.add("mv");
        commandLine.add("rm");
        commandLine.add("date");
        commandLine.add("cd");
        commandLine.add("mkdir");
        commandLine.add("rmdir");
        commandLine.add("cat");
        commandLine.add("args");
        commandLine.add("help");
        commandLine.add("more");
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);  // to take input from user !!

        commandLine = new ArrayList<>(); // initialize to my Commands List
        getCommands();
        System.out.print("CommandLine------------- " );

        Terminal terminal = new Terminal();
        input = scan.nextLine();
        while (!(input.equalsIgnoreCase("stop"))) {
            if(input.contains("|"))
            {
                pipe_list = input.split("|");
                for(int i=0; i<pipe_list.length;i++)
                {
                    input = pipe_list[i].trim();// remove space only begin and end
                    main.display();
                }
            }
            else {
                inp = input;
                main.display();
            }
            System.out.print("CommandLine------------- " );
            input = scan.nextLine();
        }
    }


}