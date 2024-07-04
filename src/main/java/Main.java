import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<String> selectedPizzaSizeName = new ArrayList<>();
    static ArrayList<Double> selectedPizzaPrice = new ArrayList<>();
    static ArrayList<String> selectedPizzaName = new ArrayList<>();
    static String pizzaInput = null;

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File pizzasJsonFile = new File("src/main/resources/menuList.json");

        Pizza pizza = objectMapper.readValue(pizzasJsonFile,Pizza.class);

        String currencyCode = "LKR";

        homeView();
        Scanner scan = new Scanner(System.in);

        while(true){
            String chooseTheMenuInput = scan.nextLine();
            switch(chooseTheMenuInput){
                case "1": mainMenuView(pizza.getPizzaItems(), currencyCode);
                break;
                case "2": makeOrderScreen(pizza.getPizzaItems(), currencyCode);
                break;
                case "x":
                    System.exit(exitTheProgram());
                default: invalidInput();
            }
        }
    }

    private static void homeView() {
        System.out.println("Welcome to PizzaHut!\n" +
                "Now you can order pizzas in different sizes!" +
                "\n" + "To View our menu, press [1]\n" +
                "To place an Order, press [2]\n" +
                "Press [x] to exit the store");
    }
    private static int exitTheProgram() {
        System.out.println("Thank you for visiting Pizza Hut, See you next time");
        return 0;
    }
    private static void invalidInput() {
        System.out.println("Please enter valid option from bellow\n" + "To View our menu, press [1]\n" + "To place an Order, press [2]");
    }

    private static void mainMenuView(List<PizzaItems> pizzaItems, String currencyCode) {
        boolean insideMenu = true;
        justViewMenu(pizzaItems, currencyCode);
        Scanner scan = new Scanner(System.in);

        while(insideMenu){
            String chooseThePizzaMenuInput = scan.nextLine();
            switch(chooseThePizzaMenuInput) {
                case "1":
                case "2":
                case "3":
                case "4":
                    printSubMenuItemData(pizzaItems, chooseThePizzaMenuInput, currencyCode);
                    break;
                case "0":
                    homeView();
                    return;
                default:
                    backToPizzaMenu(pizzaItems, currencyCode);
                    break;
            }
            scan.nextLine();
            justViewMenu(pizzaItems, currencyCode);
        }
    }
    private static void menuList(List<PizzaItems> pizzaItems, String currencyCode) {
        for (int i = 0; i< pizzaItems.size(); i++){
            System.out.println("#" + (i+1) + " " + pizzaItems.get(i).getName()
                    + " - " + "L " + pizzaItems.get(i).getLargePrice() + " " + currencyCode + " " + "|"
                    + " M " + pizzaItems.get(i).getMediumPrice() + " " + currencyCode + " " + "|"
                    + " S " + pizzaItems.get(i).getSmallPrice() + " " + currencyCode);
        }
    }
    private static void justViewMenu(List<PizzaItems> pizzaItems, String currencyCode) {
        System.out.println("PizzaHut Menu\n");

        menuList(pizzaItems, currencyCode);

        System.out.println("\n" + "Press item number to view description\n" +
                "OR\n" +
                "Press [0] to go back");

    }
    private static void backToPizzaMenu(List<PizzaItems> pizzaItems, String currencyCode) {
        System.out.println("Please enter a valid input\nPizzaHut Menu\n");

        menuList(pizzaItems, currencyCode);

        System.out.println("\n" + "Press item number to view description\n" +
                "OR\n" +
                "Press [0] to go back");
    }

    private static void printSubMenuItemData(List<PizzaItems> pizzaItems, String chooseThePizzaMenuInput, String currencyCode) {
        int menu_choice = Integer.parseInt(chooseThePizzaMenuInput);
        System.out.println("Name : " + pizzaItems.get(menu_choice-1).getName());
        System.out.println("Description : " + pizzaItems.get(menu_choice-1).getDescription());
        System.out.println("Available Sizes: " + "Large" + " | " + "Medium" + " | " + "Small" );
        System.out.println("Large Price : " + pizzaItems.get(menu_choice-1).getLargePrice() + " " + currencyCode);
        System.out.println("Medium Price : " + pizzaItems.get(menu_choice-1).getMediumPrice() + " " + currencyCode);
        System.out.println("Small Price : " + pizzaItems.get(menu_choice-1).getSmallPrice() + " " + currencyCode);

        System.out.println("\n" + "Press any to go back");
    }
    private static void makeOrderScreen(List<PizzaItems> pizzaItems, String currencyCode) {
        int pizzaOrderCount = 0;
        boolean insideOrderMenu = true;

        Scanner scanner = new Scanner(System.in);
        starterItemsSelectScreen(pizzaItems, currencyCode);

        while(insideOrderMenu || pizzaOrderCount < 3){
            if(pizzaOrderCount == 1 && ((pizzaInput == "L")  || (pizzaInput == "M") || (pizzaInput == "S"))){
                System.out.println("Please select second item you want to buy.\n");
                menuList(pizzaItems, currencyCode);
                System.out.println("\nPress item number to select as second item\n" + "OR\n" +
                        "Press [E] to complete\n" + "OR\n" + "Press [0] to go back to Main menu");
            }
            else if((pizzaOrderCount == 2) && ((pizzaInput == "L")  || (pizzaInput == "M") || (pizzaInput == "S"))) {
                insideOrderMenu = false;
                System.out.println("\nPlease select final item you want to buy.\n");
                menuList(pizzaItems, currencyCode);
                System.out.println("Press item number to select as third item\n" + "OR\n" +
                        "Press [E] to complete\n" + "OR\n" + "Press [0] to go back to Main menu");
            }

            String userInput = scanner.nextLine();
            switch(userInput) {
                case "1":
                case "2":
                case "3":
                case "4":
                    int choice = Integer.parseInt(userInput);
                    System.out.println("You have selected #" + (choice) + " " + pizzaItems.get(choice - 1).getName());
                    System.out.println("Available options -" + " L " + pizzaItems.get(choice - 1).getLargePrice() +  " " + currencyCode + " | "
                            + " M " + pizzaItems.get(choice - 1).getMediumPrice() + " " + currencyCode + " | "
                            + " S " + pizzaItems.get(choice - 1).getSmallPrice() + " " + currencyCode + "\n");

                    selectSize();
                    selectItemCategory(pizzaItems, userInput, currencyCode);
                    pizzaOrderCount++;
                    break;
                case "E":
                    printReceipt(currencyCode);
                    return;
                case "0":
                    homeView();
                    return;
            }
        }
        printReceipt(currencyCode);
    }

    private static void selectItemCategory(List<PizzaItems> pizzaItems, String userInput, String currencyCode) {
        boolean insideSizeMenu = true;
        int choice = Integer.parseInt(userInput);
        Scanner scanner = new Scanner(System.in);

        while(insideSizeMenu){
            String sizeInput = scanner.nextLine();
            switch(sizeInput){
                case "L":
                    selectedPizzaName.add(pizzaItems.get(choice - 1).getName());
                    selectedPizzaSizeName.add("Large");
                    selectedPizzaPrice.add(pizzaItems.get(choice - 1).getLargePrice());
                    pizzaInput = "L";
                    insideSizeMenu = false;
                    break;
                case "M":
                    selectedPizzaName.add(pizzaItems.get(choice - 1).getName());
                    selectedPizzaSizeName.add("Medium");
                    selectedPizzaPrice.add(pizzaItems.get(choice - 1).getMediumPrice());
                    pizzaInput = "M";
                    insideSizeMenu = false;
                    break;
                case "S":
                    selectedPizzaName.add(pizzaItems.get(choice - 1).getName());
                    selectedPizzaSizeName.add("Small");
                    selectedPizzaPrice.add(pizzaItems.get(choice - 1).getSmallPrice());
                    pizzaInput = "S";
                    insideSizeMenu = false;
                    break;
                default:
                    System.out.println("Please enter a valid input.\n\nYou have selected #" + (choice) + " " + pizzaItems.get(choice - 1).getName() + "\n\n"
                            + "Available options - L " + pizzaItems.get(choice - 1).getLargePrice() + " " + currencyCode
                            + " | M " + pizzaItems.get(choice - 1).getMediumPrice() + " " + currencyCode + "  | S "
                            + pizzaItems.get(choice - 1).getSmallPrice() + " " + currencyCode);
                    selectSize();
                    break;
            }
        }
    }

    private static void selectSize() {
        System.out.println("Please select a size you wish to buy.");
        System.out.println("\n" +
                "Press [L] to select Large\n" +
                "Press [M] to select Medium\n" +
                "Press [S] to select small");
    }

    private static void starterItemsSelectScreen(List<PizzaItems> pizzaItems, String currencyCode) {
        System.out.println("\nYou can buy 3 items.\n" + "Please select first item you want to buy.\n");
        menuList(pizzaItems, currencyCode);
        System.out.println("\nPress item number to select first item\n" + "OR\n" + "Press [0] to go back to Main menu");
    }

    private static void printReceipt(String currencyCode) {
        double total = 0;
        System.out.println("You have ordered #" + selectedPizzaName.size() + " number of items\n" +
                "            Pizza Hut\n" + "-------------------------------------");
        for (int i = 0; i < selectedPizzaPrice.size(); i++) {
            total = total + Double.parseDouble(selectedPizzaPrice.get(i).toString());
            System.out.println("#" + (i + 1) + " " + selectedPizzaName.get(i));
            System.out.println("              - " + selectedPizzaSizeName.get(i) + " - " + selectedPizzaPrice.get(i) + " " + currencyCode);
        }

        System.out.println("\n        Total : " + total + " " + currencyCode + "\n-------------------------------------");
        System.out.println("      Thank You For Ordering\n" +
                "-------------------------------------");
        System.exit(exitTheProgram());
    }

}