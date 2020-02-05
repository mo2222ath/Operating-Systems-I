import java.util.ArrayList;

class Parse {

    ArrayList<String> args; // Will be filled by arguments extracted by parse method
    private String cmd; // Will be filled by the command extracted by parse method
    private String [] line;

    ///*************
    public Parse() {
    }

    ///*************

    public ArrayList<String> getArgs()
    {
        args = new ArrayList<String>();
        for(int i=1;i<line.length;i++) {
            args.add(line[i]);
        }
        return args;
    }

    ///*************
    public String getCmd() {
        cmd = line[0];
        return cmd;
    }

    ///*************


    ///*************
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    ///*************
    public boolean parse(String input)
    {
        line =  input.split(" ");//split and return array for me
        getCmd();
        if(( cmd.equals("pwd")) && (line.length!=1))
        {
            return false;
        }
        if(cmd.equals("ls") )
        {
            if ((line.length!=3) && (line.length!=1))
            {
                return false;
            }
            if((line.length==3) && (!input.contains(">") && !input.contains(">>")))
            {
                return false;
            }
        }
        if( cmd.equals("cp") && line.length!=3)
        {
            return false;
        }
        if( cmd.equals("clear") && line.length!=1)
        {
            return false;
        }
        if( cmd.equals("cd") && line.length!=2)
        {
            return false;
        }
        if( cmd.equals("rm") && line.length!=2)
        {
            return false;
        }
        if( cmd.equals("rmdir") && line.length!=2)
        {
            return false;
        }
        if( cmd.equals("mkdir") && line.length!=2)
        {
            return false;
        }
        if( cmd.equals("args") && line.length!=2)
        {
            return false;
        }
        if( cmd.equals("mv") && line.length!=3)
        {
            return false;
        }
        if ((cmd.equals("cat"))&&((line.length < 2))) {
            if (input.contains(">") && input.contains(">>"))
            {
                return false;
            }

            return false;

        }

        if (cmd.equals("Date")){
            if ((line.length!=3) && (line.length!=1))
            {
                return false;
            }
            if((line.length==3) && (!input.contains(">") && !input.contains(">>")))
            {
                return false;
            }

        if (cmd.equals("help")){
            if ((line.length!=3) && (line.length!=1))
            {
                return false;
            }
            if((line.length==3) && (!input.contains(">") && !input.contains(">>")))
            {
                return false;
            }


        }
        if ((cmd.equals("more"))&&((line.length != 1))) {
            System.out.println("CommandLine------------- error args");
            return false;

        }    }
        return true;
    }
    ///*************

    boolean checkExist()
    {

        return Main.commandLine.contains(cmd);
    }
    ///************


}