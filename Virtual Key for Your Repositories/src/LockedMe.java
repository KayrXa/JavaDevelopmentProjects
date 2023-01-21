import java.util.Scanner;

public class LockedMe {
    public static void main(String[] args) {

        System.out.println("Welcome to Locked page");
        System.out.println("Application name: LockedMe4Ever");
        System.out.println("Author: Pavel Rygl");
        System.out.println("Simple Learn ID: ");
        System.out.println();

        //Printing Welcome screen and basic menu
        System.out.println("Menu");
        System.out.println("1. Show current file names in ascending order");
        System.out.println("2. Modify file");
        System.out.println("3. Close application");
        System.out.println();
        System.out.println("Please select one of the following choices \"1\" \"2\" \"3\" ");





        // Getting input of 1st menu
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();



        if (i == 1) {
            // Calls method - Return files in ascending order, if not selected choose form current, if it is empty / not exist
            System.out.println("Printing files in selected folder .... in ascending order");


        } else if (i == 2) {

            //Display submenu
            System.out.println("a) Add a file to existing directory list");
            System.out.println("b) Delete file from existing directory list");
            System.out.println("c) Search for the file from the main directory");

            // Getting input
            int b = sc.nextInt();


            if (b == 1) {
                // 1. type name of a file and ad it to selected directory, if file exist throw exception - or choose to overwrite
                System.out.println("Creating file .... in directory ....");
                System.out.println("File ... was created/already exist");
            } else if (b == 2) {
                // 2. delete selected file from chosen directory, if not added directory delete form current, if not file or directory exist - throw exception, validation - case sensitive - message after action - deleted/not found
                System.out.println("Deleting file ..... ");
                System.out.println("File .... was deleted");
            } else if (b == 3) {
                // 3. Search selected file from chosen directory, if not added directory search in current, if not found
                System.out.println("Searching for file ....");
                System.out.println("File .... do/not exist");
            } else if (b == 4) {
                // 4. Display menu
                System.out.println("Going back to main manu");
            } else {
                System.out.println("Sorry you put invalid input, only allowed: \"1\" \"2\" \"3\" \"4\" ");
            }


        } else if (i == 3) {
            System.out.println("Closing application");
            System.out.println("See you!");
        } else {
            System.out.println("Sorry you put invalid input, only allowed: \"1\" \"2\" \"3\" ");
        }















    }
}
