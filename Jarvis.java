import java.util.Scanner;

public class Jarvis{
    static String[] notesArray = new String[3];
public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    boolean isSystemRunning = true;
    boolean isLocked = true; 
    int maxAttempts = 3;
    int attempts = 0;
    int correctPassword = 3309;

    // THIS IS WHERE THE PASSWORD SYSTEM IS WORKING

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

    // LOCKING THE SYSTEMS DOWN

   if (isLocked) {
    System.out.println("\nAccess denied! Jarvis is shutting down");
    System.exit(0);
   } 

   // GREETING FROM THE JARVIS AFTER GRANTING ACCESS

   else{
    scanner.nextLine();
    System.out.println("Jarvis: System Activited. Hello, Boss.");

    while (isSystemRunning) {
        System.out.print("\n[Command]: ");
        String command = scanner.nextLine().trim();

        // THIS IS WHERE THE SYSTEM STARTS

        if (command.equalsIgnoreCase("hello") || command.equalsIgnoreCase("hi")) {
            System.out.println("Jarvis: Hello, Boss. I hope you are having a nice day.");
        }

        // CHECKING WHETHER THE SYSTEMS ARE WORKING PROPERLY

        else if (command.equalsIgnoreCase("status")) {
            System.out.println("Jarvis: All systems looks good. Temperatures are normal");
        } 

        // Shutting down the System

        else if (command.equalsIgnoreCase("shutdown")) {
            System.out.println("Jarvis: Powering down. Goodbye, Boss.");
            isSystemRunning = false;
        }

        // THIS IS WHERE THE REMIND, NOTE, CLEAR MEMORY FEATURE WORKS

        else if (command.equalsIgnoreCase("remind") || command.equalsIgnoreCase("note") || command.equalsIgnoreCase("clear memory")) {
            System.out.println("Jarvis: Note-taking protocol engaged.");
            System.out.println("Options [1] Write Note  [2] Read All Notes  [3] Clear Memory");
            System.out.print("Select an option number: ");

            int noteChoice = scanner.nextInt();
            scanner.nextLine();

            if(noteChoice == 1) {
                System.out.print("Jarvis: Please enter your note: ");
                String userNote = scanner.nextLine();

                boolean saved = false;
                for (int i = 0; i < notesArray.length; i++) {
                    if(notesArray[i] == null) {
                        notesArray[i] = userNote;
                        System.out.println("Jarvis: Note securely logged in." + (i + 1) + ".");
                        saved = true;
                        break;
                    }
                }
                if (!saved) {
                    System.out.println("Warning Memory full.");
                }
            }
            else if (noteChoice == 2) {
                System.out.println("\n Jarvis System Logs");
                boolean empty = true;
                for (int i = 0; i <notesArray.length; i++) {
                    if (notesArray[i] !=null) {
                        System.out.println("[" + (i + 1) + "]" + notesArray[i]);
                        empty = false;
                    }
                }
                if (empty) {
                    System.out.println("Jarvis: No notes currently found in memory.");
                }
            }
            else if (noteChoice == 3) {
                System.out.println("Clearing out memory.");
                boolean vacant = false;
                for (int i = 0; i <notesArray.length; i++) {
                    if (notesArray[i] !=null) {
                        notesArray[i] = null;
                        vacant = true;  
                    }
                }
                if (vacant) {
                    System.out.println("Jarvis: Memory has been cleared.");
                }
                else{
                    System.out.println("Memory was already clear.");
                }
            }
            else {
                System.out.println("Jarvis: Invalid Selection.");
            }
        }

        // THIS IS WHERE IT AN UNKOWN COMMAND IS TAKEN INTO ACKNOWLEDGEMENT

        else { 
            System.out.println("Jarvis: Unkown Command. Please try again later.");
        }
    }
}

}
}