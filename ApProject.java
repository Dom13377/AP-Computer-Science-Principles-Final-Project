import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import java.util.Scanner;
// This ANSI escape sequence package for coloring consoles is derived from
// https://gist.github.com/spdeepak/9900c17bc6657541dfd162d30d498950
//Java abstraction or API example
import ConsoleColors.ConsoleColors;
import java.util.concurrent.ThreadLocalRandom;

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
        
        //Ingredient/Drink Arrays
        List<String> raw_ingredients = Arrays.asList("ham", "colby jack", "mozzarella", "cheddar", "white bread", "mayo", "roast beef", "chicken", "wheat bread", "rosemary bread", "ranch dressing", "guacamole");
        String ingredients = String.join(", ", raw_ingredients);
        List<String> raw_drinks = Arrays.asList("Milk", "Cream Soda", "Sprite", "Water", "Orange Juice");
        String drinks = String.join(", ", raw_drinks);
        
        //Create Scanner Object
        Scanner scanobject = new Scanner(System.in);
        
        //Main Loop
        //utilizes selection
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
                //sequencing to set print order
                System.out.println("Here are your options:\n");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"help\"" + ConsoleColors.RESET + " to see available commands");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"list\"" + ConsoleColors.RESET + " to list ingredients");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"build\"" + ConsoleColors.RESET + " to build a sandwich");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"drinks\"" + ConsoleColors.RESET + " to select a drink with your sandwich");
                System.out.println("Type " + ConsoleColors.YELLOW + "\"exit\"" + ConsoleColors.RESET + " to quit the program\n");
            }

            else if (command.equals("drinks")){
                String selected_drink = drink_select(drinks, raw_drinks, scanobject);
                if (selected_drink.equals("exit")){
                    continue;
                }
                else {
                    System.out.println("You selected " + ConsoleColors.YELLOW + selected_drink + ConsoleColors.RESET + ". Make sure to build a sandwich if you haven\'t already.");
                }
            }

            else if (command.equals("build")){
                String rating = "";
                Double rate = build_sandwich(ingredients, scanobject);
                if (rate == 1000.){
                    continue;
                }
                else {
                    //add rating ranges
                    if (rate >= 8.50 && rate <= 9.50){
                        System.out.println("\nAh what a robust sandwich! Inexpensive yet tasty!");
                        rating = "7/10";
                    }
                    else if (rate >= 9.51 && rate <= 11.50){
                        System.out.println("This would be exquisite after a long day of hard work!");
                        rating = "8/10";
                    }
                    else if (rate >= 11.51 && rate <= 12.50){
                        System.out.println("Delicous!");
                        rating = "8.5/10";
                    }
                    else if (rate >= 12.51 && rate <= 13.50){
                        System.out.println("Nicely done, this sandwich is obviously expertly crafted!");
                        rating = "9/10";
                    }
                    else if (rate >= 13.51 && rate <= 14.50){
                        System.out.println("There are no words to describe this masterpiece fit for a King!");
                        rating = "10/10";
                    }
                    System.out.println("Rating: " + ConsoleColors.GREEN + rating + ConsoleColors.RESET + "\n");
                }
            }
            
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    //Drink Selection Function
    public static String drink_select(String drinks, List<String> raw_drinks, Scanner scanobject){
        int randnum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        String selected_drink = "invalid";
        System.out.println(drinks);
        System.out.println(ConsoleColors.YELLOW + "Choose a drink from the list to enjoy!\n" + ConsoleColors.RESET);
        while (selected_drink.equals("invalid")){
            System.out.print(ConsoleColors.RED + "Select Drink: " + ConsoleColors.RESET);
            selected_drink = scanobject.nextLine();
            //check using iteration if selected_drink value exists in the raw_drinks list
            selected_drink = drink_select_branch(selected_drink, randnum, raw_drinks);
        }
        return selected_drink;
    }

    public static String drink_select_branch(String selected_drink, int randnum, List<String> raw_drinks){
        correct_val: {
            for (int i = 0; i < 5; i++){
                String indexed_value = raw_drinks.get(i);
                if (indexed_value.equals(selected_drink)){
                    if (randnum == 0){
                        System.out.println("\nNice Choice!");
                    }
                    else if (randnum == 1){
                        System.out.println("\nPersonally I like Apple Juice better...");
                    }
                    else if (randnum == 2){
                        System.out.println("\nWow you have great taste!");
                    }
                    else if (randnum == 3){
                        System.out.println("\nExcellent Selection!");
                    }
                    System.out.print(ConsoleColors.RESET);
                    break correct_val;
                }
                else if (selected_drink.equals("exit")){
                    selected_drink = "exit";
                    break correct_val;
                }
            }
            System.out.println("Invalid Selection!");
            selected_drink = "invalid";
        }
        return selected_drink;
    }

    //Build and Price Sandwich Function
    //String dictionary of ingredients and their values
    public static Double build_sandwich(String ingredients, Scanner scanobject){
        Double price = 0.00;
        Map<String, Double> pricemap = Map.ofEntries(
            entry( "white bread", 2.00),
            entry( "wheat bread", 1.50),
            entry("rosemary bread", 2.50),
            entry("ham", 4.00),
            entry( "chicken", 3.50),
            entry( "roast beef", 5.00),
            entry("cheddar", 1.00),
            entry("colby jack", 1.50),
            entry("mozzarella", 2.00),
            entry( "mayo", 1.00),
            entry( "ranch dressing", 1.50),
            entry( "guacamole", 2.50)
        );
        //write main builder
        System.out.println("Welcome to the Sandwich Builder! You may choose up to 5 layers of any combination of ingredients.");
        System.out.println(ConsoleColors.CYAN + "*Type exit if you would like to quit*\n" + ConsoleColors.RESET);
        System.out.println("Here are your ingredients for reference:\n" + ConsoleColors.YELLOW + ingredients + ConsoleColors.RESET + "\n");

        //instantiate layer vars
        String layer1 = null;
        String layer2 = null;
        String layer3 = null;
        String layer4 = null;
        String layer5 = null;

        //prompt user for sandwich layers
        while (true){ 
            System.out.print(ConsoleColors.RED + "Bread Layer: " + ConsoleColors.RESET);
            layer1 = scanobject.nextLine();
            if (layer1.equals("exit")){
                return 1000.;
            }
            else if (layer1.equals("white bread") || layer1.equals("rosemary bread") || layer1.equals("wheat bread")) {
                break;
            }
            else {
                System.out.println("Please choose a bread!");
                continue;
            }
        }

        while (true){
            System.out.print(ConsoleColors.RED + "Meat Layer: " + ConsoleColors.RESET);
            layer2 = scanobject.nextLine();
            if (layer2.equals("exit")){
                return 1000.;
            }
            else if (layer2.equals("ham") || layer2.equals("chicken") || layer2.equals("roast beef")){
                break;
            }
            else{
                System.out.println("Please choose a meat!");
                continue;
            }
        }

        while (true){
            System.out.print(ConsoleColors.RED + "Cheese Layer: " + ConsoleColors.RESET);
            layer3 = scanobject.nextLine();
            if (layer3.equals("exit")){
                return 1000.;
            }
            else if (layer3.equals("colby jack") || layer3.equals("cheddar") || layer3.equals("mozzarella")){
                break;
            }
            else{
                System.out.println("Please choose a cheese!");
                continue;
            }
        }

        while (true){
            System.out.print(ConsoleColors.RED + "Sauce Layer: " + ConsoleColors.RESET);
            layer4 = scanobject.nextLine();
            if (layer4.equals("exit")){
                return 1000.;
            }
            else if (layer4.equals("ranch dressing") || layer4.equals("mayo") || layer4.equals("guacamole")){
                break;
            }
            else{
                System.out.println("Please choose a sauce!");
                continue;
            }
        }

        while (true){ 
            System.out.print(ConsoleColors.RED + "Bread Layer: " + ConsoleColors.RESET);
            layer5 = scanobject.nextLine();
            if (layer5.equals("exit")){
                return 1000.;
            }
            else if (layer5.equals("white bread") || layer5.equals("rosemary bread") || layer5.equals("wheat bread")) {
                break;
            }
            else {
                System.out.println("Please choose a bread!");
                continue;
            }
        }
        //mathematical operation to determine the overal price/rating of the sandwich built
        try{
            price = pricemap.get(layer1) + pricemap.get(layer2) + pricemap.get(layer3) + pricemap.get(layer4) + pricemap.get(layer5);
            
        }
        catch (Exception e){
            System.out.println(ConsoleColors.YELLOW + "\nHmm.. you might want to double check if your ingredients are correct!" + ConsoleColors.RESET);
            System.out.println("Type " + ConsoleColors.BLUE + "\"build\"" + ConsoleColors.RESET + " to try again.");
        }

        return price;
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