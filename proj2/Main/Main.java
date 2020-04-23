package Main;

import java.util.Scanner;

import index.HashIndex;

public class CS4432_Project2_lrtrujillo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DatabaseManager dbms = new DatabaseManager();

        while(true) {

            System.out.println("Enter a command: \n");
            String cmd = scanner.nextLine();
            System.out.println(cmd);


            if(cmd.equalsIgnoreCase("CREATE INDEX ON RANDOMV")) {
                dbms.createIndexes();
                System.out.println("The hash-based and array-based indexes are built");
            } else if(cmd.startsWith("SELECT * FROM Project2Dataset WHERE")) {
                dbms.executeQuery(cmd);
            } else {
                System.out.println("Invalid command");
            }
            System.out.println("-------------------------------------------------------");

        }


    }

}