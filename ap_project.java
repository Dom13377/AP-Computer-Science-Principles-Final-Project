import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ap_project {
    public static void main(String[] args){
        //Display Banner
        System.out.println("  _________                  .___       .__    .__       .__      __________      .__.__       .___            ");
        System.out.println(" /   _____/____    ____    __| _/_  _  _|  |__ |__| ____ |  |__   \\______   \\__ __|__|  |    __| _/___________ ");
        System.out.println(" \\_____  \\\\__  \\  /    \\  / __ |\\ \\/ \\/ /  |  \\|  |/ ___\\|  |  \\   |    |  _/  |  \\  |  |   / __ |/ __ \\_  __ \\");
        System.out.println(" /        \\/ __ \\|   |  \\/ /_/ | \\     /|   Y  \\  \\ \\___|    Y  \\  |    |   \\  |  /  |  |__/ /_/ \\  ___/|  | \\/");
        System.out.println("/_______  (____  /___|  /\\____ |  \\/\\_/ |___|  /__|\\___  >___|  /  |______  /____/|__|____/\\____ |\\___  >__|   ");
        System.out.println("        \\/     \\/     \\/      \\/             \\/        \\/     \\/          \\/                    \\/    \\/       ");
        System.out.println("\nBuild your own customized SANDWICH!");
        System.out.println("Type \"Help\" to see the command list\n");
        //Ingredient Array
        List<String> raw_ingredients = Arrays.asList("ham", "cheese", "lettuce", "bread", "mayo");
        String ingredients = String.join(", ", raw_ingredients);
        
        //Create Scanner Object
        Scanner scanobject = new Scanner(System.in);
        
        //Activated Boolean
        boolean program_bool = true;
        
        //Main Loop
        while (program_bool == true){
            System.out.print("Sandwich Builder>> ");
            String command = scanobject.nextLine();
            
            if (command.equals("list")){
                list_ingredients(ingredients);
            }
            
            else if (command.equals("exit")){
                program_bool = exit(program_bool);
                scanobject.close();
            }

            else if (command.equals("help")){
                //do nothing
                assert true;
            }
            
            else {
                System.out.println("Invalid Command!");
            }
        }
    }
    
    //List Ingredients to User
    public static void list_ingredients(String ingredients){
        System.out.println(ingredients);
    }

    //Set Condition to Exit the Program
    public static boolean exit(boolean program_bool){
        program_bool = false;
        return program_bool;
    }
}