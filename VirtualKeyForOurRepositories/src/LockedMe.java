import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class LockedMe {

    public static void baseWelcome() {

        //Printing Welcome screen
        System.out.println("Welcome to Locked page");
        System.out.println("Application name: LockedMe4Ever");
        System.out.println("Author: Pavel Rygl");
        System.out.println("Simple Learn ID: ");

    }

    public static void mainMenu() {
        //Printing basic menu
        System.out.println();
        System.out.println("Menu");
        System.out.println("0. Close application");
        System.out.println("1. Show current file names in ascending order");
        System.out.println("2. Modify file");
        System.out.println();
        System.out.println("Please select one of the following choices \"1\" \"2\" \"3\" ");
        System.out.println("----------------");


    }

    public static void subMenu() {
        System.out.println();
        System.out.println("Modifying menu");
        System.out.println("1) Add a file to existing directory list");
        System.out.println("2) Delete file from existing directory list");
        System.out.println("3) Search for the file from the main directory");
        System.out.println("4) Back to main menu");
        System.out.println("5) Close application");

        System.out.println();
        System.out.println("Please select one of the following choices \"1\" \"2\" \"3\" \"4\" \"5\" ");
        System.out.println("----------------");
    }



    public static void processingMenu() throws IOException {


        Scanner sc = new Scanner(System.in);
        while (true) {
            mainMenu();
            // Getting input of 1st menu
            int choice = sc.nextInt();
            switch (choice) {
                // OK
                case 0 -> {
                    System.out.println("Closing application");
                    System.out.println("See you!");
                    System.out.println("----------------");
                    System.exit(0);
                }
                case 1 -> {
                    // Calls method - Return files in ascending order, if not selected choose form current, if it is empty / not exist


                    System.out.println("Please enter directory you want to list, otherwise it will print current root directory");
                    String dirname = sc.next();
                    if ("".equals(dirname)) {
                        dirname = "user.dir";
                    } else {
                        dirname = dirname;
                    }

                    System.out.println("Printing files in selected folder " +dirname+ " in ascending order");
                    // !! resolve issue if any other dir, or when not inserted anything now just working when typing user.dir

                    String path = System.getProperty(dirname);
                    File files = new File(path);

                    for (File f:files.listFiles()) {
                        if (f.isFile())
                        System.out.println(f);
                    }
                  /*
                    for (File f:files.listFiles()) {
                        if (f.isFile())
                        {
                        for (String b : files.list()) {
                            System.out.println(b);
                        }

                        } else if (f.isDirectory())
                            for (String c : files.list()) {
                                System.out.println(c);
                            }
                    }
                   */

                    System.out.println("----------------");
                }


                // OK
                case 2 -> {
                    System.out.println("Transferring to submenu");
                    System.out.println("----------------");
                    processingSubMenu();
                }
            }

        }

    }

    public static void processingSubMenu() throws IOException {



        // Getting input
        Scanner sc = new Scanner(System.in);

        loop: while (true) {
            subMenu();
            int choicesub = sc.nextInt();
            switch (choicesub) {

                case 1:
                    // 1. type name of a file and ad it to selected directory, if file exist throw exception - or choose to overwrite
                    /*
                    TO DO
                         Try to easily enter name dir
                         Create file when not selected anything
                         If dir do not exist - return again in sub menu
                    */

                    //OK Catching file to create
                    System.out.println("Please write down file you want to create");
                    String nfile = sc.next();

                    // OK Catching path to create
                    // !! Format: C:\\Users\\austr\\IdeaProjects\\Projects\\VirtualKeyForOurRepositories\\Programoutput
                    System.out.println("Ok, preparing to create file " + nfile + " Now type a directory where you want to put it, if in current hit enter");
                    String path = sc.next();


                    //path: C:\\Users\\austr\\IdeaProjects\\Projects\\VirtualKeyForOurRepositories\\Programoutput
                    //Initializing file for dir
                    File file = new File(path, nfile);

                    //OK Checking if file exists in specific dir, if does then skip creating, if not then create
                    if (file.exists() && file.isFile()) {
                        System.out.println("Sorry file was not created");
                        System.out.println(nfile + " already exist in " + path);
                    } else {
                        System.out.println("Creating file " + nfile + " in directory " + path);
                        file.createNewFile();
                        if (file.exists() && file.isFile()){
                            System.out.println("File " +nfile + " was successfully created");

                        }else
                            System.out.println("Sorry something went wrong, try it again or contact administrator");
                    }

                    System.out.println("----------------");
                    break;

                case 2:
                    // !! 2. delete selected file from chosen directory, if not added directory delete form current, if not file or directory exist - throw exception, validation - case sensitive - message after action - deleted/not found
                    System.out.println("Type a absolute address of file you want to delete");
                    String delpath = sc.next();


                    // C:\\Users\\austr\\IdeaProjects\\Projects\\VirtualKeyForOurRepositories\\Programoutput\\test.txt
                   File delefile = new File(delpath);
                   if (delefile.isFile()){
                       System.out.println("Deleting file " +delefile);
                       delefile.delete();


                       String checkdeletion = (delefile.exists()) ? "Something went wrong file was not deleted, please try again or contact administrator." : "File was successfully deleted!";
                        System.out.println(checkdeletion);
                   } else {
                       System.out.println("Sorry you put invalid input, try it again");
                   }




                    System.out.println("----------------");
                    break;

                case 3:
                    // !! 3. Search selected file from chosen directory, if not added directory search in current, if not found
                    System.out.println("Searching for file ....");
                    System.out.println("File .... do/not exist");
                    System.out.println("----------------");
                    break;


                case 4:
                    //OK Ends loop, go back to Main menu
                    System.out.println("Going back to main menu");
                    System.out.println("----------------");

                    break loop;



                case 5:
                    //OK Finish program
                    System.out.println("Closing application");
                    System.out.println("See you!");
                    System.out.println("----------------");
                    System.exit(0);
                    break;

            }
        }


    }


    public static void main(String[] args) throws IOException {

        baseWelcome();

        processingMenu();



    }
}
