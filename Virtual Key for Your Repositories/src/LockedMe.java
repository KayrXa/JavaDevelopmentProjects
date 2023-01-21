import java.io.File;
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



    public static void processingMenu()  {


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


                    System.out.println("Please enter directory you want to list, otherwise it will print current");
                    String dirname = sc.next();
                    System.out.println("Printing files in selected folder .... in ascending order");
                    // !! resolve issue if any other dir, or when not inserted anything now just working when typing user.dir

                    String path = System.getProperty(dirname);
                    File files = new File(path);
                    for (File f : Objects.requireNonNull(files.listFiles())) {
                        System.out.println(f);
                        System.out.println(f.isDirectory());
                    }
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

    public static void processingSubMenu()  {



        // Getting input
        Scanner sc = new Scanner(System.in);

        loop: while (true) {
            subMenu();
            int choicesub = sc.nextInt();
            switch (choicesub) {

                case 1:
                    // 1. type name of a file and ad it to selected directory, if file exist throw exception - or choose to overwrite

                    // !! zatim nevytvari soubory, a zjistit v jakem formatu volit slozku

                    //!! Catching file to create
                    System.out.println("Please write down file you want to create");
                    String newfile = sc.next();

                    // !! Catching path to create
                    System.out.println("Ok, preparing to create file " + newfile + " Now type a directory where you want to put it, if in current hit enter");
                    String path = sc.next();

                    //!! Path of directory
                    File dir = new File(path);


                    System.out.println("Creating file " + newfile + " in directory " + dir);

                    //!! Create file in folder
                    //File file = new File(dir, "test.txt");



                    //!! condition if file was created or not cause exists
                    System.out.println("File " +newfile + " was created/already exist");
                    System.out.println("----------------");
                    break;

                case 2:
                    // !! 2. delete selected file from chosen directory, if not added directory delete form current, if not file or directory exist - throw exception, validation - case sensitive - message after action - deleted/not found
                    System.out.println("Deleting file ..... ");
                    System.out.println("File .... was deleted");
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


    public static void main(String[] args) {

        baseWelcome();

        processingMenu();



    }
}