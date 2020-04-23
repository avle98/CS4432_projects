package main;
import index.HashIndex;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager databasemgr = new DatabaseManager();

        while(true) {
            System.out.println("Enter command: \n");
            String command = scanner.nextLine();
            System.out.println(command);

            if(command.equalsIgnoreCase("CREATE INDEX ON RANDOMV")) {
                databasemgr.createIndexes();
                System.out.println("The hash-based and array-based indexes are completely built");
            }
            else if(command.startsWith("SELECT * FROM Project2Dataset WHERE")) {
                databasemgr.executeQuery(command);
            }
            else {
                System.out.println("Incorrect command");
            }
            System.out.println(".......................");
        }
    }
}