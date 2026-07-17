import java.util.Scanner;

public class Jarvis{
public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    boolean isSystemRunning = true;
    boolean isLocked = true; 
    int maxAttempts = 3;
    int attempts = 0;
    int correctPassword = 4533;

    while (attempts < maxAttempts) {
        System.out.print("Please enter a numerical password to unlock the system: ");
        int password = scanner.nextInt();
        attempts++;

        if (password == correctPassword) {
            System.out.println("\nHello! Welcome to the system");     
            isLocked = false;
            break;
        }
        else{
            System.out.println("Wrong password. Please try again");
            int remaining = maxAttempts - attempts;
            if (remaining > 0) {
                System.out.println("\nYou have " + remaining + " tries left");
                
            }
        }
        
    }

   if (isLocked) {
    System.out.println("Access denied! Jarvis is shutting down");
    System.exit(0);
   } 
   else{
    System.out.println("Jarvis: System Activited. Hello, Boss.");

    while (isSystemRunning) {
        System.out.print("\n[Command]: ");
        String command = scanner.nextLine().trim();

        if (command.equalsIgnoreCase("hello") || command.equalsIgnoreCase("hi")) {
            System.out.println("Jarvis: Hello, Boss. I hope you are having a nice day.");
        }

        else if (command.equalsIgnoreCase("status")) {
            System.out.println("Jarvis: All systems looks good. Temperatures are normal");
        } 

        else if (command.equalsIgnoreCase("shutdown")) {
            System.out.println("Jarvis: Powering down. Goodbye, Boss.");
            isSystemRunning = false;
        }

        else{ 
            System.out.println("Jarvis: Unkown Command. Please try again later.");
        }
    }
}

}
}