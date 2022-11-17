import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ap_project {
    public static void main(String[] args){
        //Ingredient Array
        List<String> raw_ingredients = Arrays.asList("ham", "cheese", "lettuce", "bread", "mayo");
        String ingredients = String.join(", ", raw_ingredients);
        //Create Scanner Object
        Scanner scanobject = new Scanner(System.in);
        //Activated Boolean
        boolean program_bool = true;
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
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public static void list_ingredients(String ingredients){
        System.out.println(ingredients);
    }

    public static boolean exit(boolean program_bool){
        program_bool = false;
        return program_bool;
    }
}