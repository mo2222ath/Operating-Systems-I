import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Terminal {
    Parse parser = new Parse();

    public String pwd() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s;
    }

    public void ls() {
        String all_files = "";
        File f = new File(new File("").getAbsolutePath());
        File arr[] = f.listFiles();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            all_files += arr[i].getName();
            all_files += " _ ";
        }
        System.out.println("CommandLine-------------" + all_files);
    }

    public void cd(String path) {

        File file = new File(".");
        System.out.println("Current Directory : " + System.getProperty("user.dir"));
        System.setProperty("user.dir", path);  // change CD
        System.out.println("New Directory : " + System.getProperty("user.dir"));
    }

    public void cp(String str, String str2) throws IOException {
        File source = new File(str);
        File dest = new File(str2);
        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException e) {
            System.out.println("There is something wrong !!");
        }
    }

    public void rm(String sourcePath) {
        File f = new File(sourcePath);
        if (f.delete())
            System.out.println("File deleted");
        else
            System.out.println("File was not deleted");
    }

    public void Date() {
        System.out.println(java.time.LocalDate.now());
    }

    public void Help() {
        System.out.println("cd : Change Directory");
        System.out.println("Ls : List of the file");
        System.out.println("cp : Stands for copy");
        System.out.println("cat : Conctinate files and redirect output in files ");
        System.out.println("more : View text file in command");
        System.out.println("pipe operator :");
        System.out.println("mkdir : Allows user to creat directories");
        System.out.println("rmdir : Remove empty directories from a filesystem");
        System.out.println("mv : Remove file from place to another ");
        System.out.println("rm : Delete file ");
        System.out.println("args : List all parameters ");
        System.out.println("date : Output current Date ");
        System.out.println("pwd : Return current directory");
        System.out.println("clear : Clear the command");
    }

    public void clear() {
        for (int i = 0; i < 5; i++) {
            System.out.println("                                            ");
        }
    }

    public void rmdir(String SRC_FOLDER) {
        File directory = new File(SRC_FOLDER);//make sure directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");

        } else {

            if (directory.isDirectory()) { //check if this is a directory or not
                if (directory.list().length == 0) {

                    directory.delete();
                    System.out.println("Directory is deleted : "
                            + directory.getAbsolutePath());

                } else {
                    System.out.println("The Directory is not empty!!");

                }
            } else {
                System.out.println("The file is not Directory");
            }
        }

    }

    public void mkdir(String Dir) {
        File theDir = new File(Dir);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        } else {
            System.out.println("The Directory is already exist !!");
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void args(String str) {
        if ((str.equals("ls")) || (str.equals("pwd")) || (str.equals("clear")) || (str.equals("date")) || (str.equals("help"))) {
            System.out.print("CommandLine-------------" + "no args \n");
        }
        if ((str.equals("cd")) || (str.equals("mkdir")) || (str.equals("rmdir")) || (str.equals("args")) || (str.equals("rm"))) {
            System.out.print("CommandLine-------------" + "  args1:source path \n");

        }
        if ((str.equals("cp")) || (str.equals("mv"))) {
            System.out.print("CommandLine-------------" + "  args1:source path  " + "  args2:source path  \n");
        }
        if ((str.equals("cat"))) {
            System.out.print("CommandLine-------------" + "  args1:alot \n");

        }
    }

    public void mv(String sp, String dp) {
        File file = new File(sp);
        if (file.renameTo(new File(dp))) {
            file.delete();
            System.out.println("File moved successfully");
        } else {
            System.out.println("Failed to move the file");
        }
    }

    public void more(String path , String current) {

        try {
            File f = new File(current+"\\"+path);
            if(f.exists())
            {
                FileInputStream a = new FileInputStream(f);
                BufferedReader pr = new BufferedReader(new InputStreamReader(a));
                String l="";
                int c = 0,x;
                Scanner n = new Scanner(System.in);
                while ((l = pr.readLine()) != null ) {
                    System.out.print(l + "\n");
                    c++;
                    if (c % 10 == 0) {
                        System.out.print("...........................................more press 1 or 2 to quit");
                        x = n.nextInt();
                        if (x == 2)
                            break;
                    }
                }
            }
            else
            {
                System.out.print("CommandLine-------------" + "not exist");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public void cat(String path) throws IOException {
        File f = new File(path);
        if (f.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } else {
            System.out.println("CommandLine-------------" + "not exist");
        }
    }

    public void redirectOperator() throws IOException {

            if (parser.getArgs().get(0).equals(">>")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter( parser.getArgs().get(1), true));
                writer.append(parser.getCmd());
                writer.close();

            }
            if (parser.getArgs().get(0).equals(">")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(parser.getArgs().get(1), false));
                writer.write(parser.getCmd());
                writer.close();

            }
        }
    }