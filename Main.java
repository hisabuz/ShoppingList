
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    // Containers for storing list items
    static ArrayList<String> shoppingList = new ArrayList<String>();
    static ArrayList<String> fruitList = new ArrayList<String>();


    public static void main(String[] args) {

        // displaying the help option at first
        show_help();
        // Calling the add_to_list method 
        add_to_list();
    }

    public static void clearScreen() {  
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
} 

    //> Method for display help
    public static void show_help(){
        System.out.println(
                "==================== 🛍 ==================\n" +
                "# Welcome to Shopping List App.        \n\n" +
                "==================== 🛒 ===================\n" +
                "#> Enter 'DONE' to exit the app.           |\n" +
                "#> Enter 'SHOW' to see your items.         | \n" +
                "#> Enter 'CAT' to add category items       | \n" +
                "#> Enter 'HELP' to see help.               |\n" +
                "#> Enter 'DEL' to delete list item.        |\n" +
                "#> Enter 'REMOVE' to remove your list.     |\n" +
                "#> Enter 'CLS' to clear screen.        |\n" +
                "#> Add Multiple item by comma seperation   |\n" +
                "==================== 🛒  ===================");
    }


    //> Method for display users list items
    public  static void show_list(){
        System.out.println("Here is your Regular shopping list");
        System.out.println("-----------------------------------");
        // Looping the shoppingList array to display list items
        for (String item: shoppingList){
            System.out.println((shoppingList.indexOf(item) + 1) + ". " + item.toUpperCase());
        }
        // Checking number of  list array items and give message about items
        if (shoppingList.size() <= 1) {
            System.out.println("You have " + shoppingList.size() + " item in your regular list");
        }
        else {
            System.out.println("You have "+ shoppingList.size() + " items in your regular list");
        }   
            // Displaying fruit items
            System.out.println("Your Fruits list");
            System.out.println("-----------------");
            for (String item: fruitList){
            System.out.println((fruitList.indexOf(item) + 1) + ". " + item.toUpperCase());

        }
          // // Checking number list array items and give message about items
          if (shoppingList.size() <= 1) {
            System.out.println("You have " + fruitList.size() + " item in your fruits list");
        }
        else {
            System.out.println("You have "+ fruitList.size() + " items in your fruits list");
        }

    }


    //> List items in certain Categories
    public static void categories(){
      System.out.println("FRUITS, VEGETABLE, GROCERY");
      System.out.println("Enter \"DONE\" to finish adding");
      System.out.println("Enter \"SHOW\" to see list");
      
      // Creating Scanner object to take user input to create category
      Scanner category = new Scanner(System.in);
      System.out.print("Enter Category name >> ");
      String cats = category.next();
      // Matching user input with category names
      if (cats.toUpperCase().contains("FRUITS")){
        while (true){
          Scanner fruits = new Scanner(System.in);
          System.out.print("Add fruits >> ");
          String addFruit = fruits.next();
          if (addFruit.toUpperCase().contains("DONE")){
              System.out.println("Fruits added to your list");
              add_to_list();
          }
          else if ( addFruit.toUpperCase().contains("SHOW")){
            show_list();
          }
          else{
            fruitList.add(addFruit);
          }

        }

      }
    }


    //> Method for remove list
    public static void remove_list(){
        Scanner alert = new Scanner(System.in);
        System.out.println("Are you sure you want to clear your list?\nEnter \"YES\" / \"NO\"");
        String confirm = alert.next();
        if (confirm.contains("yes")){
            shoppingList.clear();
            System.out.println("You just cleared your list completely");
        }
        if (confirm.contains("no")){
            add_to_list();
        }

    }


    //> Method to delete list items
    public  static void delete_item(){
        System.out.println("Enter 'DONE' to exit Deletion.");
        while (true){
            Scanner delete = new Scanner(System.in);
            
            System.out.print("Enter item to delete >> ");
            String del_item = delete.nextLine();
            if (del_item.contains("done")){
               show_help();
               break;
            }
            else if (!shoppingList.contains(del_item)){
              System.out.println(del_item + " not in list! Try again !!");
            }
            else{
            shoppingList.remove(del_item);
            System.out.println(del_item + " deleted");
            }
        }

    }


    //> Method to add item into the list
    public static void add_to_list(){

        while (true){
            Scanner new_item = new Scanner(System.in);
            System.out.print("add item >> ");
            String add_item = new_item.nextLine();

            switch (add_item.toUpperCase()){
                case "DONE":
                    System.out.println("\nThanks for using !" + 
                    " \n~~~~~~~~**~~~~~~~~\nDeveloped By - " +
                    " \nMuhammad Khan\nHadoop Developer.");
                    System.out.println("~~~~~~~~**~~~~~~~~");
                    System.exit(0);
                    break;
                case "SHOW":
                    show_list();
                    break;
                case "CAT":
                    categories();
                    break;
                case "REMOVE":
                    remove_list();
                    break;
                case "CLS":
                    clearScreen();
                    break;
                case "DEL":
                    delete_item();
                    break;
                case "HELP":
                    show_help();           
                    break;
                default:
                    if (shoppingList.contains(add_item)){
                        System.out.println("\"" + add_item.toUpperCase() + "\" already in your list");
                    }
                    else if (add_item.contains(",")){
                      // Split the incoming value with coma 
                      String [] split_item = add_item.split(",");
                      // Loop the splitted value and added to the list.
                      for (int i=0; i < split_item.length; i++){
                       shoppingList.add(split_item[i].trim()); // trim() used to eliminate spaces
                      }
                    }
                    else{
                        shoppingList.add(add_item);
                        System.out.println("'" +add_item.toUpperCase() + "' added to list.");
                        for(int i = 0; i<= add_item.length(); i++){
                           System.out.print("=");
                        }
                            if (shoppingList.size() <= 1) {
                                 System.out.println("================");
                                 System.out.println("You have " + shoppingList.size() + " item.");
        }
                            else {
                                  System.out.println("================");
                                  System.out.println("You have "+ shoppingList.size() + " items.");
        }
          
                    }

            }


        }
    }


}
