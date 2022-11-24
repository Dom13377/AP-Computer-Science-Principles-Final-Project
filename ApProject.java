import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import java.util.Scanner;
import ConsoleColors.ConsoleColors;

public class ApProject {
    public static void main(String[] args){
        //Activated Boolean
        boolean program_bool = true;

        //Display Banner
        System.out.println(ConsoleColors.RESET + ConsoleColors.CYAN + " ____                         __                          __          ____                 ___       __                  ");
        System.out.println(ConsoleColors.CYAN + "/\\  _`\\                      /\\ \\              __        /\\ \\        /\\  _`\\           __ /\\_ \\     /\\ \\                 ");
        System.out.println(ConsoleColors.CYAN + "\\ \\,\\L\\_\\     __      ___    \\_\\ \\  __  __  __/\\_\\    ___\\ \\ \\___    \\ \\ \\L\\ \\  __  __/\\_\\\\//\\ \\    \\_\\ \\     __   _ __  ");
        System.out.println(ConsoleColors.CYAN + " \\/_\\__ \\   /'__`\\  /' _ `\\  /'_` \\/\\ \\/\\ \\/\\ \\/\\ \\  /'___\\ \\  _ `\\   \\ \\  _ <'/\\ \\/\\ \\/\\ \\ \\ \\ \\   /'_` \\  /'__`\\/\\`'__\\");
        System.out.println(ConsoleColors.CYAN + "   /\\ \\L\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\/\\ \\L\\ \\ \\ \\_/ \\_/ \\ \\ \\/\\ \\__/\\ \\ \\ \\ \\   \\ \\ \\L\\ \\ \\ \\_\\ \\ \\ \\ \\_\\ \\_/\\ \\L\\ \\/\\ __/\\ \\ \\/ ");
        System.out.println(ConsoleColors.CYAN + "   \\ `\\____\\ \\__/.\\_\\ \\_\\ \\_\\ \\___,_\\ \\___x___/'\\ \\_\\ \\____\\\\ \\_\\ \\_\\   \\ \\____/\\ \\____/\\ \\_\\/\\____\\ \\___,_\\ \\____\\\\ \\_\\ ");
        System.out.println(ConsoleColors.CYAN + "    \\/_____/\\/__/\\/_/\\/_/\\_/ \\/__,_ /\\__/ /__/   \\/_/\\/____/ \\/_/\\/_/    \\/___/  \\/___/  \\/_/\\/____/\\/__,_ /\\/____/ \\/_/ ");
        System.out.println(ConsoleColors.RESET + "\nBuild your own customized SANDWICH!");
        System.out.print(ConsoleColors.RESET + "Type " + ConsoleColors.YELLOW + "\"help\"" + ConsoleColors.RESET + " to see the command list, ");
        System.out.println(ConsoleColors.RESET + "or Type " + ConsoleColors.BLUE + "\"build\"" + ConsoleColors.RESET + " to build a sandwich.\n");
        
        //Ingredient Array
        List<String> raw_ingredients = Arrays.asList("ham", "colby jack", "mozzarella", "cheddar", "lettuce", "white bread", "mayo", "roast beef", "chicken", "wheat bread", "rosemary bread", "ranch dressing", "guacamole");
        String ingredients = String.join(", ", raw_ingredients);
        
        //Create Scanner Object
        Scanner scanobject = new Scanner(System.in);
        
        //Main Loop
        while (program_bool == true){
            System.out.print(ConsoleColors.RED + "Sandwich Builder>> " + ConsoleColors.RESET);
            String command = scanobject.nextLine();
            
            if (command.equals("list")){
                list_ingredients(ingredients);
            }
            
            else if (command.equals("exit")){
                program_bool = exit(program_bool);
                scanobject.close();
            }

            else if (command.equals("help")){
                System.out.println("Here are your options:\n");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"help\"" + ConsoleColors.RESET + " to see available commands");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"list\"" + ConsoleColors.RESET + " to list ingredients");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"build\"" + ConsoleColors.RESET + " to build a sandwich");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"exit\"" + ConsoleColors.RESET + " to quit the program\n");
            }

            else if (command.equals("build")){
                int rating = build_sandwich(ingredients, scanobject);
                if (rating == 1000){
                    program_bool = exit(program_bool);
                }
                else {
                    //add rating ranges
                    if (rating >= 60 && rating <= 70){
                        System.out.println("\nNicely done, this sandwich is obviously expertly crafted!\n");
                    }
                }
            }
            
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    //Build and Rate Sandwich
    public static int build_sandwich(String ingredients, Scanner scanobject){
        int rating = 0;
        Map<String, Integer> ratingmap = Map.ofEntries(
            entry("ham", 20),
            entry("colby jack", 10),
            entry("cheddar", 10),
            entry("mozzarella", 10),
            entry( "lettuce", 2),
            entry( "white bread", 15),
            entry( "mayo", 5),
            entry( "roast beef", 20),
            entry( "chicken", 20),
            entry( "wheat bread", 15),
            entry("rosemary bread", 15),
            entry( "ranch dressing", 5),
            entry( "guacamole", 5),
            entry( "", 2)
        );
        //write main builder
        System.out.println("Welcome to the Sandwich Builder! You may choose up to 5 layers of any combination of ingredients.");
        System.out.println(ConsoleColors.CYAN + "*Type exit to quit or if you would like to skip a layer, just press enter when prompted*\n" + ConsoleColors.RESET);
        System.out.println("Here are your ingredients for reference:\n" + ConsoleColors.YELLOW + ingredients + ConsoleColors.RESET);
        System.out.print(ConsoleColors.RED + "\nBase Layer: " + ConsoleColors.RESET);
        String layer1 = scanobject.nextLine();
        if (layer1.equals("exit")){
            return 1000;
        }
        System.out.print(ConsoleColors.RED + "Second Layer: " + ConsoleColors.RESET);
        String layer2 = scanobject.nextLine();
        if (layer2.equals("exit")){
            return 1000;
        }
        System.out.print(ConsoleColors.RED + "Third Layer: " + ConsoleColors.RESET);
        String layer3 = scanobject.nextLine();
        if (layer3.equals("exit")){
            return 1000;
        }
        System.out.print(ConsoleColors.RED + "Fourth Layer: " + ConsoleColors.RESET);
        String layer4 = scanobject.nextLine();
        if (layer4.equals("exit")){
            return 1000;
        }
        System.out.print(ConsoleColors.RED + "Top Layer: " + ConsoleColors.RESET);
        String layer5 = scanobject.nextLine();
        if (layer5.equals("exit")){
            return 1000;
        }

        try{
            rating = ratingmap.get(layer1) + ratingmap.get(layer2) + ratingmap.get(layer3) + ratingmap.get(layer4) + ratingmap.get(layer5);
        }
        catch (Exception e){
            System.out.println(ConsoleColors.YELLOW + "\nHmm.. you might want to double check if your ingredients are correct!" + ConsoleColors.RESET);
            System.out.println("Type " + ConsoleColors.BLUE + "\"build\"" + ConsoleColors.RESET + " to try again.");
        }

        return rating;
    }

    //List Ingredients to User
    public static void list_ingredients(String ingredients){
        System.out.println(ingredients);
    }

    //Set Condition to Exit the Program
    public static boolean exit(boolean program_bool){
        System.out.println(ConsoleColors.GREEN + "\nSee you later!\n" + ConsoleColors.RESET);
        program_bool = false;
        return program_bool;
    }
}